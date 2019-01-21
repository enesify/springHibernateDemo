package com.enesify.spring.demo.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;
/**
 * The persistent class for the INSTRUCTOR_DETAIL database table.
 * 
 */
@Entity
@Table(name = "INSTRUCTOR_DETAIL")
public class InstructorDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger id;

	private String hobby;

	@Column(name = "YOUTUBE_CHANNEL")
	private String youtubeChannel;

	public InstructorDetail() {
	}

	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getHobby() {
		return this.hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getYoutubeChannel() {
		return this.youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}


}