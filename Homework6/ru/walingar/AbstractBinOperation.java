package ru.walingar;

/**
 * Created by Walin on 28.03.2017.
 */
public abstract strictfp class AbstractBinOperation implements AllExpressions {
    private AllExpressions left;
    private AllExpressions right;

    AbstractBinOperation(AllExpressions a, AllExpressions b) {
        left = a;
        right = b;
    }

    protected abstract double evaluateImpl(double a, double b);

    protected abstract int evaluateImpl(int a, int b);


    public int evaluate(int x, int y, int z) {
        return evaluateImpl(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }

    public double evaluate(double x) {
        return evaluateImpl(left.evaluate(x), right.evaluate(x));
    }

    public int evaluate(int x) {
        return evaluateImpl(left.evaluate(x), right.evaluate(x));
    }
}
