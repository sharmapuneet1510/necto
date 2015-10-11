/** 
 * <br> @Author         : puneetsharma
 * <br> @createdDate    : 02-Oct-2015
 * <br> @createdTime    : 11:06:03 pm
 * <br> @Description    :
 */
package com.v2tech.necto.plusconnect.entity.bo;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * <br>
 * 
 * @Author : puneetsharma <br>
 * @createdDate : 02-Oct-2015 <br>
 * @createdTime : 11:06:03 pm <br>
 * @Description : <br>
 */
@NodeEntity
public class Contact
	{
		@GraphId
		private Long contactId;
		private String parentUserId;
		private String emailId;
		private String mobileNumber;
		private boolean isMobile;

		public Long getContactId()
			{
				return contactId;
			}

		public void setContactId(final Long contactId)
			{
				this.contactId = contactId;
			}

		public String getParentUserId()
			{
				return parentUserId;
			}

		public void setParentUserId(final String parentUserId)
			{
				this.parentUserId = parentUserId;
			}

		public String getEmailId()
			{
				return emailId;
			}

		public void setEmailId(final String emailId)
			{
				this.emailId = emailId;
			}

		public String getMobileNumber()
			{
				return mobileNumber;
			}

		public void setMobileNumber(final String mobileNumber)
			{
				this.mobileNumber = mobileNumber;
			}

		public boolean isMobile()
			{
				return isMobile;
			}

		public void setMobile(final boolean isMobile)
			{
				this.isMobile = isMobile;
			}

		public Contact(final String parentUserId, final String emailId, final String mobileNumber, final boolean isMobile)
			{
				super();
				this.parentUserId = parentUserId;
				this.emailId = emailId;
				this.mobileNumber = mobileNumber;
				this.isMobile = isMobile;
			}

		public Contact()
			{
				super();
			}

	}
