package com.epam.entity;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private ArrayList<Component> components;

    public Composite(ArrayList<Component> components) {
        this.components = components;
    }

    public Composite() {
        components = new ArrayList<>();
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    public List<Component> getComponent() {
        return components;
    }
}
