package com.katikilabs.angaza.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.katikilabs.angaza.model.Delegate;

public class DelegateTableModel extends AbstractTableModel {

	private List<Delegate> db;
	private String[] colNames = { "Name", "House" };

	public DelegateTableModel() {

	}

	@Override
	public String getColumnName(int col) {

		return colNames[col];
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return db.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Delegate delegate = db.get(row);
		
		switch(col){
        case 0:
            return String.format("%s %s", delegate.getFirstName(), delegate.getSecondName()) ;
        case 1:
            return delegate.getHouse();
        
    }
    return null;
		
	}
	public void setData(List<Delegate>db){
        this.db = db;
    }

}
