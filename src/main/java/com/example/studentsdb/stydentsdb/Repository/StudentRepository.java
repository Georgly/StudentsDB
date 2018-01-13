package com.example.studentsdb.stydentsdb.Repository;

import com.example.studentsdb.stydentsdb.Model.Students;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Students,Long> {
}
