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
        String R = alphabetR;
        String L = alphabetL;
        for(int i = 0; i < plain.length(); i ++){
            int j = i + 1;
            String[] shiftedAlphabet = shift(L, R, plaintext.substring(i, j));

            String LAp = shiftedAlphabet[0];
            String RAp = shiftedAlphabet[1];
            
            String LAS = Lperm(LAp, findPos(R, L, plaintext.substring(i, j)));
            String RAS = Rperm(RAp, plaintext.substring(i, j));
            encoded += LAS.substring(0, 1);
            R = RAS;
            L = LAS;
        }
        return encoded;
    }

    public static String chaoDecoder(String alphabetL, String alphabetR, String encoded){
        String encodes = format(encoded);
        String result = "";
        String R = alphabetR;
        String L = alphabetL;
        for(int i = 0; i < encodes.length(); i ++){
            int j = i + 1;
            String[] shiftedAlphabet = shift(L, R, encodes.substring(i, j));

            String LAp = shiftedAlphabet[0];
            String RAp = shiftedAlphabet[1];
            
            String LAS = Lperm(LAp, encodes.substring(i, j));
            String RAS = Rperm(RAp, findPos(L, R, encodes.substring(i, j)));
            result += RAS.substring(25, 26);
            R = RAS;
            L = LAS;
        }
        return result;
    }

    public static boolean compare(String a, String b){
        if(a.equals(b)){
            return true;
        } else {
            return false;
        }        
    }

    public static String findPos(String input, String output, String letter){
        int pos = 0;
        for(int k = 0; k < 26; k++){
            if(input.charAt(k) == letter.charAt(0)){
                pos = k;
            }
        }
        int pos1 = pos + 1;
        return output.substring(pos, pos1);
    }

    public static void main(String []args){
        String LAlphabet = "HXUCZVAMDSLKPEFJRIGTWOBNYQ";
        String RAlphabet = "PTLNBQDEOYSFAVZKGJRIHWXUMC";
        String plaintext = "WELLDONEISBETTERTHANWELLSAID";
        String Cipher = "OAHQHCNYNXTSZJRRHJBYHQKSOUJY";
        String letter = "L";

        String[] shiftedAlphabets = shift(LAlphabet, RAlphabet, letter);

        String LA = shiftedAlphabets[0];
        String RA = shiftedAlphabets[1];

        System.out.println(chaoEncoder(LAlphabet, RAlphabet, plaintext));
        System.out.println(chaoDecoder(LAlphabet, RAlphabet, Cipher));
    }
}

/*
L: HXUCZVAMDSLKPEFJRIGTWOBNYQ
R: PTLNBQDEOYSFAVZKGJRIHWXUMC
I: WELLDONEISBETTERTHANWELLSAID
O: OAHQHCNYNXTSZJRRHJBYHQKSOUJY
D: WELLDONEISBETTERTHANWELLSAID

======================================================
          left:                     right: 
======================================================
HXUCZVAMDSLKPEFJRIGTWOBNYQ PTLNBQDEOYSFAVZKGJRIHWXUMC 

ONYQHXUCZVAMDBSLKPEFJRIGTW XUCPTLNBQDEOYMSFAVZKGJRIHW
ADBSLKPEFJRIGMTWONYQHXUCZV OYSFAVZKGJRIHMWXUCPTLNBQDE
HUCZVADBSLKPEXFJRIGMTWONYQ NBDEOYSFAVZKGQJRIHMWXUCPTL
QUCZVADBSLKPEHXFJRIGMTWONY NBEOYSFAVZKGQDJRIHMWXUCPTL
HFJRIGMTWONYQXUCZVADBSLKPE JRHMWXUCPTLNBIEOYSFAVZKGQD
CVADBSLKPEHFJZRIGMTWONYQXU YSAVZKGQDJRHMFWXUCPTLNBIEO
NQXUCVADBSLKPYEHFJZRIGMTWO BIOYSAVZKGQDJERHMFWXUCPTLN
YHFJZRIGMTWONEQXUCVADBSLKP RHFWXUCPTLNBIMOYSAVZKGQDJE
NQXUCVADBSLKPEYHFJZRIGMTWO MOSAVZKGQDJERYHFWXUCPTLNBI
XCVADBSLKPEYHUFJZRIGMTWONQ AVKGQDJERYHFWZXUCPTLNBIMOS
TONQXCVADBSLKWPEYHUFJZRIGM IMSAVKGQDJERYOHFWZXUCPTLNB
SKWPEYHUFJZRILGMTONQXCVADB RYHFWZXUCPTLNOBIMSAVKGQDJE
ZILGMTONQXCVARDBSKWPEYHUFJ LNBIMSAVKGQDJOERYHFWZXUCPT
JILGMTONQXCVAZRDBSKWPEYHUF LNIMSAVKGQDJOBERYHFWZXUCPT
RBSKWPEYHUFJIDLGMTONQXCVAZ RYFWZXUCPTLNIHMSAVKGQDJOBE
RSKWPEYHUFJIDBLGMTONQXCVAZ YFZXUCPTLNIHMWSAVKGQDJOBER
HFJIDBLGMTONQUXCVAZRSKWPEY LNHMWSAVKGQDJIOBERYFZXUCPT
JDBLGMTONQUXCIVAZRSKWPEYHF MWAVKGQDJIOBESRYFZXUCPTLNH
BGMTONQUXCIVALZRSKWPEYHFJD VKQDJIOBESRYFGZXUCPTLNHMWA
YFJDBGMTONQUXHCIVALZRSKWPE HMAVKQDJIOBESWRYFGZXUCPTLN
HIVALZRSKWPEYCFJDBGMTONQUX RYGZXUCPTLNHMFAVKQDJIOBESW
QXHIVALZRSKWPUEYCFJDBGMTON SWYGZXUCPTLNHRMFAVKQDJIOBE
KPUEYCFJDBGMTWONQXHIVALZRS NHMFAVKQDJIOBRESWYGZXUCPTL
SPUEYCFJDBGMTKWONQXHIVALZR NHFAVKQDJIOBRMESWYGZXUCPTL
OQXHIVALZRSPUNEYCFJDBGMTKW WYZXUCPTLNHFAGVKQDJIOBRMES
UEYCFJDBGMTKWNOQXHIVALZRSP GVQDJIOBRMESWKYZXUCPTLNHFA
JBGMTKWNOQXHIDVALZRSPUEYCF OBMESWKYZXUCPRTLNHFAGVQDJI
YFJBGMTKWNOQXCHIDVALZRSPUE JIBMESWKYZXUCOPRTLNHFAGVQD
*/