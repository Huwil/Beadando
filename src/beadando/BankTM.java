package beadando;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class BankTM extends DefaultTableModel {
	
	public BankTM(Object fieldNames[], int rows) {
		super(fieldNames, rows);
	}
	
	public boolean isCellEditable(int row, int col) {
		if(col==0) {
			return true;
		}
		return false;
	}
	
	public Class<?> getColumnClass(int index){
		if(index==0) 
			return(Boolean.class);
		else if(index==1) 
			return(Integer.class);
		return(String.class);
	}
}
