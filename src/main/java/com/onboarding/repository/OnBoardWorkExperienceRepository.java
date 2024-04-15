package com.onboarding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onboarding.model.OnBoardWorkExperience;

@Repository
public interface OnBoardWorkExperienceRepository extends JpaRepository<OnBoardWorkExperience, Long>{

	OnBoardWorkExperience getReferenceById(Long id);

}
