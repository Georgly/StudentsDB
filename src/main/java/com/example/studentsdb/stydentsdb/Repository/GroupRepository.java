package com.example.studentsdb.stydentsdb.Repository;

import com.example.studentsdb.stydentsdb.Model.Groups;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Groups,Long> {
}
