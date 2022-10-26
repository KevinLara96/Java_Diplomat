package mx.unam.diplomado.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import mx.unam.diplomado.modelo.empleado.Empleado;

public class PdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(
            Map<String, Object> model,
            Document document,
            PdfWriter writer,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        List<Empleado> empleados = (List<Empleado>) model.get("empleadosList");

        PdfPTable table = new PdfPTable(4);

        table.addCell("Nombre");
        table.addCell("Correo");
        table.addCell("Contrasena");
        table.addCell("RFC");
        table.addCell("Salario");
        table.addCell("Agencia");
        table.addCell("Puesto");

        for (Empleado empleado : empleados) {
            table.addCell(empleado.getIdEmpleado().toString());
            table.addCell(empleado.getNombre());
            table.addCell(empleado.getCorreo());
            table.addCell(empleado.getContrasena());
            table.addCell(empleado.getRfc());
            table.addCell(empleado.getSalario().toString());
            table.addCell(empleado.getAgencia().getNombreAgencia());
            table.addCell(empleado.getPuesto().getPuesto());
        }
        document.add(table);
    }

}
