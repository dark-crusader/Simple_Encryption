package encryptdecrypt;

import java.util.Scanner;

public class Main {
    private static boolean isAlpha(char c) {
        return c >= 'a' && c <= 'z';
    }

    private static String encrypt(String text, int key) {
        char[] input = text.toCharArray();
        char[] res = new char[text.length()];
        for(int i=0; i<text.length(); i++) {
            if(isAlpha(input[i])) {
                res[i] = (char) (((input[i] - 'a' + key) % 26) + 'a');
            } else {
                res[i] = input[i];
            }
        }
        return String.valueOf(res);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int key = scanner.nextInt();
        System.out.println(encrypt(text, key));

    }
}
