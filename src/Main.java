import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    static Scanner sc = new Scanner(System.in);
    public static String CeasarCode(String input, int key){
        String output = "";
        char[] in = input.toCharArray();
        for(char i: in){
            output += (Arrays.asList(alphabet).contains("" + i)) ? alphabet[Arrays.asList(alphabet).indexOf("" + i) + key > alphabet.length ? Arrays.asList(alphabet).indexOf("" + i) + key - alphabet.length : Arrays.asList(alphabet).indexOf("" + i) + key] : i;
        }
        return output;
    }
    public static String CeasarDecode(String input, int key){
        String output = "";
        char[] in = input.toCharArray();
        for(char i: in){
            output += (Arrays.asList(alphabet).contains("" + i)) ? alphabet[Arrays.asList(alphabet).indexOf("" + i) - key < 0 ? alphabet.length - Arrays.asList(alphabet).indexOf("" + i) - key : Arrays.asList(alphabet).indexOf("" + i) - key] : i;
        }
        return output;
    }
    /*
    public static String BruteDecode(String input){
        String output = "";
        char[] in = input.toCharArray();
        for(int key = 0; key )
        for(char i: in){
            output += (Arrays.asList(alphabet).contains("" + i)) ? alphabet[Arrays.asList(alphabet).indexOf("" + i) - key] : i;
        }
        return output;
    }
    */
    public static void main(String[] args) {
        String input;
        int move;
        input = sc.nextLine().toLowerCase();
        move = sc.nextInt();
        String out1 = CeasarCode(input, move);
        System.out.println(out1);
        System.out.println(CeasarDecode(out1, move));
    }
}