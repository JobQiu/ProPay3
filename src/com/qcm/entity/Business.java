package com.qcm.entity;

import java.sql.Timestamp;

/**
 * Business entity. @author MyEclipse Persistence Tools
 */

public class Business implements java.io.Serializable {

	// Fields

	private Integer id;
	private Counter counterByUserCounter;
	private Counter counterByOtherCounter;
	private Integer money;
	private String type;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public Business() {
	}

	/** full constructor */
	public Business(Counter counterByUserCounter,
			Counter counterByOtherCounter, Integer money, String type,
			Timestamp time) {
		this.counterByUserCounter = counterByUserCounter;
		this.counterByOtherCounter = counterByOtherCounter;
		this.money = money;
		this.type = type;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Counter getCounterByUserCounter() {
		return this.counterByUserCounter;
	}

	public void setCounterByUserCounter(Counter counterByUserCounter) {
		this.counterByUserCounter = counterByUserCounter;
	}

	public Counter getCounterByOtherCounter() {
		return this.counterByOtherCounter;
	}

	public void setCounterByOtherCounter(Counter counterByOtherCounter) {
		this.counterByOtherCounter = counterByOtherCounter;
	}

	public Integer getMoney() {
		return this.money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}