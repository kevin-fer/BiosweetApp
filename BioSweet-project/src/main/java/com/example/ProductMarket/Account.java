package com.example.ProductMarket;

import javax.persistence.*;

@Entity
public class Account {

	protected String adressMail;
	private String password;
	private String matricule;
	//private int price;
	//private Date dates;
	//private boolean rented;
	//private List<Date> dateLocation = new ArrayList<Date>();

	@Id
	@Column(name = "Identifiant")
	public String getAdressMail() {
		return this.adressMail;
	}
	public void setAdressMail(String id) {
		this.adressMail = id;
	}

/*	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn (name = "id")
	public Date getDates() {
		return dates;
	}
	public void setDates(Date dates) {
		this.dates = dates;
	}

	public boolean isRented() {
		return rented;
	}
	public void setRented(boolean rented) {
		this.rented = rented;
	}*/

	public Account(String adressMail, String password/*, int price*/) {
		super();
		this.setAdressMail(adressMail);
		this.setPassword(password);
		//this.setPrice(price);
	}
	public Account(String adressMail, String password, String matricule) {
		super();
		this.setAdressMail(adressMail);
		this.setPassword(password);
		this.setMatricule(matricule);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public Account() {
		super();
	}

/*
    public List<Date> getDateLocation() {
        return dateLocation;
    }
    public void setDates(String dateDébut, String dateFin) {
        this.dateLocation.add(new Date(dateDébut, dateFin));
    }*/

/*
	public String getPlateNumber() {
		return plateNumber;
	}
	
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}*/

/*
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}*/

	@Override
	public String toString() {
		return "Account{" +
				"Identifiant='" + adressMail + '\'' +
				",Password" + password + '\'' +
				'}';
	}
}
