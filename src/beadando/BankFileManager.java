package beadando;

import java.io.*;

public class BankFileManager {
	@SuppressWarnings("deprecation")
	public static void CsvReader(File fnev, BankTM banktm) {
		String id="", nev="", cim="", tul_orsz="", s="";
		try {
			FileInputStream f = new FileInputStream(fnev);
			LineNumberReader in = new LineNumberReader(new InputStreamReader(f));
			s=in.readLine();//mezõnevek az elsõ sorból
			s=in.readLine();//adatsor
			while(s!=null) {
				String[] splitS = s.split(";");
				id=splitS[0];
				nev=splitS[1];
				cim=splitS[2];
				tul_orsz=splitS[3];
				
				banktm.addRow(new Object[] {new Boolean(false), DataChecker.StoI(id), nev, cim, tul_orsz});
		
				s=in.readLine();
			}
			in.close();
			DataChecker.showMD("Adatok beolvasva!", 1);
		}catch(IOException ioe) {
			DataChecker.showMD("CsvReader: "+ioe.getMessage(), 0);
		}
	}
	
	public static void CsvWriter(String fnev, BankTM banktm) {
		try {
			PrintStream out = new PrintStream(new FileOutputStream(fnev));
			out.println("ID;Név;Cím;Tulajdonosország");
			int rdb = banktm.getRowCount();
			int cdb = banktm.getColumnCount();
			for(int i=0; i<rdb; i++) {
				for(int j=1; j<cdb-1; j++) {
					out.print(""+banktm.getValueAt(i, j)+";");
				}
				out.println(""+banktm.getValueAt(i, cdb-1));
			}
			out.close();
			DataChecker.showMD("Adatok kiírva!", 1);
		}catch(IOException ioe) {
			DataChecker.showMD("CsvWriter: "+ioe.getMessage(), 0);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void TxtReader(File fnev, BankTM banktm) {
		String id="", nev="", cim="", tul_orsz="", s="";
		try {
			FileInputStream f = new FileInputStream(fnev);
			LineNumberReader in = new LineNumberReader(new InputStreamReader(f));
			s=in.readLine();//mezõnevek az elsõ sorból
			s=in.readLine();//adatsor
			while(s!=null) {
				String[] splitS = s.split(";");
				id=splitS[0];
				nev=splitS[1];
				cim=splitS[2];
				tul_orsz=splitS[3];
				
				banktm.addRow(new Object[] {new Boolean(false), DataChecker.StoI(id), nev, cim, tul_orsz});
		
				s=in.readLine();
			}
			in.close();
			DataChecker.showMD("Adatok beolvasva!", 1);
		}catch(IOException ioe) {
			DataChecker.showMD("TxtReader: "+ioe.getMessage(), 0);
		}
	}
	
	public static void TxtWriter(String fnev, BankTM banktm) {
		try {
			PrintStream out = new PrintStream(new FileOutputStream(fnev));
			out.println("ID;Név;Cím;Tulajdonosország");
			int rdb = banktm.getRowCount();
			int cdb = banktm.getColumnCount();
			for(int i=0; i<rdb; i++) {
				for(int j=1; j<cdb-1; j++) {
					out.print(""+banktm.getValueAt(i, j)+";");
				}
				out.println(""+banktm.getValueAt(i, cdb-1));
			}
			out.close();
			DataChecker.showMD("Adatok kiírva!", 1);
		}catch(IOException ioe) {
			DataChecker.showMD("TxtWriter: "+ioe.getMessage(), 0);
		}
	}
}

