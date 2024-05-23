import java.util.*;
import java.io.*;
public class Encoder {

    public static boolean isOdd(String s){
        return s.length() % 2 != 0;
    }
    
    //Formats the String from "This is a sample text" to 
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



    public static void printGrid(char[][] grid) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(format("This is a sample text"));
        //System.out.print(format("This is a long message to check whether or not this works properly."));
    }
}

