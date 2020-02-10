package br.com.project.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.project.domain.TweetEntity;

public interface TweetRepository extends CrudRepository<TweetEntity, Long>{

}
