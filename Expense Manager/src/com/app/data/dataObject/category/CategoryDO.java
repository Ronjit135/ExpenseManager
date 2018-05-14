package com.app.data.dataObject.category;

public class CategoryDO {
	private Long categoryId;
	private String categoryName;
	private String categoryType;
	private Long walletId;

	public CategoryDO() {
		super();
	}

	public CategoryDO(String categoryName, String categoryType, Long walletId) {
		super();
		this.categoryName = categoryName;
		this.categoryType = categoryType;
		this.walletId = walletId;
	}

	public CategoryDO(Long categoryId, String categoryName, String categoryType, Long walletId) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryType = categoryType;
		this.walletId = walletId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public Long getWalletId() {
		return walletId;
	}

	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}
}
