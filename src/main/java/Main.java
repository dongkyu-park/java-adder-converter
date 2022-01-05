public class Main {
    public static void main(String[] args) {
        Adder adder = new Adder();
        Converter converter = new Converter();

//        boolean[] answer = adder.fullAdder(true, true, true);
//        System.out.println(answer[0] + ", " + answer[1]);

//        boolean[] answer2 = adder.byteAdder(new boolean[]{true,true,false,true,true,false,true,false,true}, new boolean[]{true,false,true,true,false,false,true,true});
//        for (int i = 0; i < answer2.length; i++) {
//            System.out.print(answer2[i] + ", ");
//        }
//
//        System.out.println();
//
//        boolean[] answer3 = adder.byteAdder(new boolean[]{true,true,false,false,true,false,true,false}, new boolean[]{true,true,false,true,true,false,false,true});
//
//        for (int i = 0; i < answer3.length; i++) {
//            System.out.print(answer3[i] + ", ");
//        }

//        boolean[] test = converter.dec2bin(101);
//        for (int i = 0; i < test.length; i++) {
//            System.out.print(test[i] + ", ");
//        }

//        boolean[] test = {true,true,true,true,false,true,false,true};
//        int answer = converter.bin2dec(test);
//        System.out.println(answer);

        String test = converter.dec2hexa(56616);
        System.out.println(test);

    }
}
