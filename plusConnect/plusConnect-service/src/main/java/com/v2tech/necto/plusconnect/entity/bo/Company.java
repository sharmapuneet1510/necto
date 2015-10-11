package com.v2tech.necto.plusconnect.entity.bo;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Company
	{
		@GraphId
		private Long companyId;
		private String companyName;
		private boolean isCurrentCompany;

		public Long getCompanyId()
			{
				return companyId;
			}

		public void setCompanyId(final Long companyId)
			{
				this.companyId = companyId;
			}

		public String getCompanyName()
			{
				return companyName;
			}

		public void setCompanyName(final String companyName)
			{
				this.companyName = companyName;
			}

		public boolean isCurrentCompany()
			{
				return isCurrentCompany;
			}

		public void setCurrentCompany(final boolean isCurrentCompany)
			{
				this.isCurrentCompany = isCurrentCompany;
			}

	}
