package com.app.data.entity.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.common.constants.Constants;
import com.app.data.entity.wallet.UserWallet;
import com.app.data.entity.wallet.WalletTransaction;

@Entity
@Table(name = "st_users")
@NamedNativeQueries({
	@NamedNativeQuery(name=Constants.USER_VALIDATE_USER,query=Constants.GET_USER_BY_USERNAME_PASSWORD,resultClass=User.class)
})
public class User
{
	private Long userId;
	private String userName;
	private String password;
	private String firstName;
	private String middleName;
	private String lastName;
	private List<UserWallet> wallets;
	private List<WalletTransaction> transactions;
	
	public User() {
		super();
	}
	
	public User(String userName, String password, String firstName, String middleName, String lastName) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public User(Long userId, String userName, String password, String firstName, String middleName, String lastName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id",length=30)
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Column(name="user_name",length=30)
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name="password",length=30)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="first_name",length=30)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="middle_name",length=30)
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name="last_name",length=30)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@OneToMany(mappedBy="user",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	public List<UserWallet> getWallets() {
		return wallets;
	}

	public void setWallets(List<UserWallet> wallets) {
		this.wallets = wallets;
	}

	@OneToMany(mappedBy="userWallet",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	public List<WalletTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<WalletTransaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName=" + lastName + "]";
	}
}
