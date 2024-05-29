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

    public static String[] shift(String alphabet, String alphabet2, String letter) {
        String[] alphabets = new String[2];
        String shiftedL = "";
        String shiftedR = "";
        int pos = 0;
        for(int i = 0; i < 26; i++){
            if(alphabet2.charAt(i) == letter.charAt(0)){
                pos = i;
            }
        }

        if(pos == 0){
            alphabets[0] = alphabet;
            alphabets[1] = alphabet2;
            return alphabets;
        }

        shiftedL = alphabet.substring(pos) + alphabet.substring(0, pos);
        shiftedR = alphabet2.substring(pos) + alphabet2.substring(0, pos);
        
        alphabets[0] = shiftedL;
        alphabets[1] = shiftedR;

        return alphabets;
    }

    public static String chaoEncoder(String alphabetL, String alphabetR, String plaintext){
        String plain = format(plaintext);
        String encoded = "";
        for(int i = 0; i < plain.length(); i++){
            int j = i + 1;
            if(i == 0){
                String[] alphas = shift(alphabetL, alphabetR, plain.substring(i, j));
                encoded += alphas[0].substring(0, 1); 
            } else {
                String L = alphabetL;
                String R = alphabetR;
                L = Lperm(L, plain.substring(i, j));
                R = Rperm(R, plain.substring(i, j));
                String[] alphas = shift(L, R, plain.substring(i, j));
                encoded += alphas[0].substring(0, 1); 
            }
        }
        return encoded;
    }


    public static void main(String []args){
        String LAlphabet = "BAZOMLYXITSRQDEPCNKJWHUGVF";
        String RAlphabet = "CKIWLHGFESDQBNZYAXJVUTRPOM";
        String plaintext = "This is a quick message to reformat my message properly.";
        String letter = "A";

        //System.out.println(Lperm(LAlphabet, "C"));
        //System.out.println(Rperm(RAlphabet, "A"));
        //System.out.println(format(plaintext));

        //String[] shiftedAlphabet = shift(LAlphabet, RAlphabet, letter);
        //System.out.println(Arrays.toString(shiftedAlphabet));
        
        System.out.println(chaoEncoder(LAlphabet, RAlphabet, plaintext));
    }
}

