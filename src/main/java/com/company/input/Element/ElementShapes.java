package com.company.input.Element;

import com.company.shapes.*;

import java.util.ArrayList;

/**
 * Содержит информацию о считываемой фигуре с xml
 */
public class ElementShapes {

    private String name;
    private int id;
    private ArrayList<AttributesShapes> listAttributes = new ArrayList<>(); // Лист с атрибутами

    public ElementShapes(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void addAttributes(String name,String value){
        listAttributes.add(new AttributesShapes(name,value));
    }


    /**
     * Создаёт из ElementShapes фигуру(shapes) и возвращает её
     * @return Созданная фигура(shapes)
     */
    public Shapes CreateShapes(){
        Shapes shapes = null;

        switch (name){
            case NameShapes.CIRCLE: shapes = newCircle(); break;
            case NameShapes.RECTANGLE: shapes = newRectangle(); break;
            case NameShapes.SQUARE: shapes = newSquare(); break;
            case NameShapes.TRIANGLE: shapes = newTriangle(); break;
        }

        return shapes;
    }

    /**
     * Создаёт Circle.
     * Из listAttributes отбирает AttributesShapes с Name = "diameter"  для Circle.
     * @return Circle.
     */
    private Circle newCircle(){

        Circle circle = new Circle(Float.parseFloat(findValueAttribute(NameAttribute.DIAMETER)));

        askValuesShapes(circle);

        return circle;
    }

    /**
     * Создаёт Rectangle.
     * Из listAttributes отбирает 2 AttributesShapes с Name = "side"  для Rectangle.
     * @return Rectangle.
     */
    private Rectangle newRectangle(){

        float a = Float.parseFloat(findValueAttribute(NameAttribute.SIDE));
        float b = Float.parseFloat(findValueAttribute(NameAttribute.SIDE));

        Rectangle rectangle = new Rectangle(a,b);

        askValuesShapes(rectangle);


        return rectangle;
    }

    /**
     * Создаёт Square.
     * Из listAttributes отбирает AttributesShapes с Name = "side"  для Square.
     * @return Square.
     */
    private Square newSquare(){
        Square square = new Square(Float.parseFloat(findValueAttribute(NameAttribute.SIDE)));

        askValuesShapes(square);

        return square;
    }

    /**
     * Создаёт Triangle.
     * Из listAttributes отбирает 3 AttributesShapes с Name = "side"  для Triangle.
     * @return Triangle.
     */
    private Triangle newTriangle(){

        float a = Float.parseFloat(findValueAttribute(NameAttribute.SIDE));
        float b = Float.parseFloat(findValueAttribute(NameAttribute.SIDE));
        float c = Float.parseFloat(findValueAttribute(NameAttribute.SIDE));

        Triangle triangle = new Triangle(a,b,c);

        askValuesShapes(triangle);

        return triangle;
    }

    /**
     * Устанавливает значения для shapes
     * @param shapes ;
     */
    private void askValuesShapes(Shapes shapes){
        shapes.setName(name);
        shapes.setId(id);
        shapes.setColor(findValueAttribute(NameAttribute.COLOR));
    }

    /**
     * Ищет AttributesShapes в listAttributes и возвращает его значение null если не нашел
     * После нахождения задаёт значение Name в AttributesShapes = ""; для предотвращения повторного нахождения.
     * @param name Имя AttributesShapes
     * @return Значение AttributesShapes
     */
    public String findValueAttribute(String name) {
        for (AttributesShapes a : listAttributes) {
            if (a.getName().equals(name)) {
                a.setName("");
                return a.getValue();
            }
        }
        return null;
    }



    @Override
    public String toString() {
        return "ElementShapes{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
