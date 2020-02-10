package br.com.project.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.project.config.TwitterWordsProperties;

@Service
public class TweetScheduler {

    
	@Autowired
    private TwitterWordsProperties twitterProperties;
	
	@Autowired
	private TweetExtractService tweetExtractService;

    private Logger logger = LoggerFactory.getLogger(TweetScheduler.class);


    @Scheduled(fixedDelay = 10000)
    public void scheduleTask() {
        logger.info("Início do processamento");
        tweetExtractService.process(twitterProperties.getTwitterHashs());
        logger.info("Fim do Processamento");
    }

}
