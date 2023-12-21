package com.server.server.api.data.vo.v2;

import java.util.Date;

public class PersonVOV2 {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private Date birthDay;

    public PersonVOV2() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long value) {
        this.id = value;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String value) {
        this.address = value;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String value) {
        this.gender = value;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date value) {
        this.birthDay = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((birthDay == null) ? 0 : birthDay.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        PersonVOV2 other = (PersonVOV2) obj;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (firstName == null) {
            if (other.firstName != null) return false;
        } else if (!firstName.equals(other.firstName)) return false;
        if (lastName == null) {
            if (other.lastName != null) return false;
        } else if (!lastName.equals(other.lastName)) return false;
        if (address == null) {
            if (other.address != null) return false;
        } else if (!address.equals(other.address)) return false;
        if (gender == null) {
            if (other.gender != null) return false;
        } else if (!gender.equals(other.gender)) return false;
        if (birthDay == null) {
            if (other.birthDay != null) return false;
        } else if (!birthDay.equals(other.birthDay)) return false;
        return true;
    }
}
