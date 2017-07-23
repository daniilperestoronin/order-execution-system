package com.ordersserver.domainobjects.client;

/**
 * @author Perestoronin Daniil
 */
public class PersonalInformation {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String identifier;
    private String password;

    public PersonalInformation() {
    }

    public Long getId() {
        return id;
    }

    public PersonalInformation setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public PersonalInformation setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonalInformation setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public PersonalInformation setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getIdentifier() {
        return identifier;
    }

    public PersonalInformation setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public PersonalInformation setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalInformation that = (PersonalInformation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
        if (identifier != null ? !identifier.equals(that.identifier) : that.identifier != null) return false;
        return password != null ? password.equals(that.password) : that.password == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (identifier != null ? identifier.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonalInformation{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", identifier='" + identifier + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
