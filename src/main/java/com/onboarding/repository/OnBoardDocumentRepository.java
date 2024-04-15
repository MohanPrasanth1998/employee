package com.onboarding.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onboarding.model.OnBoardDocument;
import com.onboarding.model.OnBoardReference;

@Repository
public interface OnBoardDocumentRepository extends JpaRepository<OnBoardDocument, Long> {

	OnBoardDocument findByonBoardingReferenceAndDocTypeAndFileType(OnBoardReference refId, String docType, String fileType);

}
