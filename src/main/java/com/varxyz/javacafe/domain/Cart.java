package com.varxyz.javacafe.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * cart에는 여러가지 물건이 들어올 수 있다.
 * 예를들면 아이스아메리카노 3잔, 카페라떼 2잔.
 * 이렇게 들어온다면 아이스아메리카노 3잔을 카트에 담고, 카페라떼 2잔을 담아야한다.
 * 카페라떼2잔을 담을때 카트에는 아메리카노 3잔이 남아있어야한다.
 * new MenuItem(String muenuItemName, int Stock)
 * List<MenuItem> cartList = new ArrayList<MenuItem>();
 * cartList.add(new MenuItem(iceAmericano, 3));
 * cartList.add(new MenuItem(cafeLatte, 2)); --이 부분은 구매 시점에서 작성.
 * @author Administrator
 *
 */
@Getter
@Setter
public class Cart {
	private MenuItem menuItem;
}
