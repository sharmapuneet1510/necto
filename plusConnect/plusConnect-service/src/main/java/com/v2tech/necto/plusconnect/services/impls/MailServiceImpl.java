/** 
 * <br> @Author         : puneetsharma
 * <br> @createdDate    : 01-Oct-2015
 * <br> @createdTime    : 10:21:22 pm
 * <br> @Description    :
 */
package com.v2tech.necto.plusconnect.services.impls;

import java.util.Date;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

import com.v2tech.necto.plusconnect.configuration.ConfigProperties;
import com.v2tech.necto.plusconnect.entity.bo.RegistrationCode;
import com.v2tech.necto.plusconnect.entity.bo.User;
import com.v2tech.necto.plusconnect.services.MailService;

/**
 * <br>
 * 
 * @Author : puneetsharma <br>
 * @createdDate : 01-Oct-2015 <br>
 * @createdTime : 10:21:22 pm <br>
 * @Description : <br>
 */
@Service("mailService")
public class MailServiceImpl implements MailService
	{
		org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MailServiceImpl.class);

		@Override
		public void sendVerificationRegistrationCodeMail(final User user, final RegistrationCode registrationCode)
			{
				String emailMessage = null;
				try
					{
						String hostName = ConfigProperties.getPropertyValue("hostName");
						String sendFrom = ConfigProperties.getPropertyValue("sendFrom");
						String sendFromPwd = ConfigProperties.getPropertyValue("sendFromPwd");
						String adminEmailToSentTo = ConfigProperties.getPropertyValue("adminEmailToSentTo");
						String sendFromName = ConfigProperties.getPropertyValue("sendFromName");
						Email email = new SimpleEmail();
						email.setHostName(hostName);
						email.setSentDate(new Date());
						email.addTo(user.getEmailId());
						email.addBcc(adminEmailToSentTo);
						email.setFrom(sendFrom, sendFromName);
						email.setSubject("Registration Verification Mail");
						emailMessage = "Hello " + user.getScreenName();
						emailMessage += "\n\nTo Activate Your Account, Please click on below link";
						String encodedRegistrationCode = org.apache.commons.codec.binary.Base64.encodeBase64String(registrationCode.getRegistrationCode().getBytes());
						String encodedUserId = org.apache.commons.codec.binary.Base64.encodeBase64String(registrationCode.getUserId().getBytes());
						emailMessage += "Verification Link : \n" + ConfigProperties.getPropertyValue("webServiceUrl") + "/" + "plusConnectWebService/activateUser?userId=" + encodedUserId + "&verificationToken=" + encodedRegistrationCode;
						emailMessage += "\n\n\nThanks & Regards \n+Connect Team";
						email.setMsg(emailMessage);
						email.setAuthenticator(new DefaultAuthenticator(sendFrom, sendFromPwd));
						email.setTLS(true);
						email.setTLS(true);
						email.send();
						logger.info("EMAIL ||-->> USER : " + user.getScreenName() + " || TYPE : REGISTRATION VERIFICATION || STATUS : SUCCESSFULL");
					}
				catch (Exception e)
					{
						String message = "EMAIL ||-->> USER : " + user.getScreenName() + " || TYPE : REGISTRATION VERIFICATION || STATUS : UNSUCCESSFULL";
						logger.error(message);
						throw new PlusConnectEmailNotificationException(message, e);
					}

			}

		@Override
		public void sendActivationMail(final User user, final RegistrationCode registrationCode)
			{
				String emailMessage = null;
				try
					{
						String hostName = ConfigProperties.getPropertyValue("hostName");
						String sendFrom = ConfigProperties.getPropertyValue("sendFrom");
						String sendFromPwd = ConfigProperties.getPropertyValue("sendFromPwd");
						String adminEmailToSentTo = ConfigProperties.getPropertyValue("adminEmailToSentTo");
						String sendFromName = ConfigProperties.getPropertyValue("sendFromName");
						Email email = new SimpleEmail();
						email.setHostName(hostName);
						email.setSentDate(new Date());
						email.addTo(user.getEmailId());
						email.addBcc(adminEmailToSentTo);
						email.setFrom(sendFrom, sendFromName);
						email.setSubject("Registration Activation Mail");
						emailMessage = "Hello " + user.getScreenName();
						emailMessage += "\n\nYour Verification Process Has Been Completed and Your +Connect Account has been Activated Successfully";
						emailMessage += "\nPlease Find Your OTP : " + user.getPassword();
						emailMessage += "\nNote : Your OTP Password will get expire in 30minute from now onwards , Hence please Change reset your password with 30minutes";
						emailMessage += "More over above password can only be used onced , after that it will get expired";
						emailMessage += "\n\n\nThanks & Regards \n+Connect Team";
						email.setMsg(emailMessage);
						email.setAuthenticator(new DefaultAuthenticator(sendFrom, sendFromPwd));
						email.setTLS(true);
						email.setTLS(true);
						email.send();
						logger.info("EMAIL ||-->> USER : " + user.getScreenName() + " || TYPE : REGISTRATION ACTIVATION || STATUS : SUCCESSFULL");
					}
				catch (Exception e)
					{
						String message = "EMAIL ||-->> USER : " + user.getScreenName() + " || TYPE : REGISTRATION ACTIVATION || STATUS : UNSUCCESSFULL";
						logger.error(message);
						throw new PlusConnectEmailNotificationException(message, e);
					}

			}
	}
