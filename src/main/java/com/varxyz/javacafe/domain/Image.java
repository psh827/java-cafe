package com.varxyz.javacafe.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Image {
	private long imgId;
	private long menuFk;
	private String imgName;
	private String imgOriName;
	private String imgUrl;
	
	public Image() {
		// TODO Auto-generated constructor stub
	}

	public Image(String imgUrl, String imgName) {
		this.imgName = imgName;
		this.imgUrl = imgUrl;
	}
	
	
}
