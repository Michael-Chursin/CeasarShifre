import java.util.List;
import  java.util.Scanner;

public class Main {
    static List<Character> alphabet = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    static Scanner sc = new Scanner(System.in);
    public static String CeasarCode(String input, int key){
        String output = "";
        char[] in = input.toCharArray();
        for(char i: in){
            char c = i;
            if(alphabet.contains(i)){
                if(alphabet.indexOf(i) + key >= alphabet.size()){
                    c = alphabet.get(alphabet.indexOf(i) + key - alphabet.size());
                } else if (alphabet.indexOf(i) + key < 0) {
                    c = alphabet.get(alphabet.size() - alphabet.indexOf(i) + key);
                } else{
                    c = alphabet.get(alphabet.indexOf(i) + key);
                }
            }
            output += c;
        }
        return output;
    }
    public static String CeasarDecode(String input, int key){
        String output = "";
        char[] in = input.toCharArray();
        for(char i: in){
            char c = i;
            if(alphabet.contains(i)){
                if(alphabet.indexOf(i) - key >= alphabet.size()){
                    c = alphabet.get(alphabet.indexOf(i) - key - alphabet.size());
                } else if (alphabet.indexOf(i) - key < 0) {
                    c = alphabet.get(alphabet.size() + (alphabet.indexOf(i) - key));
                } else{
                    c = alphabet.get(alphabet.indexOf(i) - key);
                }
            }
            output += c;
        }
        return output;
    }
    public static void BruteDecode(String input){
        List<String> often = List.of(" and ", " by ", " for ", " he ", " her ", " his ", " in ", " into ", " is ", " it ", " its ", " my ", " of ", " or ", " she ", " the ");
        char[] in = input.toCharArray();
        for(int key = -alphabet.size(); key < alphabet.size(); key++){
            String output = "";
            boolean correct = false;
            for(char i: in){
                char c = i;
                if(alphabet.contains(i)){
                    if(alphabet.indexOf(i) - key >= alphabet.size()){
                        c = alphabet.get(alphabet.indexOf(i) - key - alphabet.size());
                    } else if (alphabet.indexOf(i) - key < 0) {
                        c = alphabet.get(alphabet.size() + (alphabet.indexOf(i) - key));
                    } else{
                        c = alphabet.get(alphabet.indexOf(i) - key);
                    }
                }
                output += c;
            }
            for(String of: often){
                if(output.contains(of)){
                    correct = true;
                }
            }
            if(correct){
                System.out.println(output);
                System.out.println("Print Y, if output makes sense");
                char o = sc.next().toLowerCase().charAt(0);
                if(o == 'y'){
                    System.out.println("Supposed key:");
                    System.out.println(key);
                }
            }
        }
    }
    public static void main(String[] args) {
        String input;
        int move;
        input = sc.nextLine().toLowerCase();
        move = sc.nextInt();
        String out1 = CeasarCode(input, move);
        System.out.println(out1);
        BruteDecode(out1);
        move = sc.nextInt();
        System.out.println(CeasarDecode(out1, move));
    }
}