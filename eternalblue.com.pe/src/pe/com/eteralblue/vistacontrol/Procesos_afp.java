package pe.com.eteralblue.vistacontrol;

import pe.com.eteralblue.modelo.Afp;
import utils.GlobalVars;
import utils.Operaciones;

public class Procesos_afp {
	public static void registrar_afp() {
		String nombreA, respuesta = "N";
		double porcentajeP;
		do {
			System.out.println("----- REGISTRAR AFP----------");
			System.out.print("NOMBRE : ");
			nombreA = GlobalVars.leer.cadenaMayuscula();
			System.out.print("PORCENTAJE :");
			porcentajeP = GlobalVars.leer.decimal();
			GlobalVars.IdAfp++;
			Afp afp = new Afp(GlobalVars.IdAfp, nombreA, porcentajeP);
			GlobalVars.afps.add(afp);
			do {
				System.out.print("¿Desea registrar otro Afp? [S/N]: ");
				respuesta = GlobalVars.leer.cadenaMayuscula();
			} while (!respuesta.equals("S") && !respuesta.equals("N"));
			Operaciones.salto_lineas(4);
		} while (respuesta.equals("S"));

	}

	public static void editar_afp() {
		System.out.println("----- EDITAR AFP----------");
		String nombre, respuesta = "", respuesta2 = "N";
		int posicion;
		if (GlobalVars.afps.isEmpty()) {
			Operaciones.error(3);
		} else {

			do {
				listar_afp();
				System.out.println("NOMBRE : ");
				nombre = GlobalVars.leer.cadenaMayuscula();
				posicion = encontrar_nombre(nombre);
				if (posicion == -1) {
					Operaciones.error(3);
				} else {
					System.out.println("NOMBRE AFP : " + GlobalVars.afps.get(posicion).getNombreAfp());
					do {
						System.out.println("¿Desea editar nombre? [S/N]: ");
						respuesta = GlobalVars.leer.cadenaMayuscula();
						if (respuesta.equals("S")) {
							System.out.print("NUEVO NOMBRE : ");
							String newnombre = GlobalVars.leer.cadenaMayuscula();
							GlobalVars.afps.get(posicion).setNombreAfp(newnombre);

						}
					} while (!respuesta.equals("S") && !respuesta.equals("N"));
					Operaciones.salto_lineas(3);
					System.out.println("PORCENTAJE : " + GlobalVars.afps.get(posicion).getPorcentajeAfp());
					do {
						System.out.println("¿Desea editar el porcentaje? [S/N]: ");
						respuesta = GlobalVars.leer.cadenaMayuscula();
						if (respuesta.equals("S")) {
							System.out.print("NUEVO PORCENTAJE : ");
							double newporcentaje = GlobalVars.leer.decimal();
							GlobalVars.afps.get(posicion).setPorcentajeAfp(newporcentaje);

						}
					} while (!respuesta.equals("S") && !respuesta.equals("N"));
					System.out.println("TODOS LOS REGISTROS HAN SIDO EDITADOS CON ÉXITO");
					do {
						System.out.println("¿Desea seguir editando?[S/N]");
						respuesta2 = GlobalVars.leer.cadenaMayuscula();

					} while (!respuesta2.equals("S") && !respuesta.equals("N"));
				}
			} while (respuesta2.equals("S"));
		}

	}

	public static void listar_afp() {

		int num = 0;
		if (GlobalVars.afps.isEmpty()) {
			Operaciones.error(3);
		} else {
			System.out.println("N° \tNOMBRE \tPORCENTAJE");
			for (Afp afp : GlobalVars.afps) {
				System.out.println(num++ + "\t" + afp.getNombreAfp() + "\t" + afp.getPorcentajeAfp());
			}
		}

	}

	public static int encontrar_nombre(String nombre) {
		int posicion = -1;
		boolean encontrado = false;
		do {
			posicion++;
			if (nombre.equals(GlobalVars.afps.get(posicion).getNombreAfp())) {
				encontrado = true;
			}
		} while (!encontrado && posicion < GlobalVars.afps.size() - 1);
		if (!encontrado) {
			posicion = -1;
		}
		return posicion;
	}

	public static void eliminar_afp() {
		System.out.println("----- ELIMINAR AFP----------");

		String nombre, respuesta = "N", respuesta2 = "";
		int posicion;
		if (GlobalVars.afps.isEmpty()) {
			Operaciones.error(3);
		} else {

			do {
				listar_afp();
				System.out.print("NOMBRE : ");
				nombre = GlobalVars.leer.cadenaMayuscula();
				posicion = encontrar_nombre(nombre);
				if (posicion == -1) {
					Operaciones.error(2);
				} else {
					do {
						System.out.println("Estás seguro de eliminar este afp[S/N]");
						respuesta2 = GlobalVars.leer.cadenaMayuscula();
						if (respuesta2.equals("S")) {
							GlobalVars.afps.remove(posicion);
							System.out.println("REGISTRO ELIMINADO CORRECTAMENTE");

						}
					} while (!respuesta2.equals("S") && !respuesta2.equals("N"));
					if (respuesta2.equals("N")) {
						System.out.println("REGISTRO ABORTADO");
						break;
					}
					if (GlobalVars.afps.isEmpty()) {
						System.out
								.println("NO SE PUEDEN ELIMINAR MÁS REGISTROS, PORQUE TODOS ESTOS HAN SIDO ELIMINADOS");
						break;
					}
					do {

					} while (!respuesta.equals("S") && !respuesta.equals("N"));
				}

			} while (respuesta.equals("S"));

		}
	}
}
