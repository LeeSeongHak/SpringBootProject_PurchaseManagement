package com.leeweb.management.purchase.dto;

/*
 * 開発者:イーソンハク
 * 使用目的：ファイルの内容をセーブするクラス
 * 使用方：客体を宣言して使用
 */
public class FileDTO {

	private String PRODUCT_ID;
	private int QUANTITY;
	private String CREATE_USER;
	private String UPDATE_USER;

	public String getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	public void setPRODUCT_ID(String pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}
	public int getQUANTITY() {
		return QUANTITY;
	}
	public void setQUANTITY(int qUANTITY) {
		QUANTITY = qUANTITY;
	}
	public String getCREATE_USER() {
		return CREATE_USER;
	}
	public void setCREATE_USER(String cREATE_USER) {
		CREATE_USER = cREATE_USER;
	}
	public String getUPDATE_USER() {
		return UPDATE_USER;
	}
	public void setUPDATE_USER(String uPDATE_USER) {
		UPDATE_USER = uPDATE_USER;
	}
}