package dgtic.controlador;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import dgtic.modelo.Alumno;
import dgtic.repositorio.ServicioBD;
import dgtic.servicio.Consulta;
import dgtic.servicio.Exportaciones;

public class principalController {

    @FXML
    private Button btnBuscar;

    @FXML
    private TextArea txtAsalida;

    @FXML
    private TextField txtNombre;

    @FXML
    void buscarAccion(ActionEvent event) {
        List<Alumno> lista = new ArrayList<>();
        lista = ServicioBD.consulta();
        Consulta sl = new Consulta();
        List<Alumno> alm = lista.stream().filter(
                alum -> (alum.getNombre().equals(txtNombre.getText()))).collect(toList());
        String cadena = new Exportaciones().exportarCSV(sl.buscarCalificaciones(alm.get(0)));

        txtAsalida.appendText(cadena);
    }
}
