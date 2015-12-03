package com.company.input;

import com.company.input.Element.ElementShapes;
import com.company.shapes.NameShapes;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Считывает xml, если тег с именем из листа NameShapes.NAME_SHAPES создаёт ElementShapes.
 * Созданые ElementShapes с записыними в них атрибутами ложет в listElementShapes;
 */
public class HandlerXMLShapes extends DefaultHandler {

    private ArrayList<ElementShapes> listElementShapes = new ArrayList<>(); //Список считанных элементов


    private String thisTag ="";//Тег который сейчас обрабатывается
    private ElementShapes thisElementShapes; // Элемент в который сейчас записываются данные

    private int id=1; //id читаемого элемента

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //Если тег(qName) равен одному из элементов списка NameShapes.NAME_SHAPES то мы присваиваем значение qName в thisShapes
        for(String s: NameShapes.NAME_SHAPES){
            if(s.equals(qName)){
                thisElementShapes = new ElementShapes(qName,id);
                id++;
            }
        }
        //Указываем какой тег мы обрабатываем
        thisTag = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        for(String s:NameShapes.NAME_SHAPES){
            if(s.equals(qName)){
                listElementShapes.add(thisElementShapes);
                thisElementShapes = null;
            }
        }
        thisTag ="";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch,start,length);

        if(value.charAt(0) == '\n'){
            return;
        }

        if(thisElementShapes==null){
            return;
        }
        thisElementShapes.addAttributes(thisTag,value);
    }

    /**
     * Возвращает обработанные элементы.
     * @return обработанные элементы из списка listElementShapes.
     */

    public ArrayList<ElementShapes> getListElementShapes() {
        return listElementShapes;
    }
}
