import java.util.*;
import java.io.*;
public class Encoder {

    public static boolean isOdd(String s){
        return s.length() % 2 != 0;
    }
    
    //Formats the String from "This is a sample text" to TH IS IS AS AM PL ET EX TX
    public static String format(String input) {
        String no = input.replace(" ", "").replace(".", "").toUpperCase();
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < no.length(); i++) {
            s.append(no.charAt(i));

            if ((i + 1) % 2 == 0 && i != no.length() - 1) {
                s.append(' ');
            }
        }

        if(isOdd(no.toString())){
            s.append('X');
        }

        return s.toString();
    }

    //Makes the grid we need for the cipher
    public static char[][] makeGrid(String key) {
        char[][] grid = new char[5][5];
        Set<Character> usedCh = new HashSet<>();
        char current = 'a';

        int index = 0;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (ch != 'j' && !usedCh.contains(ch)) {
                usedCh.add(ch);
                grid[index / 5][index % 5] = ch;
                index++;
            }
        }

        while (index < 25) {
            if (current == 'j') {
                current++;
                continue;
            }

            if (!usedCh.contains(current)) {
                grid[index / 5][index % 5] = current;
                usedCh.add(current);
                index++;
            }
            current++;
        }

        return grid;
    }

    //prints out the whole grid in a 5x5 block of text
    public static void printGrid(char[][] grid) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    //prints out a letter from the grid given the coordinates 
    public static void printCoord(char[][] grid, int x, int y){
        System.out.println(grid[x][y]);
    }

    public static void main(String[] args) {
        int x = 0;
        int y = 0;

        String s = "This is a long message to check whether or not this works properly.";

        //Test the grid 
        char[][] result = makeGrid("");
        System.out.println("This is at (" + x + ", " + y +").");
        printCoord(result, x, y);

        System.out.println();
        System.out.println("This is the full grid.");
        printGrid(result);

        System.out.println();

        //Test the formatting
        System.out.println("This is the string before the reformatting: " + s);
        System.out.println(format(s));
    }
}

