package beadando;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

@SuppressWarnings("serial")
public class BankfiokHelp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankfiokHelp frame = new BankfiokHelp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BankfiokHelp() {
		setTitle("Help");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel bankfiok_help = new JPanel();
		bankfiok_help.setLayout(null);
		bankfiok_help.setBounds(0, 0, 416, 241);
		contentPane.add(bankfiok_help);
		
		JLabel lblABankfikTblhoz = new JLabel("A Bankfi\u00F3k t\u00E1bl\u00E1hoz tartoz\u00F3 s\u00FAg\u00F3");
		lblABankfikTblhoz.setBounds(10, 10, 200, 13);
		bankfiok_help.add(lblABankfikTblhoz);
		
		JLabel lblBankfikhozTartozAdatot = new JLabel("Bankfi\u00F3khoz tartoz\u00F3 adatot csak a megadott form\u00E1tumokban (.txt \u00E9s .csv) lehet bet\u00F6lteni,");
		lblBankfikhozTartozAdatot.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblBankfikhozTartozAdatot.setBounds(10, 60, 396, 13);
		bankfiok_help.add(lblBankfikhozTartozAdatot);
		
		JLabel label_2 = new JLabel("illetve f\u00E1jlba ki\u00EDrni is csak az el\u0151bb eml\u00EDtett form\u00E1tumokban lehet.");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_2.setBounds(10, 83, 396, 13);
		bankfiok_help.add(label_2);
		
		JLabel label_3 = new JLabel("Az adatokon v\u00E9gzett m\u00F3dos\u00EDt\u00E1sok csak a f\u00E1jlba val\u00F3 ki\u00EDr\u00E1s (ment\u00E9s) ut\u00E1n v\u00E9gleges\u00ED-");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_3.setBounds(10, 120, 396, 13);
		bankfiok_help.add(label_3);
		
		JLabel label_4 = new JLabel("t\u0151dnek.");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_4.setBounds(10, 143, 45, 13);
		bankfiok_help.add(label_4);
		
		JLabel label_5 = new JLabel("A v\u00E1ltoztat\u00E1sok m\u00E1s f\u00FClre val\u00F3 v\u00E1lt\u00E1skor nem t\u00F6rl\u0151dnek (csak kil\u00E9p\u00E9skor).");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_5.setBounds(10, 180, 396, 13);
		bankfiok_help.add(label_5);
	}

}
