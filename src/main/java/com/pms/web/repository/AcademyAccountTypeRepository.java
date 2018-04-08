package com.pms.web.repository;

import com.pms.web.entity.academy.AcademyAccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyAccountTypeRepository extends JpaRepository<AcademyAccountType,  Integer> {

	AcademyAccountType findByTextKey(String textKey);

}
