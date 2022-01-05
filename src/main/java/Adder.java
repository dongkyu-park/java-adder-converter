public class Adder {
    cs10.week1.mission1.LogicGate logicGate = new cs10.week1.mission1.LogicGate();

    public boolean sum(boolean byteA, boolean byteB) {
        return logicGate.xor(byteA, byteB);
    }

    public boolean carry(boolean byteA, boolean byteB) {
        return logicGate.and(byteA, byteB);
    }

    public boolean[] halfAdder(boolean byteA, boolean byteB) {
        boolean carry = carry(byteA, byteB);
        boolean sum = sum(byteA, byteB);

        return new boolean[]{carry, sum};
    }

    public boolean[] fullAdder(boolean byteA, boolean byteB, boolean byteC) {
        // sum값은 A, B, C중 홀 수개가 1일 때 1이 된다.

        // carry값은 A, B를 먼저 halfAdder하여 임시 carry1값과 sum1값을 구하고,
        // sum1값과 C를 halfAdder하여 carry2값을 구한 뒤 carry1값과 carry2값이 둘 중 하나라도 1이라면 1이 된다. ex) 111, 110

        // A&B = A와B의 carry값이고,
        // A^B = A와B의 sum값이므로

        // 이를 수식으로 표현하면, A&B | (A^B)&C 로 표현할 수 있다.
        boolean abSum = halfAdder(byteA, byteB)[1];
        boolean abcSum = halfAdder(abSum, byteC)[1];

        boolean abCarry = halfAdder(byteA, byteB)[0];
        boolean abcCarry = logicGate.or(abCarry, halfAdder(abSum, byteC)[0]);

        return new boolean[]{abcCarry, abcSum};
    }

    public boolean[] byteAdder(boolean[] byteA, boolean[] byteB) {
        int maxLen = compareMaxLen(byteA, byteB);
        byteA = validateLenEqual(byteA, maxLen);
        byteB = validateLenEqual(byteB, maxLen);

        boolean carry = false;
        boolean[] result = new boolean[maxLen + 1];

        for (int i = 0; i < maxLen; i++) {
            boolean[] adderResult = fullAdder(byteA[i], byteB[i], carry);
            carry = adderResult[0];
            boolean sum = adderResult[1];
            result[i] = sum;
        }

        result[maxLen] = carry;

        return result;
    }

    public int compareMaxLen(boolean[] byteA, boolean[] byteB) {
        return byteA.length >= byteB.length ? byteA.length : byteB.length;
    }

    public boolean[] validateLenEqual(boolean[] byteX, int maxLen) {
        if (byteX.length != maxLen) {
            boolean[] byteIncrease = new boolean[maxLen];

            for (int i = 0; i < byteX.length; i++) {
                byteIncrease[i] = byteX[i];
            }

            return byteIncrease;
        }

        return byteX;
    }
}
