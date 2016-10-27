package com.qcm.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.qcm.util.StringUtil;

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
	private Double balance = 0.0;
	private Integer state = 1;
	private String stateToString = "已启用";
	private String userName = "test";
	private String userPassword = "123";
	private String userQuestion = "123";
	private String userAnswer = "123";
	private String userEmail = "123";
	private String userPhone = "123";
	private String imageAddress = "123";
	private Date cardBirthday = new Date();
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
		if (StringUtil.isEmpty(cardName))
			this.cardName = "";
		return this.cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getSex() {
		if (sex == null || "".equals(sex))
			this.sex = "1";
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		if (StringUtil.isEmpty(address))
			this.address = "";
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCardNumber() {
		if (StringUtil.isEmpty(cardNumber))
			this.cardNumber = "";
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Double getBalance() {
		if (balance == null)
			this.balance = 0.0;

		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getState() {
		if (this.state == null)
			this.state = 0;
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getUserName() {
		if (StringUtil.isEmpty(this.userName))
			this.userName = "123";
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		if (StringUtil.isEmpty(this.userPassword))
			this.userPassword = "123";
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserQuestion() {
		if (StringUtil.isEmpty(this.userQuestion))
			this.userQuestion = "123";
		return this.userQuestion;
	}

	public void setUserQuestion(String userQuestion) {
		this.userQuestion = userQuestion;
	}

	public String getUserAnswer() {
		if (StringUtil.isEmpty(this.userAnswer))
			this.userAnswer = "123";
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
		if (StringUtil.isEmpty(this.userPhone))
			this.userPhone = "123";
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
		if (this.cardBirthday == null)
			this.cardBirthday = new Date();
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