package encryptdecrypt;

import java.util.Scanner;

public class Main {
    @Deprecated
    private static boolean isAlpha(char c) {
        return c >= 'a' && c <= 'z';
    }

    private String encrypt(String text, int key) {
        char[] input = text.toCharArray();
        char[] res = new char[text.length()];
        for(int i=0; i<text.length(); i++) {

                res[i] = (char)(input[i] + key);

        }
        return String.valueOf(res);
    }


    public String operate(String op, String text, int key) {
        if(op.equals("enc")) {
            return encrypt(text, key);
        } else if(op.equals("dec")) {
            return encrypt(text, -key);
        } else {
            return "Please provide a valid operation input.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String op = scanner.nextLine();
        String text = scanner.nextLine();
        int key = scanner.nextInt();
        System.out.println(new Main().operate(op, text, key));

    }
}
