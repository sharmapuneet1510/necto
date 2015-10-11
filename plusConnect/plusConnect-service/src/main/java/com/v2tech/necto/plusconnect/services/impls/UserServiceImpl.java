package com.v2tech.necto.plusconnect.services.impls;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.cxf.jaxrs.impl.ResponseBuilderImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.v2tech.necto.plusconnect.entity.bo.Contact;
import com.v2tech.necto.plusconnect.entity.bo.RegistrationCode;
import com.v2tech.necto.plusconnect.entity.bo.User;
import com.v2tech.necto.plusconnect.entity.bo.UserProfile;
import com.v2tech.necto.plusconnect.entity.exceptions.GenericExceptionMessage;
import com.v2tech.necto.plusconnect.entity.exceptions.PlusConnectServiceException;
import com.v2tech.necto.plusconnect.repositories.ContactRepository;
import com.v2tech.necto.plusconnect.repositories.RegistrationCodeRepository;
import com.v2tech.necto.plusconnect.repositories.UserProfileRepository;
import com.v2tech.necto.plusconnect.repositories.UserRepository;
import com.v2tech.necto.plusconnect.services.MailService;
import com.v2tech.necto.plusconnect.services.UserService;

/**
 * <br>
 * 
 * @Author : puneetsharma <br>
 * @createdDate : 01-Oct-2015 <br>
 * @createdTime : 10:00:35 am <br>
 * @Description : <br>
 */
