package com.onboarding.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class OnBoardDocumentDto {

	private long id;

	private String documentType;

	private String format;

	private int size;

	private String pathName;

	private String documentName;

}
