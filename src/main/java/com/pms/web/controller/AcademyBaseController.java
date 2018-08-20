package com.pms.web.controller;

import com.pms.web.R;
import com.pms.web.entity.academy.AcademyBranch;
import com.pms.web.entity.academy.Student;
import com.pms.web.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AcademyStudentController {

    private Logger log = LoggerFactory.getLogger(AcademyStudentController.class);

    @Autowired
    StudentService studentService;

    /*
     * 학생관리 - 학생 조회
     */
    @RequestMapping(
            value = {"/academy/{branchId}/student", "/academy/{branchId}/student/lesson", "/academy/{branchId}/student/attendance",
                    "/academy/{branchId}/student/grade", "/academy/{branchId}/student/group", "/academy/{branchId}/student/management",
                    "/academy/{branchId}/student/add"},
            method = RequestMethod.GET)
    public String academyStudent(@PathVariable("branchId") Integer branchId, HttpServletRequest request, Model model) {
//		List<Student> studentList = studentService.getAllAcademyStudent(branchId);
//		model.addAttribute("studentList", studentList);
        model.addAttribute("branchId", branchId);
        return "index";
    }

    @RequestMapping(value = "/academy/{branchId}/student/add", method = RequestMethod.POST)
    public String academyStudentAdd(@PathVariable("branchId") Integer branchId, @Valid Student student, BindingResult bindingResult, Model model, HttpServletRequest request, HttpSession session) {

        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError error : errors) {
                log.debug("error : {}", error.getDefaultMessage());
            }
            return "academy/student/add";
        }
        AcademyBranch branch = (AcademyBranch) session.getAttribute(R.CURRENT_ACADEMY_BRANCH);
        student.setAcademyBranch(branch);

        Student saved = studentService.addStudentWithBranch(student);

        if (saved != null) {

        } else {

        }
        System.out.println(saved);
        return "academy/student/add";
    }

    /*
     *  포토 업로드 Test 임시 페이
     */
    @RequestMapping(value = "/academy/photo", method = RequestMethod.GET)
    public String photoUpload(HttpServletRequest request) {
        return "academy/photoUpload";
    }


}
