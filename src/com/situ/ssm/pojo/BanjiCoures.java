package com.situ.ssm.pojo;

public class BanjiCoures {
	private Integer id;
	private Banji banji;
	private Coures coures;
	
	
	public BanjiCoures() {
		super();
	}



	public BanjiCoures(Banji banji, Coures coures) {
		super();
		this.banji = banji;
		this.coures = coures;
	}

	

	public BanjiCoures(Integer id, Banji banji, Coures coures) {
		super();
		this.id = id;
		this.banji = banji;
		this.coures = coures;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
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
		return "BanjiCoures [id=" + id + ", banji=" + banji + ", coures=" + coures + "]";
	}
	
	
}
