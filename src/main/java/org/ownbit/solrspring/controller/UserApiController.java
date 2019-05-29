package org.ownbit.solrspring.controller;

import org.ownbit.solrspring.entities.SolrRoleEntity;
import org.ownbit.solrspring.entities.SolrUserEntity;
import org.ownbit.solrspring.generated.api.UserApi;
import org.ownbit.solrspring.generated.model.RolesResponseDTO;
import org.ownbit.solrspring.generated.model.UserDataDTO;
import org.ownbit.solrspring.generated.model.UserRequestDTO;
import org.ownbit.solrspring.generated.model.UserResponseDTO;
import org.ownbit.solrspring.generated.model.UsersResponseDTO;
import org.ownbit.solrspring.service.api.UserServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserApiController implements UserApi {

	@Autowired
	UserServiceIF userService;

	@Override
	public ResponseEntity<Void> createUser(@RequestBody UserRequestDTO requestBody) {

		userService.deleteAllRecords();

		SolrUserEntity solrUserEntity = new SolrUserEntity();
		solrUserEntity.setId("user1");
		solrUserEntity.setDocType("test_object");
		solrUserEntity.setUserName("ioantiba");
		solrUserEntity.setPassword("admin123");
		solrUserEntity.setFullName("Ioan Tiba");
		solrUserEntity.setEntityType("root");

		// set user details
		solrUserEntity.getUserDatails().setId("user1_details");
		solrUserEntity.getUserDatails().setDocType("test_object"); // ?? or user_details
		solrUserEntity.getUserDatails().setAge("32");
		solrUserEntity.getUserDatails().setCity("Brasov");
		solrUserEntity.getUserDatails().setCountry("Romania");
		solrUserEntity.getUserDatails().setEntityType("child");

		SolrRoleEntity solrRoleEntity = new SolrRoleEntity();
		solrRoleEntity.setId("user1_role1");
		solrRoleEntity.setDocType("test_object"); // ?? or roles
		solrRoleEntity.setRoleName("ADMIN");
		solrRoleEntity.setEntityType("child");
		solrUserEntity.getRoles().add(solrRoleEntity); // add user roles

		solrRoleEntity = new SolrRoleEntity();
		solrRoleEntity.setId("user1_role2");
		solrRoleEntity.setDocType("test_object"); // ?? or roles
		solrRoleEntity.setRoleName("GUEST");
		solrRoleEntity.setEntityType("child");
		solrUserEntity.getRoles().add(solrRoleEntity); // add user roles

		boolean solrResponse = userService.createNewUser(solrUserEntity);

		if (solrResponse) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<RolesResponseDTO> getRoles() {
		return new ResponseEntity<RolesResponseDTO>(HttpStatus.OK);
	}

	@SuppressWarnings("static-access")
	@Override
	public ResponseEntity<UserResponseDTO> getUser(@PathVariable("userId") String userId) {
		log.info("Retrive User informations by id: " + userId);
		SolrUserEntity userEntity = userService.getUserEntity(userId);
		System.out.println(userEntity);
		UserResponseDTO userResponseDTO = new UserResponseDTO();
		userResponseDTO.setUser(new UserDataDTO());
		return new ResponseEntity<UserResponseDTO>(HttpStatus.OK).ok(userResponseDTO);
	}

	@Override
	public ResponseEntity<UsersResponseDTO> getUsers() {
		return new ResponseEntity<UsersResponseDTO>(HttpStatus.OK);
	}
}
