package ReversePolishNotation;

import java.util.Stack;

public class ReversePolishNotation {


    public static int evoluteRPN(String[] tokens){
        Stack<String> stack = new Stack<String>();
        int returnValue=0;
        String operators="+-*/";
        for(String each:tokens){
            if(!operators.contains(each)){
                stack.push(each);
            }else{
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int index = operators.indexOf(each);
                switch(index){
                    case 0:
                    stack.push(String.valueOf(a+b));
                    break;
                    case 1:
                    stack.push(String.valueOf(b-1));
                    break;
                    case 2:
                    stack.push(String.valueOf(b*a));
                    case 3:
                    stack.push(String.valueOf(b/a));
                }
            }
        }
        returnValue = Integer.valueOf(stack.pop());
        return returnValue;
    }

    public static void main(String[] args){
        String [] tokens = {"2","1", "+","3","*"};
        int value = evoluteRPN(tokens);
        System.out.println(value);
    }
}