package org.ownbit.solrspring.service.api.impl;

import org.ownbit.solrspring.entities.SolrUserEntity;
import org.ownbit.solrspring.repository.UserRepository;
import org.ownbit.solrspring.service.api.UserServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class UserService.
 */
@Service
@Transactional(readOnly = true)
public class UserService implements UserServiceIF {

	/** The user repository. */
	@Autowired
	UserRepository userRepository;

	@Override
	public boolean createNewUser(SolrUserEntity solrUserEntity) {
		SolrUserEntity savedEntity = userRepository.save(solrUserEntity);
		return savedEntity != null;
	}

	@Override
	public SolrUserEntity getUserEntity(String userId) {
		SolrUserEntity entity = userRepository.findUserById(userId);
		return entity;
	}

	@Override
	public void deleteAllRecords() {
		userRepository.deleteAll();
	}
}