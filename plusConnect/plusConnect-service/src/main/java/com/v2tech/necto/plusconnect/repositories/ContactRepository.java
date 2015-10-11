/** 
 * <br> @Author         : puneetsharma
 * <br> @createdDate    : 03-Oct-2015
 * <br> @createdTime    : 12:49:40 pm
 * <br> @Description    :
 */
package com.v2tech.necto.plusconnect.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.v2tech.necto.plusconnect.entity.bo.Contact;

/**
 * <br>
 * 
 * @Author : puneetsharma <br>
 * @createdDate : 03-Oct-2015 <br>
 * @createdTime : 12:49:40 pm <br>
 * @Description : <br>
 */
public interface ContactRepository extends CrudRepository<Contact, String>
	{
		List<Contact> findByParentUserId(String parentuserid);

	}
