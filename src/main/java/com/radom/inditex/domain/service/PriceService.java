package com.radom.inditex.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radom.inditex.domain.exception.PriceNotFoundException;
import com.radom.inditex.domain.model.PriceModel;
import com.radom.inditex.domain.repository.PriceRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PriceService{

	@Autowired
	PriceRepository priceRepository;
	
	/**
	 * Method to get a price
	 * @param model Safebox data
	 * @return List of items
	 * @throws PriceNotFoundException Safebox not exists exception
	 * @throws MalformedDataException Malformed data exception
	 */
	public PriceModel getPrice(LocalDateTime date, long productId, long brandId) throws PriceNotFoundException {
		
		log.info("getPrice service: ", date + " " + productId + " " + brandId);
		
		return this.priceRepository.getPrice(date, productId, brandId);
	}
}
