package ru.walingar;

/**
 * Created by Walingar on 27.03.2017.
 */
public strictfp class Add extends AbstractBinOperation {
    Add(AllExpressions a, AllExpressions b) {
        super(a, b);
    }
    protected double evaluateImpl(double x, double y) {
        return x + y;
    }

    protected int evaluateImpl(int x, int y) {
        return x + y;
    }
}
