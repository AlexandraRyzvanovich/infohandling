package com.epam.sorter;

import com.epam.entity.Component;
import com.epam.entity.Composite;
import com.epam.exception.ComponentException;

import java.util.Comparator;
import java.util.List;

public class ParagraphBySentenceCountSorter implements Sorter {
    @Override
    public Component sort(Component component) throws ComponentException {
        List<Component> componentsList = component.getComponent();
        Comparator<Component> comparatorSentences = Comparator.comparing(a -> a.getComponent().size());
        componentsList.sort(comparatorSentences.reversed());
        return new Composite(componentsList);
    }
}
