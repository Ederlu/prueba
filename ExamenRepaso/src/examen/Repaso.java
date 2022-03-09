package examen;

import java.util.Scanner;

public class Repaso {

	static String Clientes[][] = { { "Luis Gomez", "H", "1.75", "74.3", "29", "2700" },
			{ "Jaimita LLobregat", "M", "1.55", "70.2", "20", "3400" },
			{ "Pepe Gotera", "H", "1.55", "65.5", "23", "2300" }, { "Nerea Bilbao", "M", "1.75", "85.5", "27", "3200" },
			{ "Susana Melón", "M", "1.55", "65.5", "35", "2950" },
			{ "Joseba Cilarte", "H", "1.55", "70.5", "21", "2400" },
			{ "Eneko Real", "H", "1.75", "65.5", "24", "2500" }, { "Igor Dito", "H", "1.59", "95.5", "31", "3500" },
			{ "Elsa Capunta", "M", "1.60", "70.3", "28", "2500" }, { "Elisa Perez", "M", "1.75", "72", "30", "2800" },
			{ "Lola Mento", "M", "1.55", "69.3", "18", "2700" }, { "Maite Antón", "M", "1.78", "92", "19", "2800" },
			{ "Helen Chufe", "M", "1.75", "80", "46", "2900" }, { "Elena Nito", "M", "1.50", "85", "34", "2550" },
			{ "Carmelo Cotón", "H", "1.55", "78", "45", "1700" }, { "Clara Luz", "H", "1.75", "100", "28", "2900" },
			{ "Otilio Gomez ", "M", "1.69", "110", "39", "3100" }, { "Enrique Cido", "M", "1.67", "117", "47", "2700" },
			{ "Maria  Blanco ", "M", "1.78", "78", "39", "2800" },
			{ "Kepa Sakolegi", "H", "1.90", "89", "27", "3000" } };

	public static double calcularMetabolismoBasal(String pe, String alt, String ed, String se) {
		int edad = Integer.parseInt(ed);
		double altura = Double.parseDouble(alt) * 100;
		double peso = Double.parseDouble(pe);
		char sexo = se.charAt(0);
		double consumoBasal = 0;
		if (sexo == 'M') {
			consumoBasal = 655 + (9.6 * peso) + (1.8 * altura) - (4.7 * edad);
		} else if (sexo == 'H') {
			consumoBasal = 66 + (13.7 * peso) + (5 * altura) - (6.8 * edad);
		}
		return consumoBasal;
	}

	public static void recorrerArray() {
		for (int i = 0; i < Clientes.length; i++) {
			for (int j = 0; j < Clientes[i].length; j++) {

			}
		}
	}

	public static void calcularConsumoClientes() {
		for (int i = 0; i < Clientes.length; i++) {
			System.out.println(" Clientes " + Clientes[i][0]);
			double consumo = calcularMetabolismoBasal(Clientes[i][3], Clientes[i][2], Clientes[i][4], Clientes[i][1]);
			// System.out.println(" Su consumo basal es de: " + consumo);
		}
	}

	public static double pesoIdeal(String se, String alt) {
		double altura = Double.parseDouble(alt) * 100;
		char sexo = se.charAt(0);
		double pesoIdeal = 0;
		if (sexo == 'M') {
			pesoIdeal = 0.75 * altura - 62.5;
		} else if (sexo == 'H') {
			pesoIdeal = 0.75 * altura - 56.25;
		}
		return pesoIdeal;
	}

	public static String recomendacion(String se, String alt, String pe, String caloriasCon, Double mb) {
		double peso = Double.parseDouble(pe);
		int calorias = Integer.parseInt(caloriasCon);
		double pesoIdeal = pesoIdeal(se, alt);
		String recomendacion = "";
		if (pesoIdeal * 0.95 < peso && peso < pesoIdeal * 1.05) {
			System.out.println("Estas en el Peso Ideal");
		} else {
			if (calorias < mb) {
				System.out.println(" Aumentar ingesta de calorias");

			} else if (mb < calorias && calorias < mb * 1.2) {
				recomendacion = (" poco o ningun ejercicio ");
			} else if (mb * 1.2 < calorias && calorias < mb * 1.375) {
				recomendacion = (" ejercicio muy ligero");
			} else if (mb * 1.375 < calorias && calorias < mb * 1.55) {
				recomendacion = (" Ejercicio ligero(1-3 dias a la semana)");
			} else if (mb * 1.55 < calorias && calorias < mb * 1.725) {
				recomendacion = ("Ejercicio moderado(3-5 dias a la semana)");
			} else if (mb * 1.725 < calorias && calorias < mb * 1.9) {
				recomendacion = ("Ejercicio  muy fuerte(2 veces al dia)");
			} else if (calorias > mb * 1.9) {
				recomendacion = ("Reducir ingesta calorica");
			}
		}
		return recomendacion;
	}

	public static void calcularRecomendacion() {
		for (int i = 0; i < Clientes.length; i++) {
			System.out.println(" Recomendacion para el cliente " + Clientes[i][0]);
			System.out.println(recomendacion(Clientes[i][1], Clientes[i][2], Clientes[i][3], Clientes[i][5],
					calcularMetabolismoBasal(Clientes[i][3], Clientes[i][2], Clientes[i][4], Clientes[i][1])));

		}
	}

	public static void visualizarClientes() {
		System.out.println(" Nombre \t Peso actual \t Peso ideal \t Metabolismo Basal \t Recomendacion");
		for (int i = 0; i < Clientes.length; i++) {
			System.out.println(Clientes[i][0] + "\t" + Clientes[i][3] + "\t" + pesoIdeal(Clientes[i][1], Clientes[i][2])
					+ "\t" + calcularMetabolismoBasal(Clientes[i][3], Clientes[i][2], Clientes[i][4], Clientes[i][1])
					+ "\t" + recomendacion(Clientes[i][1], Clientes[i][2], Clientes[i][3], Clientes[i][5],
							calcularMetabolismoBasal(Clientes[i][3], Clientes[i][2], Clientes[i][4], Clientes[i][1])));
		}
	}

	public static void estadisticas() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Introduce el sexo ");
		char sexo = sc.nextLine().charAt(0);
//		sc.nextLine();
		int edadMin = 0;
		do {
			System.out.println(" Introduce la edad minima ");
			edadMin = sc.nextInt();
		} while (edadMin < 18);
		int edadMax = 100;
		do {
			System.out.println(" Introduce la edad maxima");
			edadMax = sc.nextInt();

		} while (edadMax > 100);
		String nombre = "";
		int calorias = 0;
		for (int i = 0; i < Clientes.length; i++) {

			if ((Clientes[i][1].charAt(0) == sexo) && (Integer.parseInt(Clientes[i][4]) >= edadMin)
					&& (Integer.parseInt(Clientes[i][4]) <= edadMax)) {
				System.out.println(Clientes[i][0]);
				if (Integer.parseInt(Clientes[i][5]) > calorias) {
					calorias = Integer.parseInt(Clientes[i][5]);
					nombre = Clientes[i][0];
				}
			}
		}

	}

	public static void menu() {
		int opcion = 0;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println(" 0-> Salir ");
			System.out.println(" 1-> Visualizar clientes");
			System.out.println(" 2-> Estadisticas ");
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				visualizarClientes();
				break;

			case 2:
				estadisticas();
				break;
			}
		} while (opcion != 0);

	}

	public static void main(String[] args) {
		menu();

	}

}
