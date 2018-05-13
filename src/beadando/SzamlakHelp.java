package beadando;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

@SuppressWarnings("serial")
public class SzamlakHelp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SzamlakHelp frame = new SzamlakHelp();
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
	public SzamlakHelp() {
		setTitle("Help");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel szamlak_help = new JPanel();
		szamlak_help.setLayout(null);
		szamlak_help.setBounds(0, 0, 416, 241);
		contentPane.add(szamlak_help);
		
		JLabel lblASzmlkTblhoz = new JLabel("A Sz\u00E1ml\u00E1k t\u00E1bl\u00E1hoz tartoz\u00F3 s\u00FAg\u00F3");
		lblASzmlkTblhoz.setBounds(10, 10, 200, 13);
		szamlak_help.add(lblASzmlkTblhoz);
		
		JLabel lblSzmlkhozTartozAdatot = new JLabel("Sz\u00E1ml\u00E1khoz tartoz\u00F3 adatot csak a megadott form\u00E1tumokban (.txt \u00E9s .csv) lehet bet\u00F6lteni,");
		lblSzmlkhozTartozAdatot.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSzmlkhozTartozAdatot.setBounds(10, 60, 396, 13);
		szamlak_help.add(lblSzmlkhozTartozAdatot);
		
		JLabel label_14 = new JLabel("illetve f\u00E1jlba ki\u00EDrni is csak az el\u0151bb eml\u00EDtett form\u00E1tumokban lehet.");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_14.setBounds(10, 83, 396, 13);
		szamlak_help.add(label_14);
		
		JLabel label_15 = new JLabel("Az adatokon v\u00E9gzett m\u00F3dos\u00EDt\u00E1sok csak a f\u00E1jlba val\u00F3 ki\u00EDr\u00E1s (ment\u00E9s) ut\u00E1n v\u00E9gleges\u00ED-");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_15.setBounds(10, 120, 396, 13);
		szamlak_help.add(label_15);
		
		JLabel label_16 = new JLabel("t\u0151dnek.");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_16.setBounds(10, 143, 45, 13);
		szamlak_help.add(label_16);
		
		JLabel label_17 = new JLabel("A v\u00E1ltoztat\u00E1sok m\u00E1s f\u00FClre val\u00F3 v\u00E1lt\u00E1skor nem t\u00F6rl\u0151dnek (csak kil\u00E9p\u00E9skor).");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_17.setBounds(10, 180, 396, 13);
		szamlak_help.add(label_17);
	}

}
