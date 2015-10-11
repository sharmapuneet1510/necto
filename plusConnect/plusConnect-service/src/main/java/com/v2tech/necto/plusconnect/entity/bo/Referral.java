package com.v2tech.necto.plusconnect.entity.bo;

import java.util.Date;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Referral
	{
		@GraphId
		private Long referralPostId;

		private String referredFor;

		private User refferedBy;

		private Date refferredDate;

		public Long getReferralPostId()
			{
				return referralPostId;
			}

		public void setReferralPostId(final Long referralPostId)
			{
				this.referralPostId = referralPostId;
			}

		public String getReferredFor()
			{
				return referredFor;
			}

		public void setReferredFor(final String referredFor)
			{
				this.referredFor = referredFor;
			}

		public User getRefferedBy()
			{
				return refferedBy;
			}

		public void setRefferedBy(final User refferedBy)
			{
				this.refferedBy = refferedBy;
			}

		public Date getRefferredDate()
			{
				return refferredDate;
			}

		public void setRefferredDate(final Date refferredDate)
			{
				this.refferredDate = refferredDate;
			}

	}
