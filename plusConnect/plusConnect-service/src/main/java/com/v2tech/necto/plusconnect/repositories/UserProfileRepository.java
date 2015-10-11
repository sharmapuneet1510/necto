/** 
 * <br> @Author         : puneetsharma
 * <br> @createdDate    : 01-Oct-2015
 * <br> @createdTime    : 10:39:30 am
 * <br> @Description    :
 */
package com.v2tech.necto.plusconnect.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import com.v2tech.necto.plusconnect.entity.bo.UserProfile;

/**
 * <br>
 * 
 * @Author : puneetsharma <br>
 * @createdDate : 01-Oct-2015 <br>
 * @createdTime : 10:39:30 am <br>
 * @Description : <br>
 */
@Repository
public interface UserProfileRepository extends GraphRepository<UserProfile>
	{

	}
