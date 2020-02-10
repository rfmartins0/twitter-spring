package br.com.project.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.Lists;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserTweetDto {

    private Long id;
    private String name;
    private String location;
    private Long countfollowers;
    private String lang;
    private List<TweetDto> tweetDtos = Lists.newArrayList();


    private LocalDateTime created_at;

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

    public Long getFollowers() {
        return countfollowers;
    }

    public void setFollowers(Long countfollowers) {
        this.countfollowers = countfollowers;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

	public List<TweetDto> getTweetDtos() {
		return tweetDtos;
	}

	public void setTweetDtos(List<TweetDto> tweetDtos) {
		this.tweetDtos = tweetDtos;
	}
}
