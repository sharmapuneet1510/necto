package com.v2tech.necto.plusconnect.webservices;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.codec.binary.Base64;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.apache.cxf.jaxrs.impl.ResponseBuilderImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v2tech.necto.plusconnect.configuration.ConfigProperties;
import com.v2tech.necto.plusconnect.entity.bo.Contact;
import com.v2tech.necto.plusconnect.entity.bo.User;
import com.v2tech.necto.plusconnect.entity.dto.Credential;
import com.v2tech.necto.plusconnect.services.UserService;

@Path("/plusConnectWebService")
@Service
public class PlusConnectWebService
	{
		@Autowired
		private UserService userService;

		@POST
		@Path("/registerUser")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response registerUser(final User user)
			{
				String message = null;
				if (user == null)
					{
						ResponseBuilder responseBuilder = new ResponseBuilderImpl();
						responseBuilder.status(Status.NOT_ACCEPTABLE);
						responseBuilder.entity(new String("user object cannot be null or empty"));
						return responseBuilder.build();
					}
				else if (user.getUsername() == null)
					{
						if (user.isMobile() == true)
							{
								message = "mobile Number cannot be null or empty";
							}
						else
							{
								message = "emailId cannot be null or empty";
							}
						ResponseBuilder responseBuilder = new ResponseBuilderImpl();
						responseBuilder.status(Status.NOT_ACCEPTABLE);
						responseBuilder.entity(new String(message));
						return responseBuilder.build();
					}
				else
					{
						return userService.registerUser(user);
					}

			}

		@GET
		@Path("/activateUser")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response activateUser(@QueryParam("userId") String userId, @QueryParam("verificationToken") String verficationToken)
			{
				if ((verficationToken != null) && (verficationToken.trim().length() > 0) && (userId != null) && (userId.trim().length() > 0))
					{
						verficationToken = new String(Base64.decodeBase64(verficationToken.trim().getBytes()));
						userId = new String(Base64.decodeBase64(userId.trim().getBytes()));
					}
				else
					{
						String message = "UserId and Verification Token Cannot be null";
						ResponseBuilder responseBuilder = new ResponseBuilderImpl();
						responseBuilder.status(Status.BAD_REQUEST);
						responseBuilder.entity(new String(message));
						return responseBuilder.build();
					}
				return userService.confirmRegistration(userId, verficationToken);
			}

		@POST
		@Path("/uploadProfilePic")
		@Consumes(MediaType.MULTIPART_FORM_DATA)
		@Produces(MediaType.APPLICATION_JSON)
		public Response uploadProfilePic(@QueryParam("userId") final String userId, @Multipart() final Attachment attachment) throws IOException
			{
				DataHandler dataHandler = attachment.getDataHandler();
				InputStream inputStream = dataHandler.getInputStream();
				String fileName = dataHandler.getName();
				String filePath = ConfigProperties.getPropertyValue("imageRepository") + File.separator + userId;
				File path = new File(filePath);
				if (path.exists() == false)
					{
						path.mkdirs();
					}
				filePath = filePath + File.separator + fileName;
				OutputStream outputStream = new FileOutputStream(new File(filePath));
				int read = 0;
				byte[] bytes = new byte[1024];
				while ((read = inputStream.read(bytes)) != -1)
					{
						outputStream.write(bytes, 0, read);
					}
				if (inputStream != null)
					{
						inputStream.close();
						inputStream = null;
					}
				if (outputStream != null)
					{
						outputStream.close();
						outputStream = null;
					}
				Response response = Response.status(Status.NO_CONTENT).build();
				String encodedUserId = Base64.encodeBase64String(userId.getBytes());
				String encodedProfilePicUrl = Base64.encodeBase64String(fileName.getBytes());
				String profilePicUrl = ConfigProperties.getPropertyValue("webServiceUrl") + "/" + "plusConnectWebService/getProfilePic?userId=" + encodedUserId + "&profilePicId=" + encodedProfilePicUrl;
				System.out.println(profilePicUrl);
				return response;
			}

		@GET
		@Path("/getProfilePic")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces("multipart/mixed")
		public Response getProfilePicForUser(@QueryParam("userId") final String userId, @QueryParam("profilePicId") final String profilePicId) throws FileNotFoundException
			{
				String decodedUserId = new String(Base64.decodeBase64(userId.getBytes()));
				String decodedProfilePicUrl = new String(Base64.decodeBase64(profilePicId.getBytes()));
				String filePath = ConfigProperties.getPropertyValue("imageRepository") + File.separator + decodedUserId + File.separator + decodedProfilePicUrl;
				File file = new File(filePath);
				ResponseBuilder response = Response.ok(file);
				response.header("Context-Disposition", "attachment; filename=\"" + decodedProfilePicUrl + "\"");
				return response.build();
			}

		@POST
		@Path("/authenticateUser")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response authenticateUser(final Credential credential)
			{
				String username = credential.getUsername();
				String password = credential.getPassword();
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				if ((username == null) || (username.trim().length() <= 0) || (password == null) || (password.trim().length() <= 0))
					{
						responseBuilder.status(Status.BAD_REQUEST);
						JSONObject jsonObject = new JSONObject();
						jsonObject.put("isError", true);
						jsonObject.put("exception", "UserName or Password Cannot be null or empty");
						responseBuilder.entity(jsonObject);
						return responseBuilder.build();
					}
				return userService.authenticateUser(username, password);
			}

		@POST
		@Path("/updateEmailAddress")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response updateEmailAddress(@QueryParam("username") final String username, final String emailAddress)
			{
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				if ((username == null) || (username.trim().length() <= 0) || (emailAddress == null) || (emailAddress.trim().length() <= 0))
					{
						responseBuilder.status(Status.BAD_REQUEST);
						JSONObject jsonObject = new JSONObject();
						jsonObject.put("isError", true);
						jsonObject.put("exception", "UserName or emailAddress Cannot be null or empty");
						responseBuilder.entity(jsonObject);
						return responseBuilder.build();
					}
				return userService.updateEmailAddress(username, emailAddress);
			}

		@POST
		@Path("/updatePassword")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response updatePassword(@QueryParam("username") final String username, final String password)
			{
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				if ((username == null) || (username.trim().length() <= 0) || (password == null) || (password.trim().length() <= 0))
					{
						responseBuilder.status(Status.BAD_REQUEST);
						JSONObject jsonObject = new JSONObject();
						jsonObject.put("isError", true);
						jsonObject.put("exception", "UserName or Password Cannot be null or empty");
						responseBuilder.entity(jsonObject);
						return responseBuilder.build();
					}
				return userService.updatePassword(username, password);
			}

		@POST
		@Path("/pushMobileContacts")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public com.v2tech.necto.plusconnect.entity.dto.Response pushContacts(@QueryParam("username") final String username, final List<Contact> contacts)
			{
				com.v2tech.necto.plusconnect.entity.dto.Response response = new com.v2tech.necto.plusconnect.entity.dto.Response();
				Map<Object, Object> responses = response.getResponses();
				if ((contacts == null) || (username == null))
					{
						responses.put("status", "fail");
						responses.put("responseCode", 400);
						responses.put("exceptionMessage", "");
					}
				return response;
			}

		@GET
		@Path("/getAllContacts")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response pushContacts(@QueryParam("username") final String username)
			{
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				if ((username == null) || (username.trim().length() <= 0))
					{
						responseBuilder.status(Status.BAD_REQUEST);
						JSONObject jsonObject = new JSONObject();
						jsonObject.put("isError", true);
						jsonObject.put("exception", "UserName Cannot be null or empty");
						responseBuilder.entity(jsonObject);
						return responseBuilder.build();
					}
				return userService.getAllContacts(username);
			}
	}
