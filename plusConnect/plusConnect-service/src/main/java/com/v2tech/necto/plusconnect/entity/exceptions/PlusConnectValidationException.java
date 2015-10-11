/** 
 * <br> @Author         : puneetsharma
 * <br> @createdDate    : 01-Oct-2015
 * <br> @createdTime    : 7:12:23 pm
 * <br> @Description    :
 */
package com.v2tech.necto.plusconnect.entity.exceptions;

/**
 * <br>
 * 
 * @Author : puneetsharma <br>
 * @createdDate : 01-Oct-2015 <br>
 * @createdTime : 7:12:23 pm <br>
 * @Description : <br>
 */
public class PlusConnectValidationException extends RuntimeException
	{

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 01-Oct-2015 <br>
		 * @createdTime : 7:13:55 pm <br>
		 * @Description :
		 */
		private static final long serialVersionUID = -3635077745089292488L;

		public PlusConnectValidationException()
			{
				super();

			}

		public PlusConnectValidationException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace)
			{
				super(message, cause, enableSuppression, writableStackTrace);

			}

		public PlusConnectValidationException(final String message, final Throwable cause)
			{
				super(message, cause);

			}

		public PlusConnectValidationException(final String message)
			{
				super(message);

			}

		public PlusConnectValidationException(final Throwable cause)
			{
				super(cause);

			}

	}
