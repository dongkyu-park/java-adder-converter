public class LogicGate {
    public boolean and(boolean byteA, boolean byteB) {
        return byteA && byteB;
    }

    public boolean or(boolean byteA, boolean byteB) {
        return byteA || byteB;
    }

    public boolean nand(boolean byteA, boolean byteB) {
        return !and(byteA, byteB);
    }

    public boolean xor(boolean byteA, boolean byteB) {
        return byteA != byteB;
    }
}
