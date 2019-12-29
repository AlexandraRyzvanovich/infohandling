package com.epam.sorter;

import com.epam.entity.Component;
import com.epam.entity.Composite;
import com.epam.exception.ComparatorException;
import com.epam.exception.ComponentException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SentenceSorterByWords implements Sorter {
    @Override
    public Component sort(Component component) throws ComponentException {
        ArrayList<Component> components = new ArrayList<>(component.getComponent());
        Comparator<Component> comparatorSentences = Comparator.comparing(a -> {
            try {
                return a.getComponent().size();
            } catch (ComponentException e) {
                throw new ComparatorException("Exception occurred while comparing", e.getCause());
            }
            return null;
        });
        Collections.sort(components, comparatorSentences);
        Component sortedComposite = new Composite(components);
        return sortedComposite;
    }
}
