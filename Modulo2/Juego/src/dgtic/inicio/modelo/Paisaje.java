package dgtic.inicio.modelo;


public class Paisaje extends Posicion{
	
	public Paisaje(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void pintar() {
		System.out.println("Pintar paisaje");
	}
}
