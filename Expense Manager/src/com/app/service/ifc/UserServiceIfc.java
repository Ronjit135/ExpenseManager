package com.app.service.ifc;

import java.util.List;

import com.app.data.entity.category.Category;
import com.app.data.entity.user.User;
import com.app.data.entity.wallet.UserWallet;
import com.app.data.entity.wallet.WalletTransaction;

public interface UserServiceIfc
{
	public User validateUser(User user);
	public void updateUser(User user);
	public List<UserWallet> getUserWallets(User user);
	public UserWallet addWallet(UserWallet wallet);
	public void deleteWallet(UserWallet wallet);
	public UserWallet getUserWallet(Long walletId);
	public List<Category> getCategoriesByWalletId(Long walletId);
	public Category addCategory(Category category);
	public void updateCategory(Category category);
	public Category getCategoryByCategoryId(Long categoryId);
	public void deleteCategory(Category category); 
	public WalletTransaction addWalletTransaction(User user, UserWallet wallet, WalletTransaction transaction);
	public List<WalletTransaction> getTransactionsByWallet(Long walletId);
}
