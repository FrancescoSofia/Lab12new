package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Flow {
	
	private int id;
	private LocalDate data;
	private double flow;
	private River river;
	
	
	public Flow(int id, LocalDate data, double flow, River river) {
		super();
		this.id = id;
		this.data = data;
		this.flow = flow;
		this.river = river;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	public double getFlow() {
		return flow;
	}


	public void setFlow(double flow) {
		this.flow = flow;
	}


	public River getRiver() {
		return river;
	}


	public void setRiver(River river) {
		this.river = river;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flow other = (Flow) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Flow [id=" + id + ", data=" + data + ", flow=" + flow + ", river=" + river + "]";
	}
	
	

}
