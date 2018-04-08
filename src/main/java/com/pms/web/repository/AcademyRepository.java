package com.pms.web.repository;

import com.pms.web.entity.academy.Academy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyRepository extends JpaRepository<Academy,  Integer> {

	Academy findByDomain(String domain);

}
