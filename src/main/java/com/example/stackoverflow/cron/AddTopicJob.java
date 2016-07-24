package com.example.stackoverflow.cron;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.example.stackoverflow.configuration.StackoverflowConfiguration;
import com.example.stackoverflow.configuration.YamlConfigParser;
import com.example.stackoverflow.db.Topic;
import com.example.stackoverflow.service.TopicService;

@Service("initjob")
public class AddTopicJob {
	@Autowired
	private TopicService topicService;

	@Autowired
	private YamlConfigParser yamlParser;

	@Autowired
	private ResourceLoader resourceLoader;

	public void execute() throws IOException {

		Resource resource = resourceLoader.getResource("classpath:config.yaml");
		File configFile = resource.getFile();
		StackoverflowConfiguration config = yamlParser.yamlParser(configFile);

		URL url;

		Topic newTopic = new Topic();
		org.jsoup.nodes.Document doc = null;

		for (int i = 0; i <= config.getReadingStep(); i++) {
			try {
				doc = Jsoup.connect(config.getBaseUrl() + (config.getSuffixNumber() +i)).get();
			} catch (org.jsoup.HttpStatusException ex) {
				continue;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println(entry.getLink());
			newTopic.setTitle(doc.getElementById("question-header")
					.getElementsByAttributeValue("class", "question-hyperlink").first().ownText());

			newTopic.setUrl(config.getBaseUrl() + (config.getSuffixNumber() +i));
			System.out.println("UpVote");
			System.out.println();

			newTopic.setUpVote(
					Integer.parseInt(doc.getElementsByAttributeValue("itemprop", "upvoteCount").first().ownText()));

			org.jsoup.nodes.Element article = doc.getElementById("question")
					.getElementsByAttributeValue("class", "post-text").first();
			if (article != null) {

				topicService.save(newTopic);
			}
			try {
				Thread.currentThread().sleep(867);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				config.setSuffixNumber(config.getSuffixNumber() + config.getReadingStep());
				yamlParser.writeConfig(configFile, config);
			}
		}
	}
}
