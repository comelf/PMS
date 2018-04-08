package com.pms.web.entity.academy;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "academyBranchId", nullable = false)
	private AcademyBranch academyBranch;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private int gender;
	
	@Column
	private Date birthday;
	
	@Column
	private String phone;
	
	@Column
	private String address1;
	
	@Column
	private String address2;
	
	@Column
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "teacherStatusId", nullable = false)
	TeacherStatus teacherStatus;
	
	//사진
	@ManyToOne
	@JoinColumn(name = "photoId", nullable = false)
	Photo photo;
	
	//학력
	@Column
	private String background;
	
	//졸업학교
	@Column
	private String graduate ;
	
	//학과
	@Column
	private String major;
	
	//입사일
	@Column
	private Date joinDate;
	
	//퇴사일
	@Column
	private String resignationDate;
		
	//서류 제출 여부
	@Column
	private boolean  contract;
	
	@Column
	private boolean document1;

	//고정급여 변동급여
	@ManyToOne
	@JoinColumn(name = "salaryTypeId", nullable = false)
	private SalaryType salaryType;

	//계좌번호
	@Column
	private String accountNumber;
	
	@Column
	private String accountBank;
	
}
