package com.radom.inditex.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PriceModel {
	
	private long productId;

	private long brandId;
	
	private long priceList;
	
	private String startDate;
	
	private String endDate;
	
	private Double price;
	
}