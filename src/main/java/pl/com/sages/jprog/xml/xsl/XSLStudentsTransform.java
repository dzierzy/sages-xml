package pl.com.sages.jprog.xml.xsl;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by marcin on 05.10.2016.
 */
public class XSLStudentsTransform {

    public void transformStudents() throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();

        StreamSource xslStream = new StreamSource("./src/main/resources/training.xslt");
        Transformer transformer = factory.newTransformer(xslStream);
        StreamSource in = new StreamSource("./src/main/resources/training.xml");
        StreamResult out = new StreamResult("./training.html");
        transformer.transform(in, out);
        System.out.println("The generated HTML file");
    }
}
