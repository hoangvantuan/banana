package banana.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "sequence")

public class Sequence {

	private static final long serialVersionUID = 1L;
	@Id
	@NotEmpty
	@Column(name = "TABLE_NAME", nullable=false)
	private String id;

	@NotEmpty
	@Column(name = "SEQUENCE_NUMBER", nullable=false)
	private Long userID;

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

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
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
