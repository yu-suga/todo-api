package com.example.todoapi.repository.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
public interface UserRepository {

    @Select("WITH c AS(SELECT id,name FROM users WHERE id = #{userId}) SELECT c.id, c.name, label.labelName genre.genreName FROM c LEFT JOIN genre on genre.genreId = c.id LEFT JOIN label label.label.labelId = c.id")
    Optional<UserRecord> select(Long userId);

    /*
        WITH aaa AS(
    SELECT * FROM a
    WHERE a.b_cd = '1'
)

SELECT
    aaa.name
    , b.name
FROM aaa
    LEFT OUTER JOIN b
        ON aaa.b_cd = b.cd
     */

}
