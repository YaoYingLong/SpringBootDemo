package com.nokia.example.JpaRepository.Impl;

import java.io.Serializable;

import javax.persistence.EntityManager;

import com.nokia.example.JpaRepository.CustomRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;


public class CustomRepositoryImpl<T , ID extends Serializable> 
	extends SimpleJpaRepository<T , ID> implements CustomRepository<T , ID> {

	private final EntityManager entityManager;
	
	public CustomRepositoryImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.entityManager = em;
	}

	@Override
	public void doSomething(ID id) {
		
	}

}
