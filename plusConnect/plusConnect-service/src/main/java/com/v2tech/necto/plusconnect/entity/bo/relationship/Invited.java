package com.v2tech.necto.plusconnect.entity.bo.relationship;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.v2tech.necto.plusconnect.entity.bo.User;

@RelationshipEntity(type = "INVITED")
public class Invited
	{
		@GraphId
		private Long inviteId;
		@StartNode
		private User invitedBy;
		@EndNode
		private User invitedTo;

		public Long getInviteId()
			{
				return inviteId;
			}

		public void setInviteId(final Long inviteId)
			{
				this.inviteId = inviteId;
			}

		public User getInvitedBy()
			{
				return invitedBy;
			}

		public void setInvitedBy(final User invitedBy)
			{
				this.invitedBy = invitedBy;
			}

		public User getInvitedTo()
			{
				return invitedTo;
			}

		public void setInvitedTo(final User invitedTo)
			{
				this.invitedTo = invitedTo;
			}

	}
