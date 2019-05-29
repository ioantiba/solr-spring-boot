package org.ownbit.solrspring.service.api;

import org.ownbit.solrspring.entities.SolrUserEntity;

/**
 * The Interface UserServiceIF.
 */
public interface UserServiceIF {

	/**
	 * Creates the new user.
	 *
	 * @param solrUserEntity the solr user entity
	 * @return true, if successful
	 */
	public boolean createNewUser(SolrUserEntity solrUserEntity);

	/**
	 * Gets the user entity.
	 *
	 * @param userId the user id
	 * @return the user entity
	 */
	public SolrUserEntity getUserEntity(String userId);

	/**
	 * Delete all records.
	 */
	public void deleteAllRecords();
}
