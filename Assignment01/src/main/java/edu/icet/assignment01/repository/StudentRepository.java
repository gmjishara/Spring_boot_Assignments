package edu.icet.assignment01.repository;

import edu.icet.assignment01.dao.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity,Long> {
}
