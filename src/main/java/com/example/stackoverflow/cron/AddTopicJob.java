package com.example.stackoverflow.cron;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Element;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import com.example.stackoverflow.db.Topic;
import com.example.stackoverflow.service.TopicService;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

@Service("initjob")
public class AddTopicJob {
	@Autowired
	private TopicService topicService;

	public void execute() {

		URL url;
		Integer startNumber = 31674367;
		StringBuilder currentLink = new StringBuilder("http://stackoverflow.com/questions/");

		for (int i = 0; i <= 10000; i++) {
			Topic newTopic = new Topic();

			// List<NewDetails> newDetails = new ArrayList<NewDetails>();
			org.jsoup.nodes.Document doc = null;
			try {
				doc = Jsoup.connect(currentLink.toString() + (startNumber + i)).get();
			} catch (org.jsoup.HttpStatusException ex) {
				continue;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println(entry.getLink());
			newTopic.setTitle(doc.getElementById("question-header")
					.getElementsByAttributeValue("class", "question-hyperlink").first().ownText());

			newTopic.setUrl(currentLink.toString() + (startNumber + i));
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
			}
		}
	}
}
