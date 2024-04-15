package com.onboarding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onboarding.model.OnBoardReference;
@Repository
public interface OnBoardReferenceRepository extends JpaRepository<OnBoardReference, Long>{
	
	@Query(" select a from OnBoardReference a where a.emailId = :emailId  ")
	OnBoardReference findByEmailId(@Param("emailId") String emailId);

	OnBoardReference findByrefId(String refId);

	//OnBoardReference getReferenceById(Long id);
}
