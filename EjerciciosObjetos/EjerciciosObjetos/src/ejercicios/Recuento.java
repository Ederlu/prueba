package ejercicios;

public class Recuento {

	// clk drc > Source > generate getters...

	private static int recuento;

	public Recuento() {
		recuento++;
	}

	public void escribirRecuento() {
		System.out.println("Hay " + recuento + " objetos de la clase.");
	}

	public static int getRecuento() {
		return recuento;
	}

	public static void setRecuento(int recuento) {
		Recuento.recuento = recuento;
	}

}
