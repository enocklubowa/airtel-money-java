package com.enocklubowa.airtelmoneyjava.model;

import lombok.Data;

@Data
public class RemittanceResponse {
    private String accountStatus;
    private String amlstatus;
    private String barType;
    private String firstName;
    private String lastName;
    private String message;
    private String msisdn;
    private boolean pinSet;
    private String status;
    private boolean userBarred;

    public String getAccountStatus() {
        switch (this.accountStatus) {
            case "Y":
                return "Active";
            case "N":
                return "Inactive";
            default:
                return this.accountStatus;
        }
    }
}
