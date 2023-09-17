package com.dalmeng.databaseMappingTest;

import com.dalmeng.databaseMappingTest.Entity.Board;
import com.dalmeng.databaseMappingTest.Entity.Problem;
import com.dalmeng.databaseMappingTest.Entity.Submit;
import com.dalmeng.databaseMappingTest.Entity.User;
import com.dalmeng.databaseMappingTest.Service.ProblemService;
import com.dalmeng.databaseMappingTest.Service.SubmitService;
import com.dalmeng.databaseMappingTest.Service.UserService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SubmitTest {

    @Autowired
    private ProblemService problemService;

    @Autowired
    private UserService userService;

    @Autowired
    private SubmitService submitService;

    @Test
    @DisplayName("한 사용자는 한 문제에 대해 여러 번 제출할 수 있다.")
    @Transactional
    public void test1(){
        Problem problem = problemService.createProblem();
        User user = userService.createUser();

        Submit submit1 = submitService.createSubmit(problem, user);
        Submit submit2 = submitService.createSubmit(problem, user);

        Assertions.assertNotEquals(submit1, submit2);
        Assertions.assertEquals(submitService.findAll().size(), 2);
    }

    @Test
    @DisplayName("한 사용자는 여러 문제에 제출할 수 있다.")
    @Transactional
    public void test2(){
        Problem problem = problemService.createProblem();
        User user = userService.createUser();

        Submit submit = submitService.createSubmit(problem, user);

        Problem newProblem = problemService.createProblem();

        Submit newSubmit = submitService.createSubmit(newProblem, user);

        Assertions.assertNotEquals(submit, newSubmit);
        Assertions.assertEquals(submitService.findAll().size(), 2);
    }

    @Test
    @DisplayName("한 문제에 여러 명이 제출할 수 있다.")
    @Transactional
    public void test3(){
        Problem problem = problemService.createProblem();
        User user = userService.createUser();

        Submit submit = submitService.createSubmit(problem, user);

        User newUser = userService.createUser();

        Submit newSubmit = submitService.createSubmit(problem, newUser);

        Assertions.assertNotEquals(submit, newSubmit);
        Assertions.assertEquals(submitService.findAll().size(), 2);
    }

    @Test
    @DisplayName("복합 테스트")
    @Transactional
    public void test4(){
        List<Problem> problems = new ArrayList<>();
        List<User> users = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            problems.add(problemService.createProblem());
            users.add(userService.createUser());
        }

        for(int c = 0; c < 5; c++){
            for(int i = 0; i < problems.size(); i++){
                for(int j = 0; j < users.size(); j++){
                    submitService.createSubmit(problems.get(i), users.get(j));
                }
            }
        }

        Assertions.assertEquals(submitService.findAll().size(), 500);
    }
}
