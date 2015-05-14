package com.venkat.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

import java.util.Date;

/**
 * The persistent class for a sample database table.
 *
 */
@XmlRootElement
@Entity
@Table(name="sample")
@NamedQueries({ @NamedQuery(name="Sample.findAll", query="SELECT e FROM Sample e"),
	@NamedQuery(name="Sample.find", query="SELECT e FROM Sample e where e.sampleId= :id")})
public class Sample implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sample_id")
	private int sampleId;

	@Lob
	@Column(name="sample_img")
	private byte[] sampleImg;

	@Column(name="sample_name")
	private String sampleName;

	@Temporal(TemporalType.DATE)
	@Column(name="sample_date")
	private Date sampleDate;


	public Sample() {
	}

	public int getSampleId() {
		return this.sampleId;
	}

	public void setSampleId(int sampleId) {
		this.sampleId = sampleId;
	}

	public byte[] getSampleImg() {
		return this.sampleImg;
	}

	public void setSampleImg(byte[] sampleImg) {
		this.sampleImg = sampleImg;
	}

	public String getSampleName() {
		return this.sampleName;
	}

	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}

	public Date getSampleDate() {
		return this.sampleDate;
	}

	public void setSampleDate(Date sampleDate) {
		this.sampleDate = sampleDate;
	}
}