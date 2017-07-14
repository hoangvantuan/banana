package banana.model;

import banana.validation.CreateGroup;
import banana.validation.EmailField;
import banana.validation.PasswordField;
import banana.validation.UpdateGroup;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
@DynamicInsert
@DynamicUpdate
public class User {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "ID")
  @GenericGenerator(name = "generator", strategy = "increment")
  @GeneratedValue(generator = "generator")
  private Integer id;

  @EmailField(groups = {CreateGroup.class})
  @Column(name = "EMAIL", nullable = false, unique = true)
  private String email;

  @PasswordField(groups = {UpdateGroup.class, CreateGroup.class})
  @Column(name = "PASSWORD", nullable = false)
  private String password;

  @Column(name = "ACTIVE")
  private Boolean active;

  @Column(name = "CREATE_AT")
  private Date createAt;

  @Column(name = "UPDATE_AT")
  private Date updateAt;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
  private List<Account> accounts;

  public User() {
    this.id = null;
    this.accounts = null;
    this.active = null;
    this.createAt = null;
    this.email = null;
    this.password = null;
    this.updateAt = null;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
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

  public List<Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<Account> accounts) {
    this.accounts = accounts;
  }

}
