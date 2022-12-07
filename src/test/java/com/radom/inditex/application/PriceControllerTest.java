package com.radom.inditex.application;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.radom.inditex.InditexApplication;
import com.radom.inditex.domain.exception.PriceNotFoundException;
import com.radom.inditex.domain.model.PriceModel;
import com.radom.inditex.domain.service.PriceService;
import com.radom.inditex.infraestructure.db.mapper.PriceEntityMapper;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(classes = { InditexApplication.class })
class PriceControllerTest {
	
	private static final String ENDPOINT_PRICE = "/price";
	private static final long DATA_PRODUCT_ID = 35455;
	private static final long DATA_BRAND_ID = 1;

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PriceService priceService;

	@Test
    @Order(1)
    void controllerTest_1406_1000_return3550() throws Exception {
		
		final long DATA_PRICE_LIST = 1;
		final String DATA_START_DATE = "2020-06-14 00:00:00";
		final String DATA_END_DATE = "2020-12-31 23:59:59";
		final Double DATA_PRICE = Double.valueOf("35.50");
		
		final String STR_REQUEST_DATE = "2020-06-14 10:00:00";
		final LocalDateTime TIME_REQUEST_DATE = LocalDateTime.parse(STR_REQUEST_DATE, PriceEntityMapper.formatter);
		
		when(priceService.getPrice(TIME_REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID))
	    	.thenReturn(PriceModel.builder()
					.productId(DATA_PRODUCT_ID)
					.brandId(DATA_BRAND_ID)
					.priceList(DATA_PRICE_LIST)
					.startDate(DATA_START_DATE)
					.endDate(DATA_END_DATE)
					.price(DATA_PRICE)
					.build());
    	
    	// Launch HTTP call
    	mockMvc
    		.perform(MockMvcRequestBuilders.get(ENDPOINT_PRICE + "/{date}/{productId}/{brandId}", STR_REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID)
            .contentType(MediaType.APPLICATION_JSON))
    		.andExpect(status().isOk())
    		.andExpect(jsonPath("$.productId").value(Matchers.is(DATA_PRODUCT_ID), Long.class))
    		.andExpect(jsonPath("$.brandId").value(Matchers.is(DATA_BRAND_ID), Long.class))
    		.andExpect(jsonPath("$.priceList").value(Matchers.is(DATA_PRICE_LIST), Long.class))
    		.andExpect(jsonPath("$.startDate").value(Matchers.is(DATA_START_DATE), LocalDateTime.class))
    		.andExpect(jsonPath("$.endDate").value(Matchers.is(DATA_END_DATE), LocalDateTime.class))
    		.andExpect(jsonPath("$.price").value(Matchers.is(DATA_PRICE), Double.class))
    		.andDo(print());

    }
	
	@Test
    @Order(2)
    void controllerTest_1406_1600_shouldReturn2545() throws Exception {
		
		final long DATA_PRICE_LIST = 2;
		final String DATA_START_DATE = "2020-06-14 15:00:00";
		final String DATA_END_DATE = "2020-06-14 18:30:00";
		final Double DATA_PRICE = Double.valueOf("25.45");
		
		final String STR_REQUEST_DATE = "2020-06-14 16:00:00";
		final LocalDateTime TIME_REQUEST_DATE = LocalDateTime.parse(STR_REQUEST_DATE, PriceEntityMapper.formatter);
		
		when(priceService.getPrice(TIME_REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID))
	    	.thenReturn(PriceModel.builder()
					.productId(DATA_PRODUCT_ID)
					.brandId(DATA_BRAND_ID)
					.priceList(DATA_PRICE_LIST)
					.startDate(DATA_START_DATE)
					.endDate(DATA_END_DATE)
					.price(DATA_PRICE)
					.build());
    	
    	// Launch HTTP call
    	mockMvc
    		.perform(MockMvcRequestBuilders.get(ENDPOINT_PRICE + "/{date}/{productId}/{brandId}", STR_REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID)
            .contentType(MediaType.APPLICATION_JSON))
    		.andExpect(status().isOk())
    		.andExpect(jsonPath("$.productId").value(Matchers.is(DATA_PRODUCT_ID), Long.class))
    		.andExpect(jsonPath("$.brandId").value(Matchers.is(DATA_BRAND_ID), Long.class))
    		.andExpect(jsonPath("$.priceList").value(Matchers.is(DATA_PRICE_LIST), Long.class))
    		.andExpect(jsonPath("$.startDate").value(Matchers.is(DATA_START_DATE), LocalDateTime.class))
    		.andExpect(jsonPath("$.endDate").value(Matchers.is(DATA_END_DATE), LocalDateTime.class))
    		.andExpect(jsonPath("$.price").value(Matchers.is(DATA_PRICE), Double.class))
    		.andDo(print());

    }
	
