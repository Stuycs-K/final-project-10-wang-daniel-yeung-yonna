import java.util.*;
import java.io.*;
public class Encoder {
    public static String Lperm(String alpha, String a){
        int pos = 0;
        String newL = "";
        char letter = a.charAt(0);
        for(int i = 0; i < alpha.length() - 1; i++){
            if(alpha.charAt(i) == letter){
                pos = i;
            }
        }
        int pos1 = pos + 1;
        newL = alpha.substring(pos) + alpha.replaceAll(alpha.substring(pos), "");
        String part = newL.substring(2, 14);
        String perm = alpha.substring(pos, pos1) + part + newL.substring(1, 2) + newL.replaceAll(alpha.substring(pos, pos1), "").replaceAll(part, "").replaceAll(newL.substring(1,2), "");
        return perm;
    }

    public static String Rperm(String alpha, String a){
        int pos = 0;
        String newR = "";
        char letter = a.charAt(0);
        for(int i = 0; i < alpha.length() - 1; i++){
            if(alpha.charAt(i) == letter){
                pos = i;
            }
        }
        int pos1 = pos + 1;
        newR = alpha.substring(pos).replaceAll(alpha.substring(pos, pos1), "") + alpha.replaceAll(alpha.substring(pos), "") + alpha.substring(pos, pos1);
        String part = newR.substring(3, 14);
        String perm = newR.substring(0, 2) + part + newR.substring(2,3) + newR.replaceAll(newR.substring(0, 14), "");
        return perm;
    }

    public static void main(String []args){
        String LAlphabet = "BFVGUHWJKNCPEDQRSTIXYLMOZA";
        String RAlphabet = "CMOPRTUVJXAYZNBQDSEFGHLWIK";
        System.out.println(Lperm(LAlphabet, "C"));
        System.out.println(Rperm(RAlphabet, "A"));
    }
}

