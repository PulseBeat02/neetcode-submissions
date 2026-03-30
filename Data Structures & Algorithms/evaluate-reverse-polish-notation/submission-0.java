class Solution {
    public int evalRPN(String[] tokens) {

        Stack<String> ops = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                String second = ops.pop();
                String first = ops.pop();
                int firstParsed = Integer.parseInt(first);
                int secondParsed = Integer.parseInt(second);
                int res = -1;
                switch (token) {
                    case "+":
                        res = firstParsed + secondParsed;
                        break;
                    case "-":
                        res = firstParsed - secondParsed;
                        break;
                    case "*":
                        res = firstParsed * secondParsed;
                        break;
                    case "/":
                        res = firstParsed / secondParsed;
                        break;
                }
                ops.push(String.valueOf(res));
            } else {
                ops.push(token);
            }
        }

        return Integer.parseInt(ops.peek());
    }

    public boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}
