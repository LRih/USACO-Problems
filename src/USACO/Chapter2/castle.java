package USACO.Chapter2;/*
ID: richard78
LANG: JAVA
TASK: castle
*/

import java.io.*;
import java.util.*;

public class castle
{
    public static int width, height;
    public static int[][] walls;
    public static int[][] rooms;
    public static int numberOfRooms = 0;
    public static int[] roomSizes;
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("castle.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        width = Integer.parseInt(tokenizer.nextToken());
        height = Integer.parseInt(tokenizer.nextToken());
        walls = new int[height][width];
        rooms = new int[height][width];
        roomSizes = new int[width * height + 1];
        // find rooms
        generateWalls(reader);
        findRooms();
        // print
        for (int y = 0; y < height; y++)
            System.out.println(Arrays.toString(rooms[y]));
        System.out.println("room sizes: " + Arrays.toString(roomSizes));

//        System.out.println(numberOfRooms);
//        System.out.println(getLargestRoom());
//        System.out.println(getWallToDestroy());
        writer.println(numberOfRooms);
        writer.println(getLargestRoom());
        writer.println(getWallToDestroy());

        reader.close();
        writer.close();
        System.exit(0);
    }

    public static void generateWalls(BufferedReader reader) throws IOException
    {
        for (int y = 0; y < height; y++)
        {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int x = 0; x < width; x++)
            {
                walls[y][x] = Integer.parseInt(tokenizer.nextToken());
            }
        }
    }

    public static void findRooms()
    {
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                if (rooms[y][x] != 0) continue;
                numberOfRooms++;
                findRooms(numberOfRooms, x, y);
            }
        }
    }
    public static void findRooms(int currentRoom, int x, int y)
    {
        if (x < 0 || y < 0 || x >= width || y >= height) return;
        else if (rooms[y][x] != 0) return;
        rooms[y][x] = currentRoom;
        roomSizes[currentRoom]++;
        if (!isWallWest(walls[y][x])) findRooms(currentRoom, x - 1, y);
        if (!isWallNorth(walls[y][x])) findRooms(currentRoom, x, y - 1);
        if (!isWallEast(walls[y][x])) findRooms(currentRoom, x + 1, y);
        if (!isWallSouth(walls[y][x])) findRooms(currentRoom, x, y + 1);
    }

    public static int getLargestRoom()
    {
        int maxRoomSize = 0;
        for (int roomSize : roomSizes)
            if (roomSize > maxRoomSize) maxRoomSize = roomSize;
        return maxRoomSize;
    }

    public static String getWallToDestroy()
    {
        int maxRoom = 0;
        int targetX = 0, targetY = 0;
        String direction = "";
        for (int x = 0; x < width; x++)
        {
            for (int y = height - 1; y >= 0; y--)
            {
                if (x - 1 >= 0 && isWallWest(walls[y][x]) && rooms[y][x] != rooms[y][x - 1])
                    if (roomSizes[rooms[y][x - 1]] + roomSizes[rooms[y][x]] > maxRoom)
                    {
                        maxRoom = roomSizes[rooms[y][x - 1]] + roomSizes[rooms[y][x]];
                        targetX = x;
                        targetY = y;
                        direction = "W";
                    }
                if (y + 1 < height && isWallSouth(walls[y][x]) && rooms[y][x] != rooms[y + 1][x])
                    if (roomSizes[rooms[y + 1][x]] + roomSizes[rooms[y][x]] > maxRoom)
                    {
                        maxRoom = roomSizes[rooms[y + 1][x]] + roomSizes[rooms[y][x]];
                        targetX = x;
                        targetY = y;
                        direction = "S";
                    }
                if (y - 1 >= 0 && isWallNorth(walls[y][x]) && rooms[y][x] != rooms[y - 1][x])
                    if (roomSizes[rooms[y - 1][x]] + roomSizes[rooms[y][x]] > maxRoom)
                    {
                        maxRoom = roomSizes[rooms[y - 1][x]] + roomSizes[rooms[y][x]];
                        targetX = x;
                        targetY = y;
                        direction = "N";
                    }
                if (x + 1 < width && isWallEast(walls[y][x]) && rooms[y][x] != rooms[y][x + 1])
                    if (roomSizes[rooms[y][x + 1]] + roomSizes[rooms[y][x]] > maxRoom)
                    {
                        maxRoom = roomSizes[rooms[y][x + 1]] + roomSizes[rooms[y][x]];
                        targetX = x;
                        targetY = y;
                        direction = "E";
                    }
            }
        }
        return maxRoom + "\n" + (targetY + 1) + " " + (targetX + 1) + " " + direction;
    }

    public static boolean isWallWest(int num)
    {
        return (num & 1) != 0;
    }
    public static boolean isWallNorth(int num)
    {
        return ((num >> 1) & 1) != 0;
    }
    public static boolean isWallEast(int num)
    {
        return ((num >> 2) & 1) != 0;
    }
    public static boolean isWallSouth(int num)
    {
        return ((num >> 3) & 1) != 0;
    }
}
