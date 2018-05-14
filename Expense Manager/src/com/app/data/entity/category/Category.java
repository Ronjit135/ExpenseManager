package com.app.data.entity.category;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;

import com.app.common.constants.Constants;
import com.app.data.entity.wallet.UserWallet;
import com.app.data.entity.wallet.WalletTransaction;

@Entity(name="st_category")
@NamedNativeQueries({
	@NamedNativeQuery(name=Constants.CATEGORY_GET_CATEGORY_BY_ID,query=Constants.GET_CATEGORY_BY_CATEGORY_ID,resultClass=Category.class),
	@NamedNativeQuery(name=Constants.CATEGORY_GET_CATEGORIES_BY_WALLET,query=Constants.GET_CATEGORIES_BY_WALLET_ID,resultClass=Category.class)
})
public class Category {
	private Long categoryId;
	private String categoryName;
	private String categoryDesc;
	private String categoryType;
	private UserWallet wallet;
	private List<WalletTransaction> transactions;
	
	public Category() {
		super();
	}

	public Category(String categoryName,String categoryDesc, String categoryType, UserWallet wallet) {
		super();
		this.categoryName = categoryName;
		this.categoryDesc = categoryDesc;
		this.categoryType = categoryType;
		this.wallet = wallet;
	}

	public Category(Long categoryId, String categoryName,String categoryDesc, String categoryType, UserWallet wallet) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDesc = categoryDesc;
		this.categoryType = categoryType;
		this.wallet = wallet;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name="category_name",length=60)
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Column(name="category_description",length=60)
	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	@Column(name="category_type",length=60)
	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	@ManyToOne
	@JoinColumn(name="wallet_id")
	public UserWallet getWallet() {
		return wallet;
	}

	public void setWallet(UserWallet wallet) {
		this.wallet = wallet;
	}

	@OneToMany(mappedBy="category",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	public List<WalletTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<WalletTransaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDesc="
				+ categoryDesc + ", categoryType=" + categoryType + ", wallet=" + wallet + "]";
	}
}
