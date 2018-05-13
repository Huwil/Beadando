package beadando;

import java.io.*;

public class BankfiokFileManager {
	@SuppressWarnings("deprecation")
	public static void CsvReader(File fnev, BankfiokTM bankfioktm) {
		String fiok_azon="", cim="", alkalmazottak="", bank_azon="", s="";
		try {
			FileInputStream f = new FileInputStream(fnev);
			LineNumberReader in = new LineNumberReader(new InputStreamReader(f));
			s=in.readLine();//mezõnevek az elsõ sorból
			s=in.readLine();//adatsor
			while(s!=null) {
				String[] splitS = s.split(";");
				fiok_azon=splitS[0];
				cim=splitS[1];
				alkalmazottak=splitS[2];
				bank_azon=splitS[3];
				
				bankfioktm.addRow(new Object[] {new Boolean(false), DataChecker.StoI(fiok_azon), cim, DataChecker.StoI(alkalmazottak), DataChecker.StoI(bank_azon)});
		
				s=in.readLine();
			}
			in.close();
			DataChecker.showMD("Adatok beolvasva!", 1);
		}catch(IOException ioe) {
			DataChecker.showMD("CsvReader: "+ioe.getMessage(), 0);
		}
	}
	
	public static void CsvWriter(String fnev, BankfiokTM bankfioktm) {
		try {
			PrintStream out = new PrintStream(new FileOutputStream(fnev));
			out.println("Fiók azon.;Cím;Alkalmazottak;Bank azon.");
			int rdb = bankfioktm.getRowCount();
			int cdb = bankfioktm.getColumnCount();
			for(int i=0; i<rdb; i++) {
				for(int j=1; j<cdb-1; j++) {
					out.print(""+bankfioktm.getValueAt(i, j)+";");
				}
				out.println(""+bankfioktm.getValueAt(i, cdb-1));
			}
			out.close();
			DataChecker.showMD("Adatok kiírva!", 1);
		}catch(IOException ioe) {
			DataChecker.showMD("CsvWriter: "+ioe.getMessage(), 0);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void TxtReader(File fnev, BankfiokTM bankfioktm) {
		String fiok_azon="", cim="", alkalmazottak="", bank_azon="", s="";
		try {
			FileInputStream f = new FileInputStream(fnev);
			LineNumberReader in = new LineNumberReader(new InputStreamReader(f));
			s=in.readLine();//mezõnevek az elsõ sorból
			s=in.readLine();//adatsor
			while(s!=null) {
				String[] splitS = s.split(";");
				fiok_azon=splitS[0];
				cim=splitS[1];
				alkalmazottak=splitS[2];
				bank_azon=splitS[3];
				
				bankfioktm.addRow(new Object[] {new Boolean(false), DataChecker.StoI(fiok_azon), cim, DataChecker.StoI(alkalmazottak), DataChecker.StoI(bank_azon)});
		
				s=in.readLine();
			}
			in.close();
			DataChecker.showMD("Adatok beolvasva!", 1);
		}catch(IOException ioe) {
			DataChecker.showMD("TxtReader: "+ioe.getMessage(), 0);
		}
	}
	
	public static void TxtWriter(String fnev, BankfiokTM bankfioktm) {
		try {
			PrintStream out = new PrintStream(new FileOutputStream(fnev));
			out.println("Fiók azon.;Cím;Alkalmazottak;Bank azon.");
			int rdb = bankfioktm.getRowCount();
			int cdb = bankfioktm.getColumnCount();
			for(int i=0; i<rdb; i++) {
				for(int j=1; j<cdb-1; j++) {
					out.print(""+bankfioktm.getValueAt(i, j)+";");
				}
				out.println(""+bankfioktm.getValueAt(i, cdb-1));
			}
			out.close();
			DataChecker.showMD("Adatok kiírva!", 1);
		}catch(IOException ioe) {
			DataChecker.showMD("TxtWriter: "+ioe.getMessage(), 0);
		}
	}
}