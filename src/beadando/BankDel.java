package beadando;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class BankDel extends JDialog {
	private JTable table;
	private BankTM banktm;
	private Boolean md = false;

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("unchecked")
	public BankDel(JFrame f, BankTM betm) {
		super(f, "Bankok törlése", true);
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
		scrollPane.setBounds(10, 10, 750, 192);
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
		
		JButton torles = new JButton("Törlés");
		torles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int db=0, jel=0, x=0;
				for(x = 0; x < betm.getRowCount(); x++)
					if ((Boolean)betm.getValueAt(x,0)) {
						db++; jel=x;
					}
				if (db==0) 
					DataChecker.showMD("Nincs kijelölve a törlendõ rekord!",0);
				if (!md) {
					if (db>1) 
						DataChecker.showMD("Több rekord van kijelölve!\nEgyszerre csak egy rekord törölhetõ!",0);
					if (db==1) {
						betm.removeRow(jel);
						DataChecker.showMD("A rekord törölve!",1);
					}
				} 
				else {
					for (int i=0; i<betm.getRowCount(); i++)
						if ((Boolean)betm.getValueAt(i,0)) {
							betm.removeRow(i); i--;
						}
					DataChecker.showMD("Rekord(ok) törölve!",1);
					}
				}
		});
		torles.setBounds(456, 230, 85, 21);
		getContentPane().add(torles);
		
		JCheckBox jcb = new JCheckBox("Több rekord is törölhetõ egyszerre!");
		jcb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				md = jcb.isSelected();
			}
		});
		jcb.setBounds(10, 205, 187, 21);
		getContentPane().add(jcb);
		
		TableRowSorter<BankTM> trs = (TableRowSorter<BankTM>)table.getRowSorter();
		trs.setSortable(0, false);
	}
}
