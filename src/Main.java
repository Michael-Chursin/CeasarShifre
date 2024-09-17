import  java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static  String CeasarCode(String input, int key){
        String output = "";
        char[] in = input.toCharArray();
        for(char i: in){
            output += (i == ' ') ? ' ' : (char)((int)i + key);
        }
        return output;
    }
    public static  String CeasarDecode(String input, int key){
        String output = "";
        char[] in = input.toCharArray();
        for(char i: in){
            output += (i == ' ') ? ' ' : (char)((int)i - key);
        }
        return output;
    }
    public static void main(String[] args) {
        String input;
        int move;
        input = sc.nextLine();
        move = sc.nextInt();
        String out1 = CeasarCode(input, move);
        System.out.println(out1);
        System.out.println(CeasarDecode(out1, move));
        //java.awt.Toolkit.getDefaultToolkit().beep();
    }
}