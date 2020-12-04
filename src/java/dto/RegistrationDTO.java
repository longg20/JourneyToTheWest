/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author Long
 */
public class RegistrationDTO implements Serializable {
    String id;
    String password;
    String fullname;
    String image;
    String description;
    String phone;
    String email;
    String role;   //admin, actor
    String roleName;        //ton ngo khong
    String roleDescription; //a monkey

    public RegistrationDTO() {
    }

    public RegistrationDTO(String id, String fullname, String image, String description, String phone, String email, String role) {
        this.id = id; 
        this.fullname = fullname;
        this.image = image;
        this.description = description;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
