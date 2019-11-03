package com.wildcodeschool.springJpaHibernate.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Maison {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	private String name;
	private String address;
	
	@Override
    public String toString() {
        return "la maison [id=" + id + ", name=" + name + 
                ", est a cette adresse=" + address + "]";
    }  
	
	public Maison() {
    }
	
	public Maison(String name, String address) {
        this.name = name;
        this.address = address;
    }
	
	
}
