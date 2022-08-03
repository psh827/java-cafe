package com.varxyz.javacafe.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FIleEntity {
	private long iId;
	private String orgNm;
	private String savedNm;
	private String savedPath;
	
	@Builder
	public FIleEntity(long iId, String orgNm, String savedNm, String savedPath) {
		this.iId = iId;
		this.orgNm = orgNm;
		this.savedNm = savedNm;
		this.savedPath = savedPath;
	}
	
	

	
	
}
