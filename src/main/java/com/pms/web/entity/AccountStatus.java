package com.pms.web.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class AccountStatus {
	public static String OPEN ="open";
	public static String PENDING ="pending";
	public static String CLOSE ="close";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false)
	private String textKey;

	@Column(nullable = false)
	private String name;
	
	public AccountStatus(String textKey, String name){
		this.textKey = textKey;
		this.name = name;
	}
	
}
