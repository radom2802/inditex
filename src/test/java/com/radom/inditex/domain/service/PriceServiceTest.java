package com.radom.inditex.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.radom.inditex.domain.model.PriceModel;
import com.radom.inditex.domain.repository.PriceRepository;
import com.radom.inditex.infraestructure.db.mapper.PriceEntityMapper;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PriceServiceTest{
	
	@MockBean
	private PriceRepository priceRepository;
	
	@Autowired
	private PriceService priceService;
	
	private static final long DATA_PRODUCT_ID = 35455;
	private static final long DATA_BRAND_ID = 1;
	
	@Test
	@Order(1)
	void serviceTest_1406_1000_shouldReturn3550() throws Exception {
		
		final long DATA_PRICE_LIST = 1;
		final String DATA_START_DATE = "2020-06-14 00:00:00";
		final String DATA_END_DATE = "2020-12-31 23:59:59";
		final Double DATA_PRICE = Double.valueOf("35.50");
		
		final LocalDateTime REQUEST_DATE = LocalDateTime.parse("2020-06-14 10:00:00", PriceEntityMapper.formatter);
		
		var expectedPrice = PriceModel.builder()
				.productId(DATA_PRODUCT_ID)
				.brandId(DATA_BRAND_ID)
				.priceList(DATA_PRICE_LIST)
				.startDate(DATA_START_DATE)
				.endDate(DATA_END_DATE)
				.price(DATA_PRICE)
				.build();

		// When repository
		when(priceRepository.getPrice(REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID))
			.thenReturn(PriceModel.builder()
				.productId(DATA_PRODUCT_ID)
				.brandId(DATA_BRAND_ID)
				.priceList(DATA_PRICE_LIST)
				.startDate(DATA_START_DATE)
				.endDate(DATA_END_DATE)
				.price(DATA_PRICE)
				.build());

		// Assert service
		PriceModel returnedPrice = priceService.getPrice(REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID);
		assertEquals(returnedPrice.getProductId(), expectedPrice.getProductId());
		assertEquals(returnedPrice.getBrandId(), expectedPrice.getBrandId());
		assertEquals(returnedPrice.getPriceList(), expectedPrice.getPriceList());
		assertEquals(returnedPrice.getStartDate(), expectedPrice.getStartDate());
		assertEquals(returnedPrice.getEndDate(), expectedPrice.getEndDate());
		assertEquals(returnedPrice.getPrice(), expectedPrice.getPrice());

		// Verify repository call
		verify(priceRepository, times(1)).getPrice(REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID);
	}
	
	@Test
	@Order(2)
	void serviceTest_1406_1600_shouldReturn2545() throws Exception {
		
		final long DATA_PRICE_LIST = 2;
		final String DATA_START_DATE = "2020-06-14 15:00:00";
		final String DATA_END_DATE = "2020-06-14 18:30:00";
		final Double DATA_PRICE = Double.valueOf("25.45");
		
		final LocalDateTime REQUEST_DATE = LocalDateTime.parse("2020-06-14 16:00:00", PriceEntityMapper.formatter);
		
		var expectedPrice = PriceModel.builder()
				.productId(DATA_PRODUCT_ID)
				.brandId(DATA_BRAND_ID)
				.priceList(DATA_PRICE_LIST)
				.startDate(DATA_START_DATE)
				.endDate(DATA_END_DATE)
				.price(DATA_PRICE)
				.build();

		// When repository
		when(priceRepository.getPrice(REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID))
			.thenReturn(PriceModel.builder()
				.productId(DATA_PRODUCT_ID)
				.brandId(DATA_BRAND_ID)
				.priceList(DATA_PRICE_LIST)
				.startDate(DATA_START_DATE)
				.endDate(DATA_END_DATE)
				.price(DATA_PRICE)
				.build());

		// Assert service
		PriceModel returnedPrice = priceService.getPrice(REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID);
		assertEquals(returnedPrice.getProductId(), expectedPrice.getProductId());
		assertEquals(returnedPrice.getBrandId(), expectedPrice.getBrandId());
		assertEquals(returnedPrice.getPriceList(), expectedPrice.getPriceList());
		assertEquals(returnedPrice.getStartDate(), expectedPrice.getStartDate());
		assertEquals(returnedPrice.getEndDate(), expectedPrice.getEndDate());
		assertEquals(returnedPrice.getPrice(), expectedPrice.getPrice());

		// Verify repository call
		verify(priceRepository, times(1)).getPrice(REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID);
	}
	
	@Test
	@Order(3)
	void serviceTest_1406_2100_shouldReturn3550() throws Exception {
		
		final long DATA_PRICE_LIST = 1;
		final String DATA_START_DATE = "2020-06-14 00:00:00";
		final String DATA_END_DATE = "2020-12-31 23:59:59";
		final Double DATA_PRICE = Double.valueOf("35.50");
		
		final LocalDateTime REQUEST_DATE = LocalDateTime.parse("2020-06-14 21:00:00", PriceEntityMapper.formatter);
		
		var expectedPrice = PriceModel.builder()
				.productId(DATA_PRODUCT_ID)
				.brandId(DATA_BRAND_ID)
				.priceList(DATA_PRICE_LIST)
				.startDate(DATA_START_DATE)
				.endDate(DATA_END_DATE)
				.price(DATA_PRICE)
				.build();

		// When repository
		when(priceRepository.getPrice(REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID))
			.thenReturn(PriceModel.builder()
				.productId(DATA_PRODUCT_ID)
				.brandId(DATA_BRAND_ID)
				.priceList(DATA_PRICE_LIST)
				.startDate(DATA_START_DATE)
				.endDate(DATA_END_DATE)
				.price(DATA_PRICE)
				.build());

		// Assert service
		PriceModel returnedPrice = priceService.getPrice(REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID);
		assertEquals(returnedPrice.getProductId(), expectedPrice.getProductId());
		assertEquals(returnedPrice.getBrandId(), expectedPrice.getBrandId());
		assertEquals(returnedPrice.getPriceList(), expectedPrice.getPriceList());
		assertEquals(returnedPrice.getStartDate(), expectedPrice.getStartDate());
		assertEquals(returnedPrice.getEndDate(), expectedPrice.getEndDate());
		assertEquals(returnedPrice.getPrice(), expectedPrice.getPrice());

		// Verify repository call
		verify(priceRepository, times(1)).getPrice(REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID);
	}
	
	@Test
	@Order(4)
	void serviceTest_1506_1000_shouldReturn3050() throws Exception {
		
		final long DATA_PRICE_LIST = 3;
		final String DATA_START_DATE = "2020-06-15 00:00:00";
		final String DATA_END_DATE = "2020-06-15 11:00:00";
		final Double DATA_PRICE = Double.valueOf("30.50");
		
		final LocalDateTime REQUEST_DATE = LocalDateTime.parse("2020-06-15 10:00:00", PriceEntityMapper.formatter);
		
		var expectedPrice = PriceModel.builder()
				.productId(DATA_PRODUCT_ID)
				.brandId(DATA_BRAND_ID)
				.priceList(DATA_PRICE_LIST)
				.startDate(DATA_START_DATE)
				.endDate(DATA_END_DATE)
				.price(DATA_PRICE)
				.build();

		// When repository
		when(priceRepository.getPrice(REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID))
			.thenReturn(PriceModel.builder()
				.productId(DATA_PRODUCT_ID)
				.brandId(DATA_BRAND_ID)
				.priceList(DATA_PRICE_LIST)
				.startDate(DATA_START_DATE)
				.endDate(DATA_END_DATE)
				.price(DATA_PRICE)
				.build());

		// Assert service
		PriceModel returnedPrice = priceService.getPrice(REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID);
		assertEquals(returnedPrice.getProductId(), expectedPrice.getProductId());
		assertEquals(returnedPrice.getBrandId(), expectedPrice.getBrandId());
		assertEquals(returnedPrice.getPriceList(), expectedPrice.getPriceList());
		assertEquals(returnedPrice.getStartDate(), expectedPrice.getStartDate());
		assertEquals(returnedPrice.getEndDate(), expectedPrice.getEndDate());
		assertEquals(returnedPrice.getPrice(), expectedPrice.getPrice());

		// Verify repository call
		verify(priceRepository, times(1)).getPrice(REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID);
	}
	
	@Test
	@Order(5)
	void serviceTest_1606_2100_shouldReturn3895() throws Exception {
		
		final long DATA_PRICE_LIST = 4;
		final String DATA_START_DATE = "2020-06-15 16:00:00";
		final String DATA_END_DATE = "2020-12-31 23:59:59";
		final Double DATA_PRICE = Double.valueOf("38.95");
		
		final LocalDateTime REQUEST_DATE = LocalDateTime.parse("2020-06-16 21:00:00", PriceEntityMapper.formatter);
		
		var expectedPrice = PriceModel.builder()
				.productId(DATA_PRODUCT_ID)
				.brandId(DATA_BRAND_ID)
				.priceList(DATA_PRICE_LIST)
				.startDate(DATA_START_DATE)
				.endDate(DATA_END_DATE)
				.price(DATA_PRICE)
				.build();

		// When repository
		when(priceRepository.getPrice(REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID))
			.thenReturn(PriceModel.builder()
				.productId(DATA_PRODUCT_ID)
				.brandId(DATA_BRAND_ID)
				.priceList(DATA_PRICE_LIST)
				.startDate(DATA_START_DATE)
				.endDate(DATA_END_DATE)
				.price(DATA_PRICE)
				.build());

		// Assert service
		PriceModel returnedPrice = priceService.getPrice(REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID);
		assertEquals(returnedPrice.getProductId(), expectedPrice.getProductId());
		assertEquals(returnedPrice.getBrandId(), expectedPrice.getBrandId());
		assertEquals(returnedPrice.getPriceList(), expectedPrice.getPriceList());
		assertEquals(returnedPrice.getStartDate(), expectedPrice.getStartDate());
		assertEquals(returnedPrice.getEndDate(), expectedPrice.getEndDate());
		assertEquals(returnedPrice.getPrice(), expectedPrice.getPrice());

		// Verify repository call
		verify(priceRepository, times(1)).getPrice(REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID);
	}
	
}
