package com.pms.web.repository;

import com.pms.web.entity.academy.OnOffStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnOffStatusRepository extends JpaRepository<OnOffStatus, Integer> {
	OnOffStatus findByTextKey(String textKey);
}
