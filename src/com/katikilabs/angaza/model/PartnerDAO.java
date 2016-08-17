package com.katikilabs.angaza.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PartnerDAO implements IPartnerDAO {

	@Override
	public void addPartner(Partner partner) throws SQLException {

		String fname = partner.getFirstName();
		String sname = partner.getSecondName();
		int pledge = partner.getPledge();
		String mode = partner.getMode();
		int del_id = partner.getDelegateId();
		
		Connection con = Database.getConnection();
		
		String sql = "INSERT INTO partner(firstname, secondname, pleadge, mode, delegate_id) values(?, ?, ?, ?, ?);";
		PreparedStatement stmt = con.prepareStatement(sql);

		
		stmt.setString(1, fname);
		stmt.setString(2, sname);
		stmt.setInt(3, pledge);
		stmt.setString(4, mode);
		stmt.setInt(5, del_id);
		
		stmt.executeUpdate();
		
		if(stmt.isClosed() == false){
			stmt.close();
		}
		if(con.isClosed() == false){
			con.close();
		}
	}

	@Override
	public Partner getPartner(int id) throws SQLException {

		Partner partner = null;
		Connection conn = Database.getConnection();
		
		Statement stmt = conn.createStatement();
		
		String sql = String.format("SELECT* FROM partner WHERE partner_id = %d", id);
		
		stmt.executeQuery(sql);
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			
			int p_id = rs.getInt(1);
			String faname = rs.getString(2);
			String sename = rs.getString(3);
			int pleadge = rs.getInt(4);
			String mode = rs.getString(5);
			int de_id = rs.getInt(6);
			
			partner = new Partner(p_id, faname, sename, pleadge, mode, de_id);
			
		}
		return partner;
	}

	@Override
	public List<Partner> getPartners() throws SQLException {
		List<Partner> partnersList = new ArrayList<Partner>();

		Connection con = Database.getConnection();

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT* FROM partner");

		while (rs.next()) {
			int pat_id = rs.getInt(1);
			String fname = rs.getString(2);
			String sname = rs.getString(3);
			int pleadge = rs.getInt(4);
			String mode = rs.getString(5);
			int del_id = rs.getInt(6);

			Partner partner = new Partner(pat_id, fname, sname, pleadge, mode,
					del_id);

			partnersList.add(partner);

		}
		rs.close();
		stmt.close();
		con.close();
		return partnersList;
	}

	@Override
	public int deletePartner(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<Partner> getPartnerPerDelegate(int id) throws SQLException{
		List<Partner> partnersPerDelegateList = new ArrayList<Partner>();

		Connection con = Database.getConnection();

		Statement stmt = con.createStatement();
		String sql = String.format("SELECT* FROM partner WHERE delegate_id = $d", id);
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			int pat_id = rs.getInt(1);
			String fname = rs.getString(2);
			String sname = rs.getString(3);
			int pleadge = rs.getInt(4);
			String mode = rs.getString(5);
			int del_id = rs.getInt(6);

			Partner partner = new Partner(pat_id, fname, sname, pleadge, mode,
					del_id);

			partnersPerDelegateList.add(partner);

		}
		rs.close();
		stmt.close();
		con.close();
		return partnersPerDelegateList;
	}
	/*public static void main(String[] args) throws SQLException {
		PartnerDAO pdao = new PartnerDAO();

		System.out.println("Name\t\tPledge\tMode");
		for(Partner partner: pdao.getPartners()){
			String finame = partner.getFirstName();
			String sename = partner.getSecondName();
			int pledge = partner.getPledge();
			String mode  = partner.getMode();
			System.out.printf("%s %s\t%d\t%s\n", finame, sename, pledge, mode);
		}
		
		//pdao.addPartner(new Partner(0, "Peter", "Onyango", 1000, "Monthly", 3));
		Partner pat = pdao.getPartner(4);
		System.out.println(pat.getFirstName() + pat.getSecondName());
	}
*/
}
