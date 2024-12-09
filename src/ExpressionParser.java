// ExpressionParser.java

import java.util.Arrays;

public class ExpressionParser {
    public double evaluateExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Invalid expression.");
        }
        return parseExpression(expression.replaceAll(" ", ""));
    }

    private double parseExpression(String expr) {
        if (expr.isEmpty()) return 0;

        int index = expr.lastIndexOf('(');
        if (index != -1) {
            int closeIndex = findClosingParenthesis(expr, index);
            double result = parseExpression(expr.substring(index + 1, closeIndex));
            expr = expr.substring(0, index) + result + expr.substring(closeIndex + 1);
            return parseExpression(expr);
        }

        return evaluateWithoutParentheses(expr);
    }

    private int findClosingParenthesis(String expr, int openIndex) {
        int count = 1;
        for (int i = openIndex + 1; i < expr.length(); i++) {
            if (expr.charAt(i) == '(') count++;
            else if (expr.charAt(i) == ')') count--;
            if (count == 0) return i;
        }
        throw new IllegalArgumentException("Unmatched parentheses.");
    }

    private double evaluateWithoutParentheses(String expr) {
        String[] tokens = expr.split("(?<=[-+*/])|(?=[-+*/])");
        return evaluateTokens(tokens);
    }

    private double evaluateTokens(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("*") || tokens[i].equals("/")) {
                double left = Double.parseDouble(tokens[i - 1]);
                double right = Double.parseDouble(tokens[i + 1]);
                double result = tokens[i].equals("*") ? left * right : left / right;
                tokens[i - 1] = String.valueOf(result);
                tokens[i] = null;
                tokens[i + 1] = null;
                return evaluateTokens(compact(tokens));
            }
        }

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-")) {
                double left = Double.parseDouble(tokens[i - 1]);
                double right = Double.parseDouble(tokens[i + 1]);
                double result = tokens[i].equals("+") ? left + right : left - right;
                tokens[i - 1] = String.valueOf(result);
                tokens[i] = null;
                tokens[i + 1] = null;
                return evaluateTokens(compact(tokens));
            }
        }

        return Double.parseDouble(tokens[0]);
    }

    private String[] compact(String[] tokens) {
        return Arrays.stream(tokens).filter(t -> t != null).toArray(String[]::new);
    }
}
