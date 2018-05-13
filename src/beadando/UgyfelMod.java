package beadando;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class UgyfelMod extends JDialog {
	private JTable table;
	private UgyfelTM ugyfeltm;
	private JTextField nev;
	private JTextField cim;
	private JTextField tel_szam;
	private JTextField szulido;
	private JTextField fiok_azon;

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("unchecked")
	public UgyfelMod(JFrame f, UgyfelTM betm) {
		super(f, "Ügyfelek módosítása", true);
		ugyfeltm=betm;
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
		scrollPane.setBounds(10, 10, 750, 181);
		getContentPane().add(scrollPane);
		
		table = new JTable(ugyfeltm);
		scrollPane.setViewportView(table);
		
		TableColumn tc = null;
		for(int i=0; i<6; i++) {
			tc=table.getColumnModel().getColumn(i);
			if(i==0)
				tc.setPreferredWidth(50);
			else
				tc.setPreferredWidth(150);
		}
		
		table.setAutoCreateRowSorter(true);
		
		nev = new JTextField();
		nev.setBounds(192, 201, 96, 19);
		getContentPane().add(nev);
		nev.setColumns(10);
		
		cim = new JTextField();
		cim.setBounds(302, 201, 96, 19);
		getContentPane().add(cim);
		cim.setColumns(10);
		
		tel_szam = new JTextField();
		tel_szam.setBounds(418, 201, 96, 19);
		getContentPane().add(tel_szam);
		tel_szam.setColumns(10);
		
		szulido = new JTextField();
		szulido.setBounds(524, 201, 96, 19);
		getContentPane().add(szulido);
		szulido.setColumns(10);
		
		fiok_azon = new JTextField();
		fiok_azon.setBounds(630, 201, 96, 19);
		getContentPane().add(fiok_azon);
		fiok_azon.setColumns(10);
		
		JButton modosit = new JButton("Módosít");
		modosit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(!DataChecker.filled(nev) && !DataChecker.filled(cim) && !DataChecker.filled(tel_szam) && !DataChecker.filled(szulido) && !DataChecker.filled(fiok_azon))
					DataChecker.showMD("Egyetlen módosító adat sincs beírva!", 0);
				else if (DataChecker.filled(tel_szam) && !DataChecker.goodInt(tel_szam)) 
					DataChecker.showMD("A Telefonszám mezõben hibás adat van!",0);
				else if (DataChecker.filled(szulido) && !DataChecker.goodDate(szulido)) 
					DataChecker.showMD("A Születési idõ mezõben hibás adat van!",0);
				else if (DataChecker.filled(fiok_azon) && !DataChecker.goodInt(fiok_azon)) 
					DataChecker.showMD("A Fiók azonosító mezõben hibás adat van!",0);
				else {
					int db=0, jel=0, x=0;
					for(x = 0; x < ugyfeltm.getRowCount(); x++) {
						if ((Boolean)ugyfeltm.getValueAt(x,0)) {
							db++; jel=x;}
						}
					if (db==0) 
						DataChecker.showMD("Nincs kijelölve a módosítandó rekord!",0);
					if (db>1) 
						DataChecker.showMD("Több rekord van kijelölve!\nEgyszerre csak egy rekord módosítható!",0);
					if (db==1) {
						if (DataChecker.filled(nev)) 
							ugyfeltm.setValueAt(DataChecker.createString(nev), jel, 2);
						if (DataChecker.filled(cim)) 
							ugyfeltm.setValueAt(DataChecker.createString(cim), jel, 3);
						if (DataChecker.filled(tel_szam)) 
							ugyfeltm.setValueAt(DataChecker.StoI(DataChecker.createString(tel_szam)), jel, 4);
						if (DataChecker.filled(szulido)) 
							ugyfeltm.setValueAt(DataChecker.StoD(DataChecker.createString(szulido)), jel, 5);
						if (DataChecker.filled(fiok_azon)) 
							ugyfeltm.setValueAt(DataChecker.StoI(DataChecker.createString(fiok_azon)), jel, 6);
					DataChecker.showMD("A rekord módosítva!",1);
					DataChecker.deleteField(nev); 
					DataChecker.deleteField(cim);
					DataChecker.deleteField(tel_szam);
					DataChecker.deleteField(szulido);
					DataChecker.deleteField(fiok_azon);
					ugyfeltm.setValueAt(new Boolean(false), jel, 0);
					}
				}
			}
		});
		modosit.setBounds(476, 230, 85, 21);
		getContentPane().add(modosit);
		
		TableRowSorter<UgyfelTM> trs = (TableRowSorter<UgyfelTM>)table.getRowSorter();
		trs.setSortable(0, false);
	}
}