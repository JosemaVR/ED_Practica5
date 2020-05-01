package practica5;

public class Main {

	public static void main(String[] args) {
		Vista v = new Vista();
		Modelo m = new Modelo();
		new Controlador(m, v);
	}
}