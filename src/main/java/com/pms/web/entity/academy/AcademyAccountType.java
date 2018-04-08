package com.pms.web.entity.academy;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class AcademyAccountType {
	
	public static final String ADMIN = "admin";
	public static final String OWNER ="owner";
	public static final String TEACHER ="teacher";
	public static final String MANAGER ="manager";
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private String textKey;

	@Column(nullable = false)
	private String name;
	
	public AcademyAccountType(String textKey, String name) {
		this.textKey = textKey;
		this.name = name;
	}
}
