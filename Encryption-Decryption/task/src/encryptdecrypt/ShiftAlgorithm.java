package encryptdecrypt;

public class ShiftAlgorithm implements Algorithm {

    private boolean isAlpha(char c) {
        return (c <= 'Z' && c >= 'A') || (c >= 'a' && c <= 'z');
    }

    private boolean isSmallAlpha(char c) {
        return (c >= 'a' && c <= 'z');
    }

    @Override
    public String encrypt(String text, int key) {
        char[] input = text.toCharArray();
        char[] res = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            if (isAlpha(input[i])) {
                if (isSmallAlpha(input[i])) {
                    if ((char) (input[i] + key) < 'a') {
                        res[i] = (char) (input[i] + key + 26);
                    } else if ((char) (input[i] + key) > 'z') {
                        res[i] = (char) (((input[i] - 'a' + key) % 26) + 'a');
                    } else {
                        res[i] = (char) (input[i] + key);
                    }
                } else {
                    if ((char) (input[i] + key) < 'A') {
                        res[i] = (char) (input[i] + key + 26);
                    } else if ((char) (input[i] + key) > 'Z') {
                        res[i] = (char) (((input[i] - 'A' + key) % 26) + 'A');
                    } else {
                        res[i] = (char) (input[i] + key);
                    }
                }
            } else {
                res[i] = input[i];
            }
        }

        return String.valueOf(res);
    }

    @Override
    public String decrypt(String text, int key) {
        return encrypt(text, -key);
    }
}
