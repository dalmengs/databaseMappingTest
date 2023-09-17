package com.dalmeng.databaseMappingTest.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Getter
public class FavoriteId implements Serializable {

    @ManyToOne
    private Board board;

    @ManyToOne
    private User user;

}
