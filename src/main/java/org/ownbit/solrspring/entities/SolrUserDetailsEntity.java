package org.ownbit.solrspring.entities;

import org.apache.solr.client.solrj.beans.Field;
import org.ownbit.solrspring.fields.SolrDataFields;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class SolrBaseEntity.
 */
public class SolrUserDetailsEntity extends SolrBaseEntity {

	/** The city. */
	@Field(SolrDataFields.CITY_FIELD)
	@Getter @Setter
	private String city;

	/** The country. */
	@Field(SolrDataFields.COUNTRY_FIELD)
	@Getter @Setter
	private String country;

	/** The age. */
	@Field(SolrDataFields.AGE_FIELD)
	@Getter @Setter
	private String age;
}
