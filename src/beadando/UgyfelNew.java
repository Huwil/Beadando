package beadando;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

@SuppressWarnings("serial")
public class UgyfelNew extends JDialog {
	private JTextField szem_szam, nev, cim, tel_szam, szul_ido, fiok_azon;
	private Ugyfel adat;
	private int kilep=0;
	/**
	 * Create the dialog.
	 */
	public UgyfelNew(JFrame f, int maxKod) {
		super(f, true);
		
		setTitle("�j �gyf�l felvitele");
		getContentPane().setBackground(new Color(255,255,255));
		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(null);
		
		JLabel lblszem_szam = new JLabel("Szem�lyi sz�m:");
		lblszem_szam.setBounds(10, 10, 100, 20);
		getContentPane().add(lblszem_szam);
		
		szem_szam = new JTextField();
		szem_szam.setEditable(false);
		szem_szam.setBounds(140, 10, 100, 20);
		getContentPane().add(szem_szam);
		szem_szam.setColumns(10);
		
		JLabel lblnev = new JLabel("N�v:");
		lblnev.setBounds(10, 40, 100, 20);
		getContentPane().add(lblnev);
		
		nev = new JTextField();
		nev.setColumns(10);
		nev.setBounds(140, 40, 100, 20);
		getContentPane().add(nev);
		
		JLabel lblcim = new JLabel("C�m:");
		lblcim.setBounds(10, 70, 100, 20);
		getContentPane().add(lblcim);
		
		cim = new JTextField();
		cim.setColumns(10);
		cim.setBounds(140, 70, 100, 20);
		getContentPane().add(cim);
		
		JLabel lbltel_szam = new JLabel("Telefonsz�m:");
		lbltel_szam.setBounds(10, 100, 120, 20);
		getContentPane().add(lbltel_szam);
		
		tel_szam = new JTextField();
		tel_szam.setColumns(10);
		tel_szam.setBounds(140, 100, 100, 20);
		getContentPane().add(tel_szam);
		
		JLabel lblszul_ido = new JLabel("Sz�let�si id�:");
		lblszul_ido.setBounds(10, 130, 120, 20);
		getContentPane().add(lblszul_ido);
		
		szul_ido = new JTextField();
		szul_ido.setColumns(10);
		szul_ido.setBounds(140, 130, 100, 20);
		getContentPane().add(szul_ido);
		
		JLabel lblfiok_azon = new JLabel("Fi�k azonos�t�:");
		lblfiok_azon.setBounds(10, 160, 120, 20);
		getContentPane().add(lblfiok_azon);
		
		fiok_azon = new JTextField();
		fiok_azon.setColumns(10);
		fiok_azon.setBounds(140, 160, 100, 20);
		getContentPane().add(fiok_azon);
		
		JButton btnleker = new JButton("Lek�r");
		btnleker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				szem_szam.setText(""+(maxKod+1));
			}
		});
		btnleker.setBounds(280, 10, 85, 20);
		getContentPane().add(btnleker);
		
		JButton btnbeszur = new JButton("Besz�r");
		btnbeszur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!DataChecker.filled(szem_szam))
					szem_szam.setText(""+(maxKod+1));
				if(!DataChecker.filled(nev))
					DataChecker.showMD("A n�v mez� �res!", 0);
				else if(!DataChecker.filled(cim))
					DataChecker.showMD("A c�m mez� �res!", 0);
				else if(!DataChecker.filled(tel_szam))
					DataChecker.showMD("A telefonsz�m mez� �res!", 0);
				else if(!DataChecker.goodInt(tel_szam))
					DataChecker.showMD("A telefonsz�m mez�be az �gyf�l telefonsz�ma (eg�sz) ker�l!", 0);
				else if(!DataChecker.filled(szul_ido))
					DataChecker.showMD("A sz�let�si id� mez� �res!", 0);
				else if(!DataChecker.goodDate(szul_ido))
					DataChecker.showMD("A sz�let�si id� mez�be sz�let�si d�tum (yyyy.mm.dd) ker�l!", 0);
				else if(!DataChecker.filled(fiok_azon))
					DataChecker.showMD("A fi�k azonos�t� mez� �res!", 0);
				else if(!DataChecker.goodInt(fiok_azon))
					DataChecker.showMD("A telefonsz�m mez�be az �gyf�l telefonsz�ma (eg�sz) ker�l!", 0);
				else {
					adat=new Ugyfel(DataChecker.StoI(DataChecker.createString(szem_szam)), DataChecker.createString(nev), DataChecker.createString(cim), DataChecker.StoI(DataChecker.createString(tel_szam)), DataChecker.StoD(DataChecker.createString(szul_ido)), DataChecker.StoI(DataChecker.createString(fiok_azon)));
					DataChecker.showMD("Adat besz�rva!", 1);
					kilep=1;
					dispose();
					setVisible(false);
				}
			}
		});
		btnbeszur.setBounds(85, 230, 85, 20);
		getContentPane().add(btnbeszur);
		
		JButton btnbezar = new JButton("Bez�r");
		btnbezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
			}
		});
		btnbezar.setBounds(270, 230, 85, 20);
		getContentPane().add(btnbezar);

	}
	
	public Ugyfel getUgyfel() {
		return adat;
	}
	
	public int Kilep() {
		return kilep;
	}
}