package pl.com.sages.jprog.xml.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Created by marcin on 05.10.2016.
 */
public class SaxTrainingParser {

    public void parseStudents(){

        try {
            File inputFile = new File("./src/main/resources/training.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            StudentsHandler handler = new StudentsHandler();
            saxParser.parse(inputFile, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
