package encryptdecrypt;


public class Main {
    // Auxiliary to check for alphabetic input
    @Deprecated
    private static boolean isAlpha(char c) {
        return c >= 'a' && c <= 'z';
    }

    //Function used for rolling encryption and decryption
    private static String encrypt(String text, int key) {
        char[] input = text.toCharArray();
        char[] res = new char[text.length()];
        for(int i=0; i<text.length(); i++) {

                res[i] = (char)(input[i] + key);

        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {

        // Default arguments provided.
        String op = "enc";
        int key = 0;
        String text = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                op = args[i + 1];
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            } else if (args[i].equals("-data")) {
                text = args[i + 1];
            }
        }

        System.out.println(new Main().operate(op, text, key));

    }

    //Interface to call function
    public String operate(String op, String text, int key) {
        if (op.equals("enc")) {
            return encrypt(text, key);
        } else if (op.equals("dec")) {
            return encrypt(text, -key);
        } else {
            return "Unknown operation";
        }
    }
}
