package com.pms.web.entity.academy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class AcademyLession {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "academyBranchId", nullable = false)
	@JsonIgnore
	private AcademyBranch academyBranch;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "lessionCategoryId", nullable = false)
	@JsonIgnore
	private LessionCategory lessionCategory;
	
	@NotEmpty
    @Size(min=2, max=20, message="이름은 2자 이상 20자 이하이어야 합니다.")
	@Column(nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "statusId", nullable = false)
	OnOffStatus status;
	
	private int lessionTime;
	
	@CreatedDate
	private Date createDate;
	
	private int lessionFee;
	
	private String lessionMethod;

	@Transient
	private String statusText;
	
	@Transient
	private Integer categoryId;
	
	@Override
	public String toString() {
		return "AcademyLession [id=" + id + ", academyBranch=" + academyBranch + ", name=" + name + ", lessionTime="
				+ lessionTime + ", createDate=" + createDate + ", lessionFee=" + lessionFee + ", lessionMethod="
				+ lessionMethod + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AcademyLession other = (AcademyLession) obj;
		if (academyBranch == null) {
			if (other.academyBranch != null)
				return false;
		} else if (!academyBranch.equals(other.academyBranch))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (id != other.id)
			return false;
		if (lessionFee != other.lessionFee)
			return false;
		if (lessionMethod == null) {
			if (other.lessionMethod != null)
				return false;
		} else if (!lessionMethod.equals(other.lessionMethod))
			return false;
		if (lessionTime != other.lessionTime)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((academyBranch == null) ? 0 : academyBranch.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + id;
		result = prime * result + lessionFee;
		result = prime * result + ((lessionMethod == null) ? 0 : lessionMethod.hashCode());
		result = prime * result + lessionTime;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}
	
}
