package com.v2tech.necto.plusconnect.entity.dto;

import java.io.Serializable;
import java.util.Set;

public class Page<T> implements Serializable
	{

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 10-Oct-2015 <br>
		 * @createdTime : 8:48:41 pm <br>
		 * @Description :
		 */
		private static final long serialVersionUID = 169741163950101112L;

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 10-Oct-2015 <br>
		 * @createdTime : 8:50:34 pm <br>
		 * @methodPackage : com.v2tech.necto.plusconnect.entity.dto <br>
		 * @Description : <br>
		 * @StepsWithExplanation : <br>
		 * @TODO : <br>
		 */
		public Page()
			{
				super();
			}

		private Integer pageNumber;
		private Integer pageSize;
		private Integer totalNumberOfRecords;
		private boolean hasNext;
		private Integer remainingPages;
		private Set<T> entities;

		public Integer getPageNumber()
			{
				return pageNumber;
			}

		public void setPageNumber(Integer pageNumber)
			{
				this.pageNumber = pageNumber;
			}

		public Integer getPageSize()
			{
				return pageSize;
			}

		public void setPageSize(Integer pageSize)
			{
				this.pageSize = pageSize;
			}

		public Integer getTotalNumberOfRecords()
			{
				return totalNumberOfRecords;
			}

		public void setTotalNumberOfRecords(Integer totalNumberOfRecords)
			{
				this.totalNumberOfRecords = totalNumberOfRecords;
			}

		public boolean isHasNext()
			{
				return hasNext;
			}

		public void setHasNext(boolean hasNext)
			{
				this.hasNext = hasNext;
			}

		public Integer getRemainingPages()
			{
				return remainingPages;
			}

		public void setRemainingPages(Integer remainingPages)
			{
				this.remainingPages = remainingPages;
			}

		public Set<T> getEntities()
			{
				return entities;
			}

		public void setEntities(Set<T> entities)
			{
				this.entities = entities;
			}

		public Page(Integer pageNumber, Integer pageSize, Integer totalNumberOfRecords, boolean hasNext, Integer remainingPages, Set<T> entities)
			{
				super();
				this.pageNumber = pageNumber;
				this.pageSize = pageSize;
				this.totalNumberOfRecords = totalNumberOfRecords;
				this.hasNext = hasNext;
				this.remainingPages = remainingPages;
				this.entities = entities;
			}

		@Override
		public String toString()
			{
				return "Page [pageNumber=" + pageNumber + ", pageSize=" + pageSize + ", totalNumberOfRecords=" + totalNumberOfRecords + ", hasNext=" + hasNext + ", remainingPages=" + remainingPages + ", entities=" + entities + "]";
			}

	}
