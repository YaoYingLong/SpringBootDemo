package com.nokia.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name="Person.findByName" , query="select p from Person p where p.name = ?1")
public class Person implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String name;

	@Column
	private String address;

	@Column
	private String city;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", city='" + city + '\'' +
				'}';
	}
}
