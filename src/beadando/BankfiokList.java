package beadando;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class BankfiokList extends JDialog {
	private JTable table;
	private BankfiokTM bankfioktm;

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("unchecked")
	public BankfiokList(JFrame f, BankfiokTM betm) {
		super(f, "Bankfiókok listája", true);
		bankfioktm=betm;
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
		scrollPane.setBounds(10, 10, 750, 250);
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
		TableRowSorter<BankfiokTM> trs = (TableRowSorter<BankfiokTM>)table.getRowSorter();
		trs.setSortable(0, false);
	}
}
