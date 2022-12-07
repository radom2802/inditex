package com.radom.inditex.infraestructure.db.repository;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.radom.inditex.domain.exception.PriceNotFoundException;
import com.radom.inditex.domain.model.PriceModel;
import com.radom.inditex.domain.repository.PriceRepository;
import com.radom.inditex.infraestructure.db.entity.PriceEntity;
import com.radom.inditex.infraestructure.db.mapper.PriceEntityMapper;
import com.radom.inditex.infrastructure.db.persistence.SpringDataPriceRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Class to implement a SQL repository for get price
 * @author rdominguez
 */
@Component
@Slf4j
public class DbPriceRepository implements PriceRepository {

	@Autowired
	private SpringDataPriceRepository springDataPriceRepository;
	
	@Autowired
	private PriceEntityMapper priceMapper;
	
	@Override
	public PriceModel getPrice(LocalDateTime date, long productId, long brandId) throws PriceNotFoundException{
		log.info("getPrice DbPriceRepository: ", date + " " + productId + " " + brandId);
		
		PriceEntity priceEntity = springDataPriceRepository.findPricesByProductId(date, productId, brandId)
	             .orElseThrow(PriceNotFoundException::new);
		
		return this.priceMapper.mapFromEntity(priceEntity);
	}

}
