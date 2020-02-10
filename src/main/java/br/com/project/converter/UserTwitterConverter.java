package br.com.project.converter;

import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import br.com.project.domain.TweetEntity;
import br.com.project.domain.UserTweetEntity;
import br.com.project.dto.TweetDto;
import br.com.project.dto.UserTweetDto;

@Component
public class UserTwitterConverter implements Function<UserTweetDto, UserTweetEntity>{

	@Override
	public UserTweetEntity apply(UserTweetDto userTweetDto) {
		UserTweetEntity userTweetEntity = new UserTweetEntity();
		userTweetEntity.setLang(userTweetDto.getLang());
		userTweetEntity.setLocation(userTweetDto.getLocation());
		userTweetEntity.setName(userTweetDto.getName());
		userTweetEntity.setFollowers(userTweetDto.getFollowers());
		for (TweetDto tweetDto : userTweetDto.getTweetDtos()) {
			TweetEntity tweetEntity = new TweetEntity();
			tweetEntity.setHour(tweetDto.getHour());
			tweetEntity.setText(tweetDto.getText());
			userTweetEntity.getTweetEntity().add(tweetEntity);
		}
		return userTweetEntity;
	}
	
	public UserTweetDto apply(UserTweetEntity userTweetEntity) {
		UserTweetDto userTweetDto = new UserTweetDto();
		userTweetDto.setLang(userTweetEntity.getLang());
		userTweetDto.setLocation(userTweetEntity.getLocation());
		userTweetDto.setName(userTweetEntity.getName());
		userTweetDto.setFollowers(userTweetEntity.getFollowers());
		for (TweetEntity tweetEntity : userTweetEntity.getTweetEntity()) {
			TweetDto tweetDto = new TweetDto();
			tweetDto.setHour(tweetEntity.getHour());
			tweetDto.setText(tweetEntity.getText());
			userTweetDto.getTweetDtos().add(tweetDto);
		}
		return userTweetDto;
	}
	
	public List<UserTweetDto> apply(List<UserTweetEntity> userTweetEntitys) {
		List<UserTweetDto> userTweetDtos = Lists.newArrayList();
		for(UserTweetEntity userTweetEntity : userTweetEntitys) {
			UserTweetDto userTweetDto = this.apply(userTweetEntity);
			userTweetDtos.add(userTweetDto);
		}
		return userTweetDtos;
	}


}
