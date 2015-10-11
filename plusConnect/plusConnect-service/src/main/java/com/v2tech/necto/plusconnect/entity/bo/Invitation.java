package com.v2tech.necto.plusconnect.entity.bo;

import java.util.Date;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Invitation
	{
		@GraphId
		private Long invitationId;

		private User invitedBy;

		private Date invitationSentDate;

		public Long getInvitationId()
			{
				return invitationId;
			}

		public void setInvitationId(final Long invitationId)
			{
				this.invitationId = invitationId;
			}

		public User getInvitedBy()
			{
				return invitedBy;
			}

		public void setInvitedBy(final User invitedBy)
			{
				this.invitedBy = invitedBy;
			}

	}
