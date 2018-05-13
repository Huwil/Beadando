package beadando;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class BankfiokTM extends DefaultTableModel {

	public BankfiokTM(Object fieldNames[], int rows) {
		super(fieldNames, rows);
	}
	
	public boolean isCellEditable(int row, int col) {
		if(col==0 || col==4) {
			return true;
		}
		return false;
	}
	
	public Class<?> getColumnClass(int index){
		if(index==0) 
			return(Boolean.class);
		else if(index==1 || index==3 || index==4) 
			return(Integer.class);
		return(String.class);
	}
}
