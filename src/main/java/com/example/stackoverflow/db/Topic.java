package com.example.stackoverflow.db;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TOPIC_ID", nullable = false)
	private Long id;

	@Column(name = "FULL_LINK", nullable = false, length = 4096)
	private String Url;

	@Lob
	@Column(name = "ARTICLE_TEXT", length= 30000)
	private String topicText;

	@Column(name = "TITLE", nullable = true, length = 512)
	private String title;
	
	@Column(name = "UP_VOTE")
	private Integer upVote;
	
	@Column(name = "DOWN_VOTE")
	private Integer downVote;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PUBLICATION_DATE", nullable = true)
	private Date publicationDate;

	public Topic() {
		super();
	}
	
	public Topic(String url, String topicText, String title, Date publicationDate) {
		super();
		Url = url;
		this.topicText = topicText;
		this.title = title;
		this.publicationDate = publicationDate;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
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

	public Integer getUpVote() {
		return upVote;
	}

	public void setUpVote(Integer upVote) {
		this.upVote = upVote;
	}

	public Integer getDownVote() {
		return downVote;
	}

	public void setDownVote(Integer downVote) {
		this.downVote = downVote;
	}
	
	

}
