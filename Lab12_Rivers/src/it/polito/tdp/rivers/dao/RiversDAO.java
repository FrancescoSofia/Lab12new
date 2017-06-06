package it.polito.tdp.rivers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import it.polito.tdp.rivers.model.Flow;
import it.polito.tdp.rivers.model.Misura;
import it.polito.tdp.rivers.model.River;
import it.polito.tdp.rivers.model.RiverIdMap;



public class RiversDAO {
	
	public List<River> getAllRiver(RiverIdMap riverIdMap){
		
		final String sql = "SELECT * FROM river";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			
			List<River> rivers = new ArrayList<River>();

			while (rs.next()) {
			
			River river = new River(rs.getInt("id"),rs.getString("name"));
			river = riverIdMap.put(river);
			rivers.add(river);
			
			}
			
			rs.close();
			conn.close();
			return rivers;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}

	}
		
	
	public River getRiver(River river){
	
	final String sql = "SELECT * FROM flow where river =?";

	try {
		Connection conn = DBConnect.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setInt(1, river.getId());
		ResultSet rs = st.executeQuery();
		
		
		int cont =0;
		LocalDate min = LocalDate.MAX;
		LocalDate max = LocalDate.MIN;
		
		double flowTot = 0;

		while (rs.next()) {
		cont++;
		
		if(rs.getDate("day").toLocalDate().compareTo(min)<0){
			min = rs.getDate("day").toLocalDate();
		}
		
		if(rs.getDate("day").toLocalDate().compareTo(max)>0){
			max = rs.getDate("day").toLocalDate();
		}
		
		flowTot += rs.getFloat("flow");
			
				}
		
		river.setFlowMed(flowTot/cont);
		river.setFirstData(min);
		river.setLastData(max);
		river.setTotMisurazioni(cont);
		
		rs.close();
		conn.close();
		return river;

	} catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException("Errore Db");
	}

	}
	
	public List<Misura> getDati(River river){
		
		final String sql = "SELECT day,flow FROM flow where river =? ";
				
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1, river.getId());
			ResultSet rs = st.executeQuery();
			
			List<Misura> dati = new ArrayList<Misura>();
			
			while (rs.next()) {
				dati.add(new Misura(rs.getDate("day").toLocalDate(),rs.getDouble("flow")));
			}
			
			return dati;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		throw new RuntimeException("Errore getFlow Database");
			
		}
		
		
	}

}
