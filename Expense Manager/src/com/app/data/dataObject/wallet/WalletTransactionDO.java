package com.app.data.dataObject.wallet;

import java.util.Date;

import com.app.data.dataObject.user.UserDO;

public class WalletTransactionDO {
	private Long walletTransactionId;
	private Long userId;
	private Long userWalletId;
	private Long transactionId;
	private String transactionDesc;
	private Long creditAmount;
	private Long debitAmount;
	private Long categoryId;
	private Date transactionDate;
	public WalletTransactionDO() {
		super();
	}
	public WalletTransactionDO(Long userId, Long userWalletId, Long transactionId, String transactionDesc,
			Long creditAmount, Long debitAmount, Long categoryId, Date transactionDate) {
		super();
		this.userId = userId;
		this.userWalletId = userWalletId;
		this.transactionId = transactionId;
		this.transactionDesc = transactionDesc;
		this.creditAmount = creditAmount;
		this.debitAmount = debitAmount;
		this.categoryId = categoryId;
		this.transactionDate = transactionDate;
	}
	public WalletTransactionDO(Long walletTransactionId, Long userId, Long userWalletId, Long transactionId,
			String transactionDesc, Long creditAmount, Long debitAmount, Long categoryId, Date transactionDate) {
		super();
		this.walletTransactionId = walletTransactionId;
		this.userId = userId;
		this.userWalletId = userWalletId;
		this.transactionId = transactionId;
		this.transactionDesc = transactionDesc;
		this.creditAmount = creditAmount;
		this.debitAmount = debitAmount;
		this.categoryId = categoryId;
		this.transactionDate = transactionDate;
	}

	public Long getWalletTransactionId() {
		return walletTransactionId;
	}

	public void setWalletTransactionId(Long walletTransactionId) {
		this.walletTransactionId = walletTransactionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserWalletId() {
		return userWalletId;
	}

	public void setUserWalletId(Long userWalletId) {
		this.userWalletId = userWalletId;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionDesc() {
		return transactionDesc;
	}

	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}

	public Long getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Long creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Long getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(Long debitAmount) {
		this.debitAmount = debitAmount;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
}
