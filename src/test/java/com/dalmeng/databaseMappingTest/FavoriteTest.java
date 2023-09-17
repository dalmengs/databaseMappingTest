package com.dalmeng.databaseMappingTest;

import com.dalmeng.databaseMappingTest.Entity.Board;
import com.dalmeng.databaseMappingTest.Entity.Favorite;
import com.dalmeng.databaseMappingTest.Entity.User;
import com.dalmeng.databaseMappingTest.Service.BoardService;
import com.dalmeng.databaseMappingTest.Service.FavoriteService;
import com.dalmeng.databaseMappingTest.Service.UserService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FavoriteTest {

    @Autowired
    private BoardService boardService;
    @Autowired
    private UserService userService;
    @Autowired
    private FavoriteService favoriteService;

    @Test
    @DisplayName("한 게시물에는 여러 명의 사용자가 좋아요를 누를 수 있다.")
    @Transactional
    public void test1(){
        Board board = boardService.createBoard();
        User user = userService.createUser();

        Favorite favorite = favoriteService.createFavorite(board, user);

        User newUser = userService.createUser();
        Favorite newFavorite = favoriteService.createFavorite(board, newUser);

        Assertions.assertEquals(favoriteService.findAll().size(), 2);
        Assertions.assertNotEquals(favorite, newFavorite);
    }

    @Test
    @DisplayName("한 사용자는 여러 게시물에 좋아요를 누를 수 있다.")
    @Transactional
    public void test2(){
        Board board = boardService.createBoard();
        User user = userService.createUser();

        Favorite favorite = favoriteService.createFavorite(board, user);

        Board newBoard = boardService.createBoard();
        Favorite newFavorite = favoriteService.createFavorite(newBoard, user);

        Assertions.assertEquals(favoriteService.findAll().size(), 2);
        Assertions.assertNotEquals(favorite, newFavorite);
    }

    @Test
    @DisplayName("사용자는 한 게시물에 좋아요를 한 번만 누를 수 있다.")
    @Transactional
    public void test3(){
        Board board = boardService.createBoard();
        User user = userService.createUser();

        Favorite favorite = favoriteService.createFavorite(board, user);
        Favorite newFavorite = favoriteService.createFavorite(board, user);

        Assertions.assertEquals(favoriteService.findAll().size(), 1);
        Assertions.assertEquals(favorite, newFavorite);
    }

    @Test
    @DisplayName("복합 테스트")
    @Transactional
    public void test4(){
        List<Board> boards = new ArrayList<>();
        List<User> users = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            boards.add(boardService.createBoard());
            users.add(userService.createUser());
        }

        for(int c = 0; c < 5; c++){
            for(int i = 0; i < boards.size(); i++){
                for(int j = 0; j < users.size(); j++){
                    favoriteService.createFavorite(boards.get(i), users.get(j));
                }
            }
        }

        Assertions.assertEquals(favoriteService.findAll().size(), 100);
    }

}
