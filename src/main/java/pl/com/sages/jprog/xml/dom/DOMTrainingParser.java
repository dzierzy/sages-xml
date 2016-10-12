package pl.com.sages.jprog.xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Date;

/**
 * Created by marcin on 05.10.2016.
 */
public class DOMTrainingParser {

    Document doc;

    String date;

    public Document getDocument() {
        return doc;
    }

    public DOMTrainingParser() throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.parse(new File("./src/main/resources/training.xml"));
        date = doc.getDocumentElement().getAttribute("date");
        System.out.println("Training session attendees at " + date );

    }

    public String getDate() {
        return date;
    }

    public void parseStudents(){
        NodeList students = doc.getElementsByTagName("student");
        presentStudents(students);
    }

    public void presentStudents(NodeList students){
        for(int i = 0 ; i < students.getLength(); i++){
            Node student = students.item(i);
            if (student.getNodeType() == Node.ELEMENT_NODE) {
                Element eStudent = (Element) student;
                String id = eStudent.getAttribute("id");
                System.out.println("id: " + id);

                // TODO show first and last name

            }
        }
    }
}
