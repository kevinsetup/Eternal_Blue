package pe.com.eteralblue.modelo;

public class Afp {
	private int IdAfp;
	private String NombreAfp;
	private double PorcentajeAfp;

	public Afp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Afp(int idAfp, String nombreAfp, double porcentajeAfp) {
		super();
		IdAfp = idAfp;
		NombreAfp = nombreAfp;
		PorcentajeAfp = porcentajeAfp;
	}

	public int getIdAfp() {
		return IdAfp;
	}

	public void setIdAfp(int idAfp) {
		IdAfp = idAfp;
	}

	public String getNombreAfp() {
		return NombreAfp;
	}

	public void setNombreAfp(String nombreAfp) {
		NombreAfp = nombreAfp;
	}

	public double getPorcentajeAfp() {
		return PorcentajeAfp;
	}

	public void setPorcentajeAfp(double porcentajeAfp) {
		PorcentajeAfp = porcentajeAfp;
	}

}
