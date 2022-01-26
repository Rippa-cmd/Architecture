package ru.geekbrains.objectValue;

import java.util.List;
import java.util.Collections;

public class ListValue {

    private final List<?> list;

    public ListValue(List<?> list) {
        this.list = Collections.unmodifiableList(list);
    }

    public List<?> getList() {
        return list;
    }
}
