package it.polito.tdp.rivers.model;

public class BacinoIdrico {
	
	private double capacitaTOT;
	private double capienzaC;
	
	
	public BacinoIdrico(double capacita) {
		super();
		this.capacitaTOT = capacita;
		this.capienzaC = capacita/2;
	}

	public double getCapacitaTOT() {
		return capacitaTOT;
	}

	public void setCapacitaTOT(double capacitaTOT) {
		this.capacitaTOT = capacitaTOT;
	}

	public double getCapienzaC() {
		return capienzaC;
	}

	public void setCapienzaC(double capienzaC) {
		this.capienzaC = capienzaC;
	}
	
		
	

}
