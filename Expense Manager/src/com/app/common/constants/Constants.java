package com.app.common.constants;

public interface Constants
{
	/*
	 * Common
	 * 
	 * */
	
	public static final String MESSAGE = "message";
	
	/*Query*/
	public static final String SELECT_ALL_FROM = "SELECT * FROM ";
	public static final String WHERE = " WHERE ";
	public static final String AND = " AND ";
	public static final String EQUAL_TO = "=:";
	
	/*Category Type*/
	public static final String CATEGORY_INCOME = "Income";
	public static final String CATEGORY_EXPENSE = "Expense";
	
	/*Category Flags*/
	public static final String SHOW_CATEGORIES = "showCategories";
	
	/*Transaction Flags*/
	public static final String FROM_ADD_TRANSACTION = "fromAddTransaction";
	public static final String SHOW_ADD_TRANSACTION = "showAddTransaction";
	
	/*User*/
	public static final String USER = "user";
	
	/*Wallet*/
	public static final String USER_WALLETS = "userWallets";
	public static final String USER_WALLET = "userWallet";
	
	/*Category*/
	public static final String WALLET_CATEGORY = "walletCategory";
	public static final String WALLET_CATEGORY_INCOME = "walletCategoryIncome";
	public static final String WALLET_CATEGORY_EXPENSE = "walletCategoryExpense";
	
	/*Wallet Transaction*/
	public static final String USER_WALLET_TRANSACTIONS = "userWalletTransactions";
	
	/*
	 * DB Tables
	 * 
	 * */
	
	/*ST_USERS*/
	public static final String USERS = "ST_USERS";
	public static final String USER_NAME = "user_name";
	public static final String PASSWORD = "password";
	
	/*USER_WALLET*/
	public static final String WALLET = "user_wallet";
	public static final String WALLET_ID = "wallet_id";
	public static final String USER_ID = "user_id";
	
	/*WALLET_TRANSACTIONS*/
	public static final String WALLET_TRANSACTIONS = "wallet_transactions";
	public static final String USER_WALLET_ID = "user_wallet_id";
	public static final String TRANSACTION_ID = "transaction_id";
	
	/*ST_CATEGORY*/
	public static final String CATEGORY = "st_category";
	public static final String CATEGORY_ID = "category_id";
	
	
	/*
	 * Queries
	 * 
	 * */
	
	/*User Queries*/
	public static final String USER_VALIDATE_USER = "User.validateUser";
	public static final String GET_USER_BY_USERNAME_PASSWORD = SELECT_ALL_FROM + USERS + WHERE + USER_NAME + EQUAL_TO + USER_NAME + AND + PASSWORD + EQUAL_TO + PASSWORD;
	
	/*Wallet Queries*/
	public static final String WALLET_GET_WALLET = "Wallet.getWalletByWalletId";
	public static final String GET_WALLET_BY_WALLET_ID = SELECT_ALL_FROM + WALLET + WHERE + WALLET_ID + EQUAL_TO + WALLET_ID;
	
	public static final String WALLET_GET_WALLETS = "Wallet.getWalletsByUserId";
	public static final String GET_WALLETS_BY_USER_ID = SELECT_ALL_FROM + WALLET + WHERE + USER_ID + EQUAL_TO + USER_ID;
	
	/*Wallet Transactions Queries*/
	public static final String WALLET_TRANSACTIONS_GET_TRANSACTION_BY_ID = "WalletTransaction.getTransactionById";
	public static final String GET_WALLET_TRANSACTION_BY_ID = SELECT_ALL_FROM + WALLET_TRANSACTIONS + WHERE + TRANSACTION_ID + EQUAL_TO + TRANSACTION_ID;
	public static final String WALLET_TRANSACTIONS_GET_USER_TRANSACTIONS_BY_USER_ID = "WalletTransaction.getUsertransactionByUserId";
	public static final String GET_USER_TRANSACTIONS_BY_USER_ID = SELECT_ALL_FROM + WALLET_TRANSACTIONS + WHERE + USER_ID + EQUAL_TO + USER_ID;
	public static final String WALLET_TRANSACTIONS_GET_WALLET_TRANSACTIONS_BY_WALLET_ID = "WalletTransaction.getWalletTransactionsByWalletId";
	public static final String GET_WALLET_TRANSACTIONS_BY_WALLET_ID = SELECT_ALL_FROM + WALLET_TRANSACTIONS + WHERE + USER_WALLET_ID + EQUAL_TO + USER_WALLET_ID;
	
	/*Category Queries*/
	public static final String CATEGORY_GET_CATEGORY_BY_ID = "Category.getCategoryById";
	public static final String GET_CATEGORY_BY_CATEGORY_ID = SELECT_ALL_FROM + CATEGORY + WHERE + CATEGORY_ID + EQUAL_TO + CATEGORY_ID;
	public static final String CATEGORY_GET_CATEGORIES_BY_WALLET = "Category.getCategoriesByWallet";
	public static final String GET_CATEGORIES_BY_WALLET_ID = SELECT_ALL_FROM + CATEGORY + WHERE + WALLET_ID + EQUAL_TO + WALLET_ID;

}
