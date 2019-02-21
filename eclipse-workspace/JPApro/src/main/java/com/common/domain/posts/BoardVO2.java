package com.common.domain.posts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.common.domain.BaseTimeEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BoardVO2 extends BaseTimeEntity{

	@Id
	@GeneratedValue
	int id;
	
	String writer;
	String subject;
	String content;
	int cnt;
	
}
