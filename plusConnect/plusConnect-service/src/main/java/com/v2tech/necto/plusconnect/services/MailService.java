/** 
 * <br> @Author         : puneetsharma
 * <br> @createdDate    : 01-Oct-2015
 * <br> @createdTime    : 10:21:03 pm
 * <br> @Description    :
 */
package com.v2tech.necto.plusconnect.services;

import org.apache.commons.mail.EmailException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.v2tech.necto.plusconnect.entity.bo.RegistrationCode;
import com.v2tech.necto.plusconnect.entity.bo.User;

/**
 * <br>
 * 
 * @Author : puneetsharma <br>
 * @createdDate : 01-Oct-2015 <br>
 * @createdTime : 10:21:03 pm <br>
 * @Description : <br>
 */
public interface MailService
	{

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 01-Oct-2015 <br>
		 * @createdTime : 11:31:17 pm <br>
		 * @methodName : setConfirmRegistrationCodeMail <br>
		 * @methodPackage : com.v2tech.nacto.plusconnect.servies <br>
		 * @Description : <br>
		 * @StepsWithExplanation : <br>
		 * @TODO : <br>
		 * @param user
		 *            <br>
		 * @param registationCode
		 *            <br>
		 * @throws EmailException
		 *             <br>
		 * @throws JsonProcessingException
		 */
		void sendVerificationRegistrationCodeMail(User user, RegistrationCode registrationCode);

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 02-Oct-2015 <br>
		 * @createdTime : 2:58:13 am <br>
		 * @methodName : sendActivationMail <br>
		 * @methodPackage : com.v2tech.nacto.plusconnect.servies <br>
		 * @Description : <br>
		 * @StepsWithExplanation : <br>
		 * @TODO : <br>
		 * @param user
		 *            <br>
		 * @param registationCode
		 */
		void sendActivationMail(User user, RegistrationCode registrationCode);

	}
