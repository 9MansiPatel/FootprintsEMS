package VO;

import java.io.Serializable;
import java.util.*;

public class ticketFormVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String netId;
	private String buildingTicket;
	private String roomTicket;
    private String timeTicket;
    private Date dateTicket;
    private String firstName;
    private String lastName;
    private String email;
    
	public boolean valid;
 
    
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
    
    public String getNetId() {
        return netId;
	}

     public void setNetId(String newNetId) {
        netId = newNetId;
	}

	
     public String getbuildingTicket() {
        return buildingTicket;
			}

     public void setBuildingTicket(String newBuildingTicket) {
        buildingTicket = newBuildingTicket;
			}
     
     public String getRoomTicket(){
    	 return roomTicket;
     }
     
     public void setRoomTicket(String newRoomTicket) {
    	 roomTicket = newRoomTicket;
     }
     
     public String getTimeTicket() {
    	 return timeTicket;
     }
     
     public void setTimeTicket(String newTimeTicket) {
    	 timeTicket = newTimeTicket;
     }
     
     public Date getDateTicket() {
    	 return dateTicket;
     }
     
     public void setDateTicket(Date newDateTicket) {
    	 dateTicket = newDateTicket;
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
