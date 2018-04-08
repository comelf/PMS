package com.pms.web.repository;

import com.pms.web.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,  Integer> {

	Account findByLoginId(String loginId);

}
