package com.nokia.example.service;

//@Service
public class PersonService {
	
	//@Autowired
	//private PersonRepository personRepository;

	/*@CachePut(value = "person")
	public List<Person> getAllPerson(){
		List<Person> people = personRepository.findAll(personFromHefei());
		return people;
	}

	@CacheEvict(value = "person")
	public void deletePersonById(Integer id){
		personRepository.deleteById(id);
	}

	@Cacheable(value = "person")
	public List<Person> findPersonByName(String name){
		List<Person> people1 = personRepository.findByName("XX" , new Sort(Direction.ASC , "age"));
		return people1;
	}*/

	
	/*List<Person> people1 = personRepository.findByName("XX" , new Sort(Direction.ASC , "age"));
	
	List<Person> people2 = personRepository.findByName("XX" , new PageRequest(0 , 10));*/
	
}
