package banana.model;

import banana.validation.NotEmpty;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "account")
@DynamicInsert
@DynamicUpdate
public class Account {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "ID")
  @GenericGenerator(name = "generator", strategy = "increment")
  @GeneratedValue(generator = "generator")
  private Integer id;

  @NotEmpty
  @Column(name = "URL")
  private String url;

  @NotEmpty
  @Column(name = "ACCOUNT_NAME")
  private String accountName;

  @NotEmpty
  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "CREATE_AT")
  private Date createAt = new Date();

  @Column(name = "UPDATE_AT")
  private Date updateAt;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "USER_ID")
  private User user;

  public Account() {
    this.accountName = null;
    this.createAt = null;
    this.id = null;
    this.password = null;
    this.updateAt = null;
    this.url = null;
    this.user = null;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}
