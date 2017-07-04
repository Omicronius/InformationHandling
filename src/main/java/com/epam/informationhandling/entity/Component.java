package com.epam.informationhandling.entity;


import java.util.List;

public abstract class Component {
    ComponentType type;

    public Component(ComponentType type) {
        this.type = type;
    }

    public abstract void setComponents(List<Component> components);

    public abstract List<Component> getComponents();

    public abstract void add(Component component);

    public abstract void remove(Component component);

    public ComponentType getType() {
        return type;
    }
}


