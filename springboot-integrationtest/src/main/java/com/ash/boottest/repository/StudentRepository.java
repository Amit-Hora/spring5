package com.ash.boottest.repository;

import java.util.List;

import com.ash.boottest.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByName(String name);
}
