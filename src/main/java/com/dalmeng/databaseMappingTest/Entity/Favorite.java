package com.dalmeng.databaseMappingTest.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Favorite {

    @EmbeddedId
    private FavoriteId favoriteId;

}