@Service("userService")
public class UserServiceImpl implements UserService
	{

		@Autowired
		private UserProfileRepository userProfileRepository;

		@Autowired
		private MailService mailService;

		@Autowired
		private UserRepository userRepository;

		@Autowired
		private RegistrationCodeRepository registrationCodeRepository;

		@Autowired
		private ContactRepository contactRepository;

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 01-Oct-2015 <br>
		 * @createdTime : 10:20:19 am <br>
		 * @methodName : saveUserProfile <br>
		 * @methodPackage : com.v2tech.nacto.plusconnect.servies.impls <br>
		 * @Description : <br>
		 * @StepsWithExplanation : <br>
		 * @TODO : <br>
		 * @param userProfile
		 *            <br>
		 * @return
		 */
		@Override
		@Transactional
		public UserProfile saveUserProfile(final UserProfile userProfile)
			{
				try
					{
						return userProfileRepository.save(userProfile);
					}
				catch (Exception e)
					{
						String message = GenericExceptionMessage.UNABLE_TO_PERSIST + "UserProfile";
						throw new PlusConnectServiceException(message, e);
					}
			}

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 01-Oct-2015 <br>
		 * @createdTime : 9:13:23 pm <br>
		 * @methodName : RegisterUser <br>
		 * @methodPackage : com.v2tech.nacto.plusconnect.servies.impls <br>
		 * @Description : <br>
		 * @StepsWithExplanation : <br>
		 * @TODO : <br>
		 * @param user
		 *            <br>
		 * @return
		 */
		@Override
		public Response registerUser(final User user)
			{
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				String username = null;
				String message = null;
				String emailId = null;
				String mobileNumber = null;
				User existingUser = null;

				if (user.isMobile() == true)
					{
						username = user.getMobileNumber();
						mobileNumber = user.getMobileNumber();
						emailId = user.getEmailId();
						if ((emailId == null) || (emailId.trim().length() > 0))
							{
								mobileNumber = mobileNumber.trim().toLowerCase();
								emailId = emailId.trim().toLowerCase();
								username = username.trim().toLowerCase();
								existingUser = userRepository.findByUsernameOrEmailIdOrMobileNumber(username, emailId, mobileNumber);
							}
						else
							{
								mobileNumber = mobileNumber.trim().toLowerCase();
								username = username.trim().toLowerCase();
								existingUser = userRepository.findByUsernameOrMobileNumber(username, mobileNumber);
							}
					}
				else
					{
						username = user.getEmailId();
						emailId = user.getEmailId();
						mobileNumber = user.getMobileNumber();
						if ((mobileNumber == null) || (mobileNumber.trim().length() > 0))
							{
								mobileNumber = mobileNumber.trim().toLowerCase();
								emailId = emailId.trim().toLowerCase();
								username = username.trim().toLowerCase();
								existingUser = userRepository.findByUsernameOrEmailIdOrMobileNumber(username, emailId, mobileNumber);
							}
						else
							{
								emailId = emailId.trim().toLowerCase();
								username = username.trim().toLowerCase();
								existingUser = userRepository.findByUsernameOrEmailId(username, emailId);
							}
					}
				if (existingUser != null)
					{
						message = "User Already Exist";
						responseBuilder.status(Status.NOT_ACCEPTABLE);
						responseBuilder.entity(new String(message));
						return responseBuilder.build();
					}
				String userId = "" + UUID.randomUUID();
				String password = RandomStringUtils.randomAlphanumeric(10);
				user.setTimeStamp(System.currentTimeMillis());
				user.setDefaultPassword(true);
				user.setUserId(userId);
				userRepository.save(user);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("username", username);
				jsonObject.put("password", password);
				jsonObject.put("userId", userId);
				responseBuilder.entity(jsonObject);
				String code = RandomStringUtils.randomAlphanumeric(25);
				RegistrationCode registrationCode = new RegistrationCode(user.getScreenName(), userId, code);
				registrationCodeRepository.save(registrationCode);
				mailService.sendVerificationRegistrationCodeMail(user, registrationCode);
				return responseBuilder.build();
			}

		@Override
		public Response confirmRegistration(final String userId, final String code)
			{
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				RegistrationCode registrationCode = registrationCodeRepository.findByUserIdAndRegistrationCode(userId, code);
				if (registrationCode != null)
					{
						User user = userRepository.findByUserId(userId);
						user.setVerified(true);
						user.setTimeStamp(System.currentTimeMillis());
						userRepository.save(user);
						mailService.sendActivationMail(user, registrationCode);
						responseBuilder.status(Status.OK);
						Response response = responseBuilder.build();
						return response;
					}
				else
					{
						String message = "Invalid UserId or VerificationToken";
						responseBuilder.status(Status.NOT_FOUND);
						responseBuilder.entity(new String(message));
						return responseBuilder.build();
					}
			}

		@Override
		public Response authenticateUser(final String username, final String password)
			{

				User user = userRepository.findByUsername(username.toLowerCase().trim());
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				JSONObject jsonObject = new JSONObject();
				if (user == null)
					{
						responseBuilder.status(Status.NOT_FOUND);
						jsonObject.put("isError", true);
						jsonObject.put("exception", "User :" + username + " Not Registered");
						responseBuilder.entity(jsonObject);
						return responseBuilder.build();
					}
				String m_password = user.getPassword();
				if (m_password.equals(password) == true)
					{
						if (user.isDefaultPassword())
							{
								Long startTime = user.getTimeStamp() + ((35) * 60000);
								Long currentTime = System.currentTimeMillis();
								if (startTime > currentTime)
									{
										responseBuilder.status(Status.UNAUTHORIZED);
										jsonObject.put("status", "ERROR");
										jsonObject.put("userId", user.getUserId());
										jsonObject.put("email", user.getEmailId());
										jsonObject.put("username", username);
										jsonObject.put("mobile", user.getMobileNumber());
										jsonObject.put("isError", true);
										jsonObject.put("exception", "Defualt Password for Username : " + username + " Expired");
										responseBuilder.entity(jsonObject);
										return responseBuilder.build();
									}
								if (user.getNumberOfLogin() > 1)
									{
										responseBuilder.status(Status.UNAUTHORIZED);
										jsonObject.put("status", "ERROR");
										jsonObject.put("userId", user.getUserId());
										jsonObject.put("email", user.getEmailId());
										jsonObject.put("username", username);
										jsonObject.put("mobile", user.getMobileNumber());
										jsonObject.put("isError", true);
										jsonObject.put("exception", "Defualt Password can be used only once.");
										responseBuilder.entity(jsonObject);
										return responseBuilder.build();
									}
							}

						if (user.isBasicProfileSet())
							{
								responseBuilder.status(Status.FOUND);
								jsonObject.put("status", "SUCCESS");
								jsonObject.put("userId", user.getUserId());
								jsonObject.put("email", user.getEmailId());
								jsonObject.put("username", username);
								jsonObject.put("mobile", user.getMobileNumber());
								jsonObject.put("isError", false);
								jsonObject.put("message", "basic Profile Not Set");
								responseBuilder.entity(jsonObject);
								return responseBuilder.build();
							}
						else
							{
								user.setNumberOfLogin(user.getNumberOfLogin() + 1);
								userRepository.save(user);
								responseBuilder.status(Status.OK);
								jsonObject.put("message", "NO ERROR, OPERATION SUCCESSFUL - DURING UPDATES");
								jsonObject.put("status", "SUCCESS");
								jsonObject.put("userId", user.getUserId());
								jsonObject.put("email", user.getEmailId());
								jsonObject.put("username", username);
								jsonObject.put("mobile", user.getMobileNumber());
								responseBuilder.entity(jsonObject);
								return responseBuilder.build();
							}
					}
				else
					{
						responseBuilder.status(Status.UNAUTHORIZED);
						jsonObject.put("status", "ERROR");
						jsonObject.put("userId", user.getUserId());
						jsonObject.put("email", user.getEmailId());
						jsonObject.put("username", username);
						jsonObject.put("mobile", user.getMobileNumber());
						jsonObject.put("isError", true);
						jsonObject.put("exception", "Invalid Password for Username : " + username);
						responseBuilder.entity(jsonObject);
						return responseBuilder.build();
					}
			}

		@Override
		public Response updateEmailAddress(final String username, final String emailAddress)
			{
				User user = userRepository.findByUsername(username.toLowerCase().trim());
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				JSONObject jsonObject = new JSONObject();
				if (user == null)
					{
						responseBuilder.status(Status.NOT_FOUND);
						jsonObject.put("isError", true);
						jsonObject.put("exception", "User :" + username + " Not Registered");
						responseBuilder.entity(jsonObject);
						return responseBuilder.build();
					}
				if (user.isVerified() == false)
					{
						responseBuilder.status(Status.UNAUTHORIZED);
						jsonObject.put("isError", true);
						jsonObject.put("exception", "User Verification Pending");
						responseBuilder.entity(jsonObject);
						return responseBuilder.build();
					}
				user.setEmailId(emailAddress);
				userRepository.save(user);
				responseBuilder.status(Status.OK);
				jsonObject.put("message", "NO ERROR, OPERATION SUCCESSFUL - DURING UPDATES");
				jsonObject.put("status", "SUCCESS");
				jsonObject.put("username", username);
				responseBuilder.entity(jsonObject);
				return responseBuilder.build();
			}

		@Override
		public Response updatePassword(final String username, final String password)
			{
				User user = userRepository.findByUsername(username.toLowerCase().trim());
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				JSONObject jsonObject = new JSONObject();
				if (user == null)
					{
						responseBuilder.status(Status.NOT_FOUND);
						jsonObject.put("isError", true);
						jsonObject.put("exception", "User :" + username + " Not Registered");
						responseBuilder.entity(jsonObject);
						return responseBuilder.build();
					}
				if (user.isVerified() == false)
					{
						responseBuilder.status(Status.UNAUTHORIZED);
						jsonObject.put("isError", true);
						jsonObject.put("exception", "User Verification Pending");
						responseBuilder.entity(jsonObject);
						return responseBuilder.build();
					}
				user.setPassword(password);
				user.setDefaultPassword(false);
				userRepository.save(user);
				responseBuilder.status(Status.OK);
				jsonObject.put("message", "NO ERROR, OPERATION SUCCESSFUL - DURING UPDATES");
				jsonObject.put("status", "SUCCESS");
				jsonObject.put("username", username);
				responseBuilder.entity(jsonObject);
				return responseBuilder.build();
			}

		@Override
		@Transactional
		public Response pushContacts(final String username, final List<Contact> contacts)
			{
				User user = userRepository.findByUsername(username.toLowerCase().trim());
				Response response = getUserNameVerificationResponse(user, username);
				if (response != null)
					{
						return response;
					}
				else
					{
						contactRepository.save(contacts);
						//List<Contact> existingContacts = user.getContacts();
						//existingContacts.addAll(contacts);
						//user.setContacts(existingContacts);
						userRepository.save(user);
						ResponseBuilder responseBuilder = new ResponseBuilderImpl();
						JSONObject jsonObject = new JSONObject();
						responseBuilder.status(Status.OK);
						jsonObject.put("message", "NO ERROR, OPERATION SUCCESSFUL - DURING UPDATES");
						jsonObject.put("status", "SUCCESS");
						jsonObject.put("username", username);
						responseBuilder.entity(jsonObject);
						return responseBuilder.build();
					}
			}

		private User verifyUser(final String username)
			{
				User user = userRepository.findByUsername(username.toLowerCase().trim());
				return user;
			}

		private Response getUserNameVerificationResponse(final User user, final String username)
			{
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				JSONObject jsonObject = new JSONObject();
				if (user == null)
					{
						responseBuilder.status(Status.NOT_FOUND);
						jsonObject.put("isError", true);
						jsonObject.put("exception", "User :" + username + " Not Registered");
						responseBuilder.entity(jsonObject);
						return responseBuilder.build();
					}
				if (user.isVerified() == false)
					{
						responseBuilder.status(Status.UNAUTHORIZED);
						jsonObject.put("isError", true);
						jsonObject.put("exception", "User Verification Pending");
						responseBuilder.entity(jsonObject);
						return responseBuilder.build();
					}
				return null;
			}

		@Override
		public Response getAllContacts(final String username)
			{
				User user = verifyUser(username);
				Response response = getUserNameVerificationResponse(user, username);
				if (response != null)
					{
						return response;
					}
				else
					{
						List<Contact> contacts = null;//user.getContacts();
						System.out.println(contacts.size());
						ResponseBuilder responseBuilder = new ResponseBuilderImpl();
						JSONObject jsonObject = new JSONObject();
						JSONObject jsonObjectInner = new JSONObject();
						jsonObjectInner.put("contacts", contacts);
						jsonObject.put("data", jsonObjectInner);
						responseBuilder.status(Status.OK);
						jsonObject.put("message", "NO ERROR, OPERATION SUCCESSFUL - DURING UPDATES");
						jsonObject.put("status", "SUCCESS");
						jsonObject.put("username", username);
						responseBuilder.entity(jsonObject);
						return responseBuilder.build();

					}
			}
	}
