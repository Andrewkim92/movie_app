package com.common.domain.posts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.common.domain.posts.Posts.PostsBuilder;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class LangVO {

	@Id
	@GeneratedValue
	int id;
	
	String title;
	String genres;
	
	String poster;
	String synopsis;
	
	@Builder
    public LangVO(String title,String genres,String poster,String synopsis) {
        this.title = title;
        this.genres = genres;
        this.poster = poster;
        this.synopsis = synopsis;
    }
	
}
