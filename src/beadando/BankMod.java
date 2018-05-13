package beadando;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class BankMod extends JDialog {
	private JTable table;
	private BankTM banktm;
	private JTextField nev, cim, tulorsz;
	
	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("unchecked")
	public BankMod(JFrame f, BankTM betm) {
		super(f, "Bankok módosítása", true);
		banktm=betm;
		setBounds(100, 100, 800, 300);
		getContentPane().setLayout(null);
		
		JButton btnBezr = new JButton("Bezár");
		btnBezr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
			}
		});
		btnBezr.setBounds(350, 230, 85, 21);
		getContentPane().add(btnBezr);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 750, 184);
		getContentPane().add(scrollPane);
		
		table = new JTable(banktm);
		scrollPane.setViewportView(table);
		
		TableColumn tc = null;
		for(int i=0; i<5; i++) {
			tc=table.getColumnModel().getColumn(i);
			if(i==0 || i==1 || i==2)
				tc.setPreferredWidth(50);
			else
				tc.setPreferredWidth(150);
		}
		
		table.setAutoCreateRowSorter(true);
		
		nev = new JTextField();
		nev.setBounds(249, 204, 96, 19);
		getContentPane().add(nev);
		nev.setColumns(10);
		
		cim = new JTextField();
		cim.setBounds(446, 204, 96, 19);
		getContentPane().add(cim);
		cim.setColumns(10);
		
		tulorsz = new JTextField();
		tulorsz.setBounds(630, 204, 96, 19);
		getContentPane().add(tulorsz);
		tulorsz.setColumns(10);
		
		JButton modosit = new JButton("Módosít");
		modosit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(!DataChecker.filled(nev) && !DataChecker.filled(cim) && !DataChecker.filled(tulorsz))
					DataChecker.showMD("Egyetlen módosító adat sincs beírva!", 0);
				else {
					int db=0, jel=0, x=0;
					for(x = 0; x < banktm.getRowCount(); x++) {
						if ((Boolean)banktm.getValueAt(x,0)) {
							db++; jel=x;}
						}
					if (db==0) 
						DataChecker.showMD("Nincs kijelölve a módosítandó rekord!",0);
					if (db>1) 
						DataChecker.showMD("Több rekord van kijelölve!\nEgyszerre csak egy rekord módosítható!",0);
					if (db==1) {
						if (DataChecker.filled(nev)) 
							banktm.setValueAt(DataChecker.createString(nev), jel, 2);
						if (DataChecker.filled(cim)) 
							banktm.setValueAt(DataChecker.createString(cim), jel, 3);
						if (DataChecker.filled(tulorsz)) 
							banktm.setValueAt(DataChecker.createString(tulorsz), jel, 4);
					DataChecker.showMD("A rekord módosítva!",1);
					DataChecker.deleteField(nev); 
					DataChecker.deleteField(cim); DataChecker.deleteField(tulorsz);
					banktm.setValueAt(new Boolean(false), jel, 0);
					}
				}
			}
		});
		modosit.setBounds(476, 230, 85, 21);
		getContentPane().add(modosit);
		
		TableRowSorter<BankTM> trs = (TableRowSorter<BankTM>)table.getRowSorter();
		trs.setSortable(0, false);
	}
}
