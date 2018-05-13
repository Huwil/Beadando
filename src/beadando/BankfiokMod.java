package beadando;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class BankfiokMod extends JDialog {
	private JTable table;
	private BankfiokTM bankfioktm;
	private JTextField cim;
	private JTextField alk;
	private JTextField bank_azon;

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("unchecked")
	public BankfiokMod(JFrame f, BankfiokTM betm) {
		super(f, "Bankfiókok módosítása", true);
		bankfioktm=betm;
		setBounds(100, 100, 800, 300);
		
		JButton btnBezr = new JButton("Bezár");
		btnBezr.setBounds(350, 230, 85, 21);
		btnBezr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnBezr);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 750, 184);
		getContentPane().add(scrollPane);
		
		table = new JTable(bankfioktm);
		scrollPane.setViewportView(table);
		
		TableColumn tc = null;
		for(int i=0; i<5; i++) {
			tc=table.getColumnModel().getColumn(i);
			if(i==0 || i==1 || i==4)
				tc.setPreferredWidth(50);
			else
				tc.setPreferredWidth(150);
		}
		
		table.setAutoCreateRowSorter(true);
		
		cim = new JTextField();
		cim.setBounds(238, 204, 96, 19);
		getContentPane().add(cim);
		cim.setColumns(10);
		
		alk = new JTextField();
		alk.setBounds(457, 204, 96, 19);
		getContentPane().add(alk);
		alk.setColumns(10);
		
		bank_azon = new JTextField();
		bank_azon.setBounds(636, 204, 96, 19);
		getContentPane().add(bank_azon);
		bank_azon.setColumns(10);
		
		JButton modosit = new JButton("Módosít");
		modosit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(!DataChecker.filled(cim) && !DataChecker.filled(alk) && !DataChecker.filled(bank_azon))
					DataChecker.showMD("Egyetlen módosító adat sincs beírva!", 0);
				else if (DataChecker.filled(alk) && !DataChecker.goodInt(alk)) 
					DataChecker.showMD("Az Alkalmazottak száma mezõben hibás adat van!",0);
				else if (DataChecker.filled(bank_azon) && !DataChecker.goodInt(bank_azon)) 
					DataChecker.showMD("A Bank azonosító mezõben hibás adat van!",0);
				else {
					int db=0, jel=0, x=0;
					for(x = 0; x < bankfioktm.getRowCount(); x++) {
						if ((Boolean)bankfioktm.getValueAt(x,0)) {
							db++; jel=x;}
						}
					if (db==0) 
						DataChecker.showMD("Nincs kijelölve a módosítandó rekord!",0);
					if (db>1) 
						DataChecker.showMD("Több rekord van kijelölve!\nEgyszerre csak egy rekord módosítható!",0);
					if (db==1) {
						if (DataChecker.filled(cim)) 
							bankfioktm.setValueAt(DataChecker.createString(cim), jel, 2);
						if (DataChecker.filled(alk)) 
							bankfioktm.setValueAt(DataChecker.StoI(DataChecker.createString(cim)), jel, 3);
						if (DataChecker.filled(bank_azon)) 
							bankfioktm.setValueAt(DataChecker.StoI(DataChecker.createString(bank_azon)), jel, 4);
					DataChecker.showMD("A rekord módosítva!",1);
					DataChecker.deleteField(cim); 
					DataChecker.deleteField(alk); 
					DataChecker.deleteField(bank_azon);
					bankfioktm.setValueAt(new Boolean(false), jel, 0);
					}
				}
			}
		});
		modosit.setBounds(476, 230, 85, 21);
		getContentPane().add(modosit);
		
		TableRowSorter<BankfiokTM> trs = (TableRowSorter<BankfiokTM>)table.getRowSorter();
		trs.setSortable(0, false);
	}
}
