package com.v2tech.necto.plusconnect.services;

import java.util.List;

import javax.ws.rs.core.Response;

import com.v2tech.necto.plusconnect.entity.bo.Contact;
import com.v2tech.necto.plusconnect.entity.bo.User;
import com.v2tech.necto.plusconnect.entity.bo.UserProfile;

public interface UserService
	{

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 01-Oct-2015 <br>
		 * @createdTime : 10:20:38 am <br>
		 * @methodName : saveUserProfile <br>
		 * @methodPackage : com.v2tech.nacto.plusconnect.servies <br>
		 * @Description : <br>
		 * @StepsWithExplanation : <br>
		 * @TODO : <br>
		 * @param userProfile
		 *            <br>
		 * @return
		 */
		UserProfile saveUserProfile(UserProfile userProfile);

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 01-Oct-2015 <br>
		 * @createdTime : 9:13:35 pm <br>
		 * @methodName : RegisterUser <br>
		 * @methodPackage : com.v2tech.nacto.plusconnect.servies <br>
		 * @Description : <br>
		 * @StepsWithExplanation : <br>
		 * @TODO : <br>
		 * @param user
		 *            <br>
		 * @return
		 */
		Response registerUser(User user);

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 02-Oct-2015 <br>
		 * @createdTime : 3:13:33 am <br>
		 * @methodName : confirmRegistration <br>
		 * @methodPackage : com.v2tech.nacto.plusconnect.servies <br>
		 * @Description : <br>
		 * @StepsWithExplanation : <br>
		 * @TODO : <br>
		 * @param userId
		 *            <br>
		 * @param reqistrationCode
		 *            <br>
		 * @return
		 */
		Response confirmRegistration(String userId, String reqistrationCode);

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 02-Oct-2015 <br>
		 * @createdTime : 10:11:05 pm <br>
		 * @methodName : authenticateUser <br>
		 * @methodPackage : com.v2tech.nacto.plusconnect.servies <br>
		 * @Description : <br>
		 * @StepsWithExplanation : <br>
		 * @TODO : <br>
		 * @param username
		 *            <br>
		 * @param password
		 *            <br>
		 * @return
		 */
		Response authenticateUser(String username, String password);

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 02-Oct-2015 <br>
		 * @createdTime : 10:47:05 pm <br>
		 * @methodName : updateUserEmail <br>
		 * @methodPackage : com.v2tech.nacto.plusconnect.servies <br>
		 * @Description : <br>
		 * @StepsWithExplanation : <br>
		 * @TODO : <br>
		 * @param username
		 *            <br>
		 * @param emailId
		 *            <br>
		 * @return
		 */
		Response updateEmailAddress(String username, String emailId);

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 02-Oct-2015 <br>
		 * @createdTime : 10:53:50 pm <br>
		 * @methodName : updatePassword <br>
		 * @methodPackage : com.v2tech.nacto.plusconnect.servies <br>
		 * @Description : <br>
		 * @StepsWithExplanation : <br>
		 * @TODO : <br>
		 * @param username
		 *            <br>
		 * @param password
		 *            <br>
		 * @return
		 */
		Response updatePassword(String username, String password);

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 02-Oct-2015 <br>
		 * @createdTime : 11:31:02 pm <br>
		 * @methodName : pushContacts <br>
		 * @methodPackage : com.v2tech.nacto.plusconnect.servies <br>
		 * @Description : <br>
		 * @StepsWithExplanation : <br>
		 * @TODO : <br>
		 * @param username
		 *            <br>
		 * @param contacts
		 *            <br>
		 * @return
		 */
		Response pushContacts(String username, List<Contact> contacts);

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 03-Oct-2015 <br>
		 * @createdTime : 7:22:13 am <br>
		 * @methodName : getAllContacts <br>
		 * @methodPackage : com.v2tech.nacto.plusconnect.servies <br>
		 * @Description : <br>
		 * @StepsWithExplanation : <br>
		 * @TODO : <br>
		 * @param username
		 *            <br>
		 * @return
		 */
		Response getAllContacts(String username);

	}
