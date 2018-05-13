package beadando;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

@SuppressWarnings("serial")
public class SzamlakNew extends JDialog {
	private JTextField szamla_szam, egyenleg, megnevezes, tipus, ugyfel_azon;
	private Szamlak adat;
	private int kilep=0;

	/**
	 * Create the dialog.
	 */
	public SzamlakNew(JFrame f, int maxKod) {
		super(f, true);
		
		setTitle("�j sz�mla felvitele");
		getContentPane().setBackground(new Color(255,255,255));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblszamla_szam = new JLabel("Sz�mlasz�m:");
		lblszamla_szam.setBounds(10, 10, 100, 20);
		getContentPane().add(lblszamla_szam);
		
		szamla_szam = new JTextField();
		szamla_szam.setEditable(false);
		szamla_szam.setBounds(140, 10, 100, 20);
		getContentPane().add(szamla_szam);
		szamla_szam.setColumns(10);
		
		JLabel lblegyenleg = new JLabel("Egyenleg:");
		lblegyenleg.setBounds(10, 40, 100, 20);
		getContentPane().add(lblegyenleg);
		
		egyenleg = new JTextField();
		egyenleg.setColumns(10);
		egyenleg.setBounds(140, 40, 100, 20);
		getContentPane().add(egyenleg);
		
		JLabel lblmegnevezes = new JLabel("Sz�mla megnevez�se:");
		lblmegnevezes.setBounds(10, 70, 130, 20);
		getContentPane().add(lblmegnevezes);
		
		megnevezes = new JTextField();
		megnevezes.setColumns(10);
		megnevezes.setBounds(140, 70, 100, 20);
		getContentPane().add(megnevezes);
		
		JLabel lbltipus = new JLabel("Sz�mla t�pusa:");
		lbltipus.setBounds(10, 100, 120, 20);
		getContentPane().add(lbltipus);
		
		tipus = new JTextField();
		tipus.setColumns(10);
		tipus.setBounds(140, 100, 100, 20);
		getContentPane().add(tipus);
		
		JLabel lblugyfel_azon = new JLabel("�gyf�l azonos�t�ja:");
		lblugyfel_azon.setBounds(10, 130, 120, 20);
		getContentPane().add(lblugyfel_azon);
		
		ugyfel_azon = new JTextField();
		ugyfel_azon.setColumns(10);
		ugyfel_azon.setBounds(140, 130, 100, 20);
		getContentPane().add(ugyfel_azon);
		
		JButton btnleker = new JButton("Lek�r");
		btnleker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				szamla_szam.setText(""+(maxKod+1));
			}
		});
		btnleker.setBounds(280, 10, 85, 20);
		getContentPane().add(btnleker);
		
		JButton btnbeszur = new JButton("Besz�r");
		btnbeszur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!DataChecker.filled(szamla_szam))
					szamla_szam.setText(""+(maxKod+1));
				if(!DataChecker.filled(egyenleg))
					DataChecker.showMD("Az egyenleg mez� �res!", 0);
				else if(!DataChecker.goodInt(egyenleg))
					DataChecker.showMD("Az egyenleg mez�be egy sz�m (eg�sz) ker�l!", 0);
				else if(!DataChecker.filled(megnevezes))
					DataChecker.showMD("A sz�mla megnevez�se mez� �res!", 0);
				else if(!DataChecker.filled(tipus))
					DataChecker.showMD("A sz�mla t�pusa mez� �res!", 0);
				else if(!DataChecker.filled(ugyfel_azon))
					DataChecker.showMD("Az �gyf�l azonos�t�ja mez� �res!", 0);
				else if(!DataChecker.goodInt(ugyfel_azon))
					DataChecker.showMD("Az �gyf�l azonos�t�ja mez�be egy sz�m (eg�sz) ker�l!", 0);
				else {
					adat=new Szamlak(DataChecker.StoI(DataChecker.createString(szamla_szam)), DataChecker.StoI(DataChecker.createString(egyenleg)), DataChecker.createString(megnevezes), DataChecker.createString(tipus), DataChecker.StoI(DataChecker.createString(ugyfel_azon)));
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
	
	public Szamlak getSzamlak() {
		return adat;
	}
	
	public int Kilep() {
		return kilep;
	}
}