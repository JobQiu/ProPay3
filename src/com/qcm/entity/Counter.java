package com.qcm.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Counter entity. @author MyEclipse Persistence Tools
 */

public class Counter implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userCounter;
	private String cardName;
	private String sex;
	private String address;
	private String cardNumber;
	private Double balance;
	private Integer state;
	private String stateToString;
	private String userName;
	private String userPassword;
	private String userQuestion;
	private String userAnswer;
	private String userEmail;
	private String userPhone;
	private String imageAddress;
	private Date cardBirthday;
	private Set businessesForUserCounter = new HashSet(0);
	private Set businessesForOtherCounter = new HashSet(0);

	// Constructors

	/** default constructor */
	public Counter() {
	}

	/** minimal constructor */
	public Counter(Integer userCounter, String cardName, String sex,
			String address, String cardNumber, Double balance, Integer state,
			String userName, String userPassword, String userQuestion,
			String userAnswer, String userPhone, Date cardBirthday) {
		this.userCounter = userCounter;
		this.cardName = cardName;
		this.sex = sex;
		this.address = address;
		this.cardNumber = cardNumber;
		this.balance = balance;
		this.state = state;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userQuestion = userQuestion;
		this.userAnswer = userAnswer;
		this.userPhone = userPhone;
		this.cardBirthday = cardBirthday;
	}

	/** full constructor */
	public Counter(Integer userCounter, String cardName, String sex,
			String address, String cardNumber, Double balance, Integer state,
			String userName, String userPassword, String userQuestion,
			String userAnswer, String userEmail, String userPhone,
			String imageAddress, Date cardBirthday,
			Set businessesForUserCounter, Set businessesForOtherCounter) {
		this.userCounter = userCounter;
		this.cardName = cardName;
		this.sex = sex;
		this.address = address;
		this.cardNumber = cardNumber;
		this.balance = balance;
		this.state = state;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userQuestion = userQuestion;
		this.userAnswer = userAnswer;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.imageAddress = imageAddress;
		this.cardBirthday = cardBirthday;
		this.businessesForUserCounter = businessesForUserCounter;
		this.businessesForOtherCounter = businessesForOtherCounter;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserCounter() {
		return this.userCounter;
	}

	public void setUserCounter(Integer userCounter) {
		this.userCounter = userCounter;
	}

	public String getCardName() {
		return this.cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserQuestion() {
		return this.userQuestion;
	}

	public void setUserQuestion(String userQuestion) {
		this.userQuestion = userQuestion;
	}

	public String getUserAnswer() {
		return this.userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getImageAddress() {
		return this.imageAddress;
	}

	public void setImageAddress(String imageAddress) {
		this.imageAddress = imageAddress;
	}

	public Date getCardBirthday() {
		return this.cardBirthday;
	}

	public void setCardBirthday(Date cardBirthday) {
		this.cardBirthday = cardBirthday;
	}

	public Set getBusinessesForUserCounter() {
		return this.businessesForUserCounter;
	}

	public void setBusinessesForUserCounter(Set businessesForUserCounter) {
		this.businessesForUserCounter = businessesForUserCounter;
	}

	public Set getBusinessesForOtherCounter() {
		return this.businessesForOtherCounter;
	}

	public void setBusinessesForOtherCounter(Set businessesForOtherCounter) {
		this.businessesForOtherCounter = businessesForOtherCounter;
	}

	public String getStateToString() {
		if (state == null)
			state = 1;
		if (state == 1)
			return "已启用";
		else {
			return "已冻结";
		}
	}


}