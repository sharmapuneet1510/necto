/** 
 * <br> @Author         : puneetsharma
 * <br> @createdDate    : 03-Oct-2015
 * <br> @createdTime    : 12:19:29 pm
 * <br> @Description    :
 */
package com.v2tech.necto.plusconnect.repositories;

import org.springframework.data.repository.CrudRepository;

import com.v2tech.necto.plusconnect.entity.bo.RegistrationCode;

/**
 * <br>
 * 
 * @Author : puneetsharma <br>
 * @createdDate : 03-Oct-2015 <br>
 * @createdTime : 12:19:29 pm <br>
 * @Description : <br>
 */
public interface RegistrationCodeRepository extends CrudRepository<RegistrationCode, String>
	{
		RegistrationCode findByUserIdAndRegistrationCode(String userId, String code);
	}
