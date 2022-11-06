package mx.unam.diplomado.pojo;

public class DataPojo {

	private int id;

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

	@Override
	public String toString() {
		return "DataPojo [id=" + id + ", message=" + message + ", getId()=" + getId() + ", getMessage()=" + getMessage()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}