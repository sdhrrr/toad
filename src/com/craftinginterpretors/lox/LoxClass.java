package com.craftinginterpretors.lox;

import java.util.List;
import java.util.Map;

public class LoxClass implements LoxCallable{
    final String name;

    LoxClass(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int arity() {
        return 0;
    }

    
}
