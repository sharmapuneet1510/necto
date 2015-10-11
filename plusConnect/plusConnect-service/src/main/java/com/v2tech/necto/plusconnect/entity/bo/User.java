/** 
 * <br> @Author         : puneetsharma
 * <br> @createdDate    : 01-Oct-2015
 * <br> @createdTime    : 6:49:46 pm
 * <br> @Description    :
 */
package com.v2tech.necto.plusconnect.entity.bo;

import java.util.LinkedHashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * <br>
 * 
 * @Author : puneetsharma <br>
 * @createdDate : 01-Oct-2015 <br>
 * @createdTime : 6:49:46 pm <br>
 * @Description : <br>
 */
@NodeEntity
public class User
	{

		@GraphId
		private Long id;
		private String userId;
		private String username;
		private String reqion;
		private String countryCode;
		private String mobileNumber;
		private String emailId;
		private String password;
		private boolean isMobile;
		private boolean isVerified = false;
		private String screenName;
		private Long timeStamp;
		private boolean isDefaultPassword = true;
		private Long numberOfLogin = 0L;
		private Long numberOfInvalidLogin = 0L;
		private boolean isBasicProfileSet = false;
		private String summary;
		@Relationship(type = "KNOWS", direction = Relationship.UNDIRECTED)
		private Set<User> knows = new LinkedHashSet<User>();
		@Relationship(type = "WORKED_FOR", direction = Relationship.UNDIRECTED)
		private Set<Company> workedFor = new LinkedHashSet<Company>();
		@Relationship(type = "IN_TRUSTED_NETWORK", direction = Relationship.UNDIRECTED)
		private Set<User> trustedNetwork = new LinkedHashSet<User>();
		@Relationship(type = "REFERRED_FOR", direction = Relationship.UNDIRECTED)
		private Set<Referral> referrals = new LinkedHashSet<Referral>();
		@Relationship(type = "INVITED", direction = Relationship.UNDIRECTED)
		private Set<Invitation> invitations = new LinkedHashSet<Invitation>();

		public String getUserId()
			{
				return userId;
			}

		public void setUserId(final String userId)
			{
				this.userId = userId;
			}

		public String getUsername()
			{
				return username;
			}

		public void setUsername(final String username)
			{
				this.username = username;
			}

		public String getReqion()
			{
				return reqion;
			}

		public void setReqion(final String reqion)
			{
				this.reqion = reqion;
			}

		public String getCountryCode()
			{
				return countryCode;
			}

		public void setCountryCode(final String countryCode)
			{
				this.countryCode = countryCode;
			}

		public String getMobileNumber()
			{
				return mobileNumber;
			}

		public void setMobileNumber(final String mobileNumber)
			{
				this.mobileNumber = mobileNumber;
			}

		public String getEmailId()
			{
				return emailId;
			}

		public void setEmailId(final String emailId)
			{
				this.emailId = emailId;
			}

		public String getPassword()
			{
				return password;
			}

		public void setPassword(final String password)
			{
				this.password = password;
			}

		public boolean isMobile()
			{
				return isMobile;
			}

		public void setMobile(final boolean isMobile)
			{
				this.isMobile = isMobile;
			}

		public boolean isVerified()
			{
				return isVerified;
			}

		public void setVerified(final boolean isVerified)
			{
				this.isVerified = isVerified;
			}

		public String getScreenName()
			{
				return screenName;
			}

		public void setScreenName(final String screenName)
			{
				this.screenName = screenName;
			}

		public Long getTimeStamp()
			{
				return timeStamp;
			}

		public void setTimeStamp(final Long timeStamp)
			{
				this.timeStamp = timeStamp;
			}

		public boolean isDefaultPassword()
			{
				return isDefaultPassword;
			}

		public void setDefaultPassword(final boolean isDefaultPassword)
			{
				this.isDefaultPassword = isDefaultPassword;
			}

		public Long getNumberOfLogin()
			{
				return numberOfLogin;
			}

		public void setNumberOfLogin(final Long numberOfLogin)
			{
				this.numberOfLogin = numberOfLogin;
			}

		public boolean isBasicProfileSet()
			{
				return isBasicProfileSet;
			}

		public void setBasicProfileSet(final boolean isBasicProfileSet)
			{
				this.isBasicProfileSet = isBasicProfileSet;
			}

		public Long getId()
			{
				return id;
			}

		public void setId(final Long id)
			{
				this.id = id;
			}

		public User(final String userId, final String username, final String reqion, final String countryCode, final String mobileNumber, final String emailId, final String password, final boolean isMobile, final String screenName)
			{
				super();
				this.userId = userId;
				this.username = username;
				this.reqion = reqion;
				this.countryCode = countryCode;
				this.mobileNumber = mobileNumber;
				this.emailId = emailId;
				this.password = password;
				this.isMobile = isMobile;
				this.screenName = screenName;

			}

		public User(final String username, final String reqion, final String countryCode, final String mobileNumber, final String emailId, final boolean isMobile, final String screenName)
			{
				super();
				this.username = username;
				this.reqion = reqion;
				this.countryCode = countryCode;
				this.mobileNumber = mobileNumber;
				this.emailId = emailId;
				this.isMobile = isMobile;
				this.screenName = screenName;
			}

		public User()
			{
				super();
			}

		public Long getNumberOfInvalidLogin()
			{
				return numberOfInvalidLogin;
			}

		public void setNumberOfInvalidLogin(final Long numberOfInvalidLogin)
			{
				this.numberOfInvalidLogin = numberOfInvalidLogin;
			}

		public String getSummary()
			{
				return summary;
			}

		public void setSummary(final String summary)
			{
				this.summary = summary;
			}

		public Set<User> getKnows()
			{
				return knows;
			}

		public void setKnows(final Set<User> knows)
			{
				this.knows = knows;
			}

	}
