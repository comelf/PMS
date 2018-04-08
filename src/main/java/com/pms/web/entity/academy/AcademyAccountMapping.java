package com.pms.web.entity.academy;

import com.pms.web.entity.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class AcademyAccountMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "academyBranchId", nullable = false)
	private AcademyBranch academyBranch;

	@ManyToOne
	@JoinColumn(name = "accountId", nullable = false)
	private Account account;

	@ManyToOne
	@JoinColumn(name = "accountTypeId", nullable = false)
	AcademyAccountType accountType;

	@ManyToOne
	@JoinColumn(name = "academyTypeId", nullable = false)
	AcademyType academyType;

	@Override
	public String toString() {
		return "AcademyAccountMapping [academyBranch=" + academyBranch + ", account=" + account + ", accountType="
				+ accountType + ", academyType=" + academyType + "]";
	}

}
