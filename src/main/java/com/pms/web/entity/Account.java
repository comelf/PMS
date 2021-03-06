package com.pms.web.entity;

import com.pms.web.entity.academy.AcademyBranch;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(unique = true, nullable = false)
	private String loginId;
	private String password;
	private String name;
	private String email;
	private Date createDate;
	private boolean admin = false;

	@ManyToOne
	@JoinColumn(name = "academyBranchId", nullable = false)
	private AcademyBranch academyBranch;
	
	@ManyToOne
	@JoinColumn(name = "accountStatusId", nullable = false)
	private AccountStatus status;

	public Account(String loginId, String hashPassword, String name, String email, boolean isAdmin, AccountStatus status, AcademyBranch academyBranch) {
		this.loginId = loginId;
		this.password = hashPassword;
		this.name = name;
		this.email = email;
		this.admin = isAdmin;
		this.status = status;
		this.academyBranch = academyBranch;
		this.createDate = new Date();
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", loginId=" + loginId + ", password=" + password + ", name=" + name + ", email="
				+ email + "]";
	}

}
