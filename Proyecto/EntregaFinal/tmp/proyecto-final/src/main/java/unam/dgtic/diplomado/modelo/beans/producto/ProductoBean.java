package unam.dgtic.diplomado.modelo.beans.producto;

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import unam.dgtic.diplomado.controlador.servicio.producto.ServicioProducto;
import unam.dgtic.diplomado.modelo.beans.orden.OrdenBean;
import unam.dgtic.diplomado.modelo.entidades.producto.ProductoEntity;

@Named
@SessionScoped
public class ProductoBean implements Serializable {

    private ServicioProducto servicioProducto;
    private ProductoEntity productoEntity;

    private int idProducto;
    private String nombreProducto;
    private Float multiplicador;
    private String estatus;

    private List<OrdenBean> ordenes;
    private String estatusStr;

    /*
     * Constructores
     */
    public ProductoBean() {
    }

    /*
     * Getters & Setters.
     */
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Float getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(Float multiplicador) throws Exception {
        this.multiplicador = multiplicador;

    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public List<OrdenBean> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<OrdenBean> ordenes) {
        this.ordenes = ordenes;
    }

    public ProductoEntity getProductoEntity() {
        return productoEntity;
    }

    public void setProductoEntity(ProductoEntity productoEntity) {
        this.productoEntity = productoEntity;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getEstatusStr() {
        return estatusStr;
    }

    public void setEstatusStr(String estatusStr) {
        this.estatusStr = estatusStr;
    }

    /*
     * Métodos bean
     */
    public List<ProductoEntity> obtenerProductos() {
        servicioProducto = new ServicioProducto();

        return (List<ProductoEntity>) servicioProducto.obtenerProductos();
    }

}
