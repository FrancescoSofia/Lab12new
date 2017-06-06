package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Event implements Comparable<Event> {

	
	public enum EventType {
		NORMALE,TRACIMAZIONE;
	}

	private double fIn;
	private double fOut;
	private LocalDate data;
	private EventType type ;
	private double fMin;
	
	@Override
	public int compareTo(Event other) {
		return this.data.compareTo(other.data);
	}

	public Event(double fIn, double fOut,double fMin, LocalDate data, EventType type) {
		super();
		this.fIn = fIn;
		this.fOut = fOut;
		this.setfMin(fMin);
		this.data = data;
		this.type = type;
	}

	public double getfIn() {
		return fIn;
	}

	public void setfIn(double fIn) {
		this.fIn = fIn;
	}

	public double getfOut() {
		return fOut;
	}

	public void setfOut(double fOut) {
		this.fOut = fOut;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public double getfMin() {
		return fMin;
	}

	public void setfMin(double fMin) {
		this.fMin = fMin;
	}

	@Override
	public String toString() {
		return "Event [fIn=" + fIn + ", fOut=" + fOut + ", data=" + data + ", type=" + type + ", fMin=" + fMin + "]";
	}

	

	

}
