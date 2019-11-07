package com.leeweb.management.purchase.dto;

/*
 * 開発者:イーソンハク
 * 使用目的：カテゴリーの計算情報をセーブするクラス
 * 使用方：客体を宣言して使用
 */
public class CategoryDTO {

	private String CATEGORY;
	private double TOTAL;

	public String getCATEGORY() {
		return CATEGORY;
	}
	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}
	public double getTOTAL() {
		return TOTAL;
	}
	public void setTOTAL(double d) {
		TOTAL = d;
	}
}
