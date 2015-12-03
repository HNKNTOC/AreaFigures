package com.company;

import com.company.input.ParsingXML;
import com.company.shapes.Shapes;
import java.io.File;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        ParsingXML parsingXML = new ParsingXML();

        //args = new String[]{"C:\\Users\\HNKNTOC\\Desktop\\Test.xml"};

        //Проверяем есть ли в  args путь файла
        if(args.length==0){
            System.err.println("The argument is not passed");
            return;
        }

        File file = new File(args[0]);

        //Проверить существует ли файл
        if (!file.exists()) {
            System.err.println("Can not find the file specified: "+file.getAbsolutePath());
            return;
        }
        //Получаем лист с Shapes
        ArrayList<Shapes> listShapes = parsingXML.getListShapes(file);

        if(listShapes == null){
            return;
        }

        //Выводим сообшение
        for (Shapes shapes : listShapes) {
            System.out.printf("%s:%s - %s \n", shapes.getId(), shapes.getColor(), shapes.calculateArea());
        }
    }
}
