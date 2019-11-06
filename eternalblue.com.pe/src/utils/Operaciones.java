package utils;

public class Operaciones {

	public static void salto_lineas(int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			System.out.println(" ");
		}

	}

	public static void error(int tipo) {
		if (tipo == 1) {

			System.out.println("FUERA DE RANGO");
		} else if (tipo == 2) {
			System.out.println("REGISTRO NO ENCONTRADO");
		} else if (tipo == 3) {
			System.out.println("REGISTROS VACIOS");
		}

	}

}
