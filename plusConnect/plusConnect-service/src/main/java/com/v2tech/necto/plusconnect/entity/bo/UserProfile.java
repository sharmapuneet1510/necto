package com.v2tech.necto.plusconnect.entity.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class UserProfile implements Serializable
	{

		private static final long serialVersionUID = -2731901061778716363L;
		@GraphId
		private Long userProfileId;
		private String userId;
		private String screenName;
		private String firstName;
		private String lastName;
		private String middleName;
		private String url;
		private String profileImageUrl;
		private String description;
		private String location;
		private Date createdDate;
		private Locale language;
		private int statusCount;
		private int friendsCount;
		private boolean isVerified;
		private boolean geoEnabled;
		private String timeZone;
		private String countryCode;
		private String group;
		private String summary;
		private Date dateOfBrith;
		private String workType;
		private String industry;
		private String profilePic;
		private boolean isBasicProficSet = false;
		private String emailAddress;
		private String gender;
		private String region;
		private String mobileNumber;

		public String getScreenName()
			{
				return screenName;
			}

		public void setScreenName(final String screenName)
			{
				this.screenName = screenName;
			}

		public String getFirstName()
			{
				return firstName;
			}

		public void setFirstName(final String firstName)
			{
				this.firstName = firstName;
			}

		public String getLastName()
			{
				return lastName;
			}

		public void setLastName(final String lastName)
			{
				this.lastName = lastName;
			}

		public String getMiddleName()
			{
				return middleName;
			}

		public void setMiddleName(final String middleName)
			{
				this.middleName = middleName;
			}

		public String getUrl()
			{
				return url;
			}

		public void setUrl(final String url)
			{
				this.url = url;
			}

		public String getProfileImageUrl()
			{
				return profileImageUrl;
			}

		public void setProfileImageUrl(final String profileImageUrl)
			{
				this.profileImageUrl = profileImageUrl;
			}

		public String getDescription()
			{
				return description;
			}

		public void setDescription(final String description)
			{
				this.description = description;
			}

		public String getLocation()
			{
				return location;
			}

		public void setLocation(final String location)
			{
				this.location = location;
			}

		public Date getCreatedDate()
			{
				return createdDate;
			}

		public void setCreatedDate(final Date createdDate)
			{
				this.createdDate = createdDate;
			}

		public Locale getLanguage()
			{
				return language;
			}

		public void setLanguage(final Locale language)
			{
				this.language = language;
			}

		public int getStatusCount()
			{
				return statusCount;
			}

		public void setStatusCount(final int statusCount)
			{
				this.statusCount = statusCount;
			}

		public int getFriendsCount()
			{
				return friendsCount;
			}

		public void setFriendsCount(final int friendsCount)
			{
				this.friendsCount = friendsCount;
			}

		public boolean isVerified()
			{
				return isVerified;
			}

		public void setVerified(final boolean isVerified)
			{
				this.isVerified = isVerified;
			}

		public boolean isGeoEnabled()
			{
				return geoEnabled;
			}

		public void setGeoEnabled(final boolean geoEnabled)
			{
				this.geoEnabled = geoEnabled;
			}

		public String getTimeZone()
			{
				return timeZone;
			}

		public void setTimeZone(final String timeZone)
			{
				this.timeZone = timeZone;
			}

		public static long getSerialversionuid()
			{
				return serialVersionUID;
			}

		public UserProfile(final Long userProfileId, final String screenName, final String firstName, final String lastName, final String middleName, final String url, final String profileImageUrl, final String description, final String location, final Date createdDate, final Locale language, final int statusCount, final int friendsCount, final boolean isVerified, final boolean geoEnabled, final String timeZone, final String countryCode, final String group, final String summary,
				final Date dateOfBrith, final String workType, final String industry, final String profilePic, final boolean isBasicProficSet, final String emailAddress, final String gender, final String region, final String mobileNumber)
			{
				super();
				this.userProfileId = userProfileId;
				this.screenName = screenName;
				this.firstName = firstName;
				this.lastName = lastName;
				this.middleName = middleName;
				this.url = url;
				this.profileImageUrl = profileImageUrl;
				this.description = description;
				this.location = location;
				this.createdDate = createdDate;
				this.language = language;
				this.statusCount = statusCount;
				this.friendsCount = friendsCount;
				this.isVerified = isVerified;
				this.geoEnabled = geoEnabled;
				this.timeZone = timeZone;
				this.countryCode = countryCode;
				this.group = group;
				this.summary = summary;
				this.dateOfBrith = dateOfBrith;
				this.workType = workType;
				this.industry = industry;
				this.profilePic = profilePic;
				this.isBasicProficSet = isBasicProficSet;
				this.emailAddress = emailAddress;
				this.gender = gender;
				this.region = region;
				this.mobileNumber = mobileNumber;
			}

		public Long getUserProfileId()
			{
				return userProfileId;
			}

		public void setUserProfileId(final Long userProfileId)
			{
				this.userProfileId = userProfileId;
			}

		public String getCountryCode()
			{
				return countryCode;
			}

		public void setCountryCode(final String countryCode)
			{
				this.countryCode = countryCode;
			}

		public String getGroup()
			{
				return group;
			}

		public void setGroup(final String group)
			{
				this.group = group;
			}

		public String getSummary()
			{
				return summary;
			}

		public void setSummary(final String summary)
			{
				this.summary = summary;
			}

		public Date getDateOfBrith()
			{
				return dateOfBrith;
			}

		public void setDateOfBrith(final Date dateOfBrith)
			{
				this.dateOfBrith = dateOfBrith;
			}

		public String getWorkType()
			{
				return workType;
			}

		public void setWorkType(final String workType)
			{
				this.workType = workType;
			}

		public String getIndustry()
			{
				return industry;
			}

		public void setIndustry(final String industry)
			{
				this.industry = industry;
			}

		public String getProfilePic()
			{
				return profilePic;
			}

		public void setProfilePic(final String profilePic)
			{
				this.profilePic = profilePic;
			}

		public boolean isBasicProficSet()
			{
				return isBasicProficSet;
			}

		public void setBasicProficSet(final boolean isBasicProficSet)
			{
				this.isBasicProficSet = isBasicProficSet;
			}

		public String getEmailAddress()
			{
				return emailAddress;
			}

		public void setEmailAddress(final String emailAddress)
			{
				this.emailAddress = emailAddress;
			}

		public String getGender()
			{
				return gender;
			}

		public void setGender(final String gender)
			{
				this.gender = gender;
			}

		public String getRegion()
			{
				return region;
			}

		public void setRegion(final String region)
			{
				this.region = region;
			}

		public String getMobileNumber()
			{
				return mobileNumber;
			}

		public void setMobileNumber(final String mobileNumber)
			{
				this.mobileNumber = mobileNumber;
			}

		public UserProfile()
			{
				super();
			}

		public String getUserId()
			{
				return userId;
			}

		public void setUserId(final String userId)
			{
				this.userId = userId;
			}

	}
