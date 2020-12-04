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
public class ErrorObj implements Serializable {
    String idError;
    String passwordError;
    String confirmError;
    String fullnameError;
    String imageError;
    String descriptionError;
    String phoneError;
    String emailError;
    
    String nameError;
    String locationError;
    String startTimeError;
    String endTimeError;
    String timeShootingError;
    String fileError;

    String amountError;
    String statusError;
    
    String quantityError;
    String exceedError;
    
    String roleNameError;
    String roleDescriptionError;
    String duplicateError;
    
    public ErrorObj() {
    }

    public void setIdError(String IdError) {
        this.idError = IdError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getIdError() {
        return idError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public String getFullnameError() {
        return fullnameError;
    }

    public String getImageError() {
        return imageError;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public void setFullnameError(String fullnameError) {
        this.fullnameError = fullnameError;
    }

    public void setImageError(String imageError) {
        this.imageError = imageError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getLocationError() {
        return locationError;
    }

    public String getStartTimeError() {
        return startTimeError;
    }

    public String getEndTimeError() {
        return endTimeError;
    }

    public String getTimeShootingError() {
        return timeShootingError;
    }

    public String getFileError() {
        return fileError;
    }

    public void setLocationError(String locationError) {
        this.locationError = locationError;
    }

    public void setStartTimeError(String startTimeError) {
        this.startTimeError = startTimeError;
    }

    public void setEndTimeError(String endTimeError) {
        this.endTimeError = endTimeError;
    }

    public void setTimeShootingError(String timeShootingError) {
        this.timeShootingError = timeShootingError;
    }

    public void setFileError(String fileError) {
        this.fileError = fileError;
    }

    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getAmountError() {
        return amountError;
    }

    public String getStatusError() {
        return statusError;
    }

    public void setAmountError(String amountError) {
        this.amountError = amountError;
    }

    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }

    public String getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }

    public String getExceedError() {
        return exceedError;
    }

    public void setExceedError(String exceedError) {
        this.exceedError = exceedError;
    }

    public String getRoleNameError() {
        return roleNameError;
    }

    public void setRoleNameError(String roleNameError) {
        this.roleNameError = roleNameError;
    }

    public String getRoleDescriptionError() {
        return roleDescriptionError;
    }

    public void setRoleDescriptionError(String roleDescriptionError) {
        this.roleDescriptionError = roleDescriptionError;
    }

    public String getDuplicateError() {
        return duplicateError;
    }

    public void setDuplicateError(String duplicateError) {
        this.duplicateError = duplicateError;
    }
}
