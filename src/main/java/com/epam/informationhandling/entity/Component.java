package com.epam.informationhandling.entity;

import com.epam.informationhandling.util.RegexHandler;

import java.util.ArrayList;

public class Component implements Parsable, Assembly {
    Type type;
    private String regex;
    private ArrayList<Component> components = new ArrayList<>();

    public Component(Type type) {
        this.type = type;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public void parse(String value) {
        components.clear();
        String regex = RegexHandler.defineRegex(this.type);
        if (type.ordinal() < Type.values().length - 1) {
            for (String element : value.split(regex)) {
                Component component = new Component(Type.values()[this.type.ordinal() + 1]);
                components.add(component);
                component.parse(element);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public String assemble() {
        return null;
    }
}
