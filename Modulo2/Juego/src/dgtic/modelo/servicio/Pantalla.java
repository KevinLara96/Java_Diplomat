package dgtic.modelo.servicio;

import java.util.List;

import dgtic.inicio.modelo.Posicion;

public class Pantalla {
	public void pintar(List<Posicion> posicion) {
		for(Posicion ps : posicion) {
			ps.pintar();
		}
	}
}
