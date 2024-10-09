package com.craftinginterpretors.lox;

import java.util.List;

public class LoxFunction implements LoxCallable{
    private final Stmt.Function declaration;
    private final Environment closure;

    private final boolean isInitializer;

    LoxFunction(Stmt.Function declaration, Environment closure, boolean isInitializer) {
        this.isInitializer = isInitializer;
        this.closure = closure;
        this.declaration = declaration;
    }

    LoxFunction bind(LoxInstance instance) {
        Environment environment = new Environment(closure);
        environment.define("this", instance);
        return new LoxFunction(declaration, environment, isInitializer); 
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
            if(isInitializer) return closure.getAt(0, "this");

            return returnValue.value;
        }

        if(isInitializer) return closure.getAt(0, "this");

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
