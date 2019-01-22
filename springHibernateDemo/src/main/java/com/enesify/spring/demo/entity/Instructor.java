package com.enesify.spring.demo.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the INSTRUCTOR database table.
 * 
 */
@Entity
@Table(name = "INSTRUCTOR")
public class Instructor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="instructorSeq")
	@SequenceGenerator(sequenceName="SEQ_INSTRUCTOR", allocationSize = 1, name = "instructorSeq")
	private long id;

	private String email;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	// bi-directional many-to-one association to InstructorDetail
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "INSTRUCTOR_DETAIL_ID")
	private InstructorDetail instructorDetail;

	public Instructor() {
	}

	public Instructor(String firstName, String lastName, String email) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public InstructorDetail getInstructorDetail() {
		return this.instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", instructorDetail=" + instructorDetail + "]";
	}
	
	

}