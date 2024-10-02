package com.craftinginterpretors.lox;

import java.util.List;

public class LoxFunction implements LoxCallable{
    private final Stmt.Function declaration;
    private final Environment closure;

    LoxFunction(Stmt.Function declaration, Environment closure) {
        this.closure = closure;
        this.declaration = declaration;
    }

    @Override
    public Object call(Interpretor interpretor, List<Object> arguments) {
        Environment environment = new Environment(closure);

        for(int i=0; i<declaration.params.size(); i++) {
            environment.define(declaration.params.get(i).lexeme, arguments.get(i));
        }

        try {
            interpretor.executeBlock(declaration.body, environment);
        } catch (Return returnValue) {
            return returnValue.value;
        }
        return null;
    }

    @Override
    public int arity() {
        return declaration.params.size();
    }

    @Override
    public String toString() {
        return "<fn " + declaration.name.lexeme + ">";
    }
}
