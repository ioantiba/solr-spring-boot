package org.ownbit.solrspring.entities;

import org.apache.solr.client.solrj.beans.Field;
import org.ownbit.solrspring.fields.SolrDataFields;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class SolrRoleEntity.
 */
public class SolrRoleEntity extends SolrBaseEntity {

	/** The role name. */
	@Field(SolrDataFields.ROLE_NAME_FIELD)
	@Getter @Setter
	protected String roleName;
}
