package net.mongo.api.model;

public class ModeleKmeans {
	private String dataSet;
	private String nom;
	private int K;
	public String getDataSet() {
		return dataSet;
	}
	public void setDataSet(String dataSet) {
		this.dataSet = dataSet;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getK() {
		return K;
	}
	public void setK(int k) {
		K = k;
	}
	

}
