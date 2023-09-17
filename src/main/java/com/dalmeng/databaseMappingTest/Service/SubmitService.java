package com.dalmeng.databaseMappingTest.Service;

import com.dalmeng.databaseMappingTest.Entity.Problem;
import com.dalmeng.databaseMappingTest.Entity.Submit;
import com.dalmeng.databaseMappingTest.Entity.User;
import com.dalmeng.databaseMappingTest.Repository.SubmitRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubmitService {

    private final SubmitRepository submitRepository;

    @Transactional
    public Submit createSubmit(Problem problem, User user){
        Submit submit = new Submit();
        submit.setProblem(problem);
        submit.setUser(user);

        return submitRepository.save(submit);
    }

    @Transactional
    public List<Submit> findAll(){
        return submitRepository.findAll();
    }

}
