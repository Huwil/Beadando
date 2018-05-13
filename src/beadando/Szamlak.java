package beadando;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Szamlak implements Serializable {
	private int szamla_szam;
	private int egyenleg;
	private String megnevezes;
	private String tipus;
	private int ugyfel_azon;
	
	public Szamlak(int szamla_szam, int egyenleg, String megnevezes, String tipus, int ugyfel_azon) {
		super();
		this.szamla_szam = szamla_szam;
		this.egyenleg = egyenleg;
		this.megnevezes = megnevezes;
		this.tipus = tipus;
		this.ugyfel_azon = ugyfel_azon;
	}

	public int getSzamla_szam() {
		return szamla_szam;
	}

	public void setSzamla_szam(int szamla_szam) {
		this.szamla_szam = szamla_szam;
	}

	public int getEgyenleg() {
		return egyenleg;
	}

	public void setEgyenleg(int egyenleg) {
		this.egyenleg = egyenleg;
	}

	public String getMegnevezes() {
		return megnevezes;
	}

	public void setMegnevezes(String megnevezes) {
		this.megnevezes = megnevezes;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	public int getUgyfel_azon() {
		return ugyfel_azon;
	}

	public void setUgyfel_azon(int ugyfel_azon) {
		this.ugyfel_azon = ugyfel_azon;
	}
	
}