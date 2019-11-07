package com.leeweb.management.purchase.dao;

import java.util.List;

import com.leeweb.management.purchase.dto.CategoryDTO;

/*
 * 開発者:イーソンハク
 * 使用目的：インターフェースとして使用するため
 * 使用方：implementsで宣言後使用
 */
public interface CalculateDao {
	public List<CategoryDTO> calculateCategory();
}