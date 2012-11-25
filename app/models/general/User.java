package models.general;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import play.db.jpa.Model;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "USR_ID")
    @SequenceGenerator(name = "USERS_SEQ")
    private long id;

    @Column(name = "USR_NAME")
    private String name;

    @Column(name = "USR_EMAIL")
    private String email;

    @Column(name = "USR_CREATION_DATE")
    private Date creationDate;

    @Column(name = "USR_STATUS")
    private UserStatus status;

    /**
     * Default constructor. All newly created users must have the status 'active' and the creation date set to 'now'.
     */
    public User() {
        this.creationDate = Calendar.getInstance().getTime();
        this.status = UserStatus.ACTIVE;
    }

    /**
     * Along with the behavior of the default constructor, this alternative also allows to pre-set the name and email
     * attributes.
     */
    public User(String _name, String _email) {
        this();
        this.name = _name;
        this.email = _email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}