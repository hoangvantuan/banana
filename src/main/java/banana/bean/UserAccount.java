package banana.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_account")

public class UserAccount {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	private String id;
	@Column(name = "USER_ID")
	private String userID;
	@Column(name = "ACCOUNT_ID")
	private String accountID;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

}
