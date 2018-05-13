package beadando;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Bank implements Serializable {
	private int id;
	private String nev;
	private String cim;
	private String tul_orsz;
	
	public Bank(int id, String nev, String cim, String tul_orsz) {
		super();
		this.id = id;
		this.nev = nev;
		this.cim = cim;
		this.tul_orsz = tul_orsz;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public String getCim() {
		return cim;
	}

	public void setCim(String cim) {
		this.cim = cim;
	}

	public String getTul_orsz() {
		return tul_orsz;
	}

	public void setTul_orsz(String tul_orsz) {
		this.tul_orsz = tul_orsz;
	}
	
	
}