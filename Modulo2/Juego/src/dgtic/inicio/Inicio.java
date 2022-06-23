package dgtic.inicio;

import java.util.ArrayList;
import java.util.List;

import dgtic.inicio.modelo.Enemigo;
import dgtic.inicio.modelo.Paisaje;
import dgtic.inicio.modelo.Personaje;
import dgtic.inicio.modelo.Posicion;
import dgtic.modelo.servicio.Pantalla;

public class Inicio {
	public static void main(String args[]) {
		Pantalla lz = new Pantalla();
		Enemigo en = new Enemigo(20, 20);
		Personaje ps = new Personaje(23, 10);
		Paisaje pa = new Paisaje(10, 10);
		
		List<Posicion> pc = new ArrayList<>();
		
		pc.add(en);
		pc.add(ps);
		pc.add(pa);
		lz.pintar(pc);
	}
}
