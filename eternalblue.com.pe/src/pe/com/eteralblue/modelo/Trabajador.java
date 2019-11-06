package pe.com.eteralblue.modelo;

public class Trabajador extends Persona {
	private String CodigoTrabajador;
	private String ProfesionTrabajador;
	private double SueldoBaseTrabajador;
	private String FechaInTrabajador;
	private int CantidadHijosTrabajador;
	private int IdArea;
	private int IdAfp;

	public Trabajador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trabajador(int idPersona, String dniPersona, String nombrePersona, String apellidoPatPersona,
			String apellidoMatPersona) {
		super(idPersona, dniPersona, nombrePersona, apellidoPatPersona, apellidoMatPersona);
		// TODO Auto-generated constructor stub
	}

	public Trabajador(int idPersona, String dniPersona, String nombrePersona, String apellidoPatPersona,
			String apellidoMatPersona, String codigoTrabajador, String profesionTrabajador, double sueldoBaseTrabajador,
			String fechaInTrabajador, int cantidadHijosTrabajador, int idArea, int idAfp) {
		super(idPersona, dniPersona, nombrePersona, apellidoPatPersona, apellidoMatPersona);
		CodigoTrabajador = codigoTrabajador;
		ProfesionTrabajador = profesionTrabajador;
		SueldoBaseTrabajador = sueldoBaseTrabajador;
		FechaInTrabajador = fechaInTrabajador;
		CantidadHijosTrabajador = cantidadHijosTrabajador;
		IdArea = idArea;
		IdAfp = idAfp;
	}

	public String getCodigoTrabajador() {
		return CodigoTrabajador;
	}

	public void setCodigoTrabajador(String codigoTrabajador) {
		CodigoTrabajador = codigoTrabajador;
	}

	public String getProfesionTrabajador() {
		return ProfesionTrabajador;
	}

	public void setProfesionTrabajador(String profesionTrabajador) {
		ProfesionTrabajador = profesionTrabajador;
	}

	public double getSueldoBaseTrabajador() {
		return SueldoBaseTrabajador;
	}

	public void setSueldoBaseTrabajador(double sueldoBaseTrabajador) {
		SueldoBaseTrabajador = sueldoBaseTrabajador;
	}

	public String getFechaInTrabajador() {
		return FechaInTrabajador;
	}

	public void setFechaInTrabajador(String fechaInTrabajador) {
		FechaInTrabajador = fechaInTrabajador;
	}

	public int getCantidadHijosTrabajador() {
		return CantidadHijosTrabajador;
	}

	public void setCantidadHijosTrabajador(int cantidadHijosTrabajador) {
		CantidadHijosTrabajador = cantidadHijosTrabajador;
	}

	public int getIdArea() {
		return IdArea;
	}

	public void setIdArea(int idArea) {
		IdArea = idArea;
	}

	public int getIdAfp() {
		return IdAfp;
	}

	public void setIdAfp(int idAfp) {
		IdAfp = idAfp;
	}

}
