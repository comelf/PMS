package com.pms.web.repository;

import com.pms.web.entity.Account;
import com.pms.web.entity.academy.AcademyAccountMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyAccountMappingRepository extends JpaRepository<AcademyAccountMapping,  Integer> {

	AcademyAccountMapping findOneByAccount(Account account);

}
