package com.pms.web.repository;

import com.pms.web.entity.academy.Academy;
import com.pms.web.entity.academy.AcademyBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademyBranchRepository extends JpaRepository<AcademyBranch,  Integer> {

	List<AcademyBranch> findAllByAcademy(Academy academy);

	AcademyBranch findOneByAcademyAndHead(Academy academy, boolean b);

}
