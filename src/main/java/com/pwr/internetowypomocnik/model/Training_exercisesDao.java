package com.pwr.internetowypomocnik.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Janusz on 2016-04-22.
 */
@Transactional
public interface Training_exercisesDao extends CrudRepository<Training_exercises, Long> {

    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automagically generated from its signature by Spring Data JPA.
     */
}