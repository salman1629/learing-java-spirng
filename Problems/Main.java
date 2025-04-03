package Problems;

public class Main {
    public static void main (String[] args){

        String [] tokens = {"2","1", "+","3","*"};
        int value = ReversePolishNotation.evoluteRPN(tokens);
        System.out.println(value);

        RotateKtimes.getRotated(3,1,2,3,4,5,6,7);
    }
}
