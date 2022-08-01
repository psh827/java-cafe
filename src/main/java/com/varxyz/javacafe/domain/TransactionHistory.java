package com.varxyz.javacafe.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 거래내역에서는 그 달의 거래내역을 보여주어야한다.
 * 8/15일에 거래내역에 들어간다면 8/15일까지의 거래내역을 보여주어야하고
 * 9/1일이되면 8월달 거래내역은 db로 들어가고 새로운 거래내역으로 시작해야한다.
 * 보여줄 내역은 거래일시 | 거래품목 | 거래수량 | 총액.
 * 마지막 줄에는 한달 총액을 표시해야한다.
 * @author Administrator
 *
 */
@Getter
@Setter
public class TransactionHistory {
	private Date regDate;
	private String menuItemName;
	private int salesVolume;
	private int total;
	private int monthTotal;
}
