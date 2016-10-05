package pl.com.sages.jprog.xml;

import pl.com.sages.jprog.xml.dom.DOMTrainingParser;
import pl.com.sages.jprog.xml.sax.SaxTrainingParser;
import pl.com.sages.jprog.xml.xpath.XPathStudents;
import pl.com.sages.jprog.xml.xsl.XSLStudentsTransform;

/**
 * Created by marcin on 05.10.2016.
 */
public class XMLTester {
    public static void main(String[] args) throws Exception {

        System.out.println("dom:");
        //new DOMTrainingParser().parseStudents();

        System.out.println("sax");
        //new SaxTrainingParser.parseStudents();

        System.out.println("xpath");
        //new  XPathStudents().parseStudents();

        System.out.println("xslt");
        //new XSLStudentsTransform().transformStudents();
    }
}
