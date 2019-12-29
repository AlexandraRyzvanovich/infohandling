package com.epam.sorter;

import com.epam.entity.Component;
import com.epam.entity.Composite;
import com.epam.exception.ComponentException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SentenceSorterByWordsLength implements Sorter {

    @Override
    public Component sort(Component component) throws ComponentException {
        ArrayList<Component> sentence = new ArrayList<>(component.getComponent());
        Comparator<Component> wordsComparator = Comparator.comparing(a-> String.valueOf(a).length());
        sentence.sort(wordsComparator);
        return new Composite(sentence);
    }
}
