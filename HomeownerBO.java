/**
 * This Business Object class is used to for Homeowner Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import com.cts.insurance.homequote.dao.HomeownerDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Homeowner;

public class HomeownerBO {

	/**
	 * @param quoteId
	 * @param lastName
	 * @param dob
	 * @param emailAddress
	 * @return
	 * @throws HomequoteBusinessException
	 * @throws HomequoteSystemException 
	 */
	public Homeowner getHomeownerInfo(final int quoteId) throws HomequoteBusinessException{
		Homeowner homeowner = null;
		final HomeownerDAO HomeownerDAO = new HomeownerDAO();
		try {
			homeowner = HomeownerDAO.getHomeowner(quoteId);
			} catch (HomequoteSystemException e) {
				throw new HomequoteBusinessException(e.getMessage());		
		}
		return homeowner;
	}
	/**
	 * @param homeowner
	 * @throws HomequoteBusinessException
	 */
	public void saveHomeownerInfo(final Homeowner homeowner) throws HomequoteBusinessException{
		
		final HomeownerDAO HomeownerDAO = new HomeownerDAO();
		try {
			HomeownerDAO.saveHomeowner(homeowner);
			} catch (HomequoteSystemException e) {
				throw new HomequoteBusinessException(e.getMessage());	
		}
	}
}
