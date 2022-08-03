package com.varxyz.javacafe.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 대분류카테고리는 소분류카테고리를 자식으로 가지고 있다.
 * 대분류카테고리 밑에는 여러개의 소분류카테고리가 존재하고, 여러개의 메뉴아이템도 가진다.
 * 두가지 케이스를 염두해두고 있는데 대분류 -> 메뉴아이템 케이스 한개, 대분류 -> 소분류 -> 메뉴아이템 케이스 한개
 * 지금 짠 도메인은 검색은 다가능하지만 양방향으로 검색이가능해 쿼리문을 잘못짜게 되면 검색에 많은 검색이
 * 필요할수도있어 주의를 해야된다.
 * @author Administrator
 *
 */

@Getter
@Setter
public class LargeCategory {
	private long lcId;
	private String largeCategoryName;
	
	public LargeCategory() {
		// TODO Auto-generated constructor stub
	}

	public LargeCategory(String largeCategoryName) {
		super();
		this.largeCategoryName = largeCategoryName;
	}

	public LargeCategory(long categoryId) {
		this.lcId = categoryId;
	}
	
	
}
