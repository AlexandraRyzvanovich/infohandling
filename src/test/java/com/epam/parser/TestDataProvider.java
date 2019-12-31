package com.epam.parser;

import com.epam.entity.Component;
import com.epam.entity.Leaf;
import com.epam.entity.LeafType;

public class TestDataProvider {
    public static final String SENTENCE_ONE = "I'm the first sentence.";
    public static final String SENTENCE_TWO = "I'm the second sentence.";
    public static final String SENTENCE_THREE = "I'm the third sentence.";
    public static final Component LEAF_SENTENCE_ONE = Leaf.getLeaf(SENTENCE_ONE, LeafType.WORD);
    public static final Component LEAF_SENTENCE_TWO = Leaf.getLeaf(SENTENCE_TWO, LeafType.WORD);
    public static final Component LEAF_SENTENCE_THREE = Leaf.getLeaf(SENTENCE_THREE, LeafType.WORD);
    public static final Component LEAF_WORD_ONE = Leaf.getLeaf("Word", LeafType.WORD);
    public static final Component LEAF_WORD_TWO = Leaf.getLeaf("happy", LeafType.WORD);
}
