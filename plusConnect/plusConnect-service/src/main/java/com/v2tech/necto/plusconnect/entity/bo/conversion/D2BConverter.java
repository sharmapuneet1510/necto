package com.v2tech.necto.plusconnect.entity.bo.conversion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.v2tech.necto.plusconnect.entity.bo.User;
import com.v2tech.necto.plusconnect.entity.dto.Contact;

public class D2BConverter
	{

		public static List<User> convertContactToUser(final List<com.v2tech.necto.plusconnect.entity.dto.Contact> contacts)
			{
				Iterator<Contact> iteratorContacts = contacts.iterator();
				List<User> users = new ArrayList<>();
				while (iteratorContacts.hasNext())
					{
						Contact contact = iteratorContacts.next();
						User user = new User();
						users.add(user);
					}
				return users;
			}
	}
