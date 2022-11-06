package mx.unam.diplomado.pojo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class TemperaturaPojo {

    @XmlElement(required = true)
    private Double centigrados;

    @XmlElement(required = true)
    private Double farenheit;

    public TemperaturaPojo() {
    }

    public TemperaturaPojo(Double centigrados, Double farenheit) {
        this.centigrados = centigrados;
        this.farenheit = farenheit;
    }

    public Double getCentigrados() {
        return centigrados;
    }

    public void setCentigrados(Double centigrados) {
        this.centigrados = centigrados;
    }

    public Double getFarenheit() {
        return farenheit;
    }

    public void setFarenheit(Double farenheit) {
        this.farenheit = farenheit;
    }

}
