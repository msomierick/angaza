package com.katikilabs.angaza.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.katikilabs.angaza.model.Delegate;
import com.katikilabs.angaza.model.Partner;

public class PartnerTableModel extends AbstractTableModel {

	private List<Partner> db;
	private String [] colNames = {"Partner Name", "Pledge"};
	@Override
	public int getColumnCount() {
		return 2;
	}

	
	@Override
	public String getColumnName(int col) {
		return colNames[col];
	}


	@Override
	public int getRowCount() {
		return db.size();
	}


	@Override
	public Object getValueAt(int row, int col) {
		Partner partner = db.get(row);
		
		switch(col){
        case 0:
            return String.format("%s %s", partner.getFirstName(), partner.getSecondName()) ;
        case 1:
            return partner.getPledge();
     
    }
    return partner;
		
	}
	public void setData(List<Partner> db){
        this.db = db;
    }
}
