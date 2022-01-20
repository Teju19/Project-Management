package com.projectmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projectmanagement.entity.Director;

@Repository
public interface DirectorRepository extends CrudRepository<Director, Integer> {

}
