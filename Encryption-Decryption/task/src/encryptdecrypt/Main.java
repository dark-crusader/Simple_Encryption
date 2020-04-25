package encryptdecrypt;

import java.io.*;
import java.util.Scanner;

public class Main {
    @Deprecated
    private static boolean isAlpha(char c) {
        return c >= 'a' && c <= 'z';
    }

    private static String encrypt(String text, int key) {
        char[] input = text.toCharArray();
        char[] res = new char[text.length()];
        for(int i=0; i<text.length(); i++) {

                res[i] = (char)(input[i] + key);

        }
        return String.valueOf(res);
    }

    private static String readFromFile(File f) {
        String res = "";
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                res += sc.nextLine();
            }


        } catch (IOException e) {
            System.out.println("An Exception was encountered while reading.");
            System.out.println("Details: ");
            e.printStackTrace();
        }
        return res;
    }

    private static void writeToFile(String s, OutputStream out) {
        try (PrintWriter pw = new PrintWriter(out)) {
            pw.print(s);
            pw.flush();
        }

    }

    public static String operate(String op, String text, int key) {
        if (op.equals("enc")) {
            return encrypt(text, key);
        } else if (op.equals("dec")) {
            return encrypt(text, -key);
        } else {
            return "Please provide a valid operation input.";
        }
    }

    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String input = "";
        boolean gotInput = false;
        OutputStream out = System.out;
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    input = args[i + 1];
                    gotInput = true;
                    break;
                case "-in":
                    if (!gotInput) {
                        File f = new File(args[i + 1]);
                        input = readFromFile(f);
                    }
                    break;
                case "-out":
                    try {
                        out = new FileOutputStream(new File(args[i + 1]));
                    } catch (IOException e) {
                        System.out.println("There was a problem in opening file for output");
                        System.out.println("Details: ");
                        e.printStackTrace();
                    }
            }
        }
        String toWrite = operate(mode, input, key);
        writeToFile(toWrite, out);

    }
}
