package mx.unam.diplomado.pojo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="data")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataPojo {
	
	@XmlAttribute
	public String on;

	@XmlElement(required=true)
    private int id;
	
	@XmlElement(required=true)
    private String message;

    public DataPojo() {
    }
    
    public void setOn(String on) {
    	this.on = on;
    }
    
    public String getOn() {
    	return on;
    }

    public DataPojo(int id, String message, String on) {
        this.id = id;
        this.message = message;
        this.on = on;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}