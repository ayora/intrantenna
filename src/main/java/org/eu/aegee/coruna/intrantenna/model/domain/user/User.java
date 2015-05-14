package org.eu.aegee.coruna.intrantenna.model.domain.user;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 
 * @author Alberto Ayora
 * 
 */

@Document(collection = "members")
// @TypeAlias("member")
public class User {

	public enum Gender {
		MALE, FEMALE
	};

	@Id
	private ObjectId id;

	@Indexed(unique = true)
	private String email;

	@Field("firstname")
	private String firstName;

	@Field("lastname")
	private String lastName;

	private Calendar birthday;

	private Gender gender;

	private String phone;

	private String address;

	@Field("zipcode")
	private String zipCode;

	private String city;

	private String country;
	
	
	// TODO probablemente haya que cambiar Calendar a DateTime (JODA Time library)
	@CreatedDate
	private Calendar createdDate;
	
	@LastModifiedBy
	private Calendar modifiedDate;

	// TODO type and field of studies and employment

	public User() {};
	
	@PersistenceConstructor
	public User(String email, String firstName, String lastName,
			Calendar birthday, Gender gender, String phone, String address,
			String zipCode, String city, String country) {

		super();

		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
	}

	public ObjectId getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public Calendar getCreatedDate() {
		return createdDate;
	}

	public Calendar getModifiedDate() {
		return modifiedDate;
	}

	@Override
	public String toString() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

		return "User [id=" + id + ", firstName=" + firstName + ", "
				+ ", lastName=" + lastName + ", email=" + email + ", birthday="
				+ sdf.format(birthday.getTime()) + ", gender="
				+ gender.toString() + ", phone=" + phone + ", address="
				+ address + ", zipCode=" + zipCode + ", city=" + city
				+ ", country=" + country + "]";
	}
}
