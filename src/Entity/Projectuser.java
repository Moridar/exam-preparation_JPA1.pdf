/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ansty
 */
@Entity
@Table(name = "projectuser")
@NamedQueries({
    @NamedQuery(name = "Projectuser.findAll", query = "SELECT p FROM Projectuser p"),
    @NamedQuery(name = "Projectuser.findById", query = "SELECT p FROM Projectuser p WHERE p.id = :id"),
    @NamedQuery(name = "Projectuser.findByCreated", query = "SELECT p FROM Projectuser p WHERE p.created = :created"),
    @NamedQuery(name = "Projectuser.findByEmail", query = "SELECT p FROM Projectuser p WHERE p.email = :email"),
    @NamedQuery(name = "Projectuser.findByUsername", query = "SELECT p FROM Projectuser p WHERE p.username = :username")})
public class Projectuser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CREATED")
    @Temporal(TemporalType.DATE)
    private Date created;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "USERNAME")
    private String username;
    @JoinTable(name = "projectuser_project", joinColumns = {
        @JoinColumn(name = "contributors_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "projects_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Project> projectCollection;

    public Projectuser() {
    }

    public Projectuser(Long id) {
        this.id = id;
    }

    public Projectuser(String username, String email) {
        this.email = email;
        this.username = username;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projectuser)) {
            return false;
        }
        Projectuser other = (Projectuser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Projectuser[ id=" + id + " ]";
    }
    
}
