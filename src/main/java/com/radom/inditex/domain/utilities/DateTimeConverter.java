package com.radom.inditex.domain.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.radom.inditex.domain.exception.BadRequestException;

public class DateTimeConverter {
	
	private DateTimeConverter(){}

	public static LocalDateTime convertDateTime(String strDate, DateTimeFormatter formato) throws BadRequestException
    {        
        LocalDateTime dateTime = LocalDateTime.now();       
        
        try{
        	dateTime = LocalDateTime.parse(strDate, formato);               
        }
        catch (Exception e)
        {            
            throw new BadRequestException("Date time format is not valid.");        
        }   
        return dateTime;     
    }
}
