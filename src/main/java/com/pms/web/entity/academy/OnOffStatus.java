package com.pms.web.entity.academy;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class OnOffStatus {
	public static String ON = "on";
	public static String OFF = "off";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false)
	private String textKey;

	public OnOffStatus(String textKey){
		this.textKey = textKey;
	}
}
