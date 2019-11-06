package pe.com.eteralblue.vistacontrol;

import utils.GlobalVars;

public class Index_menu_afp {
	public static void menu_afp() {
		System.out.println("-*-*-*-*-* MENÚ AFP -*-*-*-*-*-");
		System.out.println("----- 1.- REGISTRAR AFP  ----------");
		System.out.println("----- 2.- EDITAR    AFP  ----------");
		System.out.println("----- 3.- LISTAR    AFP  ----------");
		System.out.println("----- 4.- ELIMINAR  AFP  ----------");
		System.out.println("----- 5.- VOLVER          ----------");
		System.out.println("ELIGA UNA OPCION [1-5]..");
	}

	public static void inicio_afp() {
		int opcion;
		do {
			menu_afp();
			opcion = GlobalVars.leer.entero();
			switch (opcion) {
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;

			default:
				break;
			}

		} while (opcion != 5);

	}

}
