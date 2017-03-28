package ru.walingar;

/**
 * Created by Walin on 28.03.2017.
 */
public class LeftShift extends AbstractBinOperation {
    LeftShift(AllExpressions a, AllExpressions b) {
        super(a, b);
    }
    protected double evaluateImpl(double x, double y) {
        return 0;
    }

    protected int evaluateImpl(int x, int y) {
        return x << y;
    }
}
