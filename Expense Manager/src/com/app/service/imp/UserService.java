package com.app.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ifc.UserDAOIfc;
import com.app.data.entity.category.Category;
import com.app.data.entity.user.User;
import com.app.data.entity.wallet.UserWallet;
import com.app.data.entity.wallet.WalletTransaction;
import com.app.service.ifc.UserServiceIfc;

@Service
@Transactional
public class UserService implements UserServiceIfc
{
	@Autowired
	private UserDAOIfc userDAO;
	
	@Override
	public User validateUser(User user)
	{
		return userDAO.validateUser(user.getUserName(),user.getPassword());
	}

	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	@Override
	public List<UserWallet> getUserWallets(User user) {
		return userDAO.getUserWallets(user);
	}

	@Override
	public UserWallet addWallet(UserWallet wallet) {
		return userDAO.addWallet(wallet);
	}

	@Override
	public void deleteWallet(UserWallet wallet) {
		userDAO.deleteWallet(wallet);
	}

	@Override
	public UserWallet getUserWallet(Long walletId) {
		return userDAO.getUserWallet(walletId);
	}

	@Override
	public List<Category> getCategoriesByWalletId(Long walletId) {
		return userDAO.getCategoriesByWalletId(walletId);
	}

	@Override
	public Category addCategory(Category category) {
		return userDAO.addCategory(category);
	}

	@Override
	public void updateCategory(Category category) {
		userDAO.updateCategory(category);
	}

	@Override
	public Category getCategoryByCategoryId(Long categoryId) {
		return userDAO.getCategoryByCategoryId(categoryId);
	}

	@Override
	public void deleteCategory(Category category) {
		userDAO.deleteCategory(category);
	}

	@Override
	public WalletTransaction addWalletTransaction(User user, UserWallet wallet, WalletTransaction transaction) {
		return userDAO.addWalletTransaction(user, wallet, transaction);
	}

	@Override
	public List<WalletTransaction> getTransactionsByWallet(Long walletId) {
		return userDAO.getTransactionsByWallet(walletId);
	}
}
