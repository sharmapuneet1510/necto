package com.v2tech.necto.plusconnect.entity.dto;

import java.io.Serializable;
import java.util.Date;

import com.v2tech.necto.plusconnect.entity.dto.enums.PostType;

public class Post implements Serializable
	{

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 10-Oct-2015 <br>
		 * @createdTime : 1:23:29 pm <br>
		 * @Description :
		 */
		private static final long serialVersionUID = 7148124957408139391L;
		private PostType postType;
		private User postedBy;
		private Date postedOn;
		private String message;
	}
