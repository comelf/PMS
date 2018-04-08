package com.pms.web.repository;

import com.pms.web.entity.academy.StudentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyStudentStatusRepository extends JpaRepository<StudentStatus,  Integer> {

	StudentStatus findByTextKey(String textKey);

}
