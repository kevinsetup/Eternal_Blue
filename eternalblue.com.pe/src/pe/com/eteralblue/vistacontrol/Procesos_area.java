package pe.com.eteralblue.vistacontrol;

import java.awt.Component;

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
		} while (encontrado == false && posicion < GlobalVars.areas.size() - 1);

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
			nombreA = GlobalVars.leer.cadenaMayuscula();
			GlobalVars.IdArea++;
			Area area = new Area(GlobalVars.IdArea, nombreA);
			GlobalVars.areas.add(area);
			do {
				System.out.print("Å¼Desea registrar otra Area? [S/N]: ");
				respuesta = GlobalVars.leer.cadenaMayuscula();
			} while (!respuesta.equals("S") && !respuesta.equals("N"));
			Operaciones.salto_lineas(2);
		} while (respuesta.equals("S"));

	}

	public static void editar_area() {
		if (GlobalVars.areas.isEmpty()) {
			Operaciones.error(2);
		} else {
			int posicion;
			String respuesta = "N", respuesta2 = " ";
			do {
				System.out.println("----- EDITAR AREA ----------");
				listar_area();
				System.out.println("Nombre: ");
				posicion = buscar_area(GlobalVars.leer.cadenaMayuscula());
				if (posicion == -1) {
					Operaciones.error(2);
				} else {
					do {
						System.out.println("Nombre Actual: " + GlobalVars.areas.get(posicion).getNombreArea());
						System.out.println("Â¿Desea Modificar Area? [S/N] : ");
						respuesta = GlobalVars.leer.cadenaMayuscula();

						if (respuesta.equals("S")) {
							System.out.println("Nuevo Nombre: ");
							GlobalVars.areas.get(posicion).setNombreArea(GlobalVars.leer.cadena());
							Operaciones.salto_lineas(2);
						}
					} while (!respuesta.equals("S") && !respuesta.equals("N"));
					System.out.println("TODOS LOS REGISTROS HAN SIDO EDITADOS CON ÉXITO");
					do {
						System.out.println("¿Desea seguir editando?[S/N]");
						respuesta2 = GlobalVars.leer.cadenaMayuscula();

					} while (!respuesta2.equals("S") && !respuesta.equals("N"));
					Operaciones.salto_lineas(3);
				}
			} while (respuesta.equals("S"));

		}
	}

	public static void listar_area() {

		int num = 0;
		if (GlobalVars.areas.isEmpty()) {
			Operaciones.error(2);
		} else {
			System.out.println("----- LISTA DE AREAS ----------");
			System.out.println("NÂ° \tNOMBRE");
			for (Area area : GlobalVars.areas) {
				num++;
				System.out.println(num + "\t" + area.getNombreArea());
			}

		}
	}

	public static void eliminar_area() {
		String respuesta = "N", respuesta2 = "";
		int posicion;
		if (GlobalVars.areas.isEmpty()) {
			Operaciones.error(2);
		} else {
			do {
				System.out.println("***** ELIMINAR AREA *****");
				listar_area();
				System.out.println("NOMBRE: ");
				posicion = buscar_area(GlobalVars.leer.cadenaMayuscula());
				if (posicion == -1) {
					Operaciones.error(2);
				} else {
					do {

						System.out.println("Estás seguro de eliminar esta área? [S/N]");
						respuesta2 = GlobalVars.leer.cadenaMayuscula();
						if (respuesta2.equals("S")) {
							int id = GlobalVars.areas.get(posicion).getIdArea();
							for (int i = 0; i < GlobalVars.trabajadores.size(); i++) {
								if (id == GlobalVars.trabajadores.get(i).getIdArea()) {
									System.out
											.println("NO SE PUEDE ELIMINAR, TRABAJADORES EXISTENTES EN ESTE REGISTRO");
									break;
								} else {
									GlobalVars.areas.remove(posicion);
									System.out.println("REGISTRO ELIMINADO CORRECTAMENTE");
									break;
								}
							}
							if (GlobalVars.trabajadores.isEmpty()) {
								GlobalVars.areas.remove(posicion);
								System.out.println("REGISTRO ELIMINADO CORRECTAMENTE");
							}

						}

					} while (!respuesta2.equals("S") && !respuesta2.equals("N"));
					if (respuesta2.equals("N")) {
						System.out.println("ABORTADO");
						break;
					}
					if (GlobalVars.areas.isEmpty()) {
						System.out
								.println("NO SE PUEDEN ELIMINAR MÁS REGISTROS, PORQUE TODOS ESTOS HAN SIDO ELIMINADOS");
						break;
					}
					do {
						System.out.println("¿Desea eliminar otra área?[S/N] =  ");
						respuesta = GlobalVars.leer.cadenaMayuscula();
						Operaciones.salto_lineas(3);
					} while (!respuesta.equals("S") && !respuesta.equals("N"));
				}
			} while (respuesta.equals("S"));
		}
	}

}
