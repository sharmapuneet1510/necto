package com.v2tech.necto.plusconnect.entity.bo;

import org.neo4j.ogm.annotation.GraphId;

public class Experience
	{

		
		public Experience()
		{
			super();
		}

		@GraphId
		private Long experienceId;
		private Company company;
		private String designation;
		private int startDate;
		private int startMonth;
		private int startYear;
		private boolean tillPresent = false;
		private int endDate;
		private int endtMonth;
		private int endYear;

		public Long getExperienceId()
			{
				return experienceId;
			}

		public void setExperienceId(final Long experienceId)
			{
				this.experienceId = experienceId;
			}

		public Company getCompany()
			{
				return company;
			}

		public void setCompany(final Company company)
			{
				this.company = company;
			}

		public String getDesignation()
			{
				return designation;
			}

		public void setDesignation(final String designation)
			{
				this.designation = designation;
			}

		public int getStartDate()
			{
				return startDate;
			}

		public void setStartDate(final int startDate)
			{
				this.startDate = startDate;
			}

		public int getStartMonth()
			{
				return startMonth;
			}

		public void setStartMonth(final int startMonth)
			{
				this.startMonth = startMonth;
			}

		public int getStartYear()
			{
				return startYear;
			}

		public void setStartYear(final int startYear)
			{
				this.startYear = startYear;
			}

		public boolean isTillPresent()
			{
				return tillPresent;
			}

		public void setTillPresent(final boolean tillPresent)
			{
				this.tillPresent = tillPresent;
			}

		public int getEndDate()
			{
				return endDate;
			}

		public void setEndDate(final int endDate)
			{
				this.endDate = endDate;
			}

		public int getEndtMonth()
			{
				return endtMonth;
			}

		public void setEndtMonth(final int endtMonth)
			{
				this.endtMonth = endtMonth;
			}

		public int getEndYear()
			{
				return endYear;
			}

		public void setEndYear(final int endYear)
			{
				this.endYear = endYear;
			}

		public Experience(final Long experienceId, final Company company, final String designation, final int startDate, final int startMonth, final int startYear, final boolean tillPresent)
			{
				super();
				this.experienceId = experienceId;
				this.company = company;
				this.designation = designation;
				this.startDate = startDate;
				this.startMonth = startMonth;
				this.startYear = startYear;
				this.tillPresent = tillPresent;
			}

	}
