package com.varxyz.javacafe.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 소분류 카테고리는 대분류 카테고리와 연결되어야한다.
 * 하위로는 메뉴아이테을 가지고 있다.
 * 소분류 카테고리는 하나의 대분류카테고리를 가지지만
 * 여러개의 메뉴아이템을 가지고있다.
 * @author Administrator
 *
 */
@Getter
@Setter
public class SmallCategory {
	private long scPk;
	private long lcFk;
	private LargeCategory largeCategory;
	private String smallCategoryName;
	
}
