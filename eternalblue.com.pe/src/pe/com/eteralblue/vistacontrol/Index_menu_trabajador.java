package pe.com.eteralblue.vistacontrol;

import utils.GlobalVars;
import utils.Operaciones;

public class Index_menu_trabajador {

	public static void menu_trabajador() {
		
		System.out.println("-*-*-*-*-* MENÚ TRABAJDOR -*-*-*-*-*-");
		System.out.println("----- 1.- REGISTRAR TRABAJADOR----------");
		System.out.println("----- 2.- EDITAR TRABAJADOR   ----------");
		System.out.println("----- 3.- LISTAR TRABAJADOR   ----------");
		System.out.println("----- 4.- ELIMINAR TRABAJADOR ----------");
		System.out.println("----- 5.- VOLVER              ----------");
		System.out.println("ELIGA UNA OPCION [1-5]..");
		
		

	}

	public static void inicio_trabajador() {
		int opcion;
		do {
			Operaciones.salto_lineas(3);
			menu_trabajador();
			opcion = GlobalVars.leer.entero();
			Operaciones.salto_lineas(2);
			switch (opcion) {
			case 1:
				Procesos_trabajador.registrar_trabajor();
				break;
			case 2:
				Procesos_trabajador.editar_trabajador();
				break;
			case 3:
				Procesos_trabajador.listar_trabajador();
				break;
			case 4:
				Procesos_trabajador.eliminar_trabajador();
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
