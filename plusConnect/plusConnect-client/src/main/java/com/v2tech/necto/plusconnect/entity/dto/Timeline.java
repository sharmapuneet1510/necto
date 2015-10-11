package com.v2tech.necto.plusconnect.entity.dto;

import java.io.Serializable;
import java.util.Set;

public class Timeline implements Serializable
	{

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 10-Oct-2015 <br>
		 * @createdTime : 12:52:12 pm <br>
		 * @Description :
		 */
		private static final long serialVersionUID = 161737640684301862L;

		private String userId;

		private User user;

		private Set<Post> post;
	}
