package banana.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private String id;

	@NotEmpty
	@Email
	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;

	@NotEmpty
	@Size(min = 8)
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "ACTIVE")
	private Boolean active;

	@Column(name = "CREATE_AT")
	private Date createAt;

	@Column(name = "UPDATE_AT")
	private Date updateAt;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	Set<Account> accounts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
}
