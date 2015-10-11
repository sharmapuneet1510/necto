package com.v2tech.necto.plusconnect.entity.bo;

import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Timeline
	{
		@GraphId
		private Long timelineId;

		@Relationship(type = "RefferedFor", direction = Relationship.UNDIRECTED)
		Set<ReferralPost> referralPosts;
	}
