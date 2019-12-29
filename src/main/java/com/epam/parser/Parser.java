package com.epam.parser;

import com.epam.entity.Component;
import com.epam.exception.ComponentException;
import sun.tools.jstat.ParserException;

public abstract class Parser {
    private Parser successor;

    Component parse(String text) throws ParserException, ComponentException {
        Component component = null;
        if ( getSuccessor() != null ){
            component  = getSuccessor().parse(text);
        }
        else{
            throw new ParserException("Unable to find the correct parser. ");
        }
        return component;
    }

    Parser getSuccessor() {
        return successor;
    }

    void setSuccessor(Parser successor) {
        this.successor = successor;
    }
}
