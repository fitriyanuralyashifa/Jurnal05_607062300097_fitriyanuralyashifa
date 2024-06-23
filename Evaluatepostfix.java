import java.util.Stack;
public class Evaluatepostfix {
    public static int evaluatepostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        for (String component : postfix.split(" ")) {
            if (StringUtils.isNumeric(component)) {
                stack.push(Integer.parseInt(component));
            } else {
                int nbr1 = stack.pop();
                int nbr2 = stack.pop();
                switch (component) {
                    case "+" -> stack.push(nbr2 + nbr1);
                    case "-" -> stack.push(nbr2 - nbr1);
                    case "/" -> stack.push(nbr2 / nbr1);
                    case "*" -> stack.push(nbr2 * nbr1);
                    case "%" -> stack.push(nbr2 % nbr1);
                }
            }
        }
        return stack.pop();
    }
}

