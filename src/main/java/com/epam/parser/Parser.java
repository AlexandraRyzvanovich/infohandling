package com.epam.parser;

import com.epam.entity.Component;
import com.epam.exception.ComponentException;
import com.epam.exception.ParserException;

public abstract class Parser {
    private Parser successor;

    public abstract Component parse(String text) throws ParserException, ComponentException;

    Parser getSuccessor() {
        return successor;
    }

    void setSuccessor(Parser successor) {
        this.successor = successor;
    }
}
