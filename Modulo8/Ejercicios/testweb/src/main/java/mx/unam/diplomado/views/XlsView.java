package mx.unam.diplomado.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import mx.unam.diplomado.data.Producto;

public class XlsView extends AbstractXlsView {
	
	@Override
    protected void buildExcelDocument(
            Map<String, Object> model,
            Workbook workbook,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // cambiar nombre de archivo
        response.setHeader("Content-Disposition", "attachment; filename=\"productos.xls\"");

        // crear una pagina excel
        Sheet sheet = workbook.createSheet("Lista Productos");

        Row header = sheet.createRow(0);

        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Nombre");

        int count_row = 1;

        for (Producto producto : (List<Producto>) model.get("productosList")) {
            Row productoRow = sheet.createRow(count_row++);

            productoRow.createCell(0).setCellValue(producto.getId());
            productoRow.createCell(1).setCellValue(producto.getNombre());
        }
    }

}
