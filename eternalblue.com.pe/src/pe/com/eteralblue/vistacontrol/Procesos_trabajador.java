package pe.com.eteralblue.vistacontrol;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import pe.com.eteralblue.modelo.Trabajador;
import utils.GlobalVars;
import utils.Operaciones;

public class Procesos_trabajador {
	// JAIRO COMPLETA TODOS ESTOS
	// KEVIN HACE TODAS LAS VALIDACIONES

	public static boolean dniRepetido(String dni) {
		boolean resultado = false;
		for (int i = 0; i < GlobalVars.trabajadores.size(); i++) {
			if (GlobalVars.trabajadores.get(i).getDniPersona().equals(dni)) {
				Operaciones.error(8);
				resultado = true;
				break;
			} else {
				resultado = false;
			}
		}
		return resultado;

	}

	public static boolean codigo_repetido(String CodigoT) {
		boolean resultado = false;
		for (int i = 0; i < GlobalVars.trabajadores.size(); i++) {
			if (GlobalVars.trabajadores.get(i).getCodigoTrabajador().equals(CodigoT)) {
				Operaciones.error(8);
				resultado = true;
				break;
			} else {
				resultado = false;
			}
		}
		return resultado;

	}

	public static int buscar_Trabajador(String Dni) {
		int posicion = -1;
		boolean encontrado = false;
		do {
			posicion++;
			if (Dni.equals(GlobalVars.trabajadores.get(posicion).getDniPersona())) {
				encontrado = true;
			}
		} while (encontrado == false && posicion < GlobalVars.trabajadores.size() - 1);

		if (encontrado == false) {
			posicion = -1;
		}

		return posicion;
	}

	public static void registrar_trabajor() {
		if (GlobalVars.areas.isEmpty() || GlobalVars.afps.isEmpty()) {
			System.out.println("AREAS Y AFP TIENEN QUE SE REGISTRADOS");
		} else {

			String DniPersonaT, NombreT, ApellidoPatT, ApellidoMatT, CodigoT, ProfesionT, FechaIngT, respuesta = " N",
					area, afp;
			Double SueldoBasT;
			int cantidadHijosT, posicion, posicion2, IdArea = 0, IdAfp;
			boolean encontrado = false;
			do {
				System.out.println("-----Registrar Trabajador----------");
				do {
					System.out.print("DNI : ");
					DniPersonaT = GlobalVars.leer.cadena();
				} while (dniRepetido(DniPersonaT) || !Operaciones.DNICorrecto(DniPersonaT)
						|| !Operaciones.esNumero(DniPersonaT));
				do {
					System.out.print("NOMBRE: ");
					NombreT = GlobalVars.leer.cadenaMayuscula();
				} while (!Operaciones.validar_string(NombreT));
				do {
					System.out.print("APELLIDO PATERNO : ");
					ApellidoPatT = GlobalVars.leer.cadenaMayuscula();
				} while (!Operaciones.validar_string(ApellidoPatT));
				do {
					System.out.print("APELLIDO MATERNO : ");
					ApellidoMatT = GlobalVars.leer.cadenaMayuscula();
				} while (!Operaciones.validar_string(ApellidoMatT));
				do {
					System.out.print("CÓDIGO : ");
					CodigoT = GlobalVars.leer.cadenaMayuscula();
				} while (codigo_repetido(CodigoT) || !Operaciones.codigoCorrecto(CodigoT));
				System.out.print("PROFESION : ");
				ProfesionT = GlobalVars.leer.cadenaMayuscula();
				System.out.print("SUELDO BASE : ");
				SueldoBasT = GlobalVars.leer.decimal();
				System.out.print("FECHA DE INGRESO: ");
				FechaIngT = GlobalVars.leer.cadenaMayuscula();
				System.out.print("CANTIDAD HIJOS : ");
				cantidadHijosT = GlobalVars.leer.entero();

				do {
					Procesos_area.listar_area();
					System.out.print("AREA : ");
					area = GlobalVars.leer.cadenaMayuscula();
					posicion = Procesos_area.buscar_area(area);
					if (posicion == -1) {
						System.out.println("AREA NO ENCONTRADA");
						System.out.println("INTÉNTELO DE NUEVO : ");
						encontrado = false;

					} else {
						encontrado = true;
						IdArea = GlobalVars.areas.get(posicion).getIdArea();
						System.out.println("AREA REGISTRADA CON ÉXITO");

					}
				} while (!encontrado);
				Operaciones.salto_lineas(2);
				do {

					Procesos_afp.listar_afp();
					System.out.print("AFP : ");
					afp = GlobalVars.leer.cadenaMayuscula();
					posicion2 = Procesos_afp.encontrar_nombre(afp);
					if (posicion2 == -1) {
						System.out.println("AFP NO ENCONTRADO");
						System.out.println("INTÉNTELO DE NUEVO : ");
						encontrado = false;

					} else {
						encontrado = true;
						IdAfp = GlobalVars.afps.get(posicion2).getIdAfp();
						GlobalVars.IdTrabajador++;
						Trabajador trabajador = new Trabajador(GlobalVars.IdTrabajador, DniPersonaT, NombreT,
								ApellidoPatT, ApellidoMatT, CodigoT, ProfesionT, SueldoBasT, FechaIngT, cantidadHijosT,
								IdArea, IdAfp);
						GlobalVars.trabajadores.add(trabajador);

						System.out.println("AFP REGISTRO CON ÉXITO");

					}
				} while (!encontrado);

				do {
					System.out.print("Desea registrar otro Trabajador? [S/N]: ");
					respuesta = GlobalVars.leer.cadenaMayuscula();
				} while (!respuesta.equals("S") && !respuesta.equals("N"));
			} while (respuesta.equals("S"));
		}
	}

