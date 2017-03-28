package ru.walingar;

/**
 * Created by Walingar on 27.03.2017.
 */
public strictfp class Const implements AllExpressions {
    private Number total;

    Const(Number x){
        total = x;
    }

    public int evaluate(int x, int y, int z) {
        return total.intValue();
    }

    public int evaluate(int x) {
        return total.intValue();
    }

    public double evaluate(double x) {
        return total.doubleValue();
    }
}
