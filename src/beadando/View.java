package beadando;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class View extends JFrame {

	private JPanel contentPane, fooldal_tab, bank_tab, bankfiok_tab, ugyfel_tab, szamlak_tab;
	
	private BankTM banktm;
	private BankfiokTM bankfioktm;
	private UgyfelTM ugyfeltm;
	private SzamlakTM szamlaktm;
	
	private Font fnt = new Font("Arial", Font.BOLD, 10);
	private File fbe;
	
	private String[] elem = {"Válasszon!", "Helyi .txt fájl", "Helyi .csv fájl"};
	private String[] elem2 = {"Válasszon!", "<<Forrás>>", "Helyi .txt fájl", "Helyi .csv fájl"};
	private String bank_forras = "Válasszon!", bankfiok_forras = "Válasszon!", ugyfel_forras = "Válasszon!", szamlak_forras = "Válasszon!";
	private String bank_cel = "Válasszon!", bankfiok_cel = "Válasszon!", ugyfel_cel = "Válasszon!", szamlak_cel = "Válasszon!";
	private String choosefiletype="Elõször válassza ki a beolvasni kívánt fájl típusát!", choosesavetype="Elõször válassza ki a menteni kívánt fájl típusát!", nosavedata="Nincs kiírható adat!", nosavename="Nincs megadva a menteni kívánt fájl neve!", nosource="Nincs megadva a Forrás!";
	@SuppressWarnings("unused")
	private String bankkerkif = "bankid", bankfiokkerkif = "fiokid", ugyfelkerkif = "szemszam", szamlakkerkif = "szamlaszam";
	
	@SuppressWarnings("rawtypes")
	private JComboBox bank_combobox, bankfiok_combobox, ugyfel_combobox, szamlak_combobox;
	@SuppressWarnings("rawtypes")
	private JComboBox bank_savecombobox, bankfiok_savecombobox, ugyfel_savecombobox, szamlak_savecombobox;
	
	private JTextField bankdb, bankfiokdb, ugyfeldb, szamlakdb;
	private JTextField bank_outfilename, bankfiok_outfilename, ugyfel_outfilename, szamlak_outfilename;
	private JTextField bank_infilename, bankfiok_infilename, ugyfel_infilename, szamlak_infilename;
	
	private JButton bank_filebutton, bank_listbutton, bank_newbutton, bank_modifybutton, bank_deletebutton, bank_helpbutton, bank_savebutton;
	private JButton bankfiok_filebutton, bankfiok_listbutton, bankfiok_newbutton, bankfiok_modifybutton, bankfiok_deletebutton, bankfiok_helpbutton, bankfiok_savebutton;
	private JButton ugyfel_filebutton, ugyfel_listbutton, ugyfel_newbutton, ugyfel_modifybutton, ugyfel_deletebutton, ugyfel_helpbutton, ugyfel_savebutton;
	private JButton szamlak_filebutton, szamlak_listbutton, szamlak_newbutton, szamlak_modifybutton, szamlak_deletebutton,szamlak_helpbutton, szamlak_savebutton;
	
	private JLabel bank_label1, bankfiok_label1, ugyfel_label1, szamlak_label1, copyright;
	private JLabel fooldal1_lbl, fooldal2_lbl, fooldal3_lbl, fooldal4_lbl, fooldal5_lbl, fooldal6_lbl;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public View() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		setTitle("Banki program");
		setSize(460, 400);
		
		copyright = new JLabel();
		copyright.setBounds(130, 330, 200, 20);
		copyright.setText("Révai István - SYO9D9, 2018.");
		contentPane.add(copyright);
		
		JTabbedPane tabbedpane = new JTabbedPane();
		
		
		/**
		 * Create the Fooldal tab.
		 */
		fooldal_tab = new JPanel();
		fooldal_tab.setLayout(null);
		fooldal_tab.setBackground(Color.WHITE);

		fooldal1_lbl = new JLabel("Ez a feladat a Java programozás címû tárgyhoz készült egyéni feladat.");
		fooldal1_lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fooldal1_lbl.setBounds(10, 10, 420, 48);
		fooldal_tab.add(fooldal1_lbl);
		
		fooldal2_lbl = new JLabel("A feladat 4 tábla grafikus kezelését mutatja be különbözõ mûveletekkel (beolvasás,");
		fooldal2_lbl.setFont(new Font("Tahoma", Font.PLAIN, 10));
		fooldal2_lbl.setBounds(10, 100, 420, 30);
		fooldal_tab.add(fooldal2_lbl);
		
		fooldal3_lbl = new JLabel("listázás, módosítás, törlés, kiírás). A 4 tábla elemei egymástól függetlenül kezelhetõek.");
		fooldal3_lbl.setFont(new Font("Tahoma", Font.PLAIN, 10));
		fooldal3_lbl.setBounds(10, 130, 420, 30);
		fooldal_tab.add(fooldal3_lbl);
		
		fooldal4_lbl = new JLabel("A választott témám alapján egy bank-nyilvántartó programot készítettem, amely bankokról,");
		fooldal4_lbl.setFont(new Font("Tahoma", Font.PLAIN, 10));
		fooldal4_lbl.setBounds(10, 160, 420, 30);
		fooldal_tab.add(fooldal4_lbl);
		
		fooldal5_lbl = new JLabel("a hozzájuk tartozó bankfiókokról, ügyfelekrõl, valamint a hozzájuk tartozó bankszámlákról");
		fooldal5_lbl.setFont(new Font("Tahoma", Font.PLAIN, 10));
		fooldal5_lbl.setBounds(10, 190, 420, 30);
		fooldal_tab.add(fooldal5_lbl);
		
		fooldal6_lbl = new JLabel("készít egy grafikus kezelõ felületet.");
		fooldal6_lbl.setFont(new Font("Tahoma", Font.PLAIN, 10));
		fooldal6_lbl.setBounds(10, 220, 420, 30);
		fooldal_tab.add(fooldal6_lbl);
		
		/**
		 * Create the Bank tab.
		 */
		bank_tab = new JPanel();
		bank_tab.setLayout(null);
		bank_tab.setBackground(Color.WHITE);
		
		BufferedImage bankPicture = ImageIO.read(new File("C:\\Users\\Révai István\\Desktop\\Beadandó\\bank.png"));
		JLabel bankpicLabel = new JLabel(new ImageIcon(bankPicture));
		bankpicLabel.setBounds(0, 60, 285, 170);
		bankpicLabel.setVisible(true);
		bank_tab.add(bankpicLabel);
		
		//combobox
		bank_combobox = new JComboBox();
		bank_combobox.setToolTipText("A beolvasni kívánt fájl típusának kiválasztása.");
		bank_combobox.setBounds(0, 0, 100, 20);
		for (String s: elem) bank_combobox.addItem(s);
		bank_combobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bank_forras = (String)bank_combobox.getSelectedItem();
				bankdb.setText("");
			}
		});
		
		//file-selecting button
		bank_filebutton = new JButton("Betöltés");
		bank_filebutton.setToolTipText("A betölteni kívánt fájl tallózása.");
		bank_filebutton.setBounds(115, 0, 100, 20);
		bank_filebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bank_forras.equals("Válasszon!")) 
					DataChecker.showMD(choosefiletype, 0);
				if(bank_forras.equals("Helyi .csv fájl")) {
					FileDialog fd = new FileDialog(new JFrame(), " ", FileDialog.LOAD);
					
					fd.setFile("*.csv");
					fd.setVisible(true);
					if(fd.getFile() != null) {
						fbe = new File(fd.getDirectory(), fd.getFile());
						String befnev = fd.getFile();
						bank_infilename.setText(befnev);
						BankFileManager.CsvReader(fbe, banktm);
					}
				}
				if(bank_forras.equals("Helyi .txt fájl")) {
					FileDialog fd = new FileDialog(new JFrame(), " ", FileDialog.LOAD);
					
					fd.setFile("*.txt");
					fd.setVisible(true);
					if(fd.getFile() != null) {
						fbe = new File(fd.getDirectory(), fd.getFile());
						String befnev = fd.getFile();
						bank_infilename.setText(befnev);
						BankFileManager.TxtReader(fbe, banktm);
					}
				}
				bankdb.setText(""+banktm.getRowCount());
			}
		});
		
		//label
		bank_label1 = new JLabel("Az adatok száma:");
		bank_label1.setBounds(320, 0, 100, 20);
		
		//the number of data
		bankdb = new JTextField();
		bankdb.setHorizontalAlignment(SwingConstants.RIGHT);
		bankdb.setText("0");
		bankdb.setBounds(300, 20, 130, 20);
		bankdb.setColumns(10);
		
		//list button
		bank_listbutton = new JButton("Bank lista");
		bank_listbutton.setToolTipText("A megadott fájl adatainak kilistázása.");
		bank_listbutton.setBounds(300, 60, 130, 20);
		bank_listbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankList banklist = new BankList(View.this, banktm);
				banklist.setVisible(true);
			}
		});
		
		//bank_newdatabutton
		bank_newbutton = new JButton("Új adat");
		bank_newbutton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				int kodv=0;
				if(banktm.getRowCount()==0)
					kodv=0;
				else
					kodv=(int)banktm.getValueAt(banktm.getRowCount()-1, 1);
				BankNew bn = new BankNew(View.this, kodv);
				bn.setVisible(true);
				int kilep = bn.Kilep();
				if(kilep==1) {
					Bank newBank = bn.getBank();
					banktm.addRow(new Object[] {new Boolean(false), newBank.getId(), newBank.getNev(), newBank.getCim(), newBank.getTul_orsz()});
					bankdb.setText(""+banktm.getRowCount());
				}
			}
		});
		bank_newbutton.setToolTipText("Új adat felvitele.");
		bank_newbutton.setBounds(300, 100, 130, 20);
		
		//bank_modifydatabutton
		bank_modifybutton = new JButton("Adat módosítása");
		bank_modifybutton.setToolTipText("Meglévõ adat módosítása");
		bank_modifybutton.setBounds(300, 140, 130, 20);
		bank_modifybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (banktm.getRowCount()==0) 
					DataChecker.showMD("Nincs módosítható adat!", 0);
				else {
					BankMod mod = new BankMod(View.this, banktm);
					mod.setVisible(true);
				}
			}
		});
		
		//bank_deletebutton
		bank_deletebutton = new JButton("Adat törlése");
		bank_deletebutton.setToolTipText("A megadott adat törlése.");
		bank_deletebutton.setBounds(300, 180, 130, 20);
		bank_deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (banktm.getRowCount()==0) 
					DataChecker.showMD("Nincs törölhetõ adat!", 0);
				else {
					BankDel del = new BankDel(View.this, banktm);
					del.setVisible(true);
					bankdb.setText(""+banktm.getRowCount());
				}
			}
		});
		
		//bank_savebutton
		bank_savebutton = new JButton("Mentés");
		bank_savebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bank_cel.equals("Válasszon!"))
					DataChecker.showMD(choosesavetype, 1);
				else if(banktm.getRowCount()==0)
					DataChecker.showMD(nosavedata, 0);
				else if(bank_cel.equals("Helyi .csv fájl")) {
					if(bank_outfilename.getText().length()==0)
						DataChecker.showMD(nosavename, 0);
					else {
						BankFileManager.CsvWriter(bank_outfilename.getText().toString(), banktm);
					}
				} else if(bank_cel.equals("Helyi .txt fájl")) {
					if(bank_outfilename.getText().length()==0)
						DataChecker.showMD(nosavename, 0);
					else {
						BankFileManager.TxtWriter(bank_outfilename.getText().toString(), banktm);
					}
				}
				else if (bank_cel.equals("<<Forrás>>") && bank_forras.equals("Helyi .csv fájl")) {
					String kiirfnev = bank_infilename.getText();
					bank_outfilename.setText(kiirfnev);
					BankFileManager.CsvWriter(kiirfnev, banktm);
				}
				else if (bank_cel.equals("<<Forrás>>") && bank_forras.equals("Helyi .txt fájl")) {
					String kiirfnev = bank_infilename.getText();
					bank_outfilename.setText(kiirfnev);
					BankFileManager.TxtWriter(kiirfnev, banktm);
				}
			}
		});
		bank_savebutton.setToolTipText("Adatok mentése a kiválasztott fájlba.");
		bank_savebutton.setBounds(300, 250, 130, 20);
		
		//bank_savecombobox
		bank_savecombobox = new JComboBox();
		bank_savecombobox.setToolTipText("A menteni kívánt fájl típusának kiválasztása.");
		bank_savecombobox.setBounds(0, 250, 100, 20);
		for (String s: elem2) bank_savecombobox.addItem(s);
		bank_savecombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bank_cel = (String)bank_savecombobox.getSelectedItem();
				if (bank_cel.equals("<<Forrás>>") && bank_infilename.getText().equals(""))
					DataChecker.showMD(nosource, 0);
				if (bank_cel.equals("<<Forrás>>") && !bank_infilename.getText().equals(""))
					bank_outfilename.setText(bank_infilename.getText());
			}
		});
		
		//bank_outfilename
		bank_outfilename = new JTextField();
		bank_outfilename.setText("fájlnév.kiterjesztés");
		bank_outfilename.setBounds(115, 250, 170, 20);

		//bank_helpbutton
		bank_helpbutton = new JButton("?");
		bank_helpbutton.setFont(fnt);
		bank_helpbutton.setToolTipText("Súgó");
		bank_helpbutton.setBounds(390, 290, 40, 40);
		bank_helpbutton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				BankHelp help = new BankHelp();
				help.show();
			}
		});
		
		//bank_infilename
		bank_infilename = new JTextField();
		bank_infilename.setBounds(0, 20, 100, 20);
		bank_infilename.setEditable(false);
		bank_infilename.setColumns(10);
		
		//add elements to the tab
		bank_tab.add(bank_listbutton);
		bank_tab.add(bank_helpbutton);
		bank_tab.add(bank_newbutton);
		bank_tab.add(bank_modifybutton);
		bank_tab.add(bank_deletebutton);
		bank_tab.add(bank_filebutton);
		bank_tab.add(bank_combobox);
		bank_tab.add(bank_label1);
		bank_tab.add(bankdb);
		bank_tab.add(bank_savebutton);
		bank_tab.add(bank_savecombobox);
		bank_tab.add(bank_outfilename);
		bank_tab.add(bank_infilename);
		
		
		
		/**
		 * Create the Bankfiok tab.
		 */
		bankfiok_tab = new JPanel();
		bankfiok_tab.setLayout(null);
		bankfiok_tab.setBackground(Color.WHITE);
		
		BufferedImage bankfiokPicture = ImageIO.read(new File("C:\\Users\\Révai István\\Desktop\\Beadandó\\bankfiok.jpg"));
		JLabel bankfiokpicLabel = new JLabel(new ImageIcon(bankfiokPicture));
		bankfiokpicLabel.setBounds(0, 60, 285, 170);
		bankfiokpicLabel.setVisible(true);
		bankfiok_tab.add(bankfiokpicLabel);
		
		//combobox
		bankfiok_combobox = new JComboBox();
		bankfiok_combobox.setToolTipText("A beolvasni kívánt fájl típusának kiválasztása.");
		bankfiok_combobox.setBounds(0, 0, 100, 20);
		for (String s: elem) bankfiok_combobox.addItem(s);
		bankfiok_combobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bankfiok_forras = (String)bankfiok_combobox.getSelectedItem();
				bankfiokdb.setText("");
			}
		});
		
		//file-selecting button
		bankfiok_filebutton = new JButton("Betöltés");
		bankfiok_filebutton.setToolTipText("A betölteni kívánt fájl tallózása.");
		bankfiok_filebutton.setBounds(115, 0, 100, 20);
		bankfiok_filebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bankfiok_forras.equals("Válasszon!")) 
					DataChecker.showMD(choosefiletype, 0);
				if(bankfiok_forras.equals("Helyi .csv fájl")) {
					FileDialog fd = new FileDialog(new JFrame(), " ", FileDialog.LOAD);
					
					fd.setFile("*.csv");
					fd.setVisible(true);
					if(fd.getFile() != null) {
						fbe = new File(fd.getDirectory(), fd.getFile());
						BankfiokFileManager.CsvReader(fbe, bankfioktm);
						String befnev = fd.getFile();
						bankfiok_infilename.setText(befnev);
					}
				}
				if(bankfiok_forras.equals("Helyi .txt fájl")) {
					FileDialog fd = new FileDialog(new JFrame(), " ", FileDialog.LOAD);
					
					fd.setFile("*.txt");
					fd.setVisible(true);
					if(fd.getFile() != null) {
						fbe = new File(fd.getDirectory(), fd.getFile());
						BankfiokFileManager.TxtReader(fbe, bankfioktm);
						String befnev = fd.getFile();
						bankfiok_infilename.setText(befnev);
					}
				}
				bankfiokdb.setText(""+bankfioktm.getRowCount());
			}
		});
		
		//label
		bankfiok_label1 = new JLabel("Az adatok száma:");
		bankfiok_label1.setBounds(320, 0, 100, 20);
		
		//the number of data
		bankfiokdb = new JTextField();
		bankfiokdb.setHorizontalAlignment(SwingConstants.RIGHT);
		bankfiokdb.setText("0");
		bankfiokdb.setBounds(300, 20, 130, 20);
		bankfiokdb.setColumns(10);
		
		//list button
		bankfiok_listbutton = new JButton("Bankfiók lista");
		bankfiok_listbutton.setToolTipText("A megadott fájl adatainak kilistázása.");
		bankfiok_listbutton.setBounds(300, 60, 130, 20);
		bankfiok_listbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankfiokList bankfioklist = new BankfiokList(View.this, bankfioktm);
				bankfioklist.setVisible(true);
			}
		});
		
		//bankfiok_newdatabutton
		bankfiok_newbutton = new JButton("Új adat");
		bankfiok_newbutton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				int kodv=0;
				if(bankfioktm.getRowCount()==0)
					kodv=0;
				else
					kodv=(int)bankfioktm.getValueAt(bankfioktm.getRowCount()-1, 1);
				BankfiokNew bn = new BankfiokNew(View.this, kodv);
				bn.setVisible(true);
				int kilep = bn.Kilep();
				if(kilep==1) {
					Bankfiok newBankfiok = bn.getBankfiok();
					bankfioktm.addRow(new Object[] {new Boolean(false), newBankfiok.getFiok_azon(), newBankfiok.getCim(), newBankfiok.getAlkalmazottak(), newBankfiok.getBank_azon()});
					bankfiokdb.setText(""+bankfioktm.getRowCount());
				}
			}
		});
		bankfiok_newbutton.setToolTipText("Új adat felvitele.");
		bankfiok_newbutton.setBounds(300, 100, 130, 20);
		
		
		//bankfiok_modifydatabutton
		bankfiok_modifybutton = new JButton("Adat módosítása");
		bankfiok_modifybutton.setToolTipText("Meglévõ adat módosítása");
		bankfiok_modifybutton.setBounds(300, 140, 130, 20);
		bankfiok_modifybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bankfioktm.getRowCount()==0) 
					DataChecker.showMD("Nincs módosítható adat!", 0);
				else {
					BankfiokMod mod = new BankfiokMod(View.this, bankfioktm);
					mod.setVisible(true);
				}
			}
		});
		
		
		//bankfiok_deletebutton
		bankfiok_deletebutton = new JButton("Adat törlése");
		bankfiok_deletebutton.setToolTipText("A megadott adat törlése.");
		bankfiok_deletebutton.setBounds(300, 180, 130, 20);
		bankfiok_deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bankfioktm.getRowCount()==0) 
					DataChecker.showMD("Nincs törölhetõ adat!", 0);
				else {
					BankfiokDel del = new BankfiokDel(View.this, bankfioktm);
					del.setVisible(true);
					bankfiokdb.setText(""+bankfioktm.getRowCount());
				}
			}
		});
		
		
		//bankfiok_helpbutton
		bankfiok_helpbutton = new JButton("?");
		bankfiok_helpbutton.setFont(fnt);
		bankfiok_helpbutton.setToolTipText("Súgó");
		bankfiok_helpbutton.setBounds(390, 290, 40, 40);
		bankfiok_helpbutton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				BankfiokHelp help = new BankfiokHelp();
				help.show();
			}
		});
		
		//bankfiok_savebutton
		bankfiok_savebutton = new JButton("Mentés");
		bankfiok_savebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bankfiok_cel.equals("Válasszon!"))
					DataChecker.showMD(choosesavetype, 1);
				else if(bankfioktm.getRowCount()==0)
					DataChecker.showMD(nosavedata, 0);
				else if(bankfiok_cel.equals("Helyi .csv fájl")) {
					if(bankfiok_outfilename.getText().length()==0)
						DataChecker.showMD(nosavename, 0);
					else {
						BankfiokFileManager.CsvWriter(bankfiok_outfilename.getText().toString(), bankfioktm);
					}
				} else if(bankfiok_cel.equals("Helyi .txt fájl")) {
					if(bankfiok_outfilename.getText().length()==0)
						DataChecker.showMD(nosavename, 0);
					else {
						BankfiokFileManager.TxtWriter(bankfiok_outfilename.getText().toString(), bankfioktm);
					}
				}
				else if (bankfiok_cel.equals("<<Forrás>>") && bankfiok_forras.equals("Helyi .csv fájl")) {
					String kiirfnev = bankfiok_infilename.getText();
					bankfiok_outfilename.setText(kiirfnev);
					BankfiokFileManager.CsvWriter(kiirfnev, bankfioktm);
				}
				else if (bankfiok_cel.equals("<<Forrás>>") && bankfiok_forras.equals("Helyi .txt fájl")) {
					String kiirfnev = bankfiok_infilename.getText();
					bankfiok_outfilename.setText(kiirfnev);
					BankfiokFileManager.TxtWriter(kiirfnev, bankfioktm);
				}
			}
		});
		bankfiok_savebutton.setToolTipText("Adatok mentése a kiválasztott fájlba.");
		bankfiok_savebutton.setBounds(300, 250, 130, 20);
				
		//bankfiok_savecombobox
		bankfiok_savecombobox = new JComboBox();
		bankfiok_savecombobox.setToolTipText("A menteni kívánt fájl típusának kiválasztása.");
		bankfiok_savecombobox.setBounds(0, 250, 100, 20);
		for (String s: elem2) bankfiok_savecombobox.addItem(s);
		bankfiok_savecombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bankfiok_cel = (String)bankfiok_savecombobox.getSelectedItem();
				if (bankfiok_cel.equals("<<Forrás>>") && bankfiok_infilename.getText().equals(""))
					DataChecker.showMD(nosource, 0);
				if (bankfiok_cel.equals("<<Forrás>>") && !bankfiok_infilename.getText().equals(""))
					bankfiok_outfilename.setText(bankfiok_infilename.getText());
			}
		});
				
		//bankfiok_outfilename
		bankfiok_outfilename = new JTextField();
		bankfiok_outfilename.setText("fájlnév.kiterjesztés");
		bankfiok_outfilename.setBounds(115, 250, 170, 20);
		
		//bankfiok_infilename
		bankfiok_infilename = new JTextField();
		bankfiok_infilename.setBounds(0, 20, 100, 20);
		bankfiok_infilename.setEditable(false);
		bankfiok_infilename.setColumns(10);
		
		//add elements to the tab
		bankfiok_tab.add(bankfiok_listbutton);
		bankfiok_tab.add(bankfiok_helpbutton);
		bankfiok_tab.add(bankfiok_newbutton);
		bankfiok_tab.add(bankfiok_modifybutton);
		bankfiok_tab.add(bankfiok_deletebutton);
		bankfiok_tab.add(bankfiok_filebutton);
		bankfiok_tab.add(bankfiok_combobox);
		bankfiok_tab.add(bankfiok_label1);
		bankfiok_tab.add(bankfiokdb);
		bankfiok_tab.add(bankfiok_savebutton);
		bankfiok_tab.add(bankfiok_savecombobox);
		bankfiok_tab.add(bankfiok_outfilename);
		bankfiok_tab.add(bankfiok_infilename);
		
		
		
		
		/**
		 * Create the Ugyfel tab.
		 */
		ugyfel_tab = new JPanel();
		ugyfel_tab.setLayout(null);
		ugyfel_tab.setBackground(Color.WHITE);
		
		BufferedImage ugyfelPicture = ImageIO.read(new File("C:\\Users\\Révai István\\Desktop\\Beadandó\\ugyfel.png"));
		JLabel ugyfelpicLabel = new JLabel(new ImageIcon(ugyfelPicture));
		ugyfelpicLabel.setBounds(0, 60, 285, 170);
		ugyfelpicLabel.setVisible(true);
		ugyfel_tab.add(ugyfelpicLabel);
		
		//combobox
		ugyfel_combobox = new JComboBox();
		ugyfel_combobox.setToolTipText("A beolvasni kívánt fájl típusának kiválasztása.");
		ugyfel_combobox.setBounds(0, 0, 100, 20);
		for (String s: elem) ugyfel_combobox.addItem(s);
		ugyfel_combobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ugyfel_forras = (String)ugyfel_combobox.getSelectedItem();
				ugyfeldb.setText("");
			}
		});
		
		//file-selecting button
		ugyfel_filebutton = new JButton("Betöltés");
		ugyfel_filebutton.setToolTipText("A betölteni kívánt fájl tallózása.");
		ugyfel_filebutton.setBounds(115, 0, 100, 20);
		ugyfel_filebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ugyfel_forras.equals("Válasszon!")) 
					DataChecker.showMD(choosefiletype, 0);
				if(ugyfel_forras.equals("Helyi .csv fájl")) {
					FileDialog fd = new FileDialog(new JFrame(), " ", FileDialog.LOAD);
					
					fd.setFile("*.csv");
					fd.setVisible(true);
					if(fd.getFile() != null) {
						fbe = new File(fd.getDirectory(), fd.getFile());
						UgyfelFileManager.CsvReader(fbe, ugyfeltm);
						String befnev = fd.getFile();
						ugyfel_infilename.setText(befnev);
					}
				}
				if(ugyfel_forras.equals("Helyi .txt fájl")) {
					FileDialog fd = new FileDialog(new JFrame(), " ", FileDialog.LOAD);
					
					fd.setFile("*.txt");
					fd.setVisible(true);
					if(fd.getFile() != null) {
						fbe = new File(fd.getDirectory(), fd.getFile());
						UgyfelFileManager.TxtReader(fbe, ugyfeltm);
						String befnev = fd.getFile();
						ugyfel_infilename.setText(befnev);
					}
				}
				ugyfeldb.setText(""+ugyfeltm.getRowCount());
			}
		});
		
		//label
		ugyfel_label1 = new JLabel("Az adatok száma:");
		ugyfel_label1.setBounds(320, 0, 100, 20);
		
		//the number of data
		ugyfeldb = new JTextField();
		ugyfeldb.setHorizontalAlignment(SwingConstants.RIGHT);
		ugyfeldb.setText("0");
		ugyfeldb.setBounds(300, 20, 130, 20);
		ugyfeldb.setColumns(10);
		
		//list button
		ugyfel_listbutton = new JButton("Ügyfél lista");
		ugyfel_listbutton.setToolTipText("A megadott fájl adatainak kilistázása.");
		ugyfel_listbutton.setBounds(300, 60, 130, 20);
		ugyfel_listbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UgyfelList ugyfellist = new UgyfelList(View.this, ugyfeltm);
				ugyfellist.setVisible(true);
			}
		});
		
		//bankfiok_newdatabutton
		ugyfel_newbutton = new JButton("Új adat");
		ugyfel_newbutton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				int kodv=0;
				if(ugyfeltm.getRowCount()==0)
					kodv=0;
				else
					kodv=(int)ugyfeltm.getValueAt(ugyfeltm.getRowCount()-1, 1);
				UgyfelNew bn = new UgyfelNew(View.this, kodv);
				bn.setVisible(true);
				int kilep = bn.Kilep();
				if(kilep==1) {
					Ugyfel newUgyfel = bn.getUgyfel();
					ugyfeltm.addRow(new Object[] {new Boolean(false), newUgyfel.getSzem_szam(), newUgyfel.getNev(), newUgyfel.getCim(), newUgyfel.getTel_szam(), newUgyfel.getSzul_ido(), newUgyfel.getFiok_azon()});
					ugyfeldb.setText(""+ugyfeltm.getRowCount());
				}
			}
		});
		ugyfel_newbutton.setToolTipText("Új adat felvitele.");
		ugyfel_newbutton.setBounds(300, 100, 130, 20);
		
		
		//bankfiok_modifydatabutton
		ugyfel_modifybutton = new JButton("Adat módosítása");
		ugyfel_modifybutton.setToolTipText("Meglévõ adat módosítása");
		ugyfel_modifybutton.setBounds(300, 140, 130, 20);
		ugyfel_modifybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ugyfeltm.getRowCount()==0) 
					DataChecker.showMD("Nincs módosítható adat!", 0);
				else {
					UgyfelMod mod = new UgyfelMod(View.this, ugyfeltm);
					mod.setVisible(true);
				}
			}
		});
		
		
		//bankfiok_deletebutton
		ugyfel_deletebutton = new JButton("Adat törlése");
		ugyfel_deletebutton.setToolTipText("A megadott adat törlése.");
		ugyfel_deletebutton.setBounds(300, 180, 130, 20);
		ugyfel_deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ugyfeltm.getRowCount()==0) 
					DataChecker.showMD("Nincs törölhetõ adat!", 0);
				else {
					UgyfelDel del = new UgyfelDel(View.this, ugyfeltm);
					del.setVisible(true);
					ugyfeldb.setText(""+ugyfeltm.getRowCount());
				}
			}
		});
		
		
		//ugyfel_helpbutton
		ugyfel_helpbutton = new JButton("?");
		ugyfel_helpbutton.setFont(fnt);
		ugyfel_helpbutton.setToolTipText("Súgó");
		ugyfel_helpbutton.setBounds(390, 290, 40, 40);
		ugyfel_helpbutton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				UgyfelHelp help = new UgyfelHelp();
				help.show();
			}
		});
		
		//ugyfel_savebutton
		ugyfel_savebutton = new JButton("Mentés");
		ugyfel_savebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ugyfel_cel.equals("Válasszon!"))
					DataChecker.showMD(choosesavetype, 1);
				else if(ugyfeltm.getRowCount()==0)
					DataChecker.showMD(nosavedata, 0);
				else if(ugyfel_cel.equals("Helyi .csv fájl")) {
					if(ugyfel_outfilename.getText().length()==0)
						DataChecker.showMD(nosavename, 0);
					else {
						UgyfelFileManager.CsvWriter(ugyfel_outfilename.getText().toString(), ugyfeltm);
					}
				} else if(ugyfel_cel.equals("Helyi .txt fájl")) {
					if(ugyfel_outfilename.getText().length()==0)
						DataChecker.showMD(nosavename, 0);
					else {
						UgyfelFileManager.TxtWriter(ugyfel_outfilename.getText().toString(), ugyfeltm);
					}
				}
				else if (ugyfel_cel.equals("<<Forrás>>") && ugyfel_forras.equals("Helyi .csv fájl")) {
					String kiirfnev = ugyfel_infilename.getText();
					ugyfel_outfilename.setText(kiirfnev);
					UgyfelFileManager.CsvWriter(kiirfnev, ugyfeltm);
				}
				else if (ugyfel_cel.equals("<<Forrás>>") && ugyfel_forras.equals("Helyi .txt fájl")) {
					String kiirfnev = ugyfel_infilename.getText();
					ugyfel_outfilename.setText(kiirfnev);
					UgyfelFileManager.TxtWriter(kiirfnev, ugyfeltm);
				}
			}
		});
		ugyfel_savebutton.setToolTipText("Adatok mentése a kiválasztott fájlba.");
		ugyfel_savebutton.setBounds(300, 250, 130, 20);
						
		//ugyfel_savecombobox
		ugyfel_savecombobox = new JComboBox();
		ugyfel_savecombobox.setToolTipText("A menteni kívánt fájl típusának kiválasztása.");
		ugyfel_savecombobox.setBounds(0, 250, 100, 20);
		for (String s: elem2) ugyfel_savecombobox.addItem(s);
		ugyfel_savecombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ugyfel_cel = (String)ugyfel_savecombobox.getSelectedItem();
				if (ugyfel_cel.equals("<<Forrás>>") && ugyfel_infilename.getText().equals(""))
					DataChecker.showMD(nosource, 0);
				if (ugyfel_cel.equals("<<Forrás>>") && !ugyfel_infilename.getText().equals(""))
					ugyfel_outfilename.setText(ugyfel_infilename.getText());
			}
		});
						
		//ugyfel_outfilename
		ugyfel_outfilename = new JTextField();
		ugyfel_outfilename.setText("fájlnév.kiterjesztés");
		ugyfel_outfilename.setBounds(115, 250, 170, 20);
		
		//ugyfel_infilename
		ugyfel_infilename = new JTextField();
		ugyfel_infilename.setBounds(0, 20, 100, 20);
		ugyfel_infilename.setEditable(false);
		ugyfel_infilename.setColumns(10);
		
		//add elements to the tab
		ugyfel_tab.add(ugyfel_listbutton);
		ugyfel_tab.add(ugyfel_helpbutton);
		ugyfel_tab.add(ugyfel_newbutton);
		ugyfel_tab.add(ugyfel_modifybutton);
		ugyfel_tab.add(ugyfel_deletebutton);
		ugyfel_tab.add(ugyfel_filebutton);
		ugyfel_tab.add(ugyfel_combobox);
		ugyfel_tab.add(ugyfel_label1);
		ugyfel_tab.add(ugyfeldb);
		ugyfel_tab.add(ugyfel_savebutton);
		ugyfel_tab.add(ugyfel_savecombobox);
		ugyfel_tab.add(ugyfel_outfilename);
		ugyfel_tab.add(ugyfel_infilename);
		
		
		
		
		/**
		 * Create the Szamlak tab.
		 */
		szamlak_tab = new JPanel();
		szamlak_tab.setLayout(null);
		szamlak_tab.setBackground(Color.WHITE);
		
		BufferedImage szamlakPicture = ImageIO.read(new File("C:\\Users\\Révai István\\Desktop\\Beadandó\\szamlak.jpg"));
		JLabel szamlakpicLabel = new JLabel(new ImageIcon(szamlakPicture));
		szamlakpicLabel.setBounds(0, 60, 285, 170);
		szamlakpicLabel.setVisible(true);
		szamlak_tab.add(szamlakpicLabel);
		
		//combobox
		szamlak_combobox = new JComboBox();
		szamlak_combobox.setToolTipText("A beolvasni kívánt fájl típusának kiválasztása.");
		szamlak_combobox.setBounds(0, 0, 100, 20);
		for (String s: elem) szamlak_combobox.addItem(s);
		szamlak_combobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				szamlak_forras = (String)szamlak_combobox.getSelectedItem();
				szamlakdb.setText("");
			}
		});
		
		//file-selecting button
		szamlak_filebutton = new JButton("Betöltés");
		szamlak_filebutton.setToolTipText("A betölteni kívánt fájl tallózása.");
		szamlak_filebutton.setBounds(115, 0, 100, 20);
		szamlak_filebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(szamlak_forras.equals("Válasszon!")) 
					DataChecker.showMD(choosefiletype, 0);
				if(szamlak_forras.equals("Helyi .csv fájl")) {
					FileDialog fd = new FileDialog(new JFrame(), " ", FileDialog.LOAD);
					
					fd.setFile("*.csv");
					fd.setVisible(true);
					if(fd.getFile() != null) {
						fbe = new File(fd.getDirectory(), fd.getFile());
						SzamlakFileManager.CsvReader(fbe, szamlaktm);
						String befnev = fd.getFile();
						szamlak_infilename.setText(befnev);
					}
				}
				if(szamlak_forras.equals("Helyi .txt fájl")) {
					FileDialog fd = new FileDialog(new JFrame(), " ", FileDialog.LOAD);
					
					fd.setFile("*.txt");
					fd.setVisible(true);
					if(fd.getFile() != null) {
						fbe = new File(fd.getDirectory(), fd.getFile());
						SzamlakFileManager.TxtReader(fbe, szamlaktm);
						String befnev = fd.getFile();
						szamlak_infilename.setText(befnev);
					}
				}
				szamlakdb.setText(""+szamlaktm.getRowCount());
			}
		});
		
		//label
		szamlak_label1 = new JLabel("Az adatok száma:");
		szamlak_label1.setBounds(320, 0, 100, 20);
		
		//the number of data
		szamlakdb = new JTextField();
		szamlakdb.setHorizontalAlignment(SwingConstants.RIGHT);
		szamlakdb.setText("0");
		szamlakdb.setBounds(300, 20, 130, 20);
		szamlakdb.setColumns(10);
		
		//list button
		szamlak_listbutton = new JButton("Számlák lista");
		szamlak_listbutton.setToolTipText("A megadott fájl adatainak kilistázása.");
		szamlak_listbutton.setBounds(300, 60, 130, 20);
		szamlak_listbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SzamlakList szamlakList = new SzamlakList(View.this, szamlaktm);
				szamlakList.setVisible(true);
			}
		});
		
		//bankfiok_newdatabutton
		szamlak_newbutton = new JButton("Új adat");
		szamlak_newbutton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				int kodv=0;
				if(szamlaktm.getRowCount()==0)
					kodv=0;
				else
					kodv=(int)szamlaktm.getValueAt(szamlaktm.getRowCount()-1, 1);
				SzamlakNew bn = new SzamlakNew(View.this, kodv);
				bn.setVisible(true);
				int kilep = bn.Kilep();
				if(kilep==1) {
					Szamlak newSzamlak = bn.getSzamlak();
					szamlaktm.addRow(new Object[] {new Boolean(false), newSzamlak.getSzamla_szam(), newSzamlak.getEgyenleg(), newSzamlak.getMegnevezes(), newSzamlak.getTipus(), newSzamlak.getUgyfel_azon()});
					szamlakdb.setText(""+szamlaktm.getRowCount());
				}
			}
		});
		szamlak_newbutton.setToolTipText("Új adat felvitele.");
		szamlak_newbutton.setBounds(300, 100, 130, 20);
		
		
		//bankfiok_modifydatabutton
		szamlak_modifybutton = new JButton("Adat módosítása");
		szamlak_modifybutton.setToolTipText("Meglévõ adat módosítása");
		szamlak_modifybutton.setBounds(300, 140, 130, 20);
		szamlak_modifybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (szamlaktm.getRowCount()==0) 
					DataChecker.showMD("Nincs módosítható adat!", 0);
				else {
					SzamlakMod mod = new SzamlakMod(View.this, szamlaktm);
					mod.setVisible(true);
				}
			}
		});
		
		
		//bankfiok_deletebutton
		szamlak_deletebutton = new JButton("Adat törlése");
		szamlak_deletebutton.setToolTipText("A megadott adat törlése.");
		szamlak_deletebutton.setBounds(300, 180, 130, 20);
		szamlak_deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (szamlaktm.getRowCount()==0) 
					DataChecker.showMD("Nincs törölhetõ adat!", 0);
				else {
					SzamlakDel del = new SzamlakDel(View.this, szamlaktm);
					del.setVisible(true);
					szamlakdb.setText(""+szamlaktm.getRowCount());
				}
			}
		});
		
		
		//bankfiok_helpbutton
		szamlak_helpbutton = new JButton("?");
		szamlak_helpbutton.setFont(fnt);
		szamlak_helpbutton.setToolTipText("Súgó");
		szamlak_helpbutton.setBounds(390, 290, 40, 40);
		szamlak_helpbutton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				SzamlakHelp help = new SzamlakHelp();
				help.show();
			}
		});
		
		//szamlak_savebutton
		szamlak_savebutton = new JButton("Mentés");
		szamlak_savebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(szamlak_cel.equals("Válasszon!"))
					DataChecker.showMD(choosesavetype, 1);
				else if(szamlaktm.getRowCount()==0)
					DataChecker.showMD(nosavedata, 0);
				else if(szamlak_cel.equals("Helyi .csv fájl")) {
					if(szamlak_outfilename.getText().length()==0)
						DataChecker.showMD(nosavename, 0);
					else {
						SzamlakFileManager.CsvWriter(szamlak_outfilename.getText().toString(), szamlaktm);
					}
				} else if(szamlak_cel.equals("Helyi .txt fájl")) {
					if(szamlak_outfilename.getText().length()==0)
						DataChecker.showMD(nosavename, 0);
					else {
						SzamlakFileManager.TxtWriter(szamlak_outfilename.getText().toString(), szamlaktm);
					}
				}
				else if (szamlak_cel.equals("<<Forrás>>") && szamlak_forras.equals("Helyi .csv fájl")) {
					String kiirfnev = szamlak_infilename.getText();
					szamlak_outfilename.setText(kiirfnev);
					SzamlakFileManager.CsvWriter(kiirfnev, szamlaktm);
				}
				else if (szamlak_cel.equals("<<Forrás>>") && szamlak_forras.equals("Helyi .txt fájl")) {
					String kiirfnev = szamlak_infilename.getText();
					szamlak_outfilename.setText(kiirfnev);
					SzamlakFileManager.TxtWriter(kiirfnev, szamlaktm);
				}
			}
		});
		szamlak_savebutton.setToolTipText("Adatok mentése a kiválasztott fájlba.");
		szamlak_savebutton.setBounds(300, 250, 130, 20);
								
		//szamlak_savecombobox
		szamlak_savecombobox = new JComboBox();
		szamlak_savecombobox.setToolTipText("A menteni kívánt fájl típusának kiválasztása.");
		szamlak_savecombobox.setBounds(0, 250, 100, 20);
		for (String s: elem2) szamlak_savecombobox.addItem(s);
		szamlak_savecombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				szamlak_cel = (String)szamlak_savecombobox.getSelectedItem();
				if (szamlak_cel.equals("<<Forrás>>") && szamlak_infilename.getText().equals(""))
					DataChecker.showMD(nosource, 0);
				if (szamlak_cel.equals("<<Forrás>>") && !szamlak_infilename.getText().equals(""))
					szamlak_outfilename.setText(szamlak_infilename.getText());
			}
		});
								
		//szamlak_outfilename
		szamlak_outfilename = new JTextField();
		szamlak_outfilename.setText("fájlnév.kiterjesztés");
		szamlak_outfilename.setBounds(115, 250, 170, 20);
		
		//szamlak_infilename
		szamlak_infilename = new JTextField();
		szamlak_infilename.setBounds(0, 20, 100, 20);
		szamlak_infilename.setEditable(false);
		szamlak_infilename.setColumns(10);
		
		//add elements to the tab
		szamlak_tab.add(szamlak_listbutton);
		szamlak_tab.add(szamlak_helpbutton);
		szamlak_tab.add(szamlak_newbutton);
		szamlak_tab.add(szamlak_modifybutton);
		szamlak_tab.add(szamlak_deletebutton);
		szamlak_tab.add(szamlak_filebutton);
		szamlak_tab.add(szamlak_combobox);
		szamlak_tab.add(szamlak_label1);
		szamlak_tab.add(szamlakdb);
		szamlak_tab.add(szamlak_savebutton);
		szamlak_tab.add(szamlak_savecombobox);
		szamlak_tab.add(szamlak_outfilename);
		szamlak_tab.add(szamlak_infilename);
		
		
		
		/**
		 * Add the tabs to the tabbedpane.
		 */
		tabbedpane.addTab("Fõoldal", fooldal_tab);
		tabbedpane.addTab("Bank", bank_tab);
		tabbedpane.addTab("Bankfiók", bankfiok_tab);
		tabbedpane.addTab("Ügyfél", ugyfel_tab);
		tabbedpane.addTab("Számlák", szamlak_tab);
		getContentPane().add(tabbedpane);
		tabbedpane.setBounds(0, 0, 460, 400);
		
		Object banktmn[] = {"Jel", "ID", "Név", "Cím", "Tulajdonos ország"};
		banktm = new BankTM(banktmn, 0);
		Object bankfioktmn[] = {"Jel", "Fiók azon.", "Cím", "Alkalmazottak", "Bank azon."};
		bankfioktm = new BankfiokTM(bankfioktmn, 0);
		Object ugyfeltmn[] = {"Jel", "Személyi szám", "Név", "Cím", "Tel. szám", "Szül. idõ", "Fiók azon."};
		ugyfeltm = new UgyfelTM(ugyfeltmn, 0);
		Object szamlaktmn[] = {"Jel", "Számlaszám", "Egyenleg", "Megnevezés", "Típus", "Ügyfél azon."};
		szamlaktm = new SzamlakTM(szamlaktmn, 0);
	}
}
