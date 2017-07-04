package com.epam.informationhandling.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite extends Component {
    private List<Component> components = new ArrayList<>();

    public TextComposite(ComponentType type) {
        super(type);
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public List<Component> getComponents() {
        return components;
    }


    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : components) {
            stringBuilder.append(component.toString());
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
