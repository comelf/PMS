package com.pms.web.controller.rest;

import com.pms.web.R;
import com.pms.web.entity.academy.AcademyBranch;
import com.pms.web.entity.academy.Student;
import com.pms.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class StudentApiController {

    @Autowired
    StudentService studentService;

    //학원의 전체 학생 리스트
    @GetMapping(value = "/academy/api/student/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<Student> getStudentList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                        @RequestParam(value = "count", required = false, defaultValue = "10") Integer count,
                                        HttpSession session) {
        AcademyBranch branch = (AcademyBranch) session.getAttribute(R.CURRENT_ACADEMY_BRANCH);
        Page<Student> studentList = studentService.getAcademyStudentList(branch.getId(), page, count);
        return studentList;
    }

    //학원의 학생 검색
    @GetMapping(value = "/academy/api/student/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<Student> getStudentList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                        @RequestParam(value = "count", required = false, defaultValue = "10") Integer count,
                                        @RequestParam(value = "search") String search, HttpSession session) {
        AcademyBranch branch = (AcademyBranch) session.getAttribute(R.CURRENT_ACADEMY_BRANCH);
        Page<Student> studentList = studentService.searchAcademyStudents(branch.getId(), search, page, count);
        return studentList;
    }

    //학원의 강좌별 학생 리스트 - 강좌 리스트

    //학원의 강사별 학생 리스트 - 강사 리스트

    //특정 학생 디테일 정보
    @GetMapping(value = "/academy/api/student/{studentId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Student getStudentDetail(@PathVariable(value = "studentId") Integer studentId,
                                        HttpSession session) {
        AcademyBranch branch = (AcademyBranch) session.getAttribute(R.CURRENT_ACADEMY_BRANCH);
        Student student = studentService.getAcademyStudent(branch.getId(), studentId);
        return student;
    }

    //특정 학생 메모 (생성/삭제/수정/편집)



    //특정 학생 정보 수정 (이름/성별/학교/학년/생년월일/연락처/부모님/상태)

    //특정 학생 수강 현황

    //특정 학생 수정료 현황

    //특정 출석 현황

    //특정 시험 현황

}
