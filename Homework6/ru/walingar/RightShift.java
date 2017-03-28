package ru.walingar;

/**
 * Created by Walin on 28.03.2017.
 */
public class RightShift extends AbstractBinOperation {
    RightShift(AllExpressions a, AllExpressions b) {
        super(a, b);
    }
    protected double evaluateImpl(double x, double y) {
        return 0;
    }
    protected int evaluateImpl(int x, int y) {
        return x >> y;
    }
}
