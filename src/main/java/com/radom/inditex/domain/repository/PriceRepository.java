package com.radom.inditex.domain.repository;

import java.time.LocalDateTime;

import com.radom.inditex.domain.exception.PriceNotFoundException;
import com.radom.inditex.domain.model.PriceModel;

public interface PriceRepository{

	/**
	 * Method to get a price from the repository by date, productId and brandId
	 * @param Timestamp date
	 * @param long productId
	 * @param long branId
	 * @return Price model
	 * @throws PriceNotFoundException 
	 */
	PriceModel getPrice(LocalDateTime date, long productId, long brandId) throws PriceNotFoundException;
	
}
