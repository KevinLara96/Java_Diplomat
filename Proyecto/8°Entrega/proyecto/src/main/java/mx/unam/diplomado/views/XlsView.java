package mx.unam.diplomado.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import mx.unam.diplomado.modelo.empleado.Empleado;

public class XlsView extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(
            Map<String, Object> model,
            Workbook workbook,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // cambiar nombre de archivo
        response.setHeader("Content-Disposition", "attachment; filename=\"empleados.xls\"");

        // crear una pagina excel
        Sheet sheet = workbook.createSheet("Lista Empleados");

        Row header = sheet.createRow(0);

        header.createCell(0).setCellValue("Nombre");
        header.createCell(1).setCellValue("Correo");
        header.createCell(2).setCellValue("Contrasena");
        header.createCell(3).setCellValue("RFC");
        header.createCell(3).setCellValue("Salario");
        header.createCell(3).setCellValue("Agencia");
        header.createCell(3).setCellValue("Puesto");

        int count_row = 1;

        for (Empleado empleado : (List<Empleado>) model.get("empleadosList")) {
            Row productoRow = sheet.createRow(count_row++);
            productoRow.createCell(0).setCellValue(empleado.getNombre());
            productoRow.createCell(1).setCellValue(empleado.getCorreo());
            productoRow.createCell(2).setCellValue(empleado.getContrasena());
            productoRow.createCell(3).setCellValue(empleado.getRfc());
            productoRow.createCell(4).setCellValue(empleado.getSalario());
            productoRow.createCell(5).setCellValue(empleado.getAgencia().getNombreAgencia());
            productoRow.createCell(6).setCellValue(empleado.getPuesto().getPuesto());
        }
    }

}
