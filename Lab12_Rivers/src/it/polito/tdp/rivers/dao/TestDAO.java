package it.polito.tdp.rivers.dao;

import it.polito.tdp.rivers.model.River;
import it.polito.tdp.rivers.model.RiverIdMap;


public class TestDAO {

	public static void main(String[] args) {
		
		RiversDAO dao = new RiversDAO();
		
		River river = new River(1, null);
		dao.getRiver(river);
		System.out.println(river.toString1());
		
		RiverIdMap riverIdMap = new RiverIdMap();
		System.out.println(dao.getAllRiver(riverIdMap));
		

	}

}
