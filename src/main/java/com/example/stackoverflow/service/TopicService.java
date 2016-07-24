package com.example.stackoverflow.service;

import com.example.stackoverflow.db.Topic;

public interface TopicService {
	void findAll();

	void save(Topic topic);

	void hello();
}
