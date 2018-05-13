package beadando;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Ugyfel implements Serializable {
	private int szem_szam;
	private String nev;
	private String cim;
	private int tel_szam;
	private Date szul_ido;
	private int fiok_azon;
	
	public Ugyfel(int szem_szam, String nev, String cim, int tel_szam, Date szul_ido, int fiok_azon) {
		super();
		this.szem_szam = szem_szam;
		this.nev = nev;
		this.cim = cim;
		this.tel_szam = tel_szam;
		this.szul_ido = szul_ido;
		this.fiok_azon = fiok_azon;
	}

	public int getSzem_szam() {
		return szem_szam;
	}

	public void setSzem_szam(int szem_szam) {
		this.szem_szam = szem_szam;
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

	public int getTel_szam() {
		return tel_szam;
	}

	public void setTel_szam(int tel_szam) {
		this.tel_szam = tel_szam;
	}

	public Date getSzul_ido() {
		return szul_ido;
	}

	public void setSzul_ido(Date szul_ido) {
		this.szul_ido = szul_ido;
	}

	public int getFiok_azon() {
		return fiok_azon;
	}

	public void setFiok_azon(int fiok_azon) {
		this.fiok_azon = fiok_azon;
	}
}