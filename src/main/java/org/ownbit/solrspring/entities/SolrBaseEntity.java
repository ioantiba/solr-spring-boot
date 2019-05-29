package org.ownbit.solrspring.entities;

import org.apache.solr.client.solrj.beans.Field;
import org.ownbit.solrspring.fields.SolrDataCommonFields;
import org.ownbit.solrspring.fields.SolrDataFields;
import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class SolrBaseEntity.
 */
public class SolrBaseEntity {

	/** Id of the document. */
	@Id
	@Field(SolrDataCommonFields.ID_FIELD)
	@Getter @Setter
	protected String id;

	/** Type of the document. */
	@Field(SolrDataCommonFields.DOCTYPE_FIELD)
	@Getter @Setter
	protected String docType;

	/** The entity type. */
	@Field(SolrDataFields.ENTITY_TYPE_FIELD)
	@Getter @Setter
	protected String entityType;
}
