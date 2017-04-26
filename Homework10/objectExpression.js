/**
 * Created by Walingar on 24.04.2017.
 */

var VARIABlES = {
    'x': 0,
    'y': 1,
    'z': 2
};

function DoubleExpressionFactory(leftExpression, rightExpression) {
    var object = {};
    object.leftExpression = leftExpression;
    object.rightExpression = rightExpression;

    object.toString = function () {
        return (
            this.leftExpression.toString() + " " +
            this.rightExpression.toString() + " " +
            this.operation
        );
    };

    object.evaluate = function () {
        return eval(
            "this.leftExpression.evaluate.apply(this.leftExpression, arguments) " +
            this.operation +
            " this.rightExpression.evaluate.apply(this.rightExpression, arguments)"
        );
    };

    return object;
}

function Add(leftExpression, rightExpression) {
    var object = DoubleExpressionFactory(leftExpression, rightExpression);
    object.operation = "+";
    return object;
}

function Subtract(leftExpression, rightExpression) {
    var object = DoubleExpressionFactory(leftExpression, rightExpression);
    object.operation = "-";
    return object;
}

function Multiply(leftExpression, rightExpression) {
    var object = DoubleExpressionFactory(leftExpression, rightExpression);
    object.operation = "*";
    return object;
}

function Divide(leftExpression, rightExpression) {
    var object = DoubleExpressionFactory(leftExpression, rightExpression);
    object.operation = "/";
    return object;
}

function Negate(expression) {
    this.evaluate = function () {
        return -expression.evaluate.apply(expression, arguments);
    };

    this.toString = function () {
        return expression.toString() + " negate";
    };
}


function Const(value) {
    this.valueConst = value;
    this.evaluate = function () {
        return this.valueConst;
    };

    this.toString = function () {
        return this.valueConst.toString();
    };
}

function Variable(name) {
    this.nameVariable = name;
    this.getVariable = VARIABlES[name];

    this.evaluate = function () {
        return arguments[this.getVariable];
    };

    this.toString = function () {
        return this.nameVariable.toString();
    };
}