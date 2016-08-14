package com.example.stackoverflow.db;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TOPIC")
public class Topic implements Serializable {

	private static final long serialVersionUID = -8824597512868330141L;

	@Id
	private String url;

	@Lob
	@Column(name = "ARTICLE_TEXT", length= 30000)
	private String topicText;

	@Column(name = "TITLE", nullable = true, length = 512)
	private String title;
	
	@Column(name = "VOTE")
	private Integer vote;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PUBLICATION_DATE", nullable = true)
	private Date publicationDate;

	public Topic() {
		super();
	}
	
	public Topic(String url, String topicText, String title, Date publicationDate) {
		super();
		this.url = url;
		this.topicText = topicText;
		this.title = title;
		this.publicationDate = publicationDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTopicText() {
		return topicText;
	}

	public void setTopicText(String topicText) {
		this.topicText = topicText;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Integer getVote() {
		return vote;
	}

	public void setVote(Integer vote) {
		this.vote = vote;
	}

}
