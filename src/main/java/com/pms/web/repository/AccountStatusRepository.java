package com.pms.web.repository;

import com.pms.web.entity.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountStatusRepository extends JpaRepository<AccountStatus,  Integer> {

	AccountStatus findByTextKey(String textKey);

}
