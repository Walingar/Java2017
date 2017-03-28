package ru.walingar;

/**
 * Created by Walingar on 27.03.2017.
 */
public strictfp class Variable implements AllExpressions {
    private final String name;

    public Variable(String x) {
        name = x;
    }

    public int evaluate(int x, int y, int z) {
        switch (name) {
            case "x": return x;
            case "y": return y;
            case "z": return z;
        }
        return 0;
    }

    public int evaluate(int x) {
        return x;
    }

    public double evaluate(double x) {
        return x;
    }
}
