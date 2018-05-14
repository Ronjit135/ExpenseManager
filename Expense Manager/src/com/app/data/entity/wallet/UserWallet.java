package com.app.data.entity.wallet;

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
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.app.common.constants.Constants;
import com.app.data.entity.category.Category;
import com.app.data.entity.user.User;

@Entity
@Table(name = "user_wallet")
@NamedNativeQueries({
		@NamedNativeQuery(name = Constants.WALLET_GET_WALLET, query = Constants.GET_WALLET_BY_WALLET_ID, resultClass = UserWallet.class),
		@NamedNativeQuery(name = Constants.WALLET_GET_WALLETS, query = Constants.GET_WALLETS_BY_USER_ID, resultClass = UserWallet.class) 
		})
public class UserWallet {
	private Long walletId;
	private String walletName;
	private Long walletCurrency;
	private Long initialBalance;
	private Long currentBalance;
	private User user;
	private List<Category> categories;
	private List<WalletTransaction> transactions;

	public UserWallet() {
		super();
	}

	public UserWallet(String walletName, Long walletCurrency, Long initialBalance, Long currentBalance, User user) {
		super();
		this.walletName = walletName;
		this.walletCurrency = walletCurrency;
		this.initialBalance = initialBalance;
		this.user = user;
	}

	public UserWallet(Long walletId, String walletName, Long walletCurrency, Long initialBalance, Long currentBalance, User user) {
		super();
		this.walletId = walletId;
		this.walletName = walletName;
		this.walletCurrency = walletCurrency;
		this.initialBalance = initialBalance;
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wallet_id")
	public Long getWalletId() {
		return walletId;
	}

	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}

	@Column(name = "wallet_name", length = 30)
	public String getWalletName() {
		return walletName;
	}

	public void setWalletName(String walletName) {
		this.walletName = walletName;
	}

	@Column(name = "wallet_currency")
	public Long getWalletCurrency() {
		return walletCurrency;
	}

	public void setWalletCurrency(Long walletCurrency) {
		this.walletCurrency = walletCurrency;
	}

	@Column(name = "initial_balance")
	public Long getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(Long initialBalance) {
		this.initialBalance = initialBalance;
	}

	@Column(name="current_balance")
	public Long getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Long currentBalance) {
		this.currentBalance = currentBalance;
	}

	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(mappedBy="wallet",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@OneToMany(mappedBy="userWallet",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	public List<WalletTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<WalletTransaction> transactions) {
		this.transactions = transactions;
	}
}
