package it.unibo.sweng.tdd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private int apply(int value1, int value2, char operator) {
        int result = 0;
        switch(operator) {
            case '+':
                result = value1 + value2;
                break;
            case '-':
                result = value1 - value2;
                break;
            case '*':
                result = value1 * value2;
                break;
            case '/':
                result = value1 / value2;
                break;
        }
        return result;
    }

    public int compute(String expression) {
        if(expression == null) {
            throw new IllegalArgumentException();
        }
        Pattern pattern_first = Pattern.compile("^((\\d){1,3})");
        Pattern pattern_rest = Pattern.compile("^([\\+|\\-|\\*|\\/])((\\d){1,3})");
        Matcher matcher = pattern_first.matcher(expression);
        boolean firstLoop = true;
        int result = -1;
        while(!expression.equals("")) {
            if(!matcher.find()) {
                throw new IllegalArgumentException();
            }
            expression = expression.substring(matcher.end());
            if(firstLoop) {
                result = Integer.parseInt(matcher.group(0));
                firstLoop = false;
            } else {
                char operator = matcher.group(1).charAt(0);
                int value = Integer.parseInt(matcher.group(2));
                result = apply(result, value, operator);
            }
            matcher = pattern_rest.matcher(expression);
        }
        return result;    
    }
}
