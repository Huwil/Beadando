package beadando;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

@SuppressWarnings("serial")
public class UgyfelHelp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UgyfelHelp frame = new UgyfelHelp();
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
	public UgyfelHelp() {
		setTitle("Help");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel ugyfel_help = new JPanel();
		ugyfel_help.setLayout(null);
		ugyfel_help.setBounds(0, 0, 416, 241);
		contentPane.add(ugyfel_help);
		
		JLabel lblAgyflTblhoz = new JLabel("A \u00DCgyf\u00E9l t\u00E1bl\u00E1hoz tartoz\u00F3 s\u00FAg\u00F3");
		lblAgyflTblhoz.setBounds(10, 10, 200, 13);
		ugyfel_help.add(lblAgyflTblhoz);
		
		JLabel lblgyflhezTartozAdatot = new JLabel("\u00DCgyf\u00E9lhez tartoz\u00F3 adatot csak a megadott form\u00E1tumokban (.txt \u00E9s .csv) lehet bet\u00F6lteni,");
		lblgyflhezTartozAdatot.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblgyflhezTartozAdatot.setBounds(10, 60, 396, 13);
		ugyfel_help.add(lblgyflhezTartozAdatot);
		
		JLabel label_8 = new JLabel("illetve f\u00E1jlba ki\u00EDrni is csak az el\u0151bb eml\u00EDtett form\u00E1tumokban lehet.");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_8.setBounds(10, 83, 396, 13);
		ugyfel_help.add(label_8);
		
		JLabel label_9 = new JLabel("Az adatokon v\u00E9gzett m\u00F3dos\u00EDt\u00E1sok csak a f\u00E1jlba val\u00F3 ki\u00EDr\u00E1s (ment\u00E9s) ut\u00E1n v\u00E9gleges\u00ED-");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_9.setBounds(10, 120, 396, 13);
		ugyfel_help.add(label_9);
		
		JLabel label_10 = new JLabel("t\u0151dnek.");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_10.setBounds(10, 143, 45, 13);
		ugyfel_help.add(label_10);
		
		JLabel label_11 = new JLabel("A v\u00E1ltoztat\u00E1sok m\u00E1s f\u00FClre val\u00F3 v\u00E1lt\u00E1skor nem t\u00F6rl\u0151dnek (csak kil\u00E9p\u00E9skor).");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_11.setBounds(10, 180, 396, 13);
		ugyfel_help.add(label_11);
	}

}
