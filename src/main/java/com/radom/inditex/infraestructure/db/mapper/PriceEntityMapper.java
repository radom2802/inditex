package com.radom.inditex.infraestructure.db.mapper;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.radom.inditex.domain.model.PriceModel;
import com.radom.inditex.infraestructure.db.entity.PriceEntity;

/**
 * Class for mapping SQL price entity
 * @author rdominguez
 */
@Service
public class PriceEntityMapper {
	
	public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * Method to map price entity in price model 
	 * @param model Price model
	 * @return SQL price entity 
	 */
	public PriceModel mapFromEntity(PriceEntity entity) {
		
		return PriceModel.builder()
				.brandId(entity.getBrandId())
				.startDate(entity.getStartDate().format(formatter))
				.endDate(entity.getEndDate().format(formatter))
				.priceList(entity.getPriceList())
				.productId(entity.getProductId())
				.price(entity.getPrice())
				.build();
	}
	
}
