package pe.com.eteralblue.vistacontrol;

import pe.com.eteralblue.modelo.Boleta;
import utils.GlobalVars;
import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.xml.xmp.PdfA1Schema;

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
				"N� \tA�O \tMES \tSUELDO BASE \tGATIFICACIONES \tBONIFICACI�N \tHORAS EXTRAS \tASIGNACION FAMILIAR \tTARDANZAS \tFALTAS \tAFP \tDIEZMO \tNOMBRE \tTOTAL ");
		for (Boleta boleta : GlobalVars.boletas) {
			num++;
			System.out.println(num + "\t" + boleta.getAnioBoleta() + "\t" + boleta.getMesBoleta() + "\t\t"
					+ boleta.getSueldoBasebBoleta() + "\t\t" + boleta.getGratificacionBoleta() + "\t\t"
					+ boleta.getBonificacionBoleta() + "\t\t" + boleta.getHorasExtrasBoleta() + "\t\t"
					+ boleta.getAsignacionFamiliarBoleta() + "\t\t" + boleta.getTardanzasBoleta() + "\t\t"
					+ boleta.getFaltasBoleta() + "\t\t" + boleta.getAfpBoleta() + "\t\t" + boleta.getDiezmoBoleta()
					+ "\t\t" + buscar_nombre_id(boleta.getIdTrabajador()) + "\t"
					+ (boleta.getSueldoBasebBoleta() + boleta.getGratificacionBoleta() + boleta.getBonificacionBoleta()
							+ boleta.getHorasExtrasBoleta() + boleta.getAsignacionFamiliarBoleta()
							- boleta.getTardanzasBoleta() - boleta.getFaltasBoleta() - boleta.getAfpBoleta()
							- boleta.getDiezmoBoleta()));

		}
		generar_pdf();

	}

	public static void generar_pdf() {

		System.out.println("1.- GENERAR PDF  : ");
		System.out.println("2.-REGRESAR AL MENU");
		int opcion = GlobalVars.leer.entero();
		int opcion2;
		if (opcion == 1) {
			System.out.println("BUSCAR OPCION 2 ");
			opcion2 = GlobalVars.leer.entero();
			if (opcion2 == 2) {
				JFileChooser dlg = new JFileChooser();
				int option = dlg.showSaveDialog(dlg);
				if (option == JFileChooser.APPROVE_OPTION) {
					File f = dlg.getSelectedFile();
					String ruta = f.toString();
					System.out.println("RUTA : " + ruta);
					int opcion3;
					System.out.println("3.-GENERAR : ");
					opcion3 = GlobalVars.leer.entero();
					if (opcion3 == 3) {
						try {
							FileOutputStream archivo = new FileOutputStream(ruta + ".pdf");
							Document doc = new Document();
							doc.setPageSize(PageSize.A3.rotate());
							PdfWriter.getInstance(doc, archivo);
							doc.open();
							doc.add(new Paragraph(
									"A�O \tMES \tSUELDO BASE \tGATIFICACIONES \tBONIFICACI�N \tHORAS EXTRAS \tASIGNACION FAMILIAR \tTARDANZAS \tFALTAS \tDIEZMO \tNOMBRE \tTOTAL"));

							for (Boleta boleta : GlobalVars.boletas) {
								doc.add(new Paragraph(boleta.getAnioBoleta() + "\t" + boleta.getMesBoleta() + "\t\t"
										+ boleta.getSueldoBasebBoleta() + "\t\t" + boleta.getGratificacionBoleta()
										+ "\t\t" + boleta.getBonificacionBoleta() + "\t\t"
										+ boleta.getHorasExtrasBoleta() + "\t\t" + boleta.getAsignacionFamiliarBoleta()
										+ "\t\t" + boleta.getTardanzasBoleta() + "\t\t" + boleta.getFaltasBoleta()
										+ "\t\t" + boleta.getDiezmoBoleta() + "\t\t"
										+ buscar_nombre_id(boleta.getIdTrabajador()) + "\t"
										+ (boleta.getSueldoBasebBoleta() + boleta.getGratificacionBoleta()
												+ boleta.getBonificacionBoleta() + boleta.getHorasExtrasBoleta()
												+ boleta.getAsignacionFamiliarBoleta() - boleta.getTardanzasBoleta()
												- boleta.getFaltasBoleta() - boleta.getDiezmoBoleta())));
							}
							doc.close();

							JOptionPane.showMessageDialog(null, "PDF CREADO CORRECTAMENTE");

						} catch (Exception e) {
							System.out.println("ERROR " + e);
						}

					}

				}

			}

		}

	}
}
