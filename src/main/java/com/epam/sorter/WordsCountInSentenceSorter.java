package com.epam.sorter;

import com.epam.entity.Component;
import com.epam.entity.Composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WordsCountInSentenceSorter implements Sorter {
    @Override
    public Component sort(Component component) {
        List<Component> componentList = component.getComponent();
        Comparator<Component> wordsComparator = Comparator.comparing(a -> a.toString().length());
         componentList.sort(wordsComparator);
         Component sss = new Composite(componentList);
        return new Composite(componentList);
    }
}
