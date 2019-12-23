package com.epam.entity;

import com.epam.entity.Component;

public class Leaf implements Component {
    public void operation() {
    }
    public void add(Component c) {

    }
    public void remove(Component c) {

    }
    public Object getChild(int index) {
        throw new UnsupportedOperationException();
    }
}
