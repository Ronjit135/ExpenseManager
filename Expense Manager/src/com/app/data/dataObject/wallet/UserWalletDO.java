package com.app.data.dataObject.wallet;

public class UserWalletDO {
	private Long walletId;
	private String walletName;
	private Long walletCurrency;
	private Long initialBalance;

	public UserWalletDO() {
		super();
	}

	public UserWalletDO(String walletName, Long walletCurrency, Long initialBalance) {
		super();
		this.walletName = walletName;
		this.walletCurrency = walletCurrency;
		this.initialBalance = initialBalance;
	}

	public UserWalletDO(Long walletId, String walletName, Long walletCurrency, Long initialBalance) {
		super();
		this.walletId = walletId;
		this.walletName = walletName;
		this.walletCurrency = walletCurrency;
		this.initialBalance = initialBalance;
	}

	public Long getWalletId() {
		return walletId;
	}

	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}

	public String getWalletName() {
		return walletName;
	}

	public void setWalletName(String walletName) {
		this.walletName = walletName;
	}

	public Long getWalletCurrency() {
		return walletCurrency;
	}

	public void setWalletCurrency(Long walletCurrency) {
		this.walletCurrency = walletCurrency;
	}

	public Long getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(Long initialBalance) {
		this.initialBalance = initialBalance;
	}
}
