package com.pms.web.entity.academy;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Academy {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(unique=true, nullable=false)
	private String domain;
	
	public Academy(String name, String domain){
		this.name = name;
		this.domain = domain;
	}
	
}
