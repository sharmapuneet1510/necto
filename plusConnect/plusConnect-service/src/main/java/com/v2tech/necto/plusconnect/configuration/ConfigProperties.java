/** 
 * <br> @Author         : puneetsharma
 * <br> @createdDate    : 01-Oct-2015
 * <br> @createdTime    : 10:37:17 pm
 * <br> @Description    :
 */
package com.v2tech.necto.plusconnect.configuration;

import java.util.Map;

/**
 * <br>
 * 
 * @Author : puneetsharma <br>
 * @createdDate : 01-Oct-2015 <br>
 * @createdTime : 10:37:17 pm <br>
 * @Description : <br>
 */
public abstract class ConfigProperties
	{
		private static Map<String, String> configProperties = new java.util.LinkedHashMap<String, String>();

		public static String getPropertyValue(String key)
			{
				key = key.trim().toLowerCase();
				if (configProperties.containsKey(key) == true)
					{
						return configProperties.get(key);
					}
				else
					{
						return null;
					}
			}

		public static void setPropertyValue(String key, final String value)
			{
				key = key.trim().toLowerCase();
				if (configProperties.containsKey(key) == true)
					{
						configProperties.remove(key);
						configProperties.put(key.toLowerCase(), value.trim());
					}
				else
					{
						configProperties.put(key.toLowerCase(), value.trim());
					}
			}
	}
