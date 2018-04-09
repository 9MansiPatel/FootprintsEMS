package VO;

import java.io.Serializable;

public class LoginVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String netId;
	private String firstName;
	private String lastName;
    private String userPassword;
    public boolean valid;
    

    public String getFirstName() {
        return firstName;
	}

     public void setFirstName(String newFirstName) {
        firstName = newFirstName;
	}

	
     public String getLastName() {
        return lastName;
			}

     public void setLastName(String newLastName) {
        lastName = newLastName;
			}
    
    public String getUserPassword() {
       return userPassword;
	}

    public void setUserPassword(String newPassword) {
       userPassword = newPassword;
	}
			
    public String getNetId() {
       return netId;
	}

    public void setNetId(String newUsername) {
       netId = newUsername;
	}
    
    public boolean isValid() {
        return valid;
	}

     public void setValid(boolean newValid) {
        valid = newValid;
	}
    public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
