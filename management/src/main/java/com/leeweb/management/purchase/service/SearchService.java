package com.leeweb.management.purchase.service;

import java.util.List;

import com.leeweb.management.purchase.dto.ProductDTO;
import com.leeweb.management.purchase.dto.PurchaseInfoDTO;

/*
 * 開発者:イーソンハク
 * 使用目的：インターフェースとして使用するため
 * 使用方：implementsで宣言後使用
 */
public interface SearchService {
	List<PurchaseInfoDTO> searchByUserName(String lastName);
	ProductDTO searchByProductID(String productID, String language);
}
