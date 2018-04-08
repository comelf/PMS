package com.pms.web.repository;

import com.pms.web.entity.academy.AcademyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyTypeRepository extends JpaRepository<AcademyType,  Integer> {

	AcademyType findByTextKey(String textKey);

}
