package org.ownbit.solrspring.fields;

/**
 * The Interface SolrDataFields.
 */
public interface SolrDataFields extends SolrDataCommonFields {

	/** The username field. */
	String USERNAME_FIELD = "username";

	/** The password field. */
	String PASSWORD_FIELD = "password";

	/** The fullname field. */
	String FULLNAME_FIELD = "fullname";

	/** The city field. */
	String CITY_FIELD = "city";

	/** The country field. */
	String COUNTRY_FIELD = "country";

	/** The age field. */
	String AGE_FIELD = "age";

	/** The role name field. */
	String ROLE_NAME_FIELD = "rolename";

	/**
	 * The entity type field, <br>
	 * This field is used as parentFilter that identifies all parents docs (can be:
	 * root or child)
	 */
	// used as parentFilter that identifies all parents docs (can be: root or child)
	String ENTITY_TYPE_FIELD = "entity_type";
}
