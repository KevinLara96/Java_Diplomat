package mx.unam.diplomado.xml;


import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import mx.unam.diplomado.pojo.DataPojo;

public class XMLCreatorData {

	public static String createBasicXML(DataPojo data) {
		Document document = new Document();
		Element root = new Element("data");
		document.setRootElement(root);
		root.setAttribute("required", "true");
		Element id = new Element("id");
		id.setText(String.valueOf(data.getId()));
		root.addContent(id);

		Element message = new Element("message");
		message.setText(data.getMessage());
		root.addContent(message);

		XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
		String xmlString = outputter.outputString(document);
		return xmlString;
	}

}
