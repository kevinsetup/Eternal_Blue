package pe.com.eteralblue.vistacontrol;

import pe.com.eteralblue.modelo.Afp;
import utils.GlobalVars;
import utils.Operaciones;

public class Procesos_afp {
	public static boolean afp_repetido(String afp) {
		boolean repetido = false;
		for (int i = 0; i < GlobalVars.afps.size(); i++) {
			if (afp.equals(GlobalVars.afps.get(i).getNombreAfp())) {
				Operaciones.error(8);
				repetido = true;
				break;
			} else {
				repetido = false;
			}
		}
		return repetido;

	}

	public static void registrar_afp() {
		String nombreA, respuesta = "N";
		double porcentajeP;
		do {
			System.out.println("----- REGISTRAR AFP----------");
			do {
				System.out.print("NOMBRE : ");
				nombreA = GlobalVars.leer.cadenaMayuscula();
			} while (afp_repetido(nombreA));
			System.out.print("PORCENTAJE :");
			porcentajeP = GlobalVars.leer.decimal();
			GlobalVars.IdAfp++;
			Afp afp = new Afp(GlobalVars.IdAfp, nombreA, porcentajeP);
			GlobalVars.afps.add(afp);
			do {
				System.out.print("¿Desea registrar otro Afp? [S/N]: ");
				respuesta = GlobalVars.leer.cadenaMayuscula();
			} while (!respuesta.equals("S") && !respuesta.equals("N"));
			Operaciones.salto_lineas(2);
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
					Operaciones.salto_lineas(3);
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
				num++;
				System.out.println(num + "\t" + afp.getNombreAfp() + "\t" + afp.getPorcentajeAfp());
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
							int id = GlobalVars.afps.get(posicion).getIdAfp();
							for (int i = 0; i < GlobalVars.trabajadores.size(); i++) {
								if (id == GlobalVars.trabajadores.get(i).getIdAfp()) {
									System.out.println("NO SE PUEDE ELIMINAR PORQUE HAY TRABAJADORES REGISTRADOS");
									break;
								} else {
									GlobalVars.afps.remove(posicion);
									System.out.println("REGISTRO ELIMINADO CORRECTAMENTE");
									break;
								}
							}
							if (GlobalVars.trabajadores.isEmpty()) {
								GlobalVars.afps.remove(posicion);
								System.out.println("REISTRO ELIMINADO CORRECTAMENTE");
							}
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
						System.out.println("¿Desea eliminar otra afp?[S/N] =  ");
						respuesta = GlobalVars.leer.cadenaMayuscula();

					} while (!respuesta.equals("S") && !respuesta.equals("N"));
					Operaciones.salto_lineas(3);
				}

			} while (respuesta.equals("S"));

		}
	}
}
