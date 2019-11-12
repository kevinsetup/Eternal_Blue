package pe.com.eteralblue.vistacontrol;

import pe.com.eteralblue.modelo.Boleta;
import pe.com.eteralblue.modelo.Trabajador;
import utils.GlobalVars;
import utils.Operaciones;

public class Procesos_menu_generar_planilla {

	public static double registro_minutos(double minutos, double tardanzasB) {

		do {
			System.out.println("-------- TARDANZAS:MINUTOS --------");
			minutos = GlobalVars.leer.decimal();
		} while (minutos > 59);

		if (minutos >= 10 && minutos <= 25) {
			tardanzasB = 15;

		} else if (minutos > 25 && minutos <= 45) {
			tardanzasB = 20;
		} else if (minutos > 45 && minutos <= 59) {
			tardanzasB = 23;
		}
		System.out.println("DECUENTO DE = " + tardanzasB + " SOLES ");
		return tardanzasB;

	}

	public static double registro_horas(double horas, double tardanzasB) {

		do {
			System.out.println("-------- TARDANZAS:HORAS --------");
			horas = GlobalVars.leer.decimal();
		} while (horas > 24);

		if (horas >= 1 && horas <= 3) {
			tardanzasB = 75;

		} else if (horas > 3 && horas <= 5) {
			tardanzasB = 85;
		} else if (horas > 5 && horas <= 8) {
			tardanzasB = 95;
		}
		System.out.println("DECUENTO DE = " + tardanzasB + " SOLES ");
		return tardanzasB;

	}

	public static double retornar_porcentaje(int id) {
		double porcentaje = 0;
		for (int i = 0; i < GlobalVars.afps.size(); i++) {
			if (id == GlobalVars.afps.get(i).getIdAfp()) {
				porcentaje = GlobalVars.afps.get(i).getPorcentajeAfp();
			}
		}
		return porcentaje;

	}

	public static void generar_plantilla() {
		if (GlobalVars.trabajadores.isEmpty()) {
			System.out.println("NO HAY TRABAJADORES REGISTRADOS");
		} else {
			int anioB, mesB, idTrabajador;
			double sueldoBaseB, gratificaB, bonificaB, horasextrasB = 0, asignacionFB = 0, tardanzasB = 0, faltasB = 0,
					afpB = 0, diezmoB, minutos = 0, horas = 0, horasext;
			int num = 0, diasB;
			System.out.println("----- GENERAR PLANTILLA ----------");
			System.out.print("AÑO : ");
			anioB = GlobalVars.leer.entero();
			System.out.print("MES : ");
			mesB = GlobalVars.leer.entero();
			for (Trabajador trabajador : GlobalVars.trabajadores) {
				num++;
				System.out.println("TRABAJADOR  : " + num + " = " + trabajador.getNombrePersona());
				System.out.println("SUEDLO BASE =  " + trabajador.getSueldoBaseTrabajador());
				System.out.println("DNI =  " + trabajador.getDniPersona());
				System.out.println("CODIGO = " + trabajador.getCodigoTrabajador());
				System.out.println("**********************************************\n");
				System.out.println(
						"*/*/*/*/*/* GRATIFICACIONES-BONIFICAIONES-HORAS EXTRAS-ASIGNACION FAMILIAR */*/*/*/*/*");

				System.out.println("-------- GRATIFICACIONES --------");
				gratificaB = GlobalVars.leer.decimal();
				System.out.println("-------- BONIFICACIONES  --------");
				bonificaB = GlobalVars.leer.decimal();

				System.out.println("-------- HORAS EXTRAS-HORAS :   --------");
				horasext = GlobalVars.leer.decimal();
				if (horasext > 0 && horasext <= 3) {
					horasextrasB = 50;
				} else if (horasext > 3) {
					horasextrasB = 150;
				}

				System.out.println("-------- ASIGNACION FAMI --------");
				if (trabajador.getCantidadHijosTrabajador() > 1) {
					asignacionFB = 100;
				}

				System.out.println("**********************************************\n");
				System.out.println("*/*/*/*/*/* TARDANZAS-FALTAS */*/*/*/*/*");
				System.out.println("-------- TARDANZAS:MINUTOS/HORAS --------");
				System.out.println("*-*-*- OPCION 1 : REGISTRAR EN MINUTOS -*-*-*-   OPCION 2 : REGISTRAR EN HORAS");
				int opcion;

				opcion = GlobalVars.leer.entero();
				if (opcion == 1) {
					tardanzasB = registro_minutos(minutos, tardanzasB);
				} else if (opcion == 2) {
					tardanzasB = registro_horas(horas, tardanzasB);
				}

				System.out.println("-------- FALTAS  --------");
				diasB = GlobalVars.leer.entero();
				if (diasB >= 1 && diasB <= 3) {
					faltasB = 150;
				} else if (diasB >= 4) {
					faltasB = 350;
				}
				System.out.println("DESCUENTO = " + faltasB);

				System.out.println("-------- AFP-DIEZMOS --------");
				System.out.println("-------- AFP  --------");
				System.out.println("AFP REGISTRADO = " + Operaciones.retornar_nombre_afp(trabajador.getIdAfp()));
				sueldoBaseB = trabajador.getSueldoBaseTrabajador();
				System.out.println("SUELDO BASE = " + sueldoBaseB);
				System.out.println("PORCENTAJE AFP = " + retornar_porcentaje(trabajador.getIdAfp()));
				double descuento = sueldoBaseB * (retornar_porcentaje(trabajador.getIdAfp()) / 100);
				afpB = descuento;
				System.out.println("DESCUENTO AFP = " + retornar_porcentaje(trabajador.getIdAfp()) / 100 + "%");
				System.out.println("DESCUENTO = " + afpB);
				System.out.println("TOTAL = " + (sueldoBaseB - descuento));

				System.out.println("-------- DIEZMO  --------");
				diezmoB = sueldoBaseB / 10;
				System.out.println("DIEZMO =  10%");
				System.out.println("TOTAL = " + diezmoB);
				System.out.println("***************************************************************************");
				GlobalVars.IdBoleta++;

				Boleta boleta = new Boleta(GlobalVars.IdBoleta, anioB, mesB, sueldoBaseB, gratificaB, bonificaB,
						horasextrasB, asignacionFB, tardanzasB, faltasB, afpB, diezmoB, trabajador.getIdPersona());
				GlobalVars.boletas.add(boleta);

			}
		}

	}
}
