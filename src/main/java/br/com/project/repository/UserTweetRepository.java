package br.com.project.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.project.domain.UserTweetEntity;

public interface UserTweetRepository extends CrudRepository<UserTweetEntity, Long>{

}
