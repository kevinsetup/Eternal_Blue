package pe.com.eteralblue.vistacontrol;

import java.util.Iterator;

import pe.com.eteralblue.modelo.Boleta;
import utils.GlobalVars;

public class Procesos_menu_verplanilla {

	public static String buscar_nombre_id(int id) {
		String nombre = "";
		for (int i = 0; i < GlobalVars.trabajadores.size(); i++) {
			if (id == GlobalVars.trabajadores.get(i).getIdPersona()) {
				nombre = GlobalVars.trabajadores.get(i).getFullname();
			}
		}
		return nombre;

	}

	public static void ver_planilla() {
		int num = 0;
		System.out.println(
				"N° \tAÑO \tMES \tSUELDO BASE \tGATIFICACIONES \tBONIFICACIÓN \tHORAS EXTRAS \tASIGNACION FAMILIAR \tTARDANZAS \tFALTAS \tDIEZMO \tNOMBRE \tTOTAL ");
		for (Boleta boleta : GlobalVars.boletas) {
			num++;
			System.out.println(num + "\t" + boleta.getAnioBoleta() + "\t" + boleta.getMesBoleta() + "\t\t"
					+ boleta.getSueldoBasebBoleta() + "\t\t" + boleta.getGratificacionBoleta() + "\t\t"
					+ boleta.getBonificacionBoleta() + "\t\t" + boleta.getHorasExtrasBoleta() + "\t\t"
					+ boleta.getAsignacionFamiliarBoleta() + "\t\t" + boleta.getTardanzasBoleta() + "\t\t"
					+ boleta.getFaltasBoleta() + "\t\t" + boleta.getDiezmoBoleta() + "\t\t"
					+ buscar_nombre_id(boleta.getIdTrabajador()) + "\t"
					+ (boleta.getSueldoBasebBoleta() + boleta.getGratificacionBoleta() + boleta.getBonificacionBoleta()
							+ boleta.getHorasExtrasBoleta() + boleta.getAsignacionFamiliarBoleta()
							- boleta.getTardanzasBoleta() - boleta.getFaltasBoleta() - boleta.getDiezmoBoleta()));

		}

	}
}
