import java.util.List;

import mx.unam.tic.diplomado.agenda.modelo.entidades.Catalogo;
import mx.unam.tic.diplomado.agenda.modelo.entidades.MedioContacto;
import mx.unam.tic.diplomado.agenda.modelo.entidades.TipoContacto;
import mx.unam.tic.diplomado.agenda.modelo.hibernate.HibernateUtil;
import mx.unam.tic.diplomado.agenda.servicios.ServiciosCatalogos;
import mx.unam.tic.diplomado.agenda.servicios.ServiciosCatalogosImpl;

public class CatalogosAPP {

    public static void main(String[] args) {

        HibernateUtil.init();

        Catalogo tp1 = new TipoContacto();
        Catalogo mc1 = new MedioContacto();

        Integer id = ((TipoContacto) tp1).getId();
        Integer id2 = ((MedioContacto) mc1).getId();

        ServiciosCatalogos serviciosCatalogos = ServiciosCatalogosImpl.getInstance();

        for (Catalogo tipoContacto : serviciosCatalogos.cargaTiposContacto()) {
            System.out.println("El tipo contacto es:" + tipoContacto + " id="
                    + ((TipoContacto) tipoContacto).getId()
                    + ((TipoContacto) tipoContacto).getColumnaExtra());
        }

        /*
         * TipoContacto familiar = serviciosCatalogos.cargaTipoContactoPorId(1);
         * System.out.println("El contacto familiar===" + familiar.getNombre());
         * 
         * for (Catalogo medioContacto : serviciosCatalogos.cargaMediosContacto()) {
         * System.out.println("El tipo contacto es:" + medioContacto +
         * " id " + ((MedioContacto) medioContacto).getId());
         * }
         * 
         * List<MedioContacto> mediosContacto =
         * serviciosCatalogos.cargaMediosContacto();
         * 
         * for (MedioContacto medioContacto : mediosContacto) {
         * System.out.println("El medio contacto es:" + medioContacto);
         * }
         * 
         * MedioContacto casa = serviciosCatalogos.cargaMedioContactoPorId(1);
         * System.out.println("El medio casa===" + casa.getNombre());
         * 
         */
    }

}
