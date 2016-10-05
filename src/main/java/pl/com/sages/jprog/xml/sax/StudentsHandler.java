package pl.com.sages.jprog.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by marcin on 05.10.2016.
 */
public class StudentsHandler extends DefaultHandler {

    boolean bFirstName = false;
    boolean bLastName = false;

    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            String id = attributes.getValue("id");
            System.out.println("ID : " + id);
        } else if (qName.equalsIgnoreCase("firstName")) {
            bFirstName = true;
        } else if (qName.equalsIgnoreCase("lastName")) {
            bLastName = true;
        }
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char ch[],
                           int start, int length) throws SAXException {
        if (bFirstName) {
            System.out.println("First Name: "
                    + new String(ch, start, length));
            bFirstName = false;
        } else if (bLastName) {
            System.out.println("Last Name: "
                    + new String(ch, start, length));
            bLastName = false;
        }
    }
}