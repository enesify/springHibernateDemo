package com.enesify.spring.demo.entity;

import java.io.Serializable;
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
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="instructorDetailSeq")
	@SequenceGenerator(sequenceName="SEQ_INSTRUCTOR_DETAIL", allocationSize = 1, name = "instructorDetailSeq")
	private long id;

	private String hobby;

	@Column(name = "YOUTUBE_CHANNEL")
	private String youtubeChannel;
	
	@OneToOne(mappedBy="instructorDetail", cascade=CascadeType.ALL)
	private Instructor instructor;

	public InstructorDetail() {
	}

	public InstructorDetail(String hobby, String youtubeChannel) {
		this.hobby = hobby;
		this.youtubeChannel = youtubeChannel;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
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

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", hobby=" + hobby + ", youtubeChannel=" + youtubeChannel + "]";
	}

	
	
	

	/*
	 * public List<Instructor> getInstructors() { return this.instructors; }
	 * 
	 * public void setInstructors(List<Instructor> instructors) { this.instructors =
	 * instructors; }
	 * 
	 * public Instructor addInstructor(Instructor instructor) {
	 * getInstructors().add(instructor); instructor.setInstructorDetail(this);
	 * 
	 * return instructor; }
	 * 
	 * public Instructor removeInstructor(Instructor instructor) {
	 * getInstructors().remove(instructor); instructor.setInstructorDetail(null);
	 * 
	 * return instructor; }
	 */

}