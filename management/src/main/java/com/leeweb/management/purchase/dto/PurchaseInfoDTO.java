package com.leeweb.management.purchase.dto;

/*
 * 開発者:イーソンハク
 * 使用目的：購買情報をセーブするクラス
 * 使用方：客体を宣言して使用
 */
public class PurchaseInfoDTO {

	private String PRODUCT_ID;
	private String CREATE_USER;
	private String CREATE_TIME;

	public String getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	public void setPRODUCT_ID(String pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}
	public String getCREATE_USER() {
		return CREATE_USER;
	}
	public void setCREATE_USER(String cREATE_USER) {
		CREATE_USER = cREATE_USER;
	}
	public String getCREATE_TIME() {
		return CREATE_TIME;
	}
	public void setCREATE_TIME(String cREATE_TIME) {
		CREATE_TIME = cREATE_TIME;
	}
}
