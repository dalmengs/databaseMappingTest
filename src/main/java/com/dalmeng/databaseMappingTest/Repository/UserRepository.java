package com.dalmeng.databaseMappingTest.Repository;

import com.dalmeng.databaseMappingTest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
