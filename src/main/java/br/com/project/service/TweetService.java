package br.com.project.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.converter.UserTwitterConverter;
import br.com.project.domain.TweetEntity;
import br.com.project.domain.UserTweetEntity;
import br.com.project.dto.UserTweetDto;
import br.com.project.repository.UserTweetRepository;

@Service
public class TweetService {

	@Autowired
	private UserTweetRepository userTweetRepository;
	@Autowired
	private UserTwitterConverter userTwitterConverter;

	public List<UserTweetDto> findFollowers() {
		List<UserTweetEntity> userTweetEntitys = this.load();
		Comparator<UserTweetEntity> compareByFollers = Comparator
				.comparing(userTweetEntity -> userTweetEntity.getFollowers(), Collections.reverseOrder());
		userTweetEntitys = userTweetEntitys.stream().sorted(compareByFollers).limit(5)
				.collect(Collectors.toList());
		return userTwitterConverter.apply(userTweetEntitys);
	}

	public Map<Integer, List<UserTweetEntity>> findHours() {
		List<UserTweetEntity> userTweetEntitys = this.load();
		Map<Integer, List<UserTweetEntity>> mapHour = new TreeMap<Integer, List<UserTweetEntity>>();
		for (UserTweetEntity userTweetEntity : userTweetEntitys) {
			for (TweetEntity tweetEntity : userTweetEntity.getTweetEntity()) {
				mapHour.computeIfAbsent(tweetEntity.getHour(), k -> new ArrayList<>()).add(userTweetEntity);
			}
		}
		return mapHour;
	}

	public Map<String, List<UserTweetEntity>> findCountry() {
		List<UserTweetEntity> userTweetEntitys = this.load();
		Map<String, List<UserTweetEntity>> mapLocation = new TreeMap<String, List<UserTweetEntity>>();
		for (UserTweetEntity userTweetEntity : userTweetEntitys) {
			mapLocation.computeIfAbsent(userTweetEntity.getLocation(), k -> new ArrayList<>()).add(userTweetEntity);
		}
		return mapLocation;
	}

	private List<UserTweetEntity> load() {
		return (List<UserTweetEntity>) this.userTweetRepository.findAll();
	}

}
