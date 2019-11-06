package pe.com.eteralblue.vistacontrol;

import utils.GlobalVars;
import utils.Operaciones;

public class Index_menu_afp {
	public static void menu_afp() {
		System.out.println("-*-*-*-*-* MEN� AFP -*-*-*-*-*-");
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
				Procesos_afp.registrar_afp();
				break;
			case 2:
				Procesos_afp.editar_afp();
				break;
			case 3:
				Procesos_afp.listar_afp();
				break;
			case 4:
				Procesos_afp.eliminar_afp();
				break;
			case 5:
				Procesos_afp.eliminar_afp();
				break;

			default:
				Operaciones.error(1);
				break;
			}

		} while (opcion != 5);

	}

}
