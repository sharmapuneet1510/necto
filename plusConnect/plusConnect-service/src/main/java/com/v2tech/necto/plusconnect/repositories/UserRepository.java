/** 
 * <br> @Author         : puneetsharma
 * <br> @createdDate    : 02-Oct-2015
 * <br> @createdTime    : 3:25:19 am
 * <br> @Description    :
 */
package com.v2tech.necto.plusconnect.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.v2tech.necto.plusconnect.entity.bo.User;

/**
 * <br>
 * 
 * @Author : puneetsharma <br>
 * @createdDate : 02-Oct-2015 <br>
 * @createdTime : 3:25:19 am <br>
 * @Description : <br>
 */
@Repository
public interface UserRepository extends CrudRepository<User, String>
	{
		User findByUsername(String username);

		User findByUserId(String userId);

		User findByUsernameOrEmailIdOrMobileNumber(String username, String emailId, String mobileNumber);

		User findByUsernameOrEmailId(String username, String emailId);

		User findByUsernameOrMobileNumber(String username, String mobileNumber);

	}