	@Test
    @Order(3)
    void controllerTest_1406_2100_shouldReturn3550() throws Exception {
		
		final long DATA_PRICE_LIST = 1;
		final String DATA_START_DATE = "2020-06-14 00:00:00";
		final String DATA_END_DATE = "2020-12-31 23:59:59";
		final Double DATA_PRICE = Double.valueOf("35.50");
		
		final String STR_REQUEST_DATE = "2020-06-14 21:00:00";
		final LocalDateTime TIME_REQUEST_DATE = LocalDateTime.parse(STR_REQUEST_DATE, PriceEntityMapper.formatter);
		
		when(priceService.getPrice(TIME_REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID))
	    	.thenReturn(PriceModel.builder()
					.productId(DATA_PRODUCT_ID)
					.brandId(DATA_BRAND_ID)
					.priceList(DATA_PRICE_LIST)
					.startDate(DATA_START_DATE)
					.endDate(DATA_END_DATE)
					.price(DATA_PRICE)
					.build());
    	
    	// Launch HTTP call
    	mockMvc
    		.perform(MockMvcRequestBuilders.get(ENDPOINT_PRICE + "/{date}/{productId}/{brandId}", STR_REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID)
            .contentType(MediaType.APPLICATION_JSON))
    		.andExpect(status().isOk())
    		.andExpect(jsonPath("$.productId").value(Matchers.is(DATA_PRODUCT_ID), Long.class))
    		.andExpect(jsonPath("$.brandId").value(Matchers.is(DATA_BRAND_ID), Long.class))
    		.andExpect(jsonPath("$.priceList").value(Matchers.is(DATA_PRICE_LIST), Long.class))
    		.andExpect(jsonPath("$.startDate").value(Matchers.is(DATA_START_DATE), LocalDateTime.class))
    		.andExpect(jsonPath("$.endDate").value(Matchers.is(DATA_END_DATE), LocalDateTime.class))
    		.andExpect(jsonPath("$.price").value(Matchers.is(DATA_PRICE), Double.class))
    		.andDo(print());

    }
	
	@Test
    @Order(4)
    void controllerTest_1506_1000_shouldReturn3050() throws Exception {
		
		final long DATA_PRICE_LIST = 3;
		final String DATA_START_DATE = "2020-06-15 00:00:00";
		final String DATA_END_DATE = "2020-06-15 11:00:00";
		final Double DATA_PRICE = Double.valueOf("30.50");
		
		final String STR_REQUEST_DATE = "2020-06-15 10:00:00";
		final LocalDateTime TIME_REQUEST_DATE = LocalDateTime.parse(STR_REQUEST_DATE, PriceEntityMapper.formatter);
		
		when(priceService.getPrice(TIME_REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID))
	    	.thenReturn(PriceModel.builder()
					.productId(DATA_PRODUCT_ID)
					.brandId(DATA_BRAND_ID)
					.priceList(DATA_PRICE_LIST)
					.startDate(DATA_START_DATE)
					.endDate(DATA_END_DATE)
					.price(DATA_PRICE)
					.build());
    	
    	// Launch HTTP call
    	mockMvc
    		.perform(MockMvcRequestBuilders.get(ENDPOINT_PRICE + "/{date}/{productId}/{brandId}", STR_REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID)
            .contentType(MediaType.APPLICATION_JSON))
    		.andExpect(status().isOk())
    		.andExpect(jsonPath("$.productId").value(Matchers.is(DATA_PRODUCT_ID), Long.class))
    		.andExpect(jsonPath("$.brandId").value(Matchers.is(DATA_BRAND_ID), Long.class))
    		.andExpect(jsonPath("$.priceList").value(Matchers.is(DATA_PRICE_LIST), Long.class))
    		.andExpect(jsonPath("$.startDate").value(Matchers.is(DATA_START_DATE), LocalDateTime.class))
    		.andExpect(jsonPath("$.endDate").value(Matchers.is(DATA_END_DATE), LocalDateTime.class))
    		.andExpect(jsonPath("$.price").value(Matchers.is(DATA_PRICE), Double.class))
    		.andDo(print());

    }
	
