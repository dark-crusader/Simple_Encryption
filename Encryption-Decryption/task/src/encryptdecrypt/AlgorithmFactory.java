package encryptdecrypt;

public final class AlgorithmFactory {
    public static Algorithm getAlgo(String algoType) {
        if (algoType.equals("shift")) {
            return new ShiftAlgorithm();
        } else if (algoType.equals("unicode")) {
            return new UnicodeAlgorithm();
        } else {
            return null;
        }
    }
}
