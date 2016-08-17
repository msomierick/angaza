package com.katikilabs.angaza.main;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.katikilabs.angaza.model.Partner;
import com.katikilabs.angaza.model.PartnerDAO;

public class SortingTest {

	
	public static void main(String[] args) throws SQLException {

		PartnerDAO pd = new PartnerDAO();
		List list = pd.getPartners();
		
		Collections.sort(list, Partner.PledgeComparator);
		
		for(Object pat:list){
			Partner patn = (Partner)pat;
			System.out.println(patn.getPledge());
		}
	}

}
