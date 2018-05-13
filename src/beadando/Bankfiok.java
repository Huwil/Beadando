package beadando;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Bankfiok implements Serializable {
	private int fiok_azon;
	private String cim;
	private int alkalmazottak;
	private int bank_azon;
	
	public Bankfiok(int fiok_azon, String cim, int alkalmazottak, int bank_azon) {
		super();
		this.fiok_azon = fiok_azon;
		this.cim = cim;
		this.alkalmazottak = alkalmazottak;
		this.bank_azon = bank_azon;
	}

	public int getFiok_azon() {
		return fiok_azon;
	}

	public void setFiok_azon(int fiok_azon) {
		this.fiok_azon = fiok_azon;
	}

	public String getCim() {
		return cim;
	}

	public void setCim(String cim) {
		this.cim = cim;
	}

	public int getAlkalmazottak() {
		return alkalmazottak;
	}

	public void setAlkalmazottak(int alkalmazottak) {
		this.alkalmazottak = alkalmazottak;
	}

	public int getBank_azon() {
		return bank_azon;
	}

	public void setBank_azon(int bank_azon) {
		this.bank_azon = bank_azon;
	}
}