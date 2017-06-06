package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class River {
	
	private int id;
	private String name;
	private LocalDate firstData;
	private LocalDate lastData;
	private int totMisurazioni;
	private double flowMed;
	
	public River(int id, String name) {
		super();
		this.id = id;
		this.name = name; 
		
	}
	
	
	public LocalDate getFirstData() {
		return firstData;
	}


	public void setFirstData(LocalDate firstData) {
		this.firstData = firstData;
	}


	public LocalDate getLastData() {
		return lastData;
	}


	public void setLastData(LocalDate lastData) {
		this.lastData = lastData;
	}


	public int getTotMisurazioni() {
		return totMisurazioni;
	}


	public void setTotMisurazioni(int totMisurazioni) {
		this.totMisurazioni = totMisurazioni;
	}


	public double getFlowMed() {
		return flowMed;
	}


	public void setFlowMed(double flowMed) {
		this.flowMed = flowMed;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		River other = (River) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



	public String toString1() {
		return "River [id=" + id + ", name=" + name + ", firstData=" + firstData + ", lastData=" + lastData
				+ ", totMisurazioni=" + totMisurazioni + ", flowMed=" + flowMed + "]";
	}


	@Override
	public String toString() {
		return  id+" "+name ;
	}
	

}
