package com.v2tech.necto.plusconnect.entity.exceptions;

public class PlusConnectServiceException extends RuntimeException
	{

		/**
		* 
		*/
		private static final long serialVersionUID = 8549677070362134622L;

		public PlusConnectServiceException()
			{
				super();

			}

		public PlusConnectServiceException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace)
			{
				super(message, cause, enableSuppression, writableStackTrace);

			}

		public PlusConnectServiceException(final String message, final Throwable cause)
			{
				super(message, cause);

			}

		public PlusConnectServiceException(final String message)
			{
				super(message);

			}

		public PlusConnectServiceException(final Throwable cause)
			{
				super(cause);

			}

	}
