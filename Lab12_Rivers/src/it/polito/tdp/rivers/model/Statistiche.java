package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.*;

import it.polito.tdp.rivers.model.Event.EventType;




public class Statistiche {
	
	private PriorityQueue<Event> queue;
	
	private int giorniKO = 0;
	private double capacita;
	private double capacitaMed;
	private int cont = 0;

	private BacinoIdrico b;


	public Statistiche(BacinoIdrico b) {
		super();
		this.b = b;
		this.queue = new PriorityQueue<>();
		capacita = b.getCapienzaC();
	}	
	
	
	public int getGiorniKO() {
		return giorniKO;
	}


	public void setGiorniKO(int giorniKO) {
		this.giorniKO = giorniKO;
	}


	public double getCapacita() {
		return capacita;
	}


	public void setCapacita(double capacita) {
		this.capacita = capacita;
	}

	
public void  newDay(double fIn,double fOut,double fMin, LocalDate data) {
	cont++;
	
	if(Math.random()<0.05){
		fMin = 10*fMin;
	}
	if(fOut<fMin){
		giorniKO++;
	}

//		Event e = new Event(double fIn,double fOut, LocalDate data,EventType.NEWDAY) ;
	if(fIn+b.getCapienzaC()>b.getCapacitaTOT()){
		Event e = new Event(fIn, fOut, fMin, data,EventType.TRACIMAZIONE) ;
		queue.add(e);
	}
	else{
		Event e = new Event(fIn, fOut, fMin, data, EventType.NORMALE) ;
		queue.add(e);
	}
	
			
}

	public void run() {
		while (!queue.isEmpty()) {
			Event e = queue.poll();			
			switch (e.getType()) {
			case NORMALE:
				processNormaleEvent(e);
				break;
			case TRACIMAZIONE:
				processTracimazioneEvent(e);
				break;
			default:
				break;
			}
		}
	}
	
	private void processTracimazioneEvent(Event e) {
		b.setCapienzaC(b.getCapienzaC()-(e.getfOut()+e.getfIn()));
		capacita += b.getCapienzaC();
		
		
	}


	private void processNormaleEvent(Event e) {
		b.setCapienzaC(b.getCapienzaC()+e.getfIn()-e.getfOut());
		capacita += b.getCapienzaC();
		
	}

	public double getCapacitaMed() {
		double capacitaMed = (capacita/cont);
		return capacitaMed;
	}


	public void setCapacitaMed(double capacitaMed) {
		this.capacitaMed = capacitaMed;
	}
	
	
	
	
	
}
