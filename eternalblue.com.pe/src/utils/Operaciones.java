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
		} else if (tipo == 4) {
			System.out.println("CANTIDAD DE DIGITOS / CARACTERES INCORRECTO");
		} else if (tipo == 5) {
			System.out.println("SOLO DEBE CONTENER DIGITOS");
		} else if (tipo == 6) {
			System.out.println("REGISTRO NO ELIMINADO");
		} else if (tipo == 7) {
			System.out.println("CANTIDAD DE D�GITOS INCORRECTA");

		} else if (tipo == 8) {
			System.out.println("REGISTRO REPETIDO");
		}

	}

	public static boolean DNICorrecto(String dni) {
		boolean correcto = false;
		if (dni.length() == 8) {
			correcto = true;
		} else {
			correcto = false;
			Operaciones.error(4);
		}
		return correcto;
	}

	public static boolean esNumero(String dni) {
		boolean esnumero = false;
		try {
			Double.parseDouble(dni);
			esnumero = true;

		} catch (NumberFormatException e) {
			Operaciones.error(5);
			esnumero = false;
		}
		return esnumero;

	}

	public static boolean codigoCorrecto(String CodigoT) {
		boolean correcto = false;
		if (CodigoT.length() == 4) {
			correcto = true;
		} else {
			error(7);
			correcto = false;
		}
		return correcto;
	}

	public static String retornar_nombre_afp(int IdAfp) {
		String nombre = "";
		for (int i = 0; i < GlobalVars.afps.size(); i++) {
			if (IdAfp == GlobalVars.afps.get(i).getIdAfp()) {
				nombre = GlobalVars.afps.get(i).getNombreAfp();
			}

		}
		return nombre;
	}

	public static String retornar_nombre_area(int IdArea) {
		String nombre = "";
		for (int i = 0; i < GlobalVars.areas.size(); i++) {
			if (IdArea == GlobalVars.areas.get(i).getIdArea()) {
				nombre = GlobalVars.areas.get(i).getNombreArea();
			}
		}
		return nombre;
	}

	public static String recortar_nombres(String nombre) {
		String nombrecortado = nombre;
		if (nombre.length() > 10) {
			nombrecortado = nombre.substring(0, 8) + "...";
		} else if (nombre.length() < 8) {
			nombrecortado = nombre + "\t";
		} else {
			nombrecortado = nombre + " ";
		}
		return nombrecortado;

	}

}
