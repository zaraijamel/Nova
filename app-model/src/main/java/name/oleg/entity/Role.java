package name.oleg.entity;

import javax.persistence.*;
import java.util.Set;

@javax.persistence.Entity
@Table(name = "ROLES")
public class Role extends Entity {

    @Column(name = "ROLE")
    private String role;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")}
    )
    private Set<User> userRoles;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<User> userRoles) {
        this.userRoles = userRoles;
    }
}
