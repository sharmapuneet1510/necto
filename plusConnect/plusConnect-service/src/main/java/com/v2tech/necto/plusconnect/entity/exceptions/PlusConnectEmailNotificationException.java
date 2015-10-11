/** 
 * <br> @Author         : puneetsharma
 * <br> @createdDate    : 03-Oct-2015
 * <br> @createdTime    : 12:36:42 pm
 * <br> @Description    :
 */
package com.v2tech.necto.plusconnect.entity.exceptions;

/**
 * <br>
 * 
 * @Author : puneetsharma <br>
 * @createdDate : 03-Oct-2015 <br>
 * @createdTime : 12:36:42 pm <br>
 * @Description : <br>
 */
public class PlusConnectEmailNotificationException extends RuntimeException
	{

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 03-Oct-2015 <br>
		 * @createdTime : 12:37:34 pm <br>
		 * @Description :
		 */
		private static final long serialVersionUID = 5090479412789637384L;

		public PlusConnectEmailNotificationException()
			{
				super();
				// TODO Auto-generated constructor stub
			}

		public PlusConnectEmailNotificationException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace)
			{
				super(message, cause, enableSuppression, writableStackTrace);
				// TODO Auto-generated constructor stub
			}

		public PlusConnectEmailNotificationException(final String message, final Throwable cause)
			{
				super(message, cause);
				// TODO Auto-generated constructor stub
			}

		public PlusConnectEmailNotificationException(final String message)
			{
				super(message);
				// TODO Auto-generated constructor stub
			}

		public PlusConnectEmailNotificationException(final Throwable cause)
			{
				super(cause);
				// TODO Auto-generated constructor stub
			}

	}
