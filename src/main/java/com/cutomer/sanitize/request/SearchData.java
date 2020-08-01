package com.cutomer.sanitize.request;

import javax.validation.constraints.NotEmpty;

public class SearchData {
	
	@NotEmpty(message = "fromDate cannot not be empty")
	private String fromDate;
	@NotEmpty(message = "toDate cannot not be empty")
	private String toDate;
	@NotEmpty(message = "uuid cannot not be empty")
	private String uuid;
	public SearchData() {
		super();
	}
	
	public SearchData(@NotEmpty(message = "fromDate cannot not be empty") String fromDate,
			@NotEmpty(message = "toDate cannot not be empty") String toDate,
			@NotEmpty(message = "uuid cannot not be empty") String uuid) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.uuid = uuid;
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
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "SearchData [fromDate=" + fromDate + ", toDate=" + toDate + ", uuid=" + uuid + "]";
	}
	
	
	

}
