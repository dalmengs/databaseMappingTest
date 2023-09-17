package com.dalmeng.databaseMappingTest.Repository;

import com.dalmeng.databaseMappingTest.Entity.Submit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmitRepository extends JpaRepository<Submit, Long> {
}
