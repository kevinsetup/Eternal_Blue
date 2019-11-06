package pe.com.eteralblue.modelo;

public class Boleta {
	private int IdBoleta;
	private double SueldoBasebBoleta;
	private double GratificacionBoleta;
	private double BonificacionBoleta;
	private double HorasExtrasBoleta;
	private double AsignacionFamiliarBoleta;
	private double TardanzasBoleta;
	private double FaltasBoleta;
	private double AfpBoleta;
	private double DiezmoBoleta;
	private int IdTrabajador;

	public Boleta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boleta(int idBoleta, double sueldoBasebBoleta, double gratificacionBoleta, double bonificacionBoleta,
			double horasExtrasBoleta, double asignacionFamiliarBoleta, double tardanzasBoleta, double faltasBoleta,
			double afpBoleta, double diezmoBoleta, int idTrabajador) {
		super();
		IdBoleta = idBoleta;
		SueldoBasebBoleta = sueldoBasebBoleta;
		GratificacionBoleta = gratificacionBoleta;
		BonificacionBoleta = bonificacionBoleta;
		HorasExtrasBoleta = horasExtrasBoleta;
		AsignacionFamiliarBoleta = asignacionFamiliarBoleta;
		TardanzasBoleta = tardanzasBoleta;
		FaltasBoleta = faltasBoleta;
		AfpBoleta = afpBoleta;
		DiezmoBoleta = diezmoBoleta;
		IdTrabajador = idTrabajador;
	}

	public int getIdBoleta() {
		return IdBoleta;
	}

	public void setIdBoleta(int idBoleta) {
		IdBoleta = idBoleta;
	}

	public double getSueldoBasebBoleta() {
		return SueldoBasebBoleta;
	}

	public void setSueldoBasebBoleta(double sueldoBasebBoleta) {
		SueldoBasebBoleta = sueldoBasebBoleta;
	}

	public double getGratificacionBoleta() {
		return GratificacionBoleta;
	}

	public void setGratificacionBoleta(double gratificacionBoleta) {
		GratificacionBoleta = gratificacionBoleta;
	}

	public double getBonificacionBoleta() {
		return BonificacionBoleta;
	}

	public void setBonificacionBoleta(double bonificacionBoleta) {
		BonificacionBoleta = bonificacionBoleta;
	}

	public double getHorasExtrasBoleta() {
		return HorasExtrasBoleta;
	}

	public void setHorasExtrasBoleta(double horasExtrasBoleta) {
		HorasExtrasBoleta = horasExtrasBoleta;
	}

	public double getAsignacionFamiliarBoleta() {
		return AsignacionFamiliarBoleta;
	}

	public void setAsignacionFamiliarBoleta(double asignacionFamiliarBoleta) {
		AsignacionFamiliarBoleta = asignacionFamiliarBoleta;
	}

	public double getTardanzasBoleta() {
		return TardanzasBoleta;
	}

	public void setTardanzasBoleta(double tardanzasBoleta) {
		TardanzasBoleta = tardanzasBoleta;
	}

	public double getFaltasBoleta() {
		return FaltasBoleta;
	}

	public void setFaltasBoleta(double faltasBoleta) {
		FaltasBoleta = faltasBoleta;
	}

	public double getAfpBoleta() {
		return AfpBoleta;
	}

	public void setAfpBoleta(double afpBoleta) {
		AfpBoleta = afpBoleta;
	}

	public double getDiezmoBoleta() {
		return DiezmoBoleta;
	}

	public void setDiezmoBoleta(double diezmoBoleta) {
		DiezmoBoleta = diezmoBoleta;
	}

	public int getIdTrabajador() {
		return IdTrabajador;
	}

	public void setIdTrabajador(int idTrabajador) {
		IdTrabajador = idTrabajador;
	}

}
