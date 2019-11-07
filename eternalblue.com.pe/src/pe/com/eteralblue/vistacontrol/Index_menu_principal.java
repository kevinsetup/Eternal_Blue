package pe.com.eteralblue.vistacontrol;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import utils.GlobalVars;
import utils.Operaciones;

public class Index_menu_principal {

	public static void menu() {

		System.out.println("-*-*-*-*-* MENÚ PRINCIPAL -*-*-*-*-*-");
		System.out.println("----- 1.- DATOS TRABAJADOR ----------");
		System.out.println("----- 2.- DATOS Ã�REA       ----------");
		System.out.println("----- 3.- DATOS AFP        ----------");
		System.out.println("----- 4.- GENERAR PLANILLA ----------");
		System.out.println("----- 5.- VER PLANILLA     ----------");
		System.out.println("----- 6.- FUNCION MATEMATICA --------");
		System.out.println("----- 7.- SALIR            ----------");
		System.out.println("ELIGA UNA OPCION [1-7]..");

		/*
		 * GlobalVars.menu.add("1.- DATOS TRABAJADOR");
		 * GlobalVars.menu.add("2.- DATOS AREAS");
		 * GlobalVars.menu.add("3.-  DATOS AFP ");
		 * GlobalVars.menu.add("4.- GENERAR PLANILLA");
		 * GlobalVars.menu.add("5.- VER PLANILLA ");
		 * GlobalVars.menu.add("6.-  FUNCION MATEMATICA");
		 * GlobalVars.menu.add("7.- SALIR    ");
		 * 
		 * for (int i = 0; i < GlobalVars.menu.size(); i++) {
		 * System.out.println(GlobalVars.menu.get(i)); }
		 */

	}

	public static void inicio() {

		int opcion;
		do {
			Operaciones.salto_lineas(3);
			menu();
			opcion = GlobalVars.leer.entero();
			Operaciones.salto_lineas(2);
			switch (opcion) {

			case 1:

				Operaciones.salto_lineas(3);
				Index_menu_trabajador.inicio_trabajador();
				Operaciones.salto_lineas(2);

				break;
			case 2:
				Operaciones.salto_lineas(3);
				Index_menu_area.inicio_area();
				Operaciones.salto_lineas(2);

				break;
			case 3:
				Operaciones.salto_lineas(3);
				Index_menu_afp.inicio_afp();
				Operaciones.salto_lineas(2);
				break;
			case 4:
				Operaciones.salto_lineas(3);
				Procesos_menu_generar_planilla.generar_plantilla();
				Operaciones.salto_lineas(2);
				break;
			case 5:
				Operaciones.salto_lineas(3);
				Procesos_menu_verplanilla.ver_planilla();
				Operaciones.salto_lineas(2);

				break;
			case 6:
				Operaciones.salto_lineas(3);
				Procesos_funcion_matematica.funcion_matematica();
				Operaciones.salto_lineas(2);

				break;
			case 7:
				Operaciones.salto_lineas(1);
				Procesos_menu_salir.main(null);
				System.exit(0);
				Operaciones.salto_lineas(2);

			default:
				Operaciones.error(1);
				break;
			}

		} while (opcion != 7);

	}

	public static void main(String[] args) {
		inicio();
	}

}
