/**
 * This Action class is used to to capture the Location Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import com.cts.insurance.homequote.dao.LoginDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.User;

public class LoginBO {

	/**
	 * @param userName
	 * @param password
	 * @return
	 * @throws HomequoteSystemException 
	 */
	
	public User getUser(final String userName) throws HomequoteBusinessException{
		
		User user = new User();
		final LoginDAO loginDAO = new LoginDAO();
		try {
			user = loginDAO.getUser(userName);
		} catch (HomequoteSystemException e) {
			throw new HomequoteBusinessException(e.getMessage());
		}
		return user;
	}
	 
	/**
	 * registerUser
	 * @param user
	 * @throws HomequoteBusinessException
	 */
	public void registerUser(final User user) throws HomequoteBusinessException{
		
		final LoginDAO loginDAO = new LoginDAO();
		try {
			loginDAO.saveUser(user);
		} catch (HomequoteSystemException e) {
			throw new HomequoteBusinessException(e.getMessage());
		}
	}
}



Collapse 

9:33 AM
LocationBO.java 
/**
 * This Business Object class is used to for Location Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import java.util.ArrayList;
import java.util.List;

import com.cts.insurance.homequote.dao.LocationDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Location;

public class LocationBO {

	/**
	 * @param location
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public int saveHomeLocation(final Location location) throws HomequoteBusinessException{
		int locationInt = 0;
		final LocationDAO locationDAO = new LocationDAO();
		try {
			locationInt = locationDAO.saveLocation(location);
			} catch (HomequoteSystemException e) {
				throw new HomequoteBusinessException(e.getMessage());		
		}
		return locationInt;
	}
	
	/**
	 * @return
	 * @throws HomequoteBusinessException
	 * @throws HomequoteSystemException 
	 */
	public Location getHomeLocation(int quoteId) throws HomequoteBusinessException, HomequoteSystemException{

		Location location = new Location();
		final LocationDAO locationDAO = new LocationDAO();
		try {
			location = locationDAO.getLocation(quoteId);
			} catch (HomequoteSystemException e) {
				throw new HomequoteBusinessException(e.getMessage());		
		}
		return location;
	}
	
	/**
	 * @return
	 * @throws HomequoteBusinessException
	 * @throws HomequoteSystemException 
	 */
	public List<Location> getQuoteIds(String userName) throws HomequoteBusinessException, HomequoteSystemException{
		
		List<Location> quoteList = new ArrayList<Location>();
		final LocationDAO locationDAO = new LocationDAO();
		try {
			quoteList = locationDAO.getQuoteIds(userName);
			} catch (HomequoteSystemException e) {
				throw new HomequoteBusinessException(e.getMessage());		
		}
		return quoteList;
	}
	
}
