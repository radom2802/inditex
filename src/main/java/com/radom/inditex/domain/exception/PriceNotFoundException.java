package com.radom.inditex.domain.exception;

/**
 * Exception class with 'Requested price does not exist' message 
 * @author rdominguez
 *
 */
public class PriceNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PriceNotFoundException(){
        super("Requested price does not exist");
    }
	
}
