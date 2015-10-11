/**
 * <br> @Author         : puneetsharma
 * <br> @createdDate    : 02-Oct-2015
 * <br> @createdTime    : 11:01:28 pm
 * <br> @Description    :
 */
package com.v2tech.necto.plusconnect.entity.dto;

import java.io.Serializable;

/**
 * <br>
 *
 * @Author : puneetsharma <br>
 * @createdDate : 02-Oct-2015 <br>
 * @createdTime : 11:01:28 pm <br>
 * @Description : <br>
 */
public class Credential implements Serializable
	{

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 10-Oct-2015 <br>
		 * @createdTime : 8:46:31 pm <br>
		 * @Description :
		 */
		private static final long serialVersionUID = 5306491751258448551L;

		public Credential()
			{
				super();
			}

		private String username;
		private String password;

		public String getUsername()
			{
				return username;
			}

		public void setUsername(final String username)
			{
				this.username = username;
			}

		public String getPassword()
			{
				return password;
			}

		public void setPassword(final String password)
			{
				this.password = password;
			}

		public Credential(final String username, final String password)
			{
				super();
				this.username = username;
				this.password = password;
			}

	}
