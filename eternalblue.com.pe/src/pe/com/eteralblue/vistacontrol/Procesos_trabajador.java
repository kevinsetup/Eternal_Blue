package pe.com.eteralblue.vistacontrol;

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
				Operaciones.error(4);
				resultado = true;
				break;
			} else {
				resultado = false;
			}
		}
		return resultado;

	}

	public static boolean esNumero(String dni) {
		boolean esnumero = false;
		try {
			Double.parseDouble(dni);
			esnumero = true;

		} catch (NumberFormatException e) {
			Operaciones.error(3);
			esnumero = false;
		}
		return esnumero;

	}

	public static boolean DNICorrecto(String dni) {
		boolean correcto = false;
		if (dni.length() == 8) {
			correcto = true;
		} else {
			correcto = false;
			Operaciones.error(5);
		}
		return correcto;
	}

	public static int buscar_Trabajador(String Dni) {
		int posicion = -1;
		boolean encontrado = false;
		do {
			posicion++;
			if (Dni.equals(GlobalVars.trabajadores.get(posicion).getDniPersona())) {
				encontrado = true;
			}
		} while (encontrado == false && posicion < GlobalVars.areas.size() - 1);

		if (encontrado == false) {
			posicion = -1;
		}

		return posicion;
	}

	public static void registrar_trabajor() {
		String DniPersonaT, NombreT, ApellidoPatT, ApellidoMatT, CodigoT, ProfesionT, FechaIngT, respuesta = " N";
		Double SueldoBasT;
		int cantidadHijosT;
		do {
			System.out.println("-----Registrar Trabajador----------");
			do {
				System.out.println("DNI de la persona: ");
				DniPersonaT = GlobalVars.leer.cadena();
			} while (dniRepetido(DniPersonaT) || !DNICorrecto(DniPersonaT) || !esNumero(DniPersonaT));
			System.out.println("NOMBRE: ");
			NombreT = GlobalVars.leer.cadena();
			System.out.println("Apellido Paterno: ");
			ApellidoPatT = GlobalVars.leer.cadena();
			System.out.println("Apellido Materno: ");
			ApellidoMatT = GlobalVars.leer.cadena();
			System.out.println("Codigo: ");
			CodigoT = GlobalVars.leer.cadena();
			System.out.println("Profesion: ");
			ProfesionT = GlobalVars.leer.cadena();
			System.out.println("Sueldo base: ");
			SueldoBasT = GlobalVars.leer.decimal();
			System.out.println("Fecha de ingresos: ");
			FechaIngT = GlobalVars.leer.cadena();
			System.out.println("Cantidad Hijos: ");
			cantidadHijosT = GlobalVars.leer.entero();
			GlobalVars.IdArea++;
			GlobalVars.IdAfp++;
			GlobalVars.IdTrabajador++;
			Trabajador Trabajadores = new Trabajador(GlobalVars.IdTrabajador, DniPersonaT, NombreT, ApellidoPatT,
					ApellidoMatT, CodigoT, ProfesionT, SueldoBasT, FechaIngT, cantidadHijosT, GlobalVars.IdArea,
					GlobalVars.IdAfp);
			GlobalVars.trabajadores.add(Trabajadores);
			do {
				System.out.print("Desea registrar otra Trabajador? [S/N]: ");
				respuesta = GlobalVars.leer.cadenaMayuscula();
			} while (!respuesta.equals("S") && !respuesta.equals("N"));
		} while (respuesta.equals("S"));
	}

	public static void editar_trabajador() {
		if (GlobalVars.trabajadores.isEmpty()) {
			Operaciones.error(2);
		} else {
			int posicion;
			String respuesta = "N";
			System.out.println("----- EDITAR TRABAJADOR ----------");
			listar_trabajador();
			System.out.println("Dni: ");
			posicion = buscar_Trabajador(GlobalVars.leer.cadena());
			if (posicion == -1) {
				Operaciones.error(2);
			} else {
				System.out.println("Nombre Actual: " + GlobalVars.trabajadores.get(posicion).getNombrePersona());
				System.out.println("¿Desea Modificar? [S/N] : ");
				respuesta = GlobalVars.leer.cadenaMayuscula();
				if (respuesta.equals("S")) {
					System.out.println("Nuevo Nombre: ");
					GlobalVars.trabajadores.get(posicion).setNombrePersona(GlobalVars.leer.cadena());
					Operaciones.salto_lineas(2);
				}
				System.out.println(
						"Apellido Paterno Actual: " + GlobalVars.trabajadores.get(posicion).getApellidoPatPersona());
				System.out.println("¿Desea Modificar? [S/N] : ");
				respuesta = GlobalVars.leer.cadenaMayuscula();
				if (respuesta.equals("S")) {
					System.out.println("Nuevo Apellido Paterno: ");
					GlobalVars.trabajadores.get(posicion).setApellidoPatPersona(GlobalVars.leer.cadena());
					Operaciones.salto_lineas(2);
				}
				System.out.println(
						"Apellido Materno Actual: " + GlobalVars.trabajadores.get(posicion).getApellidoMatPersona());
				System.out.println("¿Desea Modificar? [S/N] : ");
				respuesta = GlobalVars.leer.cadenaMayuscula();
				if (respuesta.equals("S")) {
					System.out.println("Nuevo Apellido Materno: ");
					GlobalVars.trabajadores.get(posicion).setApellidoMatPersona(GlobalVars.leer.cadena());
					Operaciones.salto_lineas(2);
				}
				System.out.println("Codigo Actual: " + GlobalVars.trabajadores.get(posicion).getCodigoTrabajador());
				System.out.println("¿Desea Modificar? [S/N] : ");
				respuesta = GlobalVars.leer.cadenaMayuscula();
				if (respuesta.equals("S")) {
					System.out.println("Nuevo Codigo: ");
					GlobalVars.trabajadores.get(posicion).setCodigoTrabajador(GlobalVars.leer.cadena());
					Operaciones.salto_lineas(2);
				}
				System.out
						.println("Profesion Actual: " + GlobalVars.trabajadores.get(posicion).getProfesionTrabajador());
				System.out.println("¿Desea Modificar? [S/N] : ");
				respuesta = GlobalVars.leer.cadenaMayuscula();
				if (respuesta.equals("S")) {
					System.out.println("Nueva Profesión: ");
					GlobalVars.trabajadores.get(posicion).setProfesionTrabajador(GlobalVars.leer.cadena());
					Operaciones.salto_lineas(2);
				}
				System.out.println(
						"Sueldo Base Actual: " + GlobalVars.trabajadores.get(posicion).getSueldoBaseTrabajador());
				System.out.println("¿Desea Modificar? [S/N] : ");
				respuesta = GlobalVars.leer.cadenaMayuscula();
				if (respuesta.equals("S")) {
					System.out.println("Nuevo Sueldo Base: ");
					GlobalVars.trabajadores.get(posicion).setSueldoBaseTrabajador(GlobalVars.leer.decimal());
					Operaciones.salto_lineas(2);
				}
				System.out.println(
						"Fecha Ingresos Actual: " + GlobalVars.trabajadores.get(posicion).getFechaInTrabajador());
				System.out.println("¿Desea Modificar? [S/N] : ");
				respuesta = GlobalVars.leer.cadenaMayuscula();
				if (respuesta.equals("S")) {
					System.out.println("Nueva Fecha de Ingresos: ");
					GlobalVars.trabajadores.get(posicion).setFechaInTrabajador(GlobalVars.leer.cadena());
					Operaciones.salto_lineas(2);
				}
				System.out.println(
						"Cantidad Hijos Actual: " + GlobalVars.trabajadores.get(posicion).getCantidadHijosTrabajador());
				System.out.println("¿Desea Modificar? [S/N] : ");
				respuesta = GlobalVars.leer.cadenaMayuscula();
				if (respuesta.equals("S")) {
					System.out.println("Nueva Cantidad Hijos: ");
					GlobalVars.trabajadores.get(posicion).setCantidadHijosTrabajador(GlobalVars.leer.entero());
					Operaciones.salto_lineas(2);
				}
			}
		}
	}

	public static void listar_trabajador() {
		int num = 0;
		System.out.println("----- LISTA DE TRABAJADORES ----------");
		System.out.println(
				"N° \tDniTrabajador\tNombre\tApellidoPaterno\tApellidoMaterno\tCodigo\tProfesión\tSueldoBase\tFechaIngreso\tCantidadHijos");
		for (Trabajador trabajador : GlobalVars.trabajadores) {
			num++;
			System.out.println(num + "\t" + trabajador.getDniPersona() + "\t" + trabajador.getNombrePersona() + "\t"
					+ trabajador.getApellidoPatPersona() + "\t" + trabajador.getApellidoMatPersona() + "\t"
					+ trabajador.getCodigoTrabajador() + "\t" + trabajador.getProfesionTrabajador() + "\t"
					+ trabajador.getSueldoBaseTrabajador() + "\t" + trabajador.getFechaInTrabajador() + "\t"
					+ trabajador.getCantidadHijosTrabajador());

		}
	}

	public static void eliminar_trabajador() {
		if (GlobalVars.trabajadores.isEmpty()) {
			Operaciones.error(2);
		} else {
			int posicion;
			System.out.println("----- ELIMINAR TRABAJADORES ----------");
			listar_trabajador();
			System.out.println("DNI: ");
			posicion = buscar_Trabajador(GlobalVars.leer.cadena());
			if (posicion == -1) {
				Operaciones.error(2);
			} else {
				GlobalVars.trabajadores.remove(posicion);
				System.out.println("** TRABAJADOR ELIMINADO CORRECTAMENTE **");
			}
		}
	}

}
