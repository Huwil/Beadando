package beadando;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class SzamlakTM extends DefaultTableModel {

	public SzamlakTM(Object fieldNames[], int rows) {
		super(fieldNames, rows);
	}
	
	public boolean isCellEditable(int row, int col) {
		if(col==0 || col==5) {
			return true;
		}
		return false;
	}
	
	public Class<?> getColumnClass(int index){
		if(index==0) 
			return(Boolean.class);
		else if(index==1 || index==2 || index==5) 
			return(Integer.class);
		return(String.class);
	}
}
