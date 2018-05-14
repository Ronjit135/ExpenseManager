package com.app.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.common.constants.Constants;
import com.app.data.entity.category.Category;
import com.app.data.entity.user.User;
import com.app.data.entity.wallet.UserWallet;
import com.app.data.entity.wallet.WalletTransaction;
import com.app.service.ifc.UserServiceIfc;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	private UserServiceIfc userService;

	@PostMapping("/Login")
	public String showLogin(User user, HttpSession session) {
		user = userService.validateUser(user);
		if (user != null) {
			session.setAttribute(Constants.USER, user);
			return "redirect:/Home";
		}
		return "redirect:/";
	}

	@GetMapping("/Home")
	public String showHomePage(HttpSession session, ModelMap map) {
		if (!isAuthorized(session))
			return "redirect:/";
		List<UserWallet> userWallets = userService.getUserWallets((User) session.getAttribute(Constants.USER));
		map.addAttribute(Constants.USER_WALLETS, userWallets);
		if(session.getAttribute("fromAddTransaction") != null && (boolean) session.getAttribute("fromAddTransaction")){
			session.setAttribute(Constants.FROM_ADD_TRANSACTION, false);
			session.setAttribute(Constants.SHOW_ADD_TRANSACTION, true);
		} else {
			session.setAttribute(Constants.SHOW_ADD_TRANSACTION, false);
		}
		return "HomePage";
	}

	@PostMapping("/Home/Add")
	public String showAddTransaction(HttpSession session, Long walletId, ModelMap map) {
		if (!isAuthorized(session))
			return "redirect:/";
		UserWallet wallet = userService.getUserWallet(walletId);
		session.setAttribute(Constants.USER_WALLET, wallet);
		map.addAttribute(Constants.USER_WALLET, wallet);
		buildCategories(map, wallet);
		session.setAttribute(Constants.WALLET_CATEGORY, map.get(Constants.WALLET_CATEGORY));
		session.setAttribute(Constants.FROM_ADD_TRANSACTION, true);
		return "redirect:/Home";
	}

	@PostMapping("/Home/AddTransaction")
	public String addTransaction(HttpSession session, String transactionDesc, Long amount, Long categoryId,
			Long walletId) {
		if (!isAuthorized(session))
			return "redirect:/";
		User user = (User) session.getAttribute(Constants.USER);
		UserWallet wallet = userService.getUserWallet(walletId);
		Category category = userService.getCategoryByCategoryId(categoryId);
		Long creditAmount = new Long(0);
		Long debitAmount = new Long(0);
		Long netBalance = new Long(0);
		Long currentBalance = wallet.getCurrentBalance();
		if (category.getCategoryType().equals(Constants.CATEGORY_INCOME)) {
			creditAmount = amount;
			netBalance = currentBalance + creditAmount;
		} else {
			debitAmount = amount;
			netBalance = currentBalance - debitAmount;
		}
		wallet.setCurrentBalance(netBalance);
		Date currentDate = new Date();
		Random random = new Random();
		Long number = random.nextLong();
		Long transactionId = number > 0 ? number : 0 - number;
		WalletTransaction walletTransaction = new WalletTransaction(user, wallet, transactionId, transactionDesc,
				creditAmount, debitAmount, netBalance, category, currentDate);
		walletTransaction = userService.addWalletTransaction(user, wallet, walletTransaction);
		session.setAttribute(Constants.FROM_ADD_TRANSACTION, true);
		return "redirect:/Home";
	}

	@GetMapping("/Transactions")
	public String showTransactions(HttpSession session, ModelMap map) {
		if (!isAuthorized(session))
			return "redirect:/";
		List<UserWallet> userWallets = userService.getUserWallets((User) session.getAttribute(Constants.USER));
		map.addAttribute(Constants.USER_WALLETS, userWallets);
		return "Transaction";
	}

	@PostMapping("/Transactions")
	public String showWalletTransactions(HttpSession session, ModelMap map, Long walletId) {
		if (!isAuthorized(session))
			return "redirect:/";
		List<UserWallet> userWallets = userService.getUserWallets((User) session.getAttribute(Constants.USER));
		map.addAttribute(Constants.USER_WALLETS, userWallets);
		List<WalletTransaction> walletTransactions = userService.getTransactionsByWallet(walletId);
		Collections.reverse(walletTransactions);
		/*
		 * session.setAttribute(Constants.USER_WALLET_TRANSACTIONS,
		 * walletTransactions);
		 */
		map.addAttribute(Constants.USER_WALLET_TRANSACTIONS, walletTransactions);
		return "Transaction";
	}

	@GetMapping("/Categories")
	public String showCategories(HttpSession session, ModelMap map) {
		if (!isAuthorized(session))
			return "redirect:/";
		List<UserWallet> userWallets = userService.getUserWallets((User) session.getAttribute(Constants.USER));
		map.addAttribute(Constants.USER_WALLETS, userWallets);
		if(session.getAttribute(Constants.SHOW_CATEGORIES) != null && (Boolean) session.getAttribute(Constants.SHOW_CATEGORIES) == true){
			session.removeAttribute(Constants.SHOW_CATEGORIES);
			Long walletId = (Long) session.getAttribute(Constants.WALLET_ID);
			session.removeAttribute(Constants.WALLET_ID);
			UserWallet wallet = userService.getUserWallet(walletId);
			map.addAttribute(Constants.USER_WALLET, wallet);
			buildCategories(map, wallet);
			map.addAttribute(Constants.SHOW_CATEGORIES, true);
		} else {
			map.addAttribute(Constants.SHOW_CATEGORIES, false);
		}
		
		return "Category";
	}

	@PostMapping("/Categories")
	public String showWalletCategories(HttpSession session, Long walletId, ModelMap map) {
		if (!isAuthorized(session))
			return "redirect:/";
		UserWallet wallet = userService.getUserWallet(walletId);
		map.addAttribute(Constants.USER_WALLET, wallet);
		List<UserWallet> userWallets = userService.getUserWallets((User) session.getAttribute(Constants.USER));
		map.addAttribute(Constants.USER_WALLETS, userWallets);
		buildCategories(map, wallet);
		map.addAttribute(Constants.SHOW_CATEGORIES, true);
		return "Category";
	}

	@PostMapping("/Categories/Add")
	public String addWalletCategory(HttpSession session, Category category, Long walletId) {
		if (!isAuthorized(session))
			return "redirect:/";
		UserWallet wallet = userService.getUserWallet(walletId);
		category.setWallet(wallet);
		category = userService.addCategory(category);
		session.setAttribute(Constants.SHOW_CATEGORIES, true);
		session.setAttribute(Constants.WALLET_ID, walletId);
		return "redirect:/Categories";
	}

	@PostMapping("/Categories/EditCategory")
	public String editWalletCategory(HttpSession session, Long categoryId) {
		if (!isAuthorized(session))
			return "redirect:/";

		return "redirect:/Categories";
	}

	@PostMapping("/Categories/DeleteCategory")
	public String deleteWalletCategory(HttpSession session, Long categoryId) {
		if (!isAuthorized(session))
			return "redirect:/";
		Category category = userService.getCategoryByCategoryId(categoryId);
		userService.deleteCategory(category);
		return "redirect:/Categories";
	}

	@GetMapping("/Wallets")
	public String showWallets(HttpSession session, ModelMap map) {
		if (!isAuthorized(session))
			return "redirect:/";
		List<UserWallet> userWallets = userService.getUserWallets((User) session.getAttribute(Constants.USER));
		map.addAttribute(Constants.USER_WALLETS, userWallets);
		return "Wallet";
	}

	@PostMapping("/Wallets/Add")
	public String addWallet(HttpSession session, UserWallet userWallet) {
		if (!isAuthorized(session))
			return "redirect:/";
		User sessionUser = (User) session.getAttribute(Constants.USER);
		userWallet.setWalletCurrency(new Long(0));
		userWallet.setUser(sessionUser);
		userWallet = userService.addWallet(userWallet);
		Random random = new Random();
		Long number = random.nextLong();
		Long transactionId = number > 0 ? number : 0 - number;
		WalletTransaction transaction = new WalletTransaction(sessionUser, userWallet, transactionId, "Initial Balance",
				userWallet.getCurrentBalance(), new Long(0), userWallet.getCurrentBalance(), null, new Date());
		transaction = userService.addWalletTransaction(sessionUser, userWallet, transaction);
		return "redirect:/Wallets";
	}

	@PostMapping("/Wallets/Delete")
	public String deleteWallet(HttpSession session, Long walletId) {
		if (!isAuthorized(session))
			return "redirect:/";
		UserWallet wallet = userService.getUserWallet(walletId);
		userService.deleteWallet(wallet);
		return "redirect:/Wallets";
	}

	@GetMapping("/Profile")
	public String showProfile(HttpSession session, ModelMap map) {
		if (!isAuthorized(session))
			return "redirect:/";
		map.addAttribute(Constants.USER, session.getAttribute(Constants.USER));
		return "Profile";
	}

	@PostMapping("/Profile/Save")
	public String saveProfile(HttpSession session, User user) {
		if (!isAuthorized(session))
			return "redirect:/";
		User sessionUser = (User) session.getAttribute(Constants.USER);
		user.setUserId(sessionUser.getUserId());
		if (user.getPassword() == null || user.getPassword().isEmpty())
			user.setPassword(sessionUser.getPassword());
		userService.updateUser(user);
		session.setAttribute(Constants.USER, user);
		return "redirect:/Home";
	}

	@GetMapping("/About")
	public String showAbout(HttpSession session) {
		if (!isAuthorized(session))
			return "redirect:/";

		return "HomePage";
	}

	@GetMapping("/Contact")
	public String showContact(HttpSession session) {
		if (!isAuthorized(session))
			return "redirect:/";

		return "HomePage";
	}

	@GetMapping("/Logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	private Boolean isAuthorized(HttpSession session) {
		if (session.getAttribute(Constants.USER) != null)
			return true;
		return false;
	}

	private void buildCategories(ModelMap map, UserWallet userWallet) {
		List<Category> walletCategoryList = userService.getCategoriesByWalletId(userWallet.getWalletId());
		map.addAttribute(Constants.WALLET_CATEGORY, walletCategoryList);
		List<Category> walletCategoryIncome = new ArrayList<>();
		List<Category> walletCategoryExpense = new ArrayList<>();
		for (Category category : walletCategoryList) {
			if (category.getCategoryType().equals(Constants.CATEGORY_INCOME)) {
				walletCategoryIncome.add(category);
			} else {
				walletCategoryExpense.add(category);
			}
		}
		map.addAttribute(Constants.WALLET_CATEGORY_INCOME, walletCategoryIncome);
		map.addAttribute(Constants.WALLET_CATEGORY_EXPENSE, walletCategoryExpense);
	}
}
