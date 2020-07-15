package com.cutomer.sanitize.request;

import javax.validation.constraints.NotEmpty;

public class SearchData {
	
	@NotEmpty(message = "fromDate cannot not be empty")
	private String fromDate;
	@NotEmpty(message = "toDate cannot not be empty")
	private String toDate;
	public SearchData() {
		super();
	}
	public SearchData(String fromDate, String toDate) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	@Override
	public String toString() {
		return "SearchData [fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}
	
	

}
