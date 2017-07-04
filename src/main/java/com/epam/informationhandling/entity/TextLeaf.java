package com.epam.informationhandling.entity;

import java.util.ArrayList;
import java.util.List;

public class TextLeaf extends Component {
    private String value;

    public TextLeaf(ComponentType type, String value) {
        super(type);
        this.value = value;
    }

    @Override
    public void add(Component component) {
    }

    @Override
    public void remove(Component component) {
    }

    @Override
    public List<Component> getComponents() {
        List<Component> stub = new ArrayList<>();
        stub.add(this);
        return stub;
    }

    @Override
    public void setComponents(List<Component> components) {
    }

    @Override
    public String toString() {
        return value.trim();
    }
}
