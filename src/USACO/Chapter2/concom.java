package USACO.Chapter2;

/*
ID: richard78
LANG: JAVA
TASK: concom
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

// unfinished
public class concom
{
    public static HashMap<Integer, Company> companies = new HashMap<Integer, Company>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("concom.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("concom.out")));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++)
        {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int id = Integer.parseInt(tokenizer.nextToken());
            if (!companies.containsKey(id))
                companies.put(id, new Company(id));
            companies.get(id).add(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
        }
//        for (int i : companies.keySet())
//            System.out.println(companies.get(i).toString());

        for (int i : SetToSortedArray(companies.keySet()))
        {
            HashMap<Integer, Integer> controls = companies.get(i).getControls(new HashMap<Integer, Integer>(), new ArrayList<Company>(), companies);
            System.out.println(i + ": " + controls);
            for (int j : SetToSortedArray(controls.keySet()))
            {
                if (controls.get(j) > 50 && i != j)
                    writer.println(i + " " + j);
            }
        }

        reader.close();
        writer.close();
        System.exit(0);
    }

    public static Integer[] SetToSortedArray(Set<Integer> set)
    {
        Integer[] array = set.toArray(new Integer[]{});
        Arrays.sort(array);
        return array;
    }
}

class Company
{
    public int id;
    public List<Control> controlledCompanies = new ArrayList<Control>();
    
    public Company(int id)
    {
        this.id = id;
    }
    
    public void add(int companyID, int percent)
    {
        controlledCompanies.add(new Control(companyID, percent));
    }
    public String toString()
    {
        String result = "";
        for (Control c : controlledCompanies)
            result += c.companyID + "=" + c.percent + " ";
        return id + " { " + result + "}";
    }
    
    public HashMap<Integer, Integer> getControls(HashMap<Integer, Integer> controls, List<Company> checkedCompanies, HashMap<Integer, Company> companies)
    {
        if (checkedCompanies.contains(this)) return controls;
        checkedCompanies.add(this);
        for (Control control : controlledCompanies)
        {
            // add controlled company id if non existent
            if (!controls.containsKey(control.companyID))
                controls.put(control.companyID, 0);
            // add percentage
            controls.put(control.companyID, controls.get(control.companyID) + control.percent);
            if (control.percent > 50 && companies.containsKey(control.companyID))
                controls = companies.get(control.companyID).getControls(controls, checkedCompanies, companies);
        }
        return controls;
    }
}

class Control
{
    public int companyID;
    public int percent;

    public Control(int companyID, int percent)
    {
        this.companyID = companyID;
        this.percent = percent;
    }
}