package beadando;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

@SuppressWarnings("serial")
public class BankNew extends JDialog {
	private JTextField id, nev, cim, tul_orsz;
	private Bank adat;
	private int kilep=0;

	/**
	 * Create the dialog.
	 */
	public BankNew(JFrame f, int maxKod) {
		super(f, true);
		
		setTitle("Új bank felvitele");
		getContentPane().setBackground(new Color(255,255,255));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblid = new JLabel("Kód:");
		lblid.setBounds(10, 10, 100, 20);
		getContentPane().add(lblid);
		
		id = new JTextField();
		id.setEditable(false);
		id.setBounds(140, 10, 100, 20);
		getContentPane().add(id);
		id.setColumns(10);
		
		JLabel lblnev = new JLabel("Név:");
		lblnev.setBounds(10, 40, 100, 20);
		getContentPane().add(lblnev);
		
		nev = new JTextField();
		nev.setColumns(10);
		nev.setBounds(140, 40, 100, 20);
		getContentPane().add(nev);
		
		JLabel lblcim = new JLabel("Cím:");
		lblcim.setBounds(10, 70, 100, 20);
		getContentPane().add(lblcim);
		
		cim = new JTextField();
		cim.setColumns(10);
		cim.setBounds(140, 70, 100, 20);
		getContentPane().add(cim);
		
		JLabel lbltul_orsz = new JLabel("Tulajdonos ország:");
		lbltul_orsz.setBounds(10, 100, 120, 20);
		getContentPane().add(lbltul_orsz);
		
		tul_orsz = new JTextField();
		tul_orsz.setColumns(10);
		tul_orsz.setBounds(140, 100, 100, 20);
		getContentPane().add(tul_orsz);
		
		JButton btnleker = new JButton("Lekér");
		btnleker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText(""+(maxKod+1));
			}
		});
		btnleker.setBounds(280, 10, 85, 20);
		getContentPane().add(btnleker);
		
		JButton btnbeszur = new JButton("Beszúr");
		btnbeszur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!DataChecker.filled(id))
					id.setText(""+(maxKod+1));
				if(!DataChecker.filled(nev))
					DataChecker.showMD("A név mezõ üres!", 0);
				else if(!DataChecker.filled(cim))
					DataChecker.showMD("A cím mezõ üres!", 0);
				else if(!DataChecker.filled(tul_orsz))
					DataChecker.showMD("A tulajdonos ország mezõ üres!", 0);
				else {
					adat=new Bank(DataChecker.StoI(DataChecker.createString(id)), DataChecker.createString(nev), DataChecker.createString(cim), DataChecker.createString(tul_orsz));
					DataChecker.showMD("Adat beszúrva!", 1);
					kilep=1;
					dispose();
					setVisible(false);
				}
			}
		});
		btnbeszur.setBounds(85, 230, 85, 20);
		getContentPane().add(btnbeszur);
		
		JButton btnbezar = new JButton("Bezár");
		btnbezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
			}
		});
		btnbezar.setBounds(270, 230, 85, 20);
		getContentPane().add(btnbezar);

	}
	
	public Bank getBank() {
		return adat;
	}
	
	public int Kilep() {
		return kilep;
	}
}