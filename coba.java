import java.util.*;

public class coba {
    
    static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c); // Operand langsung ditambahkan ke ekspresi postfix
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    postfix.append(stack.pop());
                stack.pop(); // Pop '(' dari stack
            } else { // Operator
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek()))
                    postfix.append(stack.pop());
                stack.push(c);
            }
        }
        
        // Pop semua sisa operator dari stack
        while (!stack.isEmpty())
            postfix.append(stack.pop());
        
        return postfix.toString();
    }
    
    static int precedence(char c) {
        switch(c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        String infix = "a+b*c-(d/e+f)*g";
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + infixToPostfix(infix));
    }
}
