import java.util.ArrayList;

public class Converter {
    public boolean[] dec2bin(int decimal) {
        ArrayList<Boolean> arrayList = new ArrayList<>();

        while (decimal != 0) {
            if (decimal % 2 == 1) {
                arrayList.add(true);
            } else {
                arrayList.add(false);
            }
            decimal /= 2;
        }

        boolean[] answer = new boolean[arrayList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }

    public int bin2dec(boolean[] bin) {
        int answer = 0;

        for (int i = 0; i < bin.length; i++) {
            if (bin[i]) {
                answer += pow(2, i);
            }
        }

        return answer;
    }

    public int pow(int value, int power) {
        if (power == 0) {
            return 1;
        }

        int answer = value;

        for (int i = 1; i < power; i++) {
            answer *= value;
        }

        return answer;
    }

    public String dec2hexa(int decimal) {
        boolean[] bin = dec2bin(decimal);
        int tempSum = 0;
        String answer = "";

        for (int i = 0; i < bin.length; i++) {
            if (i > 0 && i % 4 == 0) {
                answer += getHexaValue(tempSum);
                tempSum = 0;
            }

            if (bin[i]) {
                tempSum += pow(2, i % 4);
            }
        }

        if (tempSum != 0) {
            answer += getHexaValue(tempSum);
        }

        return answer;
    }

    public String getHexaValue(int tempSum) {
        if (tempSum == 10) {
            return "A";
        }
        if (tempSum == 11) {
            return "B";
        }
        if (tempSum == 12) {
            return "C";
        }
        if (tempSum == 13) {
            return "D";
        }
        if (tempSum == 14) {
            return "F";
        }
        if (tempSum == 15) {
            return "D";
        }

        return String.valueOf(tempSum);
    }
}
