package com.epam.entity;

import com.epam.exception.ComponentException;

import java.util.List;

public class Leaf implements Component {
    String lexicalItem;
    LeafType leafType;

    public Leaf(String lexicalItem, LeafType leafType) {
        this.lexicalItem = lexicalItem;
        this.leafType = leafType;
    }

    public static Leaf getLeaf(String lexicalItem, LeafType leafType){
        return new Leaf(lexicalItem, leafType);
    }

    public void add(Component c) throws ComponentException {
        throw new ComponentException("Adding operation is not supprted");
    }
    public void remove(Component c) throws ComponentException {
        throw new ComponentException("Removal operation is not supported");

    }
    public List<Component> getComponent() throws ComponentException {
        throw new ComponentException("Impossible to get components from leaf");
    }
}
