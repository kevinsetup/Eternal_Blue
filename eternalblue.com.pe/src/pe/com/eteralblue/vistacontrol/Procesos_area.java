package pe.com.eteralblue.vistacontrol;

import pe.com.eteralblue.modelo.Area;
import utils.GlobalVars;
import utils.Operaciones;

public class Procesos_area {
public static int buscar_area(String nombre) {
		int posicion = -1;
		boolean encontrado = false;
		do {
			posicion++;
			if (nombre.equals(GlobalVars.areas.get(posicion).getNombreArea())) {
				encontrado = true;
			}
		} while (encontrado == false && posicion< GlobalVars.areas.size()-1);
		
		if (encontrado == false) {
			posicion = -1;
		}
		
		return posicion;
	}
	
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
				System.out.print("żDesea registrar otra Area? [S/N]: ");
				respuesta = GlobalVars.leer.cadenaMayuscula();
			} while (!respuesta.equals("S") && !respuesta.equals("N"));
		} while (respuesta.equals("S"));

	}

	public static void editar_area() {
		if (GlobalVars.areas.isEmpty()) {
			Operaciones.error(2);
		}else {
			int posicion;
			String respuesta="N";
			System.out.println("----- EDITAR AREA ----------");
			listar_area();
			System.out.println("Nombre: ");
			posicion = buscar_area(GlobalVars.leer.cadena());
			if (posicion == -1) {
				Operaciones.error(2);
			}else {
				System.out.println("Nombre Actual: " + GlobalVars.areas.get(posicion).getNombreArea());
				System.out.println("¿Desea Modificar Area? [S/N] : ");
				respuesta = GlobalVars.leer.cadenaMayuscula();
				if (respuesta.equals("S")) {
					System.out.println("Nuevo Nombre: ");
					GlobalVars.areas.get(posicion).setNombreArea(GlobalVars.leer.cadena());
					Operaciones.salto_lineas(2);
				}
			}
			
		}
	}

	public static void listar_area() {
		int num = 0;
		System.out.println("----- LISTA DE AREAS ----------");
		System.out.println("N° \tNOMBRE");
		for (Area area : GlobalVars.areas) {
			num++;
			System.out.println(num + "\t" + area.getNombreArea());

		}
	}
	
	public static void eliminar_area() {
		if (GlobalVars.areas.isEmpty()) {
			Operaciones.error(2);
		}else {
			int posicion;
			System.out.println("***** ELIMINAR AREA *****");
			listar_area();
			System.out.println("NOMBRE: ");
			posicion = buscar_area(GlobalVars.leer.cadena());
			if (posicion == -1 ) {
				Operaciones.error(2);
			}else {
				GlobalVars.areas.remove(posicion);
				System.out.println("** AREA ELIMINADA CORRECTAMENTE **");
			}
		}
	}
	
}