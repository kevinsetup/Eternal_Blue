package pe.com.eteralblue.vistacontrol;

import utils.GlobalVars;
import utils.Operaciones;

public class Index_menu_area {

	// ESTO HARÁ ELMER -> REGISTRAR, EDITAR, LISTAR, ELIMINAR , VOLVER
	public static void menu_area() {
		System.out.println("-*-*-*-*-* MENÚ AREA -*-*-*-*-*-");
		System.out.println("----- 1.- REGISTRAR ÁREA  ----------");
		System.out.println("----- 2.- EDITAR    ÁREA  ----------");
		System.out.println("----- 3.- LISTAR    ÁREA  ----------");
		System.out.println("----- 4.- ELIMINAR  ÁREA  ----------");
		System.out.println("----- 5.- VOLVER          ----------");
		System.out.println("ELIGA UNA OPCION [1-5]..");
	}

	public static void inicio_area() {
		int opcion;
		do {
			Operaciones.salto_lineas(3);
			menu_area();
			opcion = GlobalVars.leer.entero();
			Operaciones.salto_lineas(2);
			switch (opcion) {
			case 1:
				Procesos_area.registrar_area();
				break;
			case 2:
				Procesos_area.editar_area();
				break;
			case 3:
				Procesos_area.listar_area();
				break;
			case 4:
				Procesos_area.eliminar_area();
				break;
			case 5:
				Index_menu_principal.inicio();
				break;

			default:
				Operaciones.error(1);
				break;
			}

		} while (opcion != 5);
	}

}
