package model;

import java.util.Objects;

public class Email {
    private Long id;
    private String email;

    public Email() {
    }

    public Email(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        Email otherEmail = (Email) o;
        return otherEmail != null
                && id.equals(otherEmail.id)
                && email.equals(otherEmail.email);
    }
}
