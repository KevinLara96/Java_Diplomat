package mx.unam.diplomado.pojo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="data")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataPojo {

	@XmlElement(required=true)
    private int id;
	
	@XmlElement(required=true)
    private String message;

    public DataPojo() {
    }

    public DataPojo(int id, String message) {
        this.id = id;
        this.message = message;
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