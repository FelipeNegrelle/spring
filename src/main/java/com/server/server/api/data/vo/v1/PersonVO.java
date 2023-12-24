package com.server.server.api.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.Mapping;

import java.io.Serial;
import java.io.Serializable;

@JsonPropertyOrder({"uniqueKey", "firstName", "lastName", "address", "gender"})
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private Long uniqueKey;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    public PersonVO() {
    }

    public Long getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(Long value) {
        this.uniqueKey = value;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((uniqueKey == null) ? 0 : uniqueKey.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;

        PersonVO other = (PersonVO) obj;

        if (uniqueKey != other.uniqueKey) return false;

        if (firstName == null) {
            if (other.firstName != null) return false;
        } else if (!firstName.equals(other.firstName)) return false;

        if (lastName == null) {
            if (other.lastName != null) return false;
        } else if (!lastName.equals(other.lastName)) return false;

        if (gender == null) {
            if (other.gender != null) return false;
        } else if (!gender.equals(other.gender)) return false;

        if (address == null) {
            if (other.address != null) return false;
        } else if (!address.equals(other.address)) return false;

        if (uniqueKey == null) {
            if (other.uniqueKey != null) return false;
        } else if (!uniqueKey.equals(other.uniqueKey)) return false;

        return true;
    }
}
