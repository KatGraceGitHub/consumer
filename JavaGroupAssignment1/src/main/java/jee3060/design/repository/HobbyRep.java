package jee3060.design.repository;

import jee3060.design.model.Hobby;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HobbyRep extends CrudRepository<Hobby, Integer> {

}
