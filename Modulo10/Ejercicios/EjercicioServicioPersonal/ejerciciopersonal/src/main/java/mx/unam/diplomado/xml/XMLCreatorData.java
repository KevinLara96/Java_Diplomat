package mx.unam.diplomado.xml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import mx.unam.diplomado.pojo.AgenciaPojo;

public class XMLCreatorData {

    public static String createBasicXML(AgenciaPojo agencia) {
        Document document = new Document();
        Element root = new Element("agencia");
        document.setRootElement(root);
        root.setAttribute("required", "true");
        Element id = new Element("id");
        id.setText(String.valueOf(agencia.getIdAgencia()));
        root.addContent(id);

        Element message = new Element("message");
        message.setText(agencia.getUbicacion());
        root.addContent(message);

        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        String xmlString = outputter.outputString(document);
        return xmlString;
    }

}
