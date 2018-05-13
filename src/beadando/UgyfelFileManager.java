package beadando;
import java.io.*;

public class UgyfelFileManager {
	@SuppressWarnings("deprecation")
	public static void CsvReader(File fnev, UgyfelTM ugyfeltm) {
		String szem_szam="", nev="", cim="", tel_szam="", szul_ido="", fiok_azon="",s="";
		try {
			FileInputStream f = new FileInputStream(fnev);
			LineNumberReader in = new LineNumberReader(new InputStreamReader(f));
			s=in.readLine();//mezõnevek az elsõ sorból
			s=in.readLine();//adatsor
			while(s!=null) {
				String[] splitS = s.split(";");
				szem_szam=splitS[0];
				nev=splitS[1];
				cim=splitS[2];
				tel_szam=splitS[3];
				szul_ido=splitS[4];
				fiok_azon=splitS[5];
				
				ugyfeltm.addRow(new Object[] {new Boolean(false), DataChecker.StoI(szem_szam), nev, cim, DataChecker.StoI(tel_szam), szul_ido, DataChecker.StoI(fiok_azon)});
		
				s=in.readLine();
			}
			in.close();
			DataChecker.showMD("Adatok beolvasva!", 1);
		}catch(IOException ioe) {
			DataChecker.showMD("CsvReader: "+ioe.getMessage(), 0);
		}
	}
	
	public static void CsvWriter(String fnev, UgyfelTM ugyfeltm) {
		try {
			PrintStream out = new PrintStream(new FileOutputStream(fnev));
			out.println("Személyi szám;Név;Cím;Tel. szám;Szül. idõ;Fiók azon.");
			int rdb = ugyfeltm.getRowCount();
			int cdb = ugyfeltm.getColumnCount();
			for(int i=0; i<rdb; i++) {
				for(int j=1; j<cdb-1; j++) {
					out.print(""+ugyfeltm.getValueAt(i, j)+";");
				}
				out.println(""+ugyfeltm.getValueAt(i, cdb-1));
			}
			out.close();
			DataChecker.showMD("Adatok kiírva!", 1);
		}catch(IOException ioe) {
			DataChecker.showMD("CsvWriter: "+ioe.getMessage(), 0);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void TxtReader(File fnev, UgyfelTM ugyfeltm) {
		String szem_szam="", nev="", cim="", tel_szam="", szul_ido="", fiok_azon="",s="";
		try {
			FileInputStream f = new FileInputStream(fnev);
			LineNumberReader in = new LineNumberReader(new InputStreamReader(f));
			s=in.readLine();//mezõnevek az elsõ sorból
			s=in.readLine();//adatsor
			while(s!=null) {
				String[] splitS = s.split(";");
				szem_szam=splitS[0];
				nev=splitS[1];
				cim=splitS[2];
				tel_szam=splitS[3];
				szul_ido=splitS[4];
				fiok_azon=splitS[5];
				
				ugyfeltm.addRow(new Object[] {new Boolean(false), DataChecker.StoI(szem_szam), nev, cim, DataChecker.StoI(tel_szam), szul_ido, DataChecker.StoI(fiok_azon)});
		
				s=in.readLine();
			}
			in.close();
			DataChecker.showMD("Adatok beolvasva!", 1);
		}catch(IOException ioe) {
			DataChecker.showMD("TxtReader: "+ioe.getMessage(), 0);
		}
	}
	
	public static void TxtWriter(String fnev, UgyfelTM ugyfeltm) {
		try {
			PrintStream out = new PrintStream(new FileOutputStream(fnev));
			out.println("Személyi szám;Név;Cím;Tel. szám;Szül. idõ;Fiók azon.");
			int rdb = ugyfeltm.getRowCount();
			int cdb = ugyfeltm.getColumnCount();
			for(int i=0; i<rdb; i++) {
				for(int j=1; j<cdb-1; j++) {
					out.print(""+ugyfeltm.getValueAt(i, j)+";");
				}
				out.println(""+ugyfeltm.getValueAt(i, cdb-1));
			}
			out.close();
			DataChecker.showMD("Adatok kiírva!", 1);
		}catch(IOException ioe) {
			DataChecker.showMD("TxtWriter: "+ioe.getMessage(), 0);
		}
	}
}
