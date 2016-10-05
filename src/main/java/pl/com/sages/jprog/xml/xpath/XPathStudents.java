package pl.com.sages.jprog.xml.xpath;


import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import pl.com.sages.jprog.xml.dom.DOMTrainingParser;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

/**
 * Created by marcin on 05.10.2016.
 */
public class XPathStudents{

    public void parseStudents() throws Exception {

        DOMTrainingParser domParser = new DOMTrainingParser();
        Document doc = new DOMTrainingParser().getDocument();

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();

        XPathExpression expr = xpath.compile("/training/students/student");
        NodeList students = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        domParser.presentStudents(students);


    }

}
