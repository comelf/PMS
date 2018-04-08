package com.pms.web.entity.academy;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class StudentStatus {
	public static String PENDING = "pending";
	public static String OPEN = "open";
	public static String CLOSE = "close";
	public static String DELETE = "delete";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false)
	private String textKey;

	@Column(nullable = false)
	private String name;
	
	public StudentStatus(String textKey, String name){
		this.textKey = textKey;
		this.name = name;
	}
	
}
