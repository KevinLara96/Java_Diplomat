package mx.unam.diplomado.data;

import java.math.BigDecimal;
import java.util.Date;

public class FormatoDato {
	
	private Date fecha;	
	private BigDecimal salario;	
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	

}
