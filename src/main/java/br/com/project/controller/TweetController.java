package br.com.project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.domain.UserTweetEntity;
import br.com.project.dto.UserTweetDto;
import br.com.project.service.TweetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(value = "TopResource")
@RestController
@RequestMapping("/v1/api/")
public class TweetController {
	
	@Autowired
	private TweetService tweetService;


	@ApiOperation(value = "Exibe os horários", httpMethod = "GET")
	@ApiResponse(code = 200, message = "Horários retornados")
	@GetMapping(path = "hours", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Integer, List<UserTweetEntity>> findHours() {
		return tweetService.findHours();
    }

	@ApiOperation(value = "Exibe os seguidores", httpMethod = "GET")
	@ApiResponse(code = 200, message = "Seguidores retornados")
    @GetMapping(path = "followers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserTweetDto> findFollowers() {
        return tweetService.findFollowers();
    }

	@ApiOperation(value = "Exibe os países", httpMethod = "GET")
	@ApiResponse(code = 200, message = "Países retornados")
    @GetMapping(path = "country", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, List<UserTweetEntity>> findCountry() {
        return tweetService.findCountry();
    }

}
