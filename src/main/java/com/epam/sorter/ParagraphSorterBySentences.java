package com.epam.sorter;

import com.epam.entity.Component;
import com.epam.entity.Composite;
import com.epam.exception.ComponentException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ParagraphSorterBySentences implements Sorter {
    @Override
    public Component sort(Component component) throws ComponentException {
        ArrayList<Component> components = new ArrayList<>(component.getComponent());
        Comparator<Component> comparatorSentences = Comparator.comparing(a -> a.getComponent().size());
        components.sort(comparatorSentences);
        return new Composite(components);
    }
}
