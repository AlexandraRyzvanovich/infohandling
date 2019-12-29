package com.epam.sorter;

import com.epam.entity.Component;
import com.epam.exception.ComponentException;

public interface Sorter  {

    Component sort(Component component) throws ComponentException;
}
