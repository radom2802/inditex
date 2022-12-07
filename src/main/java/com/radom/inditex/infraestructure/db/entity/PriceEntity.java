package com.radom.inditex.infraestructure.db.entity;

import java.time.LocalDateTime;
import java.util.Currency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "prices")
@NoArgsConstructor
@AllArgsConstructor
public class PriceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "brandId")
	private long brandId;
	
	@Column(name = "startDate")
	private LocalDateTime startDate;
	
	@Column(name = "endDate")
	private LocalDateTime endDate;
	
	@Column(name = "priceList")
	private long priceList;
	
	@Column(name = "productId")
	private long productId;
	
	@Column(name = "priority")
	private Integer priority;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "currency")
	private Currency currency;
	
}