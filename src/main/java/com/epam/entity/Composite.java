package com.epam.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite implements Component {
    private List<Component> components;

    public Composite(List<Component> components) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Composite)) {
            return false;
        }
        Composite composite = (Composite) o;
        return components.equals(composite.components);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + components.hashCode();
        return result;
    }
}
