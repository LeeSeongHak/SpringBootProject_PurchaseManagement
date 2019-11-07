package com.leeweb.management.purchase.dao;

import java.util.List;

import com.leeweb.management.purchase.dto.ProductDTO;
import com.leeweb.management.purchase.dto.PurchaseInfoDTO;

/*
 * 開発者:イーソンハク
 * 使用目的：インターフェースとして使用するため
 * 使用方：implementsで宣言後使用
 */
public interface SearchDao {
	public List<PurchaseInfoDTO> searchByUserName(String lastName);
	public ProductDTO searchByProductID(String productID, String language);
}
