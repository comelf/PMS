package com.pms.web.entity.academy;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class SalaryType {
	
	public static String FIXED = "fixed";
	public static String CHANGE = "change";
	public static String MIXED = "mixed";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false)
	private String textKey;

	@Column(nullable = false)
	private String name;
	
	public SalaryType(String textKey, String name){
		this.textKey = textKey;
		this.name = name;
	}
	
}
