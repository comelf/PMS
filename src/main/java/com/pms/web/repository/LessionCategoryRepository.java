package com.pms.web.repository;

import com.pms.web.entity.academy.AcademyBranch;
import com.pms.web.entity.academy.LessionCategory;
import com.pms.web.entity.academy.OnOffStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessionCategoryRepository extends JpaRepository<LessionCategory, Integer> {
	List<LessionCategory> findAllByAcademyBranchIdAndStatus(Integer branchId, OnOffStatus status);
	LessionCategory findByNameAndAcademyBranchAndStatus(String name, AcademyBranch branchId, OnOffStatus status);
	
	LessionCategory findOneByAcademyBranchAndIdAndStatus(AcademyBranch branch, Integer categoryId, OnOffStatus status);
	Page<LessionCategory> findOneByAcademyBranchIdAndStatus(Integer branchId, OnOffStatus status, Pageable pageable);
}
