package utils;

import java.util.ArrayList;

import pe.com.eteralblue.modelo.Afp;
import pe.com.eteralblue.modelo.Area;
import pe.com.eteralblue.modelo.Trabajador;

public class GlobalVars {
	public static Lectura leer = new Lectura();
	public static ArrayList<Area> areas = new ArrayList<Area>();
	public static ArrayList<String> menu = new ArrayList<String>();
	public static ArrayList<Afp> afps = new ArrayList<Afp>();
	public static ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();

	public static int IdPersona = -1;
	public static int IdArea = -1;
	public static int IdAfp = -1;
	public static int IdTrabajador = -1;

}
