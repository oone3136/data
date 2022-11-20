package org.tugas.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {
    public String loginName;
    public String password;
    public String email;
    public String fullname;
    public String mobilePhoneNumber;
    public String addres;
    public String workPhoneNumber;

}
