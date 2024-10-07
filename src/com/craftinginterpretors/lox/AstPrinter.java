package com.craftinginterpretors.lox;

import com.craftinginterpretors.lox.Expr.Assign;
import com.craftinginterpretors.lox.Expr.Call;
import com.craftinginterpretors.lox.Expr.Logical;
import com.craftinginterpretors.lox.Expr.Variable;

class AstPrinter implements Expr.Visitor<String>{
    String print(Expr expr) {
        return expr.accept(this);
    }

    @Override 
    public String visitBinaryExpr(Expr.Binary expr) {
        return parenthesize(expr.operator.lexeme, expr.left, expr.right);
    }

    @Override
    public String visitGroupingExpr(Expr.Grouping expr) {
        return parenthesize("group", expr.expression);
    }

    @Override
    public String visitLiteralExpr(Expr.Literal expr) {
        if (expr.value == null) return "nil";
        return expr.value.toString();
    }

    @Override
    public String visitUnaryExpr(Expr.Unary expr) {
        return parenthesize(expr.operator.lexeme, expr.right);
    }

    private String parenthesize(String name, Expr... exprs) {
        StringBuilder builder = new StringBuilder();

        builder.append("(").append(name);

        for(Expr expr : exprs) {
            builder.append(" ");
            builder.append(expr.accept(this));
        }

        builder.append(")");

        return builder.toString();
    }

    @Override
    public String visitAssignExpr(Assign expr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitAssignExpr'");
    }

    @Override
    public String visitCallExpr(Call expr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitCallExpr'");
    }

    @Override
    public String visitLogicalExpr(Logical expr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitLogicalExpr'");
    }

    @Override
    public String visitVariableExpr(Variable expr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitVariableExpr'");
    }

    // pritns (* (- 123) (group 45.67)) . was checking the ast tree printer
    // public static void main(String[] args) {
    //     Expr expression = new Expr.Binary(
    //         new Expr.Unary(new Token(TokenType.MINUS, "-", null, 1), 
    //                         new Expr.Literal(123)),
    //         new Token(TokenType.STAR, "*", null, 1),
    //         new Expr.Grouping(new Expr.Literal(45.67))
    //     );

    //     System.out.println(new AstPrinter().print(expression));
    // }
}
