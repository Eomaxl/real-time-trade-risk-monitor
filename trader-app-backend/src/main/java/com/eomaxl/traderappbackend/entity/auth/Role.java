package com.eomaxl.traderappbackend.entity.auth;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name =  "roles")
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String roleName;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "role_permission", joinColumns = @JoinColumn(name="role_id"), inverseJoinColumns = @JoinColumn(name= "permission_id")
    )
    private Set<Permission> permissions = new HashSet<>();
}
