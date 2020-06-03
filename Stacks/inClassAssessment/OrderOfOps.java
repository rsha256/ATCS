package inClassAssessment;

import java.util.Stack;

public class OrderOfOps {

    private String input;
    private Stack<Double> numbers;
    private Stack<String> operators;
    private String expression;
    private String[] exp;
    private int position;


    public OrderOfOps() {
        input = "";
    }

    public OrderOfOps(String in) {
        expression = in;
        exp = expression.split(" ");
        numbers = new Stack<Double>();
        operators = new Stack<String>();
        position = 0;

    }

    public String getExpression() {
        return expression;
    }

    public double evaluate() {
        for (int x = 0; x < expression.length(); x++) {
            int space = expression.indexOf(" ", x);
            String a = expression.substring(x, space);
            x = space;
            position = space++;

            switch (a) {
                case "(":
                    OrderOfOps temp = new OrderOfOps(expression.substring(x + 1));
                    numbers.push(temp.evaluate());
                    x += temp.position + 1;
                    break;
                case ")":
                    while (numbers.size() > 1)
                        calculate();
                    return numbers.pop();
                case "^":
                    if (operators.isEmpty())
                        operators.push(a);
                    else {
                        while (!operators.isEmpty() && (operators.peek().equals("^")))
                            calculate();
                        operators.push(a);
                    }
                    break;
                case "*":
                case "/":
                    if (operators.isEmpty())
                        operators.push(a);
                    else {
                        while (!operators.isEmpty() && (operators.peek().equals("^") || operators.peek().equals("*") || operators.peek().equals("/")))
                            calculate();
                        operators.push(a);
                    }
                    break;
                case "+":
                case "-":
                    if (operators.isEmpty())
                        operators.push(a);
                    else {
                        while (!operators.isEmpty())
                            calculate();
                        operators.push(a);
                    }
                    break;
                default:
                    numbers.push(Double.parseDouble(a));
            }
        }

        while (numbers.size() > 1)
            calculate();

        return numbers.pop();
    }

    private void calculate() {
        double secondNumber = numbers.pop();
        double firstNumber = numbers.pop();
        switch (operators.pop()) {
            case "^":
                double answer1 = Math.pow(firstNumber, secondNumber);
                numbers.push(answer1);
                break;
            case "*":
                double answer2 = firstNumber * secondNumber;
                numbers.push(answer2);
                break;
            case "/":
                double answer3 = firstNumber / secondNumber;
                numbers.push(answer3);
                break;
            case "+":
                double answer4 = firstNumber + secondNumber;
                numbers.push(answer4);
                break;
            case "-":
                double answer5 = firstNumber - secondNumber;
                numbers.push(answer5);
                break;
        }

    }

    public static void main(String[] args) {
        OrderOfOps one = new OrderOfOps("4 + 2 * 3 - 8 ");
        System.out.println(one.evaluate());

        OrderOfOps two = new OrderOfOps("8 / 2 + 3 * 5 ");
        System.out.println(two.evaluate());

        OrderOfOps three = new OrderOfOps("50 / 10 + 2 * 10 ");
        System.out.println(three.evaluate());

        OrderOfOps four = new OrderOfOps("3 * ( 2 + 1 ) - 3 ");
        System.out.println(four.evaluate());
    }

}
