/**
 * <br> @Author         : puneetsharma
 * <br> @createdDate    : 02-Oct-2015
 * <br> @createdTime    : 11:06:03 pm
 * <br> @Description    :
 */
package com.v2tech.necto.plusconnect.entity.dto;

import java.io.Serializable;

/**
 * <br>
 *
 * @Author : puneetsharma <br>
 * @createdDate : 02-Oct-2015 <br>
 * @createdTime : 11:06:03 pm <br>
 * @Description : <br>
 */
public class MobileContact implements Serializable
	{
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 10-Oct-2015 <br>
		 * @createdTime : 8:46:01 pm <br>
		 * @Description :
		 */
		private static final long serialVersionUID = -1288727912487644835L;

		public MobileContact()
			{
				super();
			}

		private String mobileName;
		private String mobileNumber;

		public String getMobileName()
			{
				return mobileName;
			}

		public void setMobileName(String mobileName)
			{
				this.mobileName = mobileName;
			}

		public String getMobileNumber()
			{
				return mobileNumber;
			}

		public void setMobileNumber(String mobileNumber)
			{
				this.mobileNumber = mobileNumber;
			}

		public MobileContact(String mobileName, String mobileNumber)
			{
				super();
				this.mobileName = mobileName;
				this.mobileNumber = mobileNumber;
			}

		@Override
		public String toString()
			{
				return "MobileContact [mobileName=" + mobileName + ", mobileNumber=" + mobileNumber + "]";
			}

	}
