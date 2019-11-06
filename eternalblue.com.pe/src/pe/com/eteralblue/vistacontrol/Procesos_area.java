package pe.com.eteralblue.vistacontrol;

import pe.com.eteralblue.modelo.Area;
import utils.GlobalVars;

public class Procesos_area {

	public static void registrar_area() {
		String nombreA, respuesta = "N";
		do {
			System.out.println("----- REGISTRAR AREA----------");
			System.out.print("NOMBRE: ");
			nombreA = GlobalVars.leer.cadena();
			GlobalVars.IdArea++;
			Area area = new Area(GlobalVars.IdArea, nombreA);
			GlobalVars.areas.add(area);
			do {
				System.out.print("¿Desea registrar otra Area? [S/N]: ");
				respuesta = GlobalVars.leer.cadenaMayuscula();
			} while (!respuesta.equals("S") && !respuesta.equals("N"));
		} while (respuesta.equals("S"));

	}

	public static void editar_area() {

	}

	public static void listar_area() {
		int num = 0;
		System.out.println("N° \tNOMBRE");
		for (Area area : GlobalVars.areas) {
			num++;
			System.out.println(num + "\t" + area.getNombreArea());

		}

	}
	
	
	public static void eliminar_area() {
		listar_area();
		
	}

}
