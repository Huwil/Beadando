package beadando;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class SzamlakMod extends JDialog {
	private JTable table;
	private SzamlakTM szamlaktm;
	private JTextField egyenleg;
	private JTextField megnevezes;
	private JTextField tipus;
	private JTextField ugyfel_azon;

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("unchecked")
	public SzamlakMod(JFrame f, SzamlakTM betm) {
		super(f, "Számlák módosítása", true);
		szamlaktm=betm;
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
		
		table = new JTable(szamlaktm);
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
		
		egyenleg = new JTextField();
		egyenleg.setBounds(179, 204, 96, 19);
		getContentPane().add(egyenleg);
		egyenleg.setColumns(10);
		
		megnevezes = new JTextField();
		megnevezes.setBounds(306, 204, 96, 19);
		getContentPane().add(megnevezes);
		megnevezes.setColumns(10);
		
		tipus = new JTextField();
		tipus.setBounds(436, 204, 96, 19);
		getContentPane().add(tipus);
		tipus.setColumns(10);
		
		ugyfel_azon = new JTextField();
		ugyfel_azon.setBounds(587, 204, 96, 19);
		getContentPane().add(ugyfel_azon);
		ugyfel_azon.setColumns(10);
		
		JButton modosit = new JButton("Módosít");
		modosit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(!DataChecker.filled(egyenleg) && !DataChecker.filled(megnevezes) && !DataChecker.filled(tipus) && !DataChecker.filled(ugyfel_azon))
					DataChecker.showMD("Egyetlen módosító adat sincs beírva!", 0);
				else if (DataChecker.filled(egyenleg) && !DataChecker.goodInt(egyenleg)) 
					DataChecker.showMD("Az Egyenleg mezõben hibás adat van!",0);
				else if (DataChecker.filled(ugyfel_azon) && !DataChecker.goodInt(ugyfel_azon)) 
					DataChecker.showMD("Az Ügyfél azonosító mezõben hibás adat van!",0);
				else {
					int db=0, jel=0, x=0;
					for(x = 0; x < szamlaktm.getRowCount(); x++) {
						if ((Boolean)szamlaktm.getValueAt(x,0)) {
							db++; jel=x;}
						}
					if (db==0) 
						DataChecker.showMD("Nincs kijelölve a módosítandó rekord!",0);
					if (db>1) 
						DataChecker.showMD("Több rekord van kijelölve!\nEgyszerre csak egy rekord módosítható!",0);
					if (db==1) {
						if (DataChecker.filled(egyenleg)) 
							szamlaktm.setValueAt(DataChecker.StoI(DataChecker.createString(egyenleg)), jel, 2);
						if (DataChecker.filled(megnevezes)) 
							szamlaktm.setValueAt(DataChecker.createString(megnevezes), jel, 3);
						if (DataChecker.filled(tipus)) 
							szamlaktm.setValueAt(DataChecker.createString(tipus), jel, 4);
						if (DataChecker.filled(ugyfel_azon)) 
							szamlaktm.setValueAt(DataChecker.StoI(DataChecker.createString(ugyfel_azon)), jel, 5);
					DataChecker.showMD("A rekord módosítva!",1);
					DataChecker.deleteField(egyenleg); 
					DataChecker.deleteField(megnevezes);
					DataChecker.deleteField(tipus);
					DataChecker.deleteField(ugyfel_azon);
					szamlaktm.setValueAt(new Boolean(false), jel, 0);
					}
				}
			}
		});
		modosit.setBounds(476, 230, 85, 21);
		getContentPane().add(modosit);
		
		TableRowSorter<SzamlakTM> trs = (TableRowSorter<SzamlakTM>)table.getRowSorter();
		trs.setSortable(0, false);
	}
}
