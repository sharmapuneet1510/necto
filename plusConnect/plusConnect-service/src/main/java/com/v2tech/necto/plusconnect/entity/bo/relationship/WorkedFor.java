package com.v2tech.necto.plusconnect.entity.bo.relationship;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.v2tech.necto.plusconnect.entity.bo.Company;
import com.v2tech.necto.plusconnect.entity.bo.User;

@RelationshipEntity(type = "WORKED_FOR")
public class WorkedFor
	{
		@GraphId
		private Long workedForId;

		@StartNode
		private User employee;

		@EndNode
		private Company company;
	}
