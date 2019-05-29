package org.ownbit.solrspring.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient.Builder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.data.solr.server.support.HttpSolrClientFactory;

/**
 * SOLR Context configuration.
 *
 * @author tibaio
 * @since 10.10.2017
 */
@Configuration
@EnableSolrRepositories(basePackages = { BasicConstants.SOLR_REPOSITORIES_BASE_PACKAGES })
public class SolrContext {

	/** The solr host. */
	@Value("${" + BasicConstants.CONF_KEY_SOLR_HOST + "}")
	private String solrHost;

	/** The Constant COLLECTION_BASIC. */
	public static final String COLLECTION_BASIC = "basic";

	/** The Constant COLLECTION_DYNAMIC. */
	public static final String COLLECTION_DYNAMIC = "dynamic";

	/**
	 * Solr template.
	 *
	 * @return the solr template
	 * @throws SolrServerException the solr server exception
	 */
	@Bean
	public SolrTemplate solrTemplate() throws SolrServerException {
		return new SolrTemplate(new HttpSolrClientFactory(solrClient()));
	}

	/**
	 * Solr client.
	 *
	 * @return the solr client
	 * @throws SolrServerException the solr server exception
	 */
	private SolrClient solrClient() throws SolrServerException {
		if (StringUtils.isNotEmpty(solrHost)) {
			return new Builder().withBaseSolrUrl(solrHost).build();
		} else {
			throw new SolrServerException(
					"SOLR Server is not defined. Check application.properties file for property key: " + solrHost);
		}
	}
}
