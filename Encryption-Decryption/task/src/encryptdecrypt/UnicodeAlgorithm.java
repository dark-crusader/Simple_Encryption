package encryptdecrypt;

public class UnicodeAlgorithm implements Algorithm {
    @Override
    public String encrypt(String text, int key) {
        char[] input = text.toCharArray();
        char[] res = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {

            res[i] = (char) (input[i] + key);

        }
        return String.valueOf(res);
    }

    @Override
    public String decrypt(String text, int key) {
        return encrypt(text, -key);
    }
}
