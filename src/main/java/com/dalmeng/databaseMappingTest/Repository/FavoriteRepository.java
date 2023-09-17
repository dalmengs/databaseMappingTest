package com.dalmeng.databaseMappingTest.Repository;

import com.dalmeng.databaseMappingTest.Entity.Favorite;
import com.dalmeng.databaseMappingTest.Entity.FavoriteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, FavoriteId> {
}
