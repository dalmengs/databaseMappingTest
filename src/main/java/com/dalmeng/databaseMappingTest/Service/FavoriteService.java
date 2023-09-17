package com.dalmeng.databaseMappingTest.Service;

import com.dalmeng.databaseMappingTest.Entity.Board;
import com.dalmeng.databaseMappingTest.Entity.Favorite;
import com.dalmeng.databaseMappingTest.Entity.FavoriteId;
import com.dalmeng.databaseMappingTest.Entity.User;
import com.dalmeng.databaseMappingTest.Repository.FavoriteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    @Transactional
    public Favorite createFavorite(Board board, User user){
        Favorite favorite = new Favorite();
        FavoriteId favoriteId = new FavoriteId(board, user);

        favorite.setFavoriteId(favoriteId);
        return favoriteRepository.save(favorite);
    }

    @Transactional
    public List<Favorite> findAll(){
        return favoriteRepository.findAll();
    }

}
