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

		public PostType getPostType()
			{
				return postType;
			}

		public void setPostType(PostType postType)
			{
				this.postType = postType;
			}

		public User getPostedBy()
			{
				return postedBy;
			}

		public void setPostedBy(User postedBy)
			{
				this.postedBy = postedBy;
			}

		public Date getPostedOn()
			{
				return postedOn;
			}

		public void setPostedOn(Date postedOn)
			{
				this.postedOn = postedOn;
			}

		public String getMessage()
			{
				return message;
			}

		public void setMessage(String message)
			{
				this.message = message;
			}

		/**
		 * <br>
		 * @Author : puneetsharma <br>
		 * @createdDate : 10-Oct-2015 <br>
		 * @createdTime : 2:32:02 pm <br>
		 * @methodPackage : com.v2tech.necto.plusconnect.entity.dto <br>
		 * @Description : <br>
		 * @StepsWithExplanation : <br>
		 * @TODO : <br>
		 * @param postType <br>
		 * @param postedBy <br>
		 * @param postedOn <br>
		 * @param message
		 */
		public Post(PostType postType, User postedBy, Date postedOn, String message)
			{
				super();
				this.postType = postType;
				this.postedBy = postedBy;
				this.postedOn = postedOn;
				this.message = message;
			}

	}
