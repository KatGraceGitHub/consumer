package jee3060.design.repository;

import jee3060.design.model.Hobby;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
/*
    @Repository
    public interface HobbyRepository extends CrudRepository <Hobby, Integer> {
        @Query("select t from Hobby t where t.title=?1")
        Hobby findByTitle(String title);

        @Modifying
        @Transactional
        @Query("update ThinkTank t set t.descript = ?2, t.title=?1 where t.thinkid = ?3")
        int updateById(String title, String desc, int id);
    }

*/