package com.nokia.example.JpaRepository;

import com.nokia.example.model.Person;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CustomerSpecs {

	public static Specification<Person> personFromHefei(){
		return new Specification<Person>(){

			@Override
			public Predicate toPredicate(Root<Person> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				return cb.equal(root.get("address") , "chengdu");
			}
			
		};
	}

	/*public PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Sort.Direction.ASC, "title");
		} else if ("title".equals(sortType)) {
			sort = new Sort(Sort.Direction.ASC, "title");
		}
		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}*/
	
}