	public static void editar_trabajador() {
		if (GlobalVars.trabajadores.isEmpty()) {
			Operaciones.error(2);
		} else {
			int posicion;
			String respuesta = "N", respuesta2 = "";
			do {
				System.out.println("----- EDITAR TRABAJADOR ----------");
				listar_trabajador();
				System.out.println("Dni: ");
				posicion = buscar_Trabajador(GlobalVars.leer.cadena());
				if (posicion == -1) {
					Operaciones.error(2);
				} else {
					do {
						System.out
								.println("Nombre Actual: " + GlobalVars.trabajadores.get(posicion).getNombrePersona());
						System.out.println("¿Desea Modificar? [S/N] : ");
						respuesta = GlobalVars.leer.cadenaMayuscula();
						if (respuesta.equals("S")) {
							System.out.println("Nuevo Nombre: ");
							GlobalVars.trabajadores.get(posicion).setNombrePersona(GlobalVars.leer.cadena());
							Operaciones.salto_lineas(2);
						}
					} while (!respuesta.equals("S") && !respuesta.equals("N"));

					do {
						System.out.println("Apellido Paterno Actual: "
								+ GlobalVars.trabajadores.get(posicion).getApellidoPatPersona());
						System.out.println("¿Desea Modificar? [S/N] : ");
						respuesta = GlobalVars.leer.cadenaMayuscula();
						if (respuesta.equals("S")) {
							System.out.println("Nuevo Apellido Paterno: ");
							GlobalVars.trabajadores.get(posicion).setApellidoPatPersona(GlobalVars.leer.cadena());
							Operaciones.salto_lineas(2);
						}

					} while (!respuesta.equals("S") && !respuesta.equals("N"));

					do {
						System.out.println("Apellido Materno Actual: "
								+ GlobalVars.trabajadores.get(posicion).getApellidoMatPersona());
						System.out.println("¿Desea Modificar? [S/N] : ");
						respuesta = GlobalVars.leer.cadenaMayuscula();
						if (respuesta.equals("S")) {
							System.out.println("Nuevo Apellido Materno: ");
							GlobalVars.trabajadores.get(posicion).setApellidoMatPersona(GlobalVars.leer.cadena());
							Operaciones.salto_lineas(2);
						}

					} while (!respuesta.equals("S") && !respuesta.equals("N"));

					do {

						System.out.println(
								"Profesion Actual: " + GlobalVars.trabajadores.get(posicion).getProfesionTrabajador());
						System.out.println("¿Desea Modificar? [S/N] : ");
						respuesta = GlobalVars.leer.cadenaMayuscula();
						if (respuesta.equals("S")) {
							System.out.println("Nueva ProfesiÃ³n: ");
							GlobalVars.trabajadores.get(posicion).setProfesionTrabajador(GlobalVars.leer.cadena());
							Operaciones.salto_lineas(2);
						}
					} while (!respuesta.equals("S") && !respuesta.equals("N"));

					do {
						System.out.println("Sueldo Base Actual: "
								+ GlobalVars.trabajadores.get(posicion).getSueldoBaseTrabajador());
						System.out.println("ÂDesea Modificar? [S/N] : ");
						respuesta = GlobalVars.leer.cadenaMayuscula();
						if (respuesta.equals("S")) {
							System.out.println("Nuevo Sueldo Base: ");
							GlobalVars.trabajadores.get(posicion).setSueldoBaseTrabajador(GlobalVars.leer.decimal());
							Operaciones.salto_lineas(2);
						}
					} while (!respuesta.equals("S") && !respuesta.equals("N"));
					do {
						System.out.println("Fecha Ingresos Actual: "
								+ GlobalVars.trabajadores.get(posicion).getFechaInTrabajador());
						System.out.println("¿Desea Modificar? [S/N] : ");
						respuesta = GlobalVars.leer.cadenaMayuscula();
						if (respuesta.equals("S")) {
							System.out.println("Nueva Fecha de Ingresos: ");
							GlobalVars.trabajadores.get(posicion).setFechaInTrabajador(GlobalVars.leer.cadena());
							Operaciones.salto_lineas(2);
						}
					} while (!respuesta.equals("S") && !respuesta.equals("N"));
					do {
						System.out.println("Cantidad Hijos Actual: "
								+ GlobalVars.trabajadores.get(posicion).getCantidadHijosTrabajador());
						System.out.println("¿Desea Modificar? [S/N] : ");
						respuesta = GlobalVars.leer.cadenaMayuscula();
						if (respuesta.equals("S")) {
							System.out.println("Nueva Cantidad Hijos: ");
							GlobalVars.trabajadores.get(posicion).setCantidadHijosTrabajador(GlobalVars.leer.entero());
							Operaciones.salto_lineas(2);
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

	public static void listar_trabajador() {
		int num = 0;
		if (GlobalVars.trabajadores.isEmpty()) {
			Operaciones.error(2);
		} else {
			System.out.println("----- LISTA DE TRABAJADORES ----------");
			System.out.println(
					"NÂ° \tDNI  \t\t\tAPELLIDOS Y NOMBRE  \t\tCODIGO \t\tPROFESIÓN  \t\tSUELDO  \tFECHA INGRESO  \tCANTIDAD HIJOS  \tAREA  \t\tAFP ");
			for (Trabajador trabajador : GlobalVars.trabajadores) {
				num++;
				System.out.println(num + "\t" + trabajador.getDniPersona() + "\t\t"
						+ Operaciones.recortar_nombres(trabajador.getFullname()) + "\t\t"
						+ trabajador.getCodigoTrabajador() + "\t\t"
						+ Operaciones.recortar_nombres(trabajador.getProfesionTrabajador()) + "\t"
						+ trabajador.getSueldoBaseTrabajador() + "\t\t" + trabajador.getFechaInTrabajador() + "\t\t"
						+ trabajador.getCantidadHijosTrabajador() + "\t\t\t"
						+ Operaciones.retornar_nombre_area(trabajador.getIdArea()) + "\t"
						+ Operaciones.retornar_nombre_afp(trabajador.getIdAfp()));

			}
		}
	}

	public static void eliminar_trabajador() {
		System.out.println("----- ELIMINAR TRABAJADORES ----------");
		String respuesta = "N", respuesta2 = "";
		int posicion;
		if (GlobalVars.trabajadores.isEmpty()) {
			Operaciones.error(2);
		} else {
			do {
				listar_trabajador();
				System.out.print("DNI: ");
				posicion = buscar_Trabajador(GlobalVars.leer.cadena());
				if (posicion == -1) {
					Operaciones.error(2);
				} else {
					do {
						System.out.println("¿Estás seguro de eliminar este trabajador[S/N]");
						respuesta2 = GlobalVars.leer.cadenaMayuscula();
						if (respuesta2.equals("S")) {
							int id = GlobalVars.trabajadores.get(posicion).getIdPersona();
							for (int i = 0; i < GlobalVars.boletas.size(); i++) {
								if (id == GlobalVars.boletas.get(i).getIdTrabajador()) {
									System.out.println("NO SE PUEDE ELIMINAR, BOLETAS REGISTRADAS");
									break;
								} else {
									GlobalVars.trabajadores.remove(posicion);
									System.out.println("REGISTRO ELIMINADO CORRECTAMENTE");
									break;
								}

							}
							if (GlobalVars.boletas.isEmpty()) {
								GlobalVars.trabajadores.remove(posicion);
								System.out.println("REGISTRO ELIMINADO CORRECTAMENTE");
							}
						}
					} while (!respuesta2.equals("S") && !respuesta2.equals("N"));
					if (respuesta2.equals("N")) {
						System.out.println("ABORTADO");
						break;
					}
					if (GlobalVars.trabajadores.isEmpty()) {
						System.out
								.println("NO SE PUEDEN ELIMINAR MÁS REGISTROS, PORQUE TODOS ESTOS HAN SIDO ELIMINADOS");
						break;
					}
					do {
						System.out.println("¿Desea eliminar otro trabajador?[S/N] =  ");
						respuesta = GlobalVars.leer.cadenaMayuscula();
					} while (!respuesta.equals("S") && !respuesta.equals("N"));

				}

			} while (respuesta.equals("S"));
		}

	}
}
