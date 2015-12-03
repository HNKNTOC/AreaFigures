package com.company.input;

import com.company.shapes.Shapes;
import com.company.input.Element.ElementShapes;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.xml.sax.SAXException;


import javax.annotation.Resource;
import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class ParsingXML{

    private SAXParserFactory factory = SAXParserFactory.newInstance();
    private HandlerXMLShapes handler = new HandlerXMLShapes();
    private File xsd = new File("src/main/resources/shapes.xsd");

    public ParsingXML() {

    }

    /**
     * Возвращает лист элементов из XML.
     * @param xml XML из которого нужно считать фигуры.
     * @return список фигур.
     */
    public ArrayList<Shapes> getListShapes(File xml) {

        try {

            if (!validityCheckXML(xml)) {
                System.err.println("XML not validity XSD");
                return null;
            }

            SAXParser parser = factory.newSAXParser();
            parser.parse(xml,handler);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ArrayList<ElementShapes> elementShapes = handler.getListElementShapes();
        ArrayList<Shapes> shapes = new ArrayList<>();

        for(ElementShapes e: elementShapes) shapes.add(e.CreateShapes());

        return shapes;
    }


    /**
     * Проверка xml на соответствие xsd
     * @param xml провер¤емый xml
     * @return true если xml соответствует xsd false если не соответствует
     */
    public boolean validityCheckXML(File xml){

        if(xsd==null){
            System.err.println("Not found shapes.xsd");
            return false;
        }

        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsd));

            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));

        } catch (SAXException e) {
            e.printStackTrace();
            //System.err.println(e.getMessage());
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
