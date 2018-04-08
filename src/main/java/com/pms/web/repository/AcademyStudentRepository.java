package com.pms.web.repository;

import com.pms.web.entity.academy.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademyStudentRepository extends JpaRepository<Student,  Integer> {

	@Query("select s from Student s where academyBranchId = :branchId")
	List<Student> findAllByAcademyBranchId(@Param("branchId") Integer branchId);

}
