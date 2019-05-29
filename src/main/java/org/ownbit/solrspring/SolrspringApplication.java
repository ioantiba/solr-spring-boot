package org.ownbit.solrspring;

import org.ownbit.solrspring.config.BasicConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { BasicConstants.SOLR_BASE_PACKAGES })
public class SolrspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolrspringApplication.class, args);
	}
}
