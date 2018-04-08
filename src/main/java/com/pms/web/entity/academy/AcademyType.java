package com.pms.web.entity.academy;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class AcademyType {

	public static final String MUSIC = "music";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false)
	private String textKey;

	@Column(nullable = false)
	private String name;
	
	public AcademyType(String textKey, String name) {
		this.textKey = textKey;
		this.name = name;
	}
}
