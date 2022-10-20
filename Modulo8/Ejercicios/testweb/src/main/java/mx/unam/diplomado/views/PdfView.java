package mx.unam.diplomado.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import mx.unam.diplomado.data.Producto;

public class PdfView extends AbstractPdfView {

	@Override
    protected void buildPdfDocument(
            Map<String, Object> model,
            Document document,
            PdfWriter writer,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        List<Producto> productos = (List<Producto>) model.get("productosList");

        PdfPTable table = new PdfPTable(2);

        table.addCell("ID");
        table.addCell("Nombre");

        for(Producto producto : productos ) {
        	table.addCell(producto.getId().toString());
            table.addCell(producto.getNombre());
        }
        document.add(table);
    }
	
}
