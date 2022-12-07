package com.radom.inditex.application;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.radom.inditex.domain.model.PriceModel;
import com.radom.inditex.domain.service.PriceService;
import com.radom.inditex.domain.utilities.DateTimeConverter;
import com.radom.inditex.infraestructure.db.mapper.PriceEntityMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * Rest API Controller
 * @author rdominguez
 */
@Slf4j
@RestController
@RequestMapping("/price")
public class PriceController {
	
	@Autowired
	private PriceService priceService;
	
    @Operation(summary = "Retrieves a price by product, price and date", 
    		description = "Retrieves the price for a specific productId and brandId at a date")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200", description = "Price correctly retrieved"),
            @ApiResponse(responseCode = "404", description = "Requested price does not exist"),
            @ApiResponse(responseCode = "422", description = "Malformed expected data"),
            @ApiResponse(responseCode = "500", description = "Unexpected API error") })
	 @GetMapping(value = "/{strDate}/{productId}/{brandId}", produces = { "application/json" })
    ResponseEntity<PriceModel> getPrice(@PathVariable String strDate, @PathVariable long productId, @PathVariable long brandId)
    				throws Exception {
    	log.info("getPrice controller: ", strDate + " " + productId + " " + brandId);
    	LocalDateTime date = DateTimeConverter.convertDateTime(strDate, PriceEntityMapper.formatter);
    	final PriceModel model = priceService.getPrice(date, productId, brandId);
    	return new ResponseEntity<>(model, HttpStatus.OK);
    }

}
