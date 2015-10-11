package com.v2tech.necto.plusconnect.entity.bo.relationship;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.v2tech.necto.plusconnect.entity.bo.User;

@RelationshipEntity(type = "KNOWS")
public class Knows
	{
		@GraphId
		private Long knowsId;

		@StartNode
		private User user;

		@EndNode
		private User knows;
	}
