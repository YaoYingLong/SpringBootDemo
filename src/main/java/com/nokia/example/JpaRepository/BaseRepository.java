package com.nokia.example.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T , ID extends Serializable> extends JpaRepository<T , ID>  /*, QueryDslPredicateExecutor<T>*/{

    List<T> findAll();

    T findOne(ID id);

}
