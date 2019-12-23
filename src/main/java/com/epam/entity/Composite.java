package com.epam.entity;

import com.epam.entity.Component;

import java.util.ArrayList;

public class Composite implements Component {
    private ArrayList<Component> components = new ArrayList<Component>();

    public void operation() {
        System.out.println("Composite -> Call children operations");
        int size = components.size();
        for (int i = 0; i < size; i++) {
            components.get(i).operation();
        }
    }

    public void add(Component component) {
        System.out.println("Composite -> Adding component");
        components.add(component);
    }

    public void remove(Component component) {
        System.out.println("Composite -> Removing component");
        components.remove(component);
    }

    public Object getChild(int index) {
        System.out.println("Composite -> Getting component");
        return components.get(index);
    }
}
