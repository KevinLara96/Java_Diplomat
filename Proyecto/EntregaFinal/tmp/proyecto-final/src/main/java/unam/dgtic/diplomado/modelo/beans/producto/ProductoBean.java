package unam.dgtic.diplomado.modelo.beans.producto;

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import unam.dgtic.diplomado.controlador.servicio.producto.ServicioProducto;
import unam.dgtic.diplomado.modelo.entidades.producto.ProductoEntity;

@Named
@SessionScoped
public class ProductoBean implements Serializable {

    private ServicioProducto servicioProducto;
    private ProductoEntity productoEntity;

    private Integer idProducto;
    private String nombreProducto;
    private Float multiplicador;
    private String estatus;

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

    public void obtenerProducto() {
        servicioProducto = new ServicioProducto();

        this.productoEntity = servicioProducto.obtenerProducto(this.idProducto);
    }

    public void actualizarProducto() {
        servicioProducto = new ServicioProducto();

        ProductoEntity productoMod = servicioProducto.obtenerProducto(this.idProducto);
        try {
            productoMod.setIdProducto(this.idProducto);
            productoMod.setNombreProducto(productoEntity.getNombreProducto());
            productoMod.setMultiplicador(productoEntity.getMultiplicador());
            productoMod.setEstatus(productoEntity.getEstatus());
            productoMod.setOrdenes(servicioProducto.productoJoinOrden(this.getIdProducto()));

            servicioProducto.actualizarProducto(productoMod);
            this.estatusStr = "Producto actualizado con éxito";
        } catch (Exception e) {
            this.estatusStr = "No se pudo actualizar el producto: " + e.getMessage();
        }
    }

    public void nuevoProducto() {
        servicioProducto = new ServicioProducto();

        this.productoEntity = new ProductoEntity();
        try {
            productoEntity.setIdProducto(this.idProducto);
            productoEntity.setNombreProducto(this.nombreProducto);
            productoEntity.setMultiplicador(this.multiplicador);
            productoEntity.setEstatus(this.estatus);
            productoEntity.setOrdenes(servicioProducto.productoJoinOrden(this.idProducto));

            servicioProducto.guardarProducto(productoEntity);
            this.estatusStr = "Producto agregado con éxito.";
        } catch (Exception e) {
            this.estatusStr = "No se pudo agregar el producto: " + e.getMessage();
        }
    }

    public void eliminarProducto() {
        servicioProducto = new ServicioProducto();
        try {
            if (servicioProducto.eliminarProducto(this.idProducto)) {
                this.estatusStr = "Producto eliminado con éxito";
            } else {
                this.estatusStr = "ERROR. No se pudo eliminar el producto";
            }
        } catch (Exception e) {
            this.estatusStr = "ERROR. No se pudo eliminar el producto";
        }
    }
}
