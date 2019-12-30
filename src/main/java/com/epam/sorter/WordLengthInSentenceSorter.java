package com.epam.sorter;

import com.epam.entity.Component;
import com.epam.entity.Composite;

import java.util.Comparator;
import java.util.List;

public class WordLengthInSentenceSorter implements Sorter {
    @Override
    public Component sort(Component component) {
        List<Component> list = component.getComponent();
        Comparator<Component> wordComparator = Comparator.comparing(a -> String.valueOf(a).length());
        list.sort(wordComparator.reversed());
        return new Composite(list);
    }
}
