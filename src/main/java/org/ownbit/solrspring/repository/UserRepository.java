package org.ownbit.solrspring.repository;

import org.ownbit.solrspring.entities.SolrUserEntity;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends SolrCrudRepository<SolrUserEntity, String> {

   @Query(fields = {"*", "[child parentFilter=entity_type:root]"})
   // @Query(fields = {"*", "[child parentFilter=entity_type:root childFilter=id:user1*]"})
   SolrUserEntity findUserById(String userId);
   
   //@Query(value = "name:Ioan", fields = {"*", "[child parentFilter=name:Ioan]"})
   //Iterable<ObjectY> findAllObjectXWithObjectY();
   
   //@Query(fields = {"*", "[child parentFilter=type_s:root]"})
   //ObjectX findObjectXWithObjectYById(String id);
}