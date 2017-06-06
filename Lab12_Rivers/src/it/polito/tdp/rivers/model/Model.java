package it.polito.tdp.rivers.model;

import java.util.List;
import it.polito.tdp.rivers.dao.RiversDAO;

public class Model {
	
	private List<River> rivers;
	private RiversDAO dao;
	private RiverIdMap riverIdMap;
	private List<Misura> dati;
	
	public Model(){
		
		this.riverIdMap = new RiverIdMap();
		dao = new RiversDAO();
		
	}
	
	public List<River> getAllRiver(){
		if(this.rivers== null){
		this.rivers = dao.getAllRiver(riverIdMap);
		}
		return this.rivers;
	}

	public River getRiver(River river) {
		River riverModel = dao.getRiver(river);
		return riverModel;
		
	}
	
//	public List<Misura> getDati(River river){
//		dati = dao.getDati(river);
//		return dati;
//	}
	
	public Statistiche simula(int k,River river){
		dati = dao.getDati(river);
	double q = k*river.getFlowMed()*86400 *30;
	BacinoIdrico b = new BacinoIdrico(q);
	Statistiche stat = new Statistiche(b);

	for(Misura m: dati){
		stat.newDay(m.getFlow()*86400,0.8*river.getFlowMed()*86400, 0.8*river.getFlowMed()*86400, m.getData());
	}
	stat.run();
//	System.out.println(stat.getGiorniKO());
//	System.out.println(stat.getCapacitaMed());
	return stat;
	}
	
	

}
