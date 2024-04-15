package com.onboarding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onboarding.model.OnBoardEducationDetails;
@Repository
public interface OnBoardEducationDetailsRepository extends JpaRepository<OnBoardEducationDetails, Long> {

	OnBoardEducationDetails getReferenceById(Long id);

}
