package com.epam.entity;

import com.epam.exception.ComponentException;

import java.util.List;

public interface Component {
    void add(Component c) throws ComponentException;
    void remove(Component c) throws ComponentException;
    List<Component> getComponent () throws ComponentException;
}
