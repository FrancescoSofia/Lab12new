package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Misura {
	
	private LocalDate data;
	private double flow;
	
	
	public Misura(LocalDate data, double flow) {
		super();
		this.data = data;
		this.flow = flow;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		long temp;
		temp = Double.doubleToLongBits(flow);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Misura other = (Misura) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (Double.doubleToLongBits(flow) != Double.doubleToLongBits(other.flow))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Misura [data=" + data + ", flow=" + flow + "]";
	}
	
	

}
