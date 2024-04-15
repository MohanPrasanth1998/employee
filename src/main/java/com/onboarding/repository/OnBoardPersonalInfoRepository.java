package com.onboarding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onboarding.model.OnBoardPersonalInfo;
@Repository
public interface OnBoardPersonalInfoRepository extends JpaRepository<OnBoardPersonalInfo, Long> {

	OnBoardPersonalInfo getReferenceById(Long id);

}
