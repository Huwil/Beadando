package beadando;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

@SuppressWarnings("serial")
public class BankfiokNew extends JDialog {
	private JTextField fiok_azon, cim, alkalmazottak, bank_azon;
	private Bankfiok adat;
	private int kilep=0;

	/**
	 * Create the dialog.
	 */
	public BankfiokNew(JFrame f, int maxKod) {
		super(f, true);
		
		setTitle("�j bankfi�k felvitele");
		getContentPane().setBackground(new Color(255,255,255));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblfiok_azon = new JLabel("Fi�k azonos�t�:");
		lblfiok_azon.setBounds(10, 10, 100, 20);
		getContentPane().add(lblfiok_azon);
		
		fiok_azon = new JTextField();
		fiok_azon.setEditable(false);
		fiok_azon.setBounds(140, 10, 100, 20);
		getContentPane().add(fiok_azon);
		fiok_azon.setColumns(10);
		
		JLabel lblcim = new JLabel("C�m:");
		lblcim.setBounds(10, 40, 100, 20);
		getContentPane().add(lblcim);
		
		cim = new JTextField();
		cim.setColumns(10);
		cim.setBounds(140, 40, 100, 20);
		getContentPane().add(cim);
		
		JLabel lblalk = new JLabel("Alkalmazottak sz�ma:");
		lblalk.setBounds(10, 70, 120, 20);
		getContentPane().add(lblalk);
		
		alkalmazottak = new JTextField();
		alkalmazottak.setColumns(10);
		alkalmazottak.setBounds(140, 70, 100, 20);
		getContentPane().add(alkalmazottak);
		
		JLabel lblbank_azon = new JLabel("Bank azonos�t�:");
		lblbank_azon.setBounds(10, 100, 120, 20);
		getContentPane().add(lblbank_azon);
		
		bank_azon = new JTextField();
		bank_azon.setColumns(10);
		bank_azon.setBounds(140, 100, 100, 20);
		getContentPane().add(bank_azon);
		
		JButton btnleker = new JButton("Lek�r");
		btnleker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fiok_azon.setText(""+(maxKod+1));
			}
		});
		btnleker.setBounds(280, 10, 85, 20);
		getContentPane().add(btnleker);
		
		JButton btnbeszur = new JButton("Besz�r");
		btnbeszur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!DataChecker.filled(fiok_azon))
					fiok_azon.setText(""+(maxKod+1));
				if(!DataChecker.filled(cim))
					DataChecker.showMD("A c�m mez� �res!", 0);
				else if(!DataChecker.filled(alkalmazottak))
					DataChecker.showMD("Az alkalmazottak mez� �res!", 0);
				else if(!DataChecker.goodInt(alkalmazottak))
					DataChecker.showMD("Az alkalmazottak mez�be az alkalmazottak sz�ma (eg�sz) ker�l!", 0);
				else if(!DataChecker.filled(bank_azon))
					DataChecker.showMD("A bank azonos�t� mez� �res!", 0);
				else if(!DataChecker.goodInt(bank_azon))
					DataChecker.showMD("A bank azonos�t� mez�be a bank azonos�t�ja (eg�sz) ker�l!", 0);
				else {
					adat=new Bankfiok(DataChecker.StoI(DataChecker.createString(fiok_azon)), DataChecker.createString(cim), DataChecker.StoI(DataChecker.createString(alkalmazottak)), DataChecker.StoI(DataChecker.createString(bank_azon)));
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
	
	public Bankfiok getBankfiok() {
		return adat;
	}
	
	public int Kilep() {
		return kilep;
	}
}