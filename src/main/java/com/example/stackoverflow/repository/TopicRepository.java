package com.example.stackoverflow.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stackoverflow.db.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {

}
