package com.common.domain.posts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BoardVO {

	@Id
	@GeneratedValue
	int id;
	
	String writer;
	String content;
	int cnt;
}
