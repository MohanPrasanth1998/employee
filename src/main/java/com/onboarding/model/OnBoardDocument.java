package com.onboarding.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "on_board_document")
//,uniqueConstraints = @UniqueConstraint(columnNames = {"doc_type","file_type","ref_id"})
@ToString
public class OnBoardDocument { //AuditMaker Pending

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "doc_type")
	private String docType;
	
	@Column(name = "file_format")
	private String fileFormat;
	
	@Column(name = "file_size")
	private long fileSize;
	
	@Column(name = "path_name")
	private String pathName;
	
	@Column(name = "doc_name")
	private String docName;
	
	@Column(name="file_type")
	private String fileType;
	

	@ManyToOne(targetEntity = OnBoardReference.class)
	@JoinColumn(name = "ref_id", referencedColumnName = "ref_Id")
	private OnBoardReference onBoardingReference;


	
	

}