	@Test
    @Order(5)
    void controllerTest_1606_2100_shouldReturn3895() throws Exception {
		
		final long DATA_PRICE_LIST = 4;
		final String DATA_START_DATE = "2020-06-15 16:00:00";
		final String DATA_END_DATE = "2020-12-31 23:59:59";
		final Double DATA_PRICE = Double.valueOf("38.95");
		
		final String STR_REQUEST_DATE = "2020-06-16 21:00:00";
		final LocalDateTime TIME_REQUEST_DATE = LocalDateTime.parse(STR_REQUEST_DATE, PriceEntityMapper.formatter);
		
		when(priceService.getPrice(TIME_REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID))
	    	.thenReturn(PriceModel.builder()
					.productId(DATA_PRODUCT_ID)
					.brandId(DATA_BRAND_ID)
					.priceList(DATA_PRICE_LIST)
					.startDate(DATA_START_DATE)
					.endDate(DATA_END_DATE)
					.price(DATA_PRICE)
					.build());
    	
    	// Launch HTTP call
    	mockMvc
    		.perform(MockMvcRequestBuilders.get(ENDPOINT_PRICE + "/{date}/{productId}/{brandId}", STR_REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID)
            .contentType(MediaType.APPLICATION_JSON))
    		.andExpect(status().isOk())
    		.andExpect(jsonPath("$.productId").value(Matchers.is(DATA_PRODUCT_ID), Long.class))
    		.andExpect(jsonPath("$.brandId").value(Matchers.is(DATA_BRAND_ID), Long.class))
    		.andExpect(jsonPath("$.priceList").value(Matchers.is(DATA_PRICE_LIST), Long.class))
    		.andExpect(jsonPath("$.startDate").value(Matchers.is(DATA_START_DATE), LocalDateTime.class))
    		.andExpect(jsonPath("$.endDate").value(Matchers.is(DATA_END_DATE), LocalDateTime.class))
    		.andExpect(jsonPath("$.price").value(Matchers.is(DATA_PRICE), Double.class))
    		.andDo(print());

    }
	
	@Test
    @Order(6)
    void controllerTest_returnNotFoundException() throws Exception {
		
		final String STR_REQUEST_DATE = "2022-12-06 10:00:00";
		final LocalDateTime TIME_REQUEST_DATE = LocalDateTime.parse(STR_REQUEST_DATE, PriceEntityMapper.formatter);
		
		when(priceService.getPrice(TIME_REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID))
    		.thenThrow(PriceNotFoundException.class);
    	
    	// Launch HTTP call
    	mockMvc
    		.perform(MockMvcRequestBuilders.get(ENDPOINT_PRICE + "/{date}/{productId}/{brandId}", STR_REQUEST_DATE, DATA_PRODUCT_ID, DATA_BRAND_ID)
                .contentType(MediaType.APPLICATION_JSON))
    		.andExpect(status().isNotFound())
    		.andDo(print());
    }
	
}
