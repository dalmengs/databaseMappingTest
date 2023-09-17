package com.dalmeng.databaseMappingTest.Repository;

import com.dalmeng.databaseMappingTest.Entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.beans.JavaBean;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {
}
