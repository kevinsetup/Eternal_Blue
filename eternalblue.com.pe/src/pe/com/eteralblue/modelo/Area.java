package pe.com.eteralblue.modelo;

public class Area {
	private int IdArea;
	private String NombreArea;

	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Area(int idArea, String nombreArea) {
		super();
		IdArea = idArea;
		NombreArea = nombreArea;
	}

	public int getIdArea() {
		return IdArea;
	}

	public void setIdArea(int idArea) {
		IdArea = idArea;
	}

	public String getNombreArea() {
		return NombreArea;
	}

	public void setNombreArea(String nombreArea) {
		NombreArea = nombreArea;
	}

}
