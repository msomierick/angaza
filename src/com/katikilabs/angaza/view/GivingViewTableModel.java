package com.katikilabs.angaza.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.katikilabs.angaza.model.Delegate;
import com.katikilabs.angaza.model.Giving;
import com.katikilabs.angaza.model.GivingView;

public class GivingViewTableModel extends AbstractTableModel {

	private List<GivingView> db;
	private String [] colNames = {"Partner Name", "Pledge", "Mode", "Amount", "Date"};
	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return db.size();
	}
	

	@Override
	public String getColumnName(int col) {
		return colNames[col];
	}

	public Object getValueAt(int row, int col) {
		GivingView view = db.get(row);
		
		switch(col){
        case 0:
            return String.format("%s %s", view.getFirstName(), view.getSecondName()) ;
        case 1:
            return view.getPledge();
        case 2:
        	return view.getMode();
        case 3:
        	return view.getAmount();
        case 4:
        	return view.getDate();
        
    }
    return null;
		
	}
	public void setData(List<GivingView>db){
        this.db = db;
    }

}
