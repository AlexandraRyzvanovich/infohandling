package com.epam.entity;

import com.epam.exception.ComponentException;

import java.util.List;
import java.util.Objects;

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

    public void add(Component c)  {
        throw new ComponentException("Adding operation is not supported");
    }
    public void remove(Component c) {
        throw new ComponentException("Removal operation is not supported");

    }
    public List<Component> getComponent() {
        throw new ComponentException("Impossible to get components from leaf");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Leaf)) {
            return false;
        }
        Leaf leaf = (Leaf) o;
        return lexicalItem.equals(leaf.lexicalItem) &&
                leafType == leaf.leafType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + lexicalItem.hashCode();
        result = prime * result + leafType.hashCode();
        return result;
    }
}
