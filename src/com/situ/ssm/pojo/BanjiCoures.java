package com.situ.ssm.pojo;

public class BanjiCoures {
	private Banji banji;
	private Coures coures;
	
	
	public BanjiCoures(Banji banji, Coures coures) {
		super();
		this.banji = banji;
		this.coures = coures;
	}



	public Banji getBanji() {
		return banji;
	}



	public void setBanji(Banji banji) {
		this.banji = banji;
	}



	public Coures getCoures() {
		return coures;
	}



	public void setCoures(Coures coures) {
		this.coures = coures;
	}



	@Override
	public String toString() {
		return "BanjiCoures [banji=" + banji + ", coures=" + coures + "]";
	}
	
	
}
