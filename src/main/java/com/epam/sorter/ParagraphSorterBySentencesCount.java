package com.epam.sorter;

import com.epam.entity.Component;
import com.epam.entity.Composite;
import com.epam.exception.ComponentException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ParagraphSorterBySentencesCount implements Sorter {
    @Override
    public Component sort(Component component) throws ComponentException {
        List<Component> componentsList = component.getComponent();
        List<Component> components = new ArrayList<>(componentsList);
        Comparator<Component> comparatorSentences = Comparator.comparing(a -> a.getComponent().size());
        components.sort(comparatorSentences);
        return new Composite(components);
    }
}
