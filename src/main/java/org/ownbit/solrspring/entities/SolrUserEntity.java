package org.ownbit.solrspring.entities;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.beans.Field;
import org.ownbit.solrspring.config.SolrContext;
import org.ownbit.solrspring.fields.SolrDataFields;
import org.springframework.data.solr.core.mapping.SolrDocument;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class SolrBaseEntity.
 */
@SolrDocument(collection = SolrContext.COLLECTION_DYNAMIC)
public class SolrUserEntity extends SolrBaseEntity {

  /** The user name. */
  @Field(SolrDataFields.USERNAME_FIELD)
  @Getter @Setter
  private String userName;

  /** The password. */
  @Field(SolrDataFields.PASSWORD_FIELD)
  @Getter @Setter
  private String password;

  /** The full name. */
  @Field(SolrDataFields.FULLNAME_FIELD)
  @Getter @Setter
  private String fullName;

  /** The user datails. */
  @Field(child = true)
  @Getter @Setter
  private SolrUserDetailsEntity userDatails = new SolrUserDetailsEntity();

  /** The roles. */
  @Field(child = true)
  @Getter @Setter
  private List<SolrRoleEntity> roles = new ArrayList<SolrRoleEntity>();
}
