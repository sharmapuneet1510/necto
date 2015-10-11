/** 
 * <br> @Author         : puneetsharma
 * <br> @createdDate    : 03-Oct-2015
 * <br> @createdTime    : 12:15:51 pm
 * <br> @Description    :
 */
package com.v2tech.necto.plusconnect.entity.bo;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * <br>
 * 
 * @Author : puneetsharma <br>
 * @createdDate : 03-Oct-2015 <br>
 * @createdTime : 12:15:51 pm <br>
 * @Description : <br>
 */
@NodeEntity
public class RegistrationCode
	{

		@GraphId
		private Long registrationCodeId;
		private String screenName;
		private String userId;
		private String registrationCode;

		public Long getRegistrationCodeId()
			{
				return registrationCodeId;
			}

		public void setRegistrationCodeId(final Long registrationCodeId)
			{
				this.registrationCodeId = registrationCodeId;
			}

		public String getRegistrationCode()
			{
				return registrationCode;
			}

		public void setRegistrationCode(final String registrationCode)
			{
				this.registrationCode = registrationCode;
			}

		public String getScreenName()
			{
				return screenName;
			}

		public void setScreenName(final String screenName)
			{
				this.screenName = screenName;
			}

		public String getUserId()
			{
				return userId;
			}

		public void setUserId(final String userId)
			{
				this.userId = userId;
			}

		public RegistrationCode(final String screenName, final String userId, final String registrationCode)
			{
				super();
				this.screenName = screenName;
				this.userId = userId;
				this.registrationCode = registrationCode;
			}

		public RegistrationCode()
			{
				super();
			}

	}
