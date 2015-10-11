package com.v2tech.necto.plusconnect.entity.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Response implements Serializable
	{

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 10-Oct-2015 <br>
		 * @createdTime : 8:52:53 pm <br>
		 * @Description :
		 */
		private static final long serialVersionUID = -6881661686564150273L;

		public Response()
			{
				super();
			}

		private Map<Object, Object> responses = new LinkedHashMap<Object, Object>();

		public Map<Object, Object> getResponses()
			{
				return responses;
			}

		public void setResponses(Map<Object, Object> responses)
			{
				this.responses = responses;
			}

		@Override
		public String toString()
			{
				return "Response [responses=" + responses + "]";
			}

	}
