package com.chinasofti.bean;

public class Counter {
	private Integer visitcount;

	public Integer getVisitcount() {
		return visitcount;
	}

	public void setVisitcount(Integer visitcount) {
		this.visitcount = visitcount;
	}

	public Counter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Counter(Integer visitcount) {
		super();
		this.visitcount = visitcount;
	}

	@Override
	public String toString() {
		return "Counter [visitcount=" + visitcount + "]";
	}
	
}
