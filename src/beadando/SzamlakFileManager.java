package beadando;
import java.io.*;

public class SzamlakFileManager {
	@SuppressWarnings("deprecation")
	public static void CsvReader(File fnev, SzamlakTM szamlaktm) {
		String szamla_szam="", egyenleg="", megnevezes="", tipus="", ugyfel_azon="", s="";
		try {
			FileInputStream f = new FileInputStream(fnev);
			LineNumberReader in = new LineNumberReader(new InputStreamReader(f));
			s=in.readLine();//mezõnevek az elsõ sorból
			s=in.readLine();//adatsor
			while(s!=null) {
				String[] splitS = s.split(";");
				szamla_szam=splitS[0];
				egyenleg=splitS[1];
				megnevezes=splitS[2];
				tipus=splitS[3];
				ugyfel_azon=splitS[4];
				
				szamlaktm.addRow(new Object[] {new Boolean(false), DataChecker.StoI(szamla_szam), DataChecker.StoI(egyenleg), megnevezes, tipus, DataChecker.StoI(ugyfel_azon)});
		
				s=in.readLine();
			}
			in.close();
			DataChecker.showMD("Adatok beolvasva!", 1);
		}catch(IOException ioe) {
			DataChecker.showMD("CsvReader: "+ioe.getMessage(), 0);
		}
	}
	
	public static void CsvWriter(String fnev, SzamlakTM szamlaktm) {
		try {
			PrintStream out = new PrintStream(new FileOutputStream(fnev));
			out.println("Számlaszám;Egyenleg;Megnevezés;Típus;Ügyfél azon.");
			int rdb = szamlaktm.getRowCount();
			int cdb = szamlaktm.getColumnCount();
			for(int i=0; i<rdb; i++) {
				for(int j=1; j<cdb-1; j++) {
					out.print(""+szamlaktm.getValueAt(i, j)+";");
				}
				out.println(""+szamlaktm.getValueAt(i, cdb-1));
			}
			out.close();
			DataChecker.showMD("Adatok kiírva!", 1);
		}catch(IOException ioe) {
			DataChecker.showMD("CsvWriter: "+ioe.getMessage(), 0);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void TxtReader(File fnev, SzamlakTM szamlaktm) {
		String szamla_szam="", egyenleg="", megnevezes="", tipus="", ugyfel_azon="", s="";
		try {
			FileInputStream f = new FileInputStream(fnev);
			LineNumberReader in = new LineNumberReader(new InputStreamReader(f));
			s=in.readLine();//mezõnevek az elsõ sorból
			s=in.readLine();//adatsor
			while(s!=null) {
				String[] splitS = s.split(";");
				szamla_szam=splitS[0];
				egyenleg=splitS[1];
				megnevezes=splitS[2];
				tipus=splitS[3];
				ugyfel_azon=splitS[4];
				
				szamlaktm.addRow(new Object[] {new Boolean(false), DataChecker.StoI(szamla_szam), DataChecker.StoI(egyenleg), megnevezes, tipus, DataChecker.StoI(ugyfel_azon)});
		
				s=in.readLine();
			}
			in.close();
			DataChecker.showMD("Adatok beolvasva!", 1);
		}catch(IOException ioe) {
			DataChecker.showMD("TxtReader: "+ioe.getMessage(), 0);
		}
	}
	
	public static void TxtWriter(String fnev, SzamlakTM szamlaktm) {
		try {
			PrintStream out = new PrintStream(new FileOutputStream(fnev));
			out.println("Számlaszám;Egyenleg;Megnevezés;Típus;Ügyfél azon.");
			int rdb = szamlaktm.getRowCount();
			int cdb = szamlaktm.getColumnCount();
			for(int i=0; i<rdb; i++) {
				for(int j=1; j<cdb-1; j++) {
					out.print(""+szamlaktm.getValueAt(i, j)+";");
				}
				out.println(""+szamlaktm.getValueAt(i, cdb-1));
			}
			out.close();
			DataChecker.showMD("Adatok kiírva!", 1);
		}catch(IOException ioe) {
			DataChecker.showMD("TxtWriter: "+ioe.getMessage(), 0);
		}
	}
}
