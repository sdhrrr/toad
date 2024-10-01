package com.craftinginterpretors.lox;

import java.util.List;

interface LoxCallable {
    int arity();
    Object call(Interpretor interpretor, List<Object> arguments);
}
