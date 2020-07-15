package com.cutomer.sanitize.entity;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*@Entity
@Table(name = "user_authorities")*/
public class UserAuthority {
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO)
	 */
	private BigInteger id;
	private BigInteger user_id;
	private String authority;
	
	public UserAuthority() {
		super();
	}
	public UserAuthority(BigInteger id, BigInteger user_id, String authority) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.authority = authority;
	}
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public BigInteger getUser_id() {
		return user_id;
	}
	public void setUser_id(BigInteger user_id) {
		this.user_id = user_id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Override
	public String toString() {
		return "UserAuthorities [id=" + id + ", user_id=" + user_id + ", authority=" + authority + "]";
	}
}
