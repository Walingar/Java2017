package ru.walingar;

/**
 * Created by Walingar on 28.03.2017.
 */
public class ExpressionParser {
    private String expression;
    private int value;
    private int ind;
    private String name;

    private enum Token {number, variable, not, add, sub, div, mul, leftShift, rightShift, openBrace, closeBrace, end, start}

    private Token curToken = Token.start;

    private void skipWhiteSpaces() {
        while (ind < expression.length() && Character.isWhitespace(expression.charAt(ind))) {
            ind++;
        }
    }

    private void nextToken() {
        skipWhiteSpaces();
        if (ind >= expression.length()) {
            curToken = Token.end;
            return;
        }
        char ch = expression.charAt(ind);
        switch (ch) {
            case '-':
                if (curToken == Token.number || curToken == Token.variable || curToken == Token.closeBrace) {
                    curToken = Token.sub;
                } else {
                    curToken = Token.not;
                }
                break;
            case '+':
                curToken = Token.add;
                break;
            case '*':
                curToken = Token.mul;
                break;
            case '/':
                curToken = Token.div;
                break;
            case '(':
                curToken = Token.openBrace;
                break;
            case ')':
                curToken = Token.closeBrace;
                break;
            default:
                if (Character.isDigit(ch)) {
                    int l = ind;
                    while (ind < expression.length() && Character.isDigit(expression.charAt(ind))) {
                        ind++;
                    }
                    int r = ind;
                    if (ind == expression.length()) {
                        ind++;
                    }
                    value = Integer.parseUnsignedInt(expression.substring(l, r));
                    curToken = Token.number;
                    ind--;
                } else if (ch == 'x' || ch == 'y' || ch == 'z') {
                    name = Character.toString(ch);
                    curToken = Token.variable;
                } else if (ind + 2 < expression.length() && expression.substring(ind, ind + 2).equals("<<")) {
                    curToken = Token.leftShift;
                    ind++;
                } else if (ind + 2 < expression.length() && expression.substring(ind, ind + 2).equals(">>")) {
                    curToken = Token.rightShift;
                    ind++;
                } else {
                    curToken = Token.start;
                }
        }
        ind++;
    }

    private AllExpressions unar() {
        nextToken();
        AllExpressions res;
        switch (curToken) {
            case number:
                res = new Const(value);
                nextToken();
                break;
            case variable:
                res = new Variable(name);
                nextToken();
                break;
            case not:
                res = new Not(unar(), new Const(0));
                break;
            case openBrace:
                res = shifts();
                nextToken();
                break;
            default:
                return new Const(0);
        }
        return res;
    }

    private AllExpressions mulDiv() {
        AllExpressions res = unar();
        do {
            switch (curToken) {
                case mul:
                    res = new Multiply(res, unar());
                    break;
                case div:
                    res = new Divide(res, unar());
                    break;
                default:
                    return res;
            }
        } while (curToken != Token.end);
        return res;
    }

    private AllExpressions addSub() {
        AllExpressions res = mulDiv();
        do {
            switch (curToken) {
                case add:
                    res = new Add(res, mulDiv());
                    break;
                case sub:
                    res = new Subtract(res, mulDiv());
                    break;
                default:
                    return res;
            }
        } while (curToken != Token.end);
        return res;
    }

    private AllExpressions shifts() {
        AllExpressions res = addSub();
        do {
            switch (curToken) {
                case leftShift:
                    res = new LeftShift(res, addSub());
                    break;
                case rightShift:
                    res = new RightShift(res, addSub());
                    break;
                default:
                    return res;
            }
        } while (curToken != Token.end);
        return res;
    }

    public AllExpressions parse(String s) {
        expression = s;
        return shifts();
    }
}
