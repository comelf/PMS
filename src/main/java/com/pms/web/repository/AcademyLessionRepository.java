package com.pms.web.repository;

import com.pms.web.entity.academy.AcademyBranch;
import com.pms.web.entity.academy.AcademyLession;
import com.pms.web.entity.academy.OnOffStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademyLessionRepository extends JpaRepository<AcademyLession,  Integer> {
	
	public List<AcademyLession> findAllByAcademyBranchIdAndStatus(Integer branchId, OnOffStatus status);
	public List<AcademyLession> findAllByAcademyBranchIdAndLessionCategoryIdAndStatus(Integer branchId, Integer categoryId, OnOffStatus status);
	public AcademyLession findByNameAndAcademyBranchAndStatus(String name, AcademyBranch branch, OnOffStatus status);
	public AcademyLession findOneByAcademyBranchAndIdAndStatus(AcademyBranch branch, Integer lessionId, OnOffStatus status);
}
