package com.epam.entity;

import java.util.List;

public interface Component {
    void add(Component c);
    void remove(Component c);
    List<Component> getComponent ();
}
