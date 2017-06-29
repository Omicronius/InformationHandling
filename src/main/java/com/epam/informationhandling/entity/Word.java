package com.epam.informationhandling.entity;

public class Word extends Component {
    private String value;

    public Word(Type type, String value) {
        super(type);
        this.value = value;
    }

    @Override
    public String assemble() {
        return value;
    }
}
