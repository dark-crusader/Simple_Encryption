package encryptdecrypt;

public interface Algorithm {
    public String encrypt(String text, int key);

    public String decrypt(String text, int key);
}
