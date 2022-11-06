package mx.unam.diplomado.app;


import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mx.unam.diplomado.pojo.DataPojo;

public class ClientWSDemoApp {

	private static final String REST_URI_PING = "http://localhost:8080/wsdemo/ws/actions/ping";
	private static final String REST_URI_XML = "http://localhost:8080/wsdemo/ws/actions/xml";
	private static final String REST_URI_XML_OBJECT = "http://localhost:8080/wsdemo/ws/actions/xmlobject";
	private static final String REST_URI_JSON_GET = "http://localhost:8080/wsdemo/ws/actions/get/";
	private static final String REST_URI_JSON_POST = "http://localhost:8080/wsdemo/ws/actions/post";

	public static void main(String[] args) {		
		ClientWSDemoApp app = new ClientWSDemoApp();
		app.consumesPingWS();
		app.consumeXML();
		app.consumeXMLObject();
		app.consumeGetId();
		app.consumePost();
	}

	public void consumesPingWS() {
		System.out.println("Consumiendo WS Ping");
		Client client = ClientBuilder.newClient();
		String s = client.target(REST_URI_PING).request(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println("La respuesta es:" + s);
	}
	
	public void consumeXML() {
		System.out.println("Consumiendo WS XML");
		Client client = ClientBuilder.newClient();
		String s = client.target(REST_URI_XML).request(MediaType.APPLICATION_XML).get(String.class);
		System.out.println("La respuesta es:" + s);
	}
	
	public void consumeXMLObject() {
		System.out.println("Consumiendo WS XML Object");
		Client client = ClientBuilder.newClient();
		Response resp = client.target(REST_URI_XML_OBJECT).request(MediaType.APPLICATION_XML).get();
		String s = resp.readEntity(String.class);
		System.out.println("La respuesta es:" + s);
	}
	
	public void consumeGetId() {
		System.out.println("Consumiendo WS GET JSON");
		Client client = ClientBuilder.newClient();
		WebTarget myResource = client.target(REST_URI_JSON_GET)
				.path("{id}")
				.resolveTemplate("id", 3);
		Response resp = myResource.request(MediaType.APPLICATION_JSON).get();
		DataPojo data = resp.readEntity(DataPojo.class);
		System.out.println("La respuesta es:" + data);
	}
	
	public void consumePost() {
		System.out.println("Consumiendo WS POST JSON");
		DataPojo data = new DataPojo(8, "information");
		Client client = ClientBuilder.newClient();
		WebTarget myResource = client.target(REST_URI_JSON_POST);
		DataPojo dataResp = myResource.request(MediaType.APPLICATION_JSON)
				.post(Entity.json(data), DataPojo.class);
		System.out.println("La respuesta es:" + dataResp);
	}

}
