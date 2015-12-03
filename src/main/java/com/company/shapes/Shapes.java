package com.company.shapes;

/**
 * Содержет данные фигуры.
 */
public class Shapes {
    private String name;
    private String color;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Вычисляет площадь фигуры
     * @return площадь
     */
    public double calculateArea(){
        return 0.0f;
    }

    @Override
    public String toString() {
        return "shapes{" +
                "name='" + name + '\'' +
                ", COLOR='" + color + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
