package com.satya.travelapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "app_user")
public class AppUser implements Serializable {

    private static final long serialVersionUID = -3004454436388981246L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotBlank(message = "First name should not be blank")
	@Size(min =2, max = 20, message="The Name should be within 2 to 20 characters")
	private String name;

    @Column(name = "contact_number", unique = true)
    @NotBlank(message = "Contact number should not be blank")
    private String contactNumber;

    @Column(name = "email", unique = true)
	@Email(message = "Invalid email format")
	@NotBlank(message = "Email should not be blank")
    private String email;


    @Column(name = "password")
    @NotBlank(message = "Password should not be blank")
    private String password;

    @Column(name = "status")
    private String status;

    @Column(name = "role")
    private String role;

    

    public AppUser(Integer id,
			@NotBlank(message = "First name should not be blank") @Size(min = 2, max = 20, message = "The first name should be within 2 to 20 characters") String firstName,
			@Size(max = 20, message = "The name last name should be within 20 characters") String lastName,
			@NotBlank(message = "Email should not be blank") String contactNumber,
			@Email(message = "Invalid email format") @NotBlank(message = "Email should not be blank") String email,
			@NotBlank(message = "Password should not be blank") String password, String status, String role) {
		super();
		this.id = id;
		this.name = firstName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
		this.status = status;
		this.role = role;
	}

	public AppUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", name=" + name + ", contactNumber=" + contactNumber + ", email=" + email
				+ ", password=" + password + ", status=" + status + ", role=" + role + "]";
	}

}


