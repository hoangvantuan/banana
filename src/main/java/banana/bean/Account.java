package banana.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "account")

public class Account {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	private String id;

	@NotEmpty
	@Column(name = "URL", nullable=false)
	private String url;

	@NotEmpty
	@Column(name = "ACCOUNT_NAME", nullable=false)
	private String accountName;

	@NotEmpty
	@Column(name = "PASSWORD", nullable=false)
	private String password;

	@Column(name = "CREATE_AT")
	private Date createAt;

	@Column(name = "UPDATE_AT")
	private Date updateAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

}
