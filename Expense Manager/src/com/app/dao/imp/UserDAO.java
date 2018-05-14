package com.app.dao.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.common.constants.Constants;
import com.app.dao.ifc.UserDAOIfc;
import com.app.data.entity.category.Category;
import com.app.data.entity.user.User;
import com.app.data.entity.wallet.UserWallet;
import com.app.data.entity.wallet.WalletTransaction;

@Repository
public class UserDAO implements UserDAOIfc {
	@Autowired
	private SessionFactory sesssionFactory;

	@Override
	public User validateUser(String userName, String password) {
		User user = null;
		try {
			user = (User) sesssionFactory.getCurrentSession().getNamedNativeQuery(Constants.USER_VALIDATE_USER)
					.setParameter(Constants.USER_NAME, userName).setParameter(Constants.PASSWORD, password)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		return user;
	}

	@Override
	public void updateUser(User user) {
		sesssionFactory.getCurrentSession().update(user);
	}

	@Override
	public List<UserWallet> getUserWallets(User user) {
		List<UserWallet> userWallets = new ArrayList<>();
		userWallets = sesssionFactory.getCurrentSession().getNamedNativeQuery(Constants.WALLET_GET_WALLETS)
				.setParameter(Constants.USER_ID, user.getUserId()).getResultList();
		return userWallets;
	}

	@Override
	public UserWallet addWallet(UserWallet wallet) {
		Long walletId = (Long) sesssionFactory.getCurrentSession().save(wallet);
		wallet.setWalletId(walletId);
		return wallet;
	}

	@Override
	public void deleteWallet(UserWallet wallet) {
		sesssionFactory.getCurrentSession().delete(wallet);
	}

	@Override
	public UserWallet getUserWallet(Long walletId) {
		UserWallet wallet = (UserWallet) sesssionFactory.getCurrentSession()
				.getNamedNativeQuery(Constants.WALLET_GET_WALLET).setParameter(Constants.WALLET_ID, walletId)
				.getSingleResult();
		return wallet;
	}

	@Override
	public List<Category> getCategoriesByWalletId(Long walletId) {
		List<Category> categoryList = new ArrayList<>();
		categoryList = sesssionFactory.getCurrentSession()
				.getNamedNativeQuery(Constants.CATEGORY_GET_CATEGORIES_BY_WALLET)
				.setParameter(Constants.WALLET_ID, walletId).getResultList();
		return categoryList;
	}

	@Override
	public Category addCategory(Category category) {
		Long categoryId = (Long) sesssionFactory.getCurrentSession().save(category);
		category.setCategoryId(categoryId);
		return category;
	}

	@Override
	public void updateCategory(Category category) {
		sesssionFactory.getCurrentSession().update(category);
	}

	@Override
	public Category getCategoryByCategoryId(Long categoryId) {
		Category category = null;
		category = (Category) sesssionFactory.getCurrentSession()
				.getNamedNativeQuery(Constants.CATEGORY_GET_CATEGORY_BY_ID)
				.setParameter(Constants.CATEGORY_ID, categoryId).getSingleResult();
		return category;
	}

	@Override
	public void deleteCategory(Category category) {
		sesssionFactory.getCurrentSession().delete(category);
	}

	@Override
	public WalletTransaction addWalletTransaction(User user, UserWallet wallet, WalletTransaction transaction) {
		sesssionFactory.getCurrentSession().update(wallet);
		Long walletTransactionId = (Long) sesssionFactory.getCurrentSession().save(transaction);
		transaction.setWalletTransactionId(walletTransactionId);
		return transaction;
	}

	@Override
	public List<WalletTransaction> getTransactionsByWallet(Long walletId) {
		List<WalletTransaction> walletTransactions = new ArrayList<>();
		walletTransactions = sesssionFactory.getCurrentSession()
				.getNamedNativeQuery(Constants.WALLET_TRANSACTIONS_GET_WALLET_TRANSACTIONS_BY_WALLET_ID)
				.setParameter(Constants.USER_WALLET_ID, walletId).getResultList();
		return walletTransactions;
	}
}
