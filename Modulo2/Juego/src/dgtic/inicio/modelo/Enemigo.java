package dgtic.inicio.modelo;

public class Enemigo extends Posicion{

	public Enemigo(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pintar() {
		System.out.println("Pintar enemigo");
	}

	
}
