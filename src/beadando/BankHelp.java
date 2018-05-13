package beadando;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class BankHelp extends JDialog {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankHelp frame = new BankHelp();
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
	public BankHelp() {
		setTitle("Help");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel bank_help = new JPanel();
		bank_help.setBounds(10, 10, 416, 241);
		contentPane.add(bank_help);
		bank_help.setLayout(null);
		
		JLabel lblABankTblhoz = new JLabel("A Bank t\u00E1bl\u00E1hoz tartoz\u00F3 s\u00FAg\u00F3");
		lblABankTblhoz.setBounds(10, 10, 200, 13);
		bank_help.add(lblABankTblhoz);
		
		JLabel lblBankhozTartozAdatot = new JLabel("Bankhoz tartoz\u00F3 adatot csak a megadott form\u00E1tumokban (.txt \u00E9s .csv) lehet bet\u00F6lteni,");
		lblBankhozTartozAdatot.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblBankhozTartozAdatot.setBounds(10, 60, 396, 13);
		bank_help.add(lblBankhozTartozAdatot);
		
		JLabel lblIlletveFjlbaKirni = new JLabel("illetve f\u00E1jlba ki\u00EDrni is csak az el\u0151bb eml\u00EDtett form\u00E1tumokban lehet.");
		lblIlletveFjlbaKirni.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblIlletveFjlbaKirni.setBounds(10, 83, 396, 13);
		bank_help.add(lblIlletveFjlbaKirni);
		
		JLabel lblAzAdatokonVgzett = new JLabel("Az adatokon v\u00E9gzett m\u00F3dos\u00EDt\u00E1sok csak a f\u00E1jlba val\u00F3 ki\u00EDr\u00E1s (ment\u00E9s) ut\u00E1n v\u00E9gleges\u00ED-");
		lblAzAdatokonVgzett.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblAzAdatokonVgzett.setBounds(10, 120, 396, 13);
		bank_help.add(lblAzAdatokonVgzett);
		
		JLabel lblTdnek = new JLabel("t\u0151dnek.");
		lblTdnek.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblTdnek.setBounds(10, 143, 45, 13);
		bank_help.add(lblTdnek);
		
		JLabel lblAVltoztatsokMs = new JLabel("A v\u00E1ltoztat\u00E1sok m\u00E1s f\u00FClre val\u00F3 v\u00E1lt\u00E1skor nem t\u00F6rl\u0151dnek (csak kil\u00E9p\u00E9skor).");
		lblAVltoztatsokMs.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblAVltoztatsokMs.setBounds(10, 180, 396, 13);
		bank_help.add(lblAVltoztatsokMs);
		
		
		
		
		
		
	}
}
