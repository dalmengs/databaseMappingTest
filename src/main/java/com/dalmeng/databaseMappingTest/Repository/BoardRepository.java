package com.dalmeng.databaseMappingTest.Repository;

import com.dalmeng.databaseMappingTest.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
