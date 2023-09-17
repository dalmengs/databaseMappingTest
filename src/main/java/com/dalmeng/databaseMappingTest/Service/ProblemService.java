package com.dalmeng.databaseMappingTest.Service;

import com.dalmeng.databaseMappingTest.Entity.Problem;
import com.dalmeng.databaseMappingTest.Repository.ProblemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProblemService {

    private final ProblemRepository problemRepository;

    @Transactional
    public Problem createProblem(){
        Problem problem = new Problem();
        return problemRepository.save(problem);
    }

}
