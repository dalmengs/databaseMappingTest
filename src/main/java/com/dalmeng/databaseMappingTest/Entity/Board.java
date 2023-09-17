package com.dalmeng.databaseMappingTest.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
