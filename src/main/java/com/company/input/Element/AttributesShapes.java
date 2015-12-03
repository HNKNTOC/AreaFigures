package com.company.input.Element;

/**
 * Содержит имя и значение атрибута
 */
public class AttributesShapes {
    private String name;
    private String value;

    public AttributesShapes(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AttributesShapes{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
