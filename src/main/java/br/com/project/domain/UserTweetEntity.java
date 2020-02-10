package br.com.project.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.collect.Lists;

@Entity
@Table(name = "tweet_user")
public class UserTweetEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column
	private String name;
	@Column
    private String location;
	@Column
    private String lang;
	@Column 
	private Long followers;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<TweetEntity> tweetEntity = Lists.newArrayList();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public List<TweetEntity> getTweetEntity() {
		return tweetEntity;
	}
	public void setTweetEntity(List<TweetEntity> tweetEntity) {
		this.tweetEntity = tweetEntity;
	}
	public Long getFollowers() {
		return followers;
	}
	public void setFollowers(Long followers) {
		this.followers = followers;
	}

}
