package com.qcm.entity;

import java.sql.Timestamp;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private Timestamp time;
	private String abstract_;
	private String text;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** minimal constructor */
	public News(String title, String abstract_, String text) {
		this.title = title;
		this.abstract_ = abstract_;
		this.text = text;
	}

	/** full constructor */
	public News(String title, Timestamp time, String abstract_, String text) {
		this.title = title;
		this.time = time;
		this.abstract_ = abstract_;
		this.text = text;
	}

	// Property accessors
	
	public String toString(){
		return "id = " + id + " title = " + title + " time = " + time + " abstract_ = " + abstract_ + " text = " + text;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getAbstract_() {
		return this.abstract_;
	}

	public void setAbstract_(String abstract_) {
		this.abstract_ = abstract_;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}