package com.amazin.nayra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amazin.nayra.entity.CommonConstants;

@Repository
public interface CommonConstantsRepository extends JpaRepository<CommonConstants, Integer>{

	@Query(value = "select * from common_constants where is_active=1 and is_deleted=0 and code=:code",nativeQuery = true)
	CommonConstants findActiveRecordByCode(@Param("code") String code);

}
