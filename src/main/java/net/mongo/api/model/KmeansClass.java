package net.mongo.api.model;

public class KmeansClass {
	private String local;
	private Double price;
	private int sise;
	private int cluster;
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getSise() {
		return sise;
	}
	public void setSise(int sise) {
		this.sise = sise;
	}
	public int getCluster() {
		return cluster;
	}
	public void setCluster(int cluster) {
		this.cluster = cluster;
	}
	@Override
	public String toString() {
		return "TestD [local=" + local + ", price=" + price + ", sise=" + sise + ", cluster=" + cluster + "]";
	}
	
	

}
