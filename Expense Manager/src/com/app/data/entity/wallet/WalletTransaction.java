package com.app.data.entity.wallet;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.app.common.constants.Constants;
import com.app.data.entity.category.Category;
import com.app.data.entity.user.User;

@Entity(name = "wallet_transactions")
@NamedNativeQueries({
	@NamedNativeQuery(name=Constants.WALLET_TRANSACTIONS_GET_TRANSACTION_BY_ID,query=Constants.GET_WALLET_TRANSACTION_BY_ID,resultClass=WalletTransaction.class),
	@NamedNativeQuery(name=Constants.WALLET_TRANSACTIONS_GET_USER_TRANSACTIONS_BY_USER_ID,query=Constants.GET_USER_TRANSACTIONS_BY_USER_ID,resultClass=WalletTransaction.class),
	@NamedNativeQuery(name=Constants.WALLET_TRANSACTIONS_GET_WALLET_TRANSACTIONS_BY_WALLET_ID,query=Constants.GET_WALLET_TRANSACTIONS_BY_WALLET_ID,resultClass=WalletTransaction.class)
})
public class WalletTransaction {
	private Long walletTransactionId;
	private User walletUser;
	private UserWallet userWallet;
	private Long transactionId;
	private String transactionDesc;
	private Long creditAmount;
	private Long debitAmount;
	private Long netAmount;
	private Category category;
	private Date transactionDate;

	public WalletTransaction() {
		super();
	}

	public WalletTransaction(User walletUser, UserWallet userWallet, Long transactionId, String transactionDesc,
			Long creditAmount, Long debitAmount, Long netAmount, Category category, Date transactionDate) {
		super();
		this.walletUser = walletUser;
		this.userWallet = userWallet;
		this.transactionId = transactionId;
		this.transactionDesc = transactionDesc;
		this.creditAmount = creditAmount;
		this.debitAmount = debitAmount;
		this.netAmount = netAmount;
		this.category = category;
		this.transactionDate = transactionDate;
	}

	public WalletTransaction(Long walletTransactionId, User walletUser, UserWallet userWallet, Long transactionId,
			String transactionDesc, Long creditAmount, Long debitAmount, Long netAmount, Category category,
			Date transactionDate) {
		super();
		this.walletTransactionId = walletTransactionId;
		this.walletUser = walletUser;
		this.userWallet = userWallet;
		this.transactionId = transactionId;
		this.transactionDesc = transactionDesc;
		this.creditAmount = creditAmount;
		this.debitAmount = debitAmount;
		this.netAmount = netAmount;
		this.category = category;
		this.transactionDate = transactionDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wallet_transaction_id")
	public Long getWalletTransactionId() {
		return walletTransactionId;
	}

	public void setWalletTransactionId(Long walletTransactionId) {
		this.walletTransactionId = walletTransactionId;
	}

	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return walletUser;
	}

	public void setUser(User user) {
		this.walletUser = user;
	}

	
	@ManyToOne
	@JoinColumn(name = "user_wallet_id")
	public UserWallet getUserWallet() {
		return userWallet;
	}

	public void setUserWallet(UserWallet userWallet) {
		this.userWallet = userWallet;
	}

	@Column(name = "transaction_id")
	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	@Column(name = "transaction_description", length = 60)
	public String getTransactionDesc() {
		return transactionDesc;
	}

	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}

	@Column(name = "credit_amount")
	public Long getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Long creditAmount) {
		this.creditAmount = creditAmount;
	}

	@Column(name = "debit_amount")
	public Long getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(Long debitAmount) {
		this.debitAmount = debitAmount;
	}

	@Column(name = "net_amount")
	public Long getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Long netAmount) {
		this.netAmount = netAmount;
	}

	@ManyToOne
	@JoinColumn(name = "category_id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "transaction_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "WalletTransaction [walletTransactionId=" + walletTransactionId + ", user=" + walletUser + ", userWallet="
				+ userWallet + ", transactionId=" + transactionId + ", transactionDesc=" + transactionDesc
				+ ", creditAmount=" + creditAmount + ", debitAmount=" + debitAmount + ", netAmount=" + netAmount
				+ ", category=" + category + ", transactionDate=" + transactionDate + "]";
	}
}