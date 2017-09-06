package pl.bartekdrzazgowski.beanvalidation;

import java.time.LocalDateTime;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

class Project {

    @NotBlank
    private String name;

    @Past
    private LocalDateTime createdAt;
    
    private Set<@Email String> emails;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }
}
