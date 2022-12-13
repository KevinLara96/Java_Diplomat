package unam.dgtic.diplomado.modelo.entidades.cliente;

public class ClienteOrden{
	private Integer idCliente;
	private Integer idOrden;

	public ClienteOrden(){

	}

	public ClienteOrden(Integer idCliente, Integer idOrden){
		this.idCliente = idCliente;
		this.idOrden = idOrden;
	}

	public Integer getIdCliente(){
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) throws Exception{
		if(idCliente == null || idCliente <= 0){
			throw new ExcepcionAtributos("IdCliente inválido.");
		} else {
			this.idCliente = idCliente;
		}
	}

	public Integer getIdOrden(){
		return this.idOrden;
	}

	public void setIdOrden(Integer idOrden) throws Exception{
		if(idOrden == null || idOrden <= 0){
			throw new ExcepcionAtributos("IdOrden inválido.");
		} else {
			this.idOrden = idOrden;
		}
	}
}
