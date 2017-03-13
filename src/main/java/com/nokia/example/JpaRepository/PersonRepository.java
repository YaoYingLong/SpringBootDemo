package com.nokia.example.JpaRepository;

import com.nokia.example.model.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {

	List<Person> findByName(String name);
	
	List<Person> findByNameLike(String name);
	
	List<Person> findByNameAndAddress(String name, String address);

	List<Person> findFirst10ByName(String name);
	
	List<Person> findTop30ByName(String name);
	
	@Query("select p from Person p where p.address = ?1")
	List<Person> findByAddress(String address);
	
	@Query("select p from Person p where p.city = :city")
	List<Person> findByCity(@Param("city") String city);
	
	@Modifying
	@Transactional
	@Query("Update Person p set p.name = ?1 where p.id = ?2")//HQL query
	int setNameById(String name, Integer id);
	
	List<Person> findByName(String name, Sort sort);
	
	List<Person> findByName(String name, Pageable pageable);

	@Transactional
	void deleteById(Integer id);

	@Transactional
	void deleteByNameAndCity(String name, String city);
	
	//sql query
	@Query(value = "select p from person p where p.city = ?1 and p.city = ?2" , nativeQuery=true)
	List<Person> findByNameAndCity(String name, String city);
	
}
