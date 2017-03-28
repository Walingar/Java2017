package ru.walingar;

/**
 * Created by Walingar on 28.03.2017.
 */
public class Not extends AbstractBinOperation {
    Not(AllExpressions a, AllExpressions b) {
        super(a, b);
    }
    protected double evaluateImpl(double x, double y) {
        return -x;
    }

    protected int evaluateImpl(int x, int y) {
        return -x;
    }
}
