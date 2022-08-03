package com.varxyz.javacafe.provider;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryProvider {
	private long cid;
	private String categoryName;
	
	public CategoryProvider() {
		
	}
}
