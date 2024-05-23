import java.util.*;
import java.io.*;
public class Encoder {

    public static boolean isOdd(String s){
        return s.length() % 2 != 0;
    }
    
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

    public static void main(String[] args) {
        System.out.print(format("This is a long message to check whether or not this works properly."));
    }
}

