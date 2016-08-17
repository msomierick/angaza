package com.katikilabs.angaza.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import com.katikilabs.angaza.model.Delegate;
import com.katikilabs.angaza.model.DelegateDAO;
import com.katikilabs.angaza.model.GivingViewDAO;
import com.katikilabs.angaza.model.PartnerDAO;

public class TablePanel extends JPanel {

	private JTable table;
	private DelegateTableModel tableModel;
	private DelegateDAO delDAO;
	private PartnerDAO patDAO;
	private PartnerTableModel patModel;
	private GivingViewTableModel viewModel;
	private GivingViewDAO viewDAO;
	public TablePanel() throws SQLException{
		
		delDAO = new  DelegateDAO();
		patDAO = new PartnerDAO();
		viewDAO = new GivingViewDAO();
		
		tableModel = new DelegateTableModel();
		patModel = new PartnerTableModel();
		viewModel = new GivingViewTableModel();
		
		tableModel.setData(delDAO.getDelegates());
		patModel.setData(patDAO.getPartners());
		viewModel.setData(viewDAO.getGivingViews());
		
		table = new JTable(patModel){
			public boolean isCellEditable(int rows, int columns) {
                return false;
            }

            public Component prepareRenderer(TableCellRenderer cellRenderer, int rows, int columns) {
                Component tableCell = super.prepareRenderer(cellRenderer, rows, columns);
                
                if (rows % 2 == 0) {
                    tableCell.setBackground(new Color(255, 223, 247));
                } else {
                    tableCell.setBackground(Color.WHITE);
                }
                
                if (isCellSelected(rows, columns)) {
                    tableCell.setBackground(Color.MAGENTA);
                }
                return tableCell;
            }
		};
		add(new JScrollPane(table),  BorderLayout.CENTER);
	}
	
	public void setData(List<Delegate> db){
        tableModel.setData(db);
    }
}
