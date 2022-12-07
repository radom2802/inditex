package com.radom.inditex.infrastructure.db.persistence;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.radom.inditex.infraestructure.db.entity.PriceEntity;

public interface SpringDataPriceRepository extends JpaRepository<PriceEntity, Long> {

	@Query("SELECT pr FROM PriceEntity pr WHERE pr.productId = :productId AND pr.brandId= :brandId AND pr.startDate <= :date AND pr.endDate > :date ORDER BY priority DESC")
	Optional<PriceEntity> findPricesByProductId(@Param("date") LocalDateTime date, @Param("productId") long productId, @Param("brandId") long brandId);
	
}
