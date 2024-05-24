import java.util.*;
import java.io.*;
public class Encoder {
    public static String format(String s){
        return s.replaceAll(" ", "").replaceAll("\\.", "").replaceAll(",", "").toUpperCase();   
    }

    public static String Lperm(String alpha, String a){
        int position = 0;
        String changeAlpha = "";
        char letter = a.charAt(0);
        for(int i = 0; i < alpha.length() - 1; i++){
            if(alpha.charAt(i) == letter){
                position = i;
            }
        }
        int position1 = position + 1;
        changeAlpha = alpha.substring(position) + alpha.replaceAll(alpha.substring(position), "");
        String part = changeAlpha.substring(2, 14);
        String finalAlpha = alpha.substring(position, position1) + part + changeAlpha.substring(1, 2) + changeAlpha.replaceAll(alpha.substring(position, position1), "").replaceAll(part, "").replaceAll(changeAlpha.substring(1,2), "");
        return finalAlpha;
    }

    public static String Rperm(String alpha, String a){
        int position = 0;
        String changeAlpha = "";
        char letter = a.charAt(0);
        for(int i = 0; i < alpha.length() - 1; i++){
            if(alpha.charAt(i) == letter){
                position = i;
            }
        }
        int position1 = position + 1;
        changeAlpha = alpha.substring(position).replaceAll(alpha.substring(position, position1), "") + alpha.replaceAll(alpha.substring(position), "") + alpha.substring(position, position1);
        String part = changeAlpha.substring(3, 14);
        String finalAlpha = changeAlpha.substring(0, 2) + part + changeAlpha.substring(2,3) + changeAlpha.replaceAll(changeAlpha.substring(0, 14), "");
        return finalAlpha;
    }

    public static String chaoEncoder(String alphaL, String alphaR, String plaintext){
        //for(int i = 0; i < plaintext.length(); i++){
//
        //}
        return "";
    }   

    public static void main(String []args){
        String LAlphabet = "BFVGUHWJKNCPEDQRSTIXYLMOZA";
        String RAlphabet = "CMOPRTUVJXAYZNBQDSEFGHLWIK";
        String plaintext = "This is a quick message to reformat my message properly.";

        System.out.println(Lperm(LAlphabet, "C"));
        System.out.println(Rperm(RAlphabet, "A"));
        System.out.println(plaintext);
        System.out.println(format(plaintext));
        
    }
}

