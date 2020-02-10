package br.com.project.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import br.com.project.converter.UserTwitterConverter;
import br.com.project.domain.UserTweetEntity;
import br.com.project.dto.TweetDto;
import br.com.project.dto.UserTweetDto;
import br.com.project.repository.TweetRepository;
import br.com.project.repository.UserTweetRepository;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Service
public class TweetExtractService {

	@Autowired
	private TweetRepository tweetRepository;
	@Autowired
	private UserTweetRepository userTweetRepository;

	@Autowired
	private UserTwitterConverter userTwitterConverter;

	@SuppressWarnings("deprecation")
	public void process(String[] hashs) {
		List<UserTweetDto> userTweetDtos = Lists.newArrayList();
		for (String hash : hashs) {
			Twitter twitter = TwitterFactory.getSingleton();
			Query query = new Query(hash);
			QueryResult result = null;
			try {
				result = twitter.search(query);
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Status status : result.getTweets()) {
				UserTweetDto tweetUser = new UserTweetDto();
				TweetDto tweet = new TweetDto();
				tweetUser.setName(status.getUser().getName());
				tweetUser.setId(status.getUser().getId());
				tweetUser.setLang(status.getUser().getLang());
				tweetUser.setLocation(status.getUser().getLocation());
				tweetUser.setFollowers(new Long(status.getUser().getFollowersCount()));
				tweet.setText(status.getText());
				tweet.setHour(status.getCreatedAt().getHours());
				tweet.setCreated_at(new Date(status.getCreatedAt().getDate()));
				tweetUser.setTweetDtos(Lists.newArrayList(tweet));
				userTweetDtos.add(tweetUser);
			}
		}

		List<UserTweetEntity> userTwitterEntitys = Lists.newArrayList();
		for (UserTweetDto userTweetDto : userTweetDtos) {
			UserTweetEntity userTwitterEntity = userTwitterConverter.apply(userTweetDto);
			userTwitterEntitys.add(userTwitterEntity);
			tweetRepository.saveAll(userTwitterEntity.getTweetEntity());
		}
		userTweetRepository.saveAll(userTwitterEntitys);

	}

}
