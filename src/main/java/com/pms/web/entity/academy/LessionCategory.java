package com.pms.web.entity.academy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class LessionCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "academyBranchId", nullable = false)
	@JsonIgnore
	private AcademyBranch academyBranch;
	
	@NotEmpty
    @Size(min=2, max=20, message="이름은 2자 이상 20자 이하이어야 합니다.")
	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "lessionCategory", targetEntity = AcademyLession.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	List<AcademyLession> lessions;
	
	@ManyToOne
	@JoinColumn(name = "statusId", nullable = false)
	@JsonIgnore
	OnOffStatus status;
	
	public LessionCategory(String name, AcademyBranch branch, OnOffStatus status) {
		this.name = name;
		this.academyBranch = branch;
		this.status = status;
	}

}
