package com.leeweb.management.purchase.dto;

/*
 * 開発者:イーソンハク
 * 使用目的：製品情報をセーブするクラス
 * 使用方：客体を宣言して使用
 */
public class ProductDTO {

	private String PRODUCT_ID;
	private String PRODUCT_NAME;
	private String CATEGORY_NAME;

	public String getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	public void setPRODUCT_ID(String pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}
	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}
	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}
	public String getCATEGORY_NAME() {
		return CATEGORY_NAME;
	}
	public void setCATEGORY_NAME(String cATEGORY_NAME) {
		CATEGORY_NAME = cATEGORY_NAME;
	}
}
