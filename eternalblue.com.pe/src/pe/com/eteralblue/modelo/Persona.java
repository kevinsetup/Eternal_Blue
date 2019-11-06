package pe.com.eteralblue.modelo;

public class Persona {
	private int IdPersona;
	private String DniPersona;
	private String NombrePersona;
	private String ApellidoPatPersona;
	private String ApellidoMatPersona;

	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Persona(int idPersona, String dniPersona, String nombrePersona, String apellidoPatPersona,
			String apellidoMatPersona) {
		super();
		IdPersona = idPersona;
		DniPersona = dniPersona;
		NombrePersona = nombrePersona;
		ApellidoPatPersona = apellidoPatPersona;
		ApellidoMatPersona = apellidoMatPersona;
	}

	public int getIdPersona() {
		return IdPersona;
	}

	public void setIdPersona(int idPersona) {
		IdPersona = idPersona;
	}

	public String getDniPersona() {
		return DniPersona;
	}

	public void setDniPersona(String dniPersona) {
		DniPersona = dniPersona;
	}

	public String getNombrePersona() {
		return NombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		NombrePersona = nombrePersona;
	}

	public String getApellidoPatPersona() {
		return ApellidoPatPersona;
	}

	public void setApellidoPatPersona(String apellidoPatPersona) {
		ApellidoPatPersona = apellidoPatPersona;
	}

	public String getApellidoMatPersona() {
		return ApellidoMatPersona;
	}

	public void setApellidoMatPersona(String apellidoMatPersona) {
		ApellidoMatPersona = apellidoMatPersona;
	}

}
