/**
 * This Business Object class is used to for Property Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import com.cts.insurance.homequote.dao.PropertyDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Property;

public class PropertyBO {

	/**
	 * @param quoteId
	 * @return
	 * @throws HomequoteBusinessException
	 * @throws HomequoteSystemException 
	 */
	public Property getProperty(final int quoteId) throws HomequoteBusinessException{
		
		Property property = new Property();
		final PropertyDAO PropertyDAO = new PropertyDAO();
		try {	
			property = PropertyDAO.getProperty(quoteId);
		} catch(HomequoteSystemException e) {
			throw new HomequoteBusinessException(e.getMessage());
		}
		
		return property;
	}
	/**
	 * @param property
	 * @throws HomequoteBusinessException
	 */
	public void saveProperty(final Property property) throws HomequoteBusinessException{

		final PropertyDAO PropertyDAO = new PropertyDAO();
		try {	
			PropertyDAO.saveProperty(property);
		} catch(HomequoteSystemException e) {
			throw new HomequoteBusinessException(e.getMessage());
		}
	}
	
}
