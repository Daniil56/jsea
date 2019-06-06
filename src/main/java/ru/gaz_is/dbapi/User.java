package ru.gaz_is.dbapi;

public class User {
    private long id;
    private String firstname;
    private String surname;
    private String username;

    public User() {
    }

    public User(long id, String firstname, String surname, String username) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.username = username;
    }

    public User(String firstname, String surname, String username) {
        this.firstname = firstname;
        this.surname = surname;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (firstname != null ? !firstname.equals(user.firstname) : user.firstname != null) return false;
        return surname != null ? surname.equals(user.surname) : user.surname == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("User{").append("id=").append(id).append(", firstname='").append(firstname).append('\'').append(", surname='").append(surname).append('\'').append(", username='").append(username).append('\'').append('}').toString();
    }
}
