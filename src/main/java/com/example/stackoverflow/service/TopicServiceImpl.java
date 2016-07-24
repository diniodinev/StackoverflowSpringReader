package com.example.stackoverflow.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stackoverflow.db.Topic;
import com.example.stackoverflow.repository.TopicRepository;

@Service
public class TopicServiceImpl implements TopicService {

	private static final Logger LOG = LoggerFactory.getLogger(TopicServiceImpl.class);

	@Autowired
	private TopicRepository topicRepository;

	@Override
	public void findAll() {
		topicRepository.findAll();
	}

	@Override
	public void save(Topic topic) {
		topicRepository.save(topic);
	}
	
	@Override
	public void hello() {
		System.out.println("Hello World!");
        LOG.info("Hello World!");
    }

}
