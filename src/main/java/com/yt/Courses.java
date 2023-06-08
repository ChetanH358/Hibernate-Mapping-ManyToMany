package com.yt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Courses_DETAILS")
@Entity
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Cid;
	private String Cname;
	private String Cduration;
	private String Ctrainer;
	private int Cfees;

	public int getCid() {
		return Cid;
	}

	public void setCid(int cid) {
		Cid = cid;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	public String getCduration() {
		return Cduration;
	}

	public void setCduration(String cduration) {
		Cduration = cduration;
	}

	public String getCtrainer() {
		return Ctrainer;
	}

	public void setCtrainer(String ctrainer) {
		Ctrainer = ctrainer;
	}

	public int getCfees() {
		return Cfees;
	}

	public void setCfees(int cfees) {
		Cfees = cfees;
	}

}