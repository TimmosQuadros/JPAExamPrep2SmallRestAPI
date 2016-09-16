/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TimmosQuadros
 */
@Entity
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.id = :id"),
    @NamedQuery(name = "Person.findByDtype", query = "SELECT p FROM Person p WHERE p.dtype = :dtype"),
    @NamedQuery(name = "Person.findByAge", query = "SELECT p FROM Person p WHERE p.age = :age"),
    @NamedQuery(name = "Person.findByBirthdate", query = "SELECT p FROM Person p WHERE p.birthdate = :birthdate"),
    @NamedQuery(name = "Person.findByFirstname", query = "SELECT p FROM Person p WHERE p.firstname = :firstname"),
    @NamedQuery(name = "Person.findByIsmarried", query = "SELECT p FROM Person p WHERE p.ismarried = :ismarried"),
    @NamedQuery(name = "Person.findByLastname", query = "SELECT p FROM Person p WHERE p.lastname = :lastname")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Size(max = 31)
    @Column(name = "DTYPE")
    private String dtype;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "BIRTHDATE")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Size(max = 255)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "ISMARRIED")
    private Boolean ismarried;
    @Size(max = 255)
    @Column(name = "LASTNAME")
    private String lastname;
    @JoinTable(name = "person_grade", joinColumns = {
        @JoinColumn(name = "Person_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "grades_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Grade> gradeCollection;
    @OneToMany(mappedBy = "personId")
    private Collection<Person> personCollection;
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID")
    @ManyToOne
    private Person personId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Phdstudent phdstudent;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Student student;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Employee employee;

    public Person() {
    }

    public Person(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Boolean getIsmarried() {
        return ismarried;
    }

    public void setIsmarried(Boolean ismarried) {
        this.ismarried = ismarried;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @XmlTransient
    public Collection<Grade> getGradeCollection() {
        return gradeCollection;
    }

    public void setGradeCollection(Collection<Grade> gradeCollection) {
        this.gradeCollection = gradeCollection;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Phdstudent getPhdstudent() {
        return phdstudent;
    }

    public void setPhdstudent(Phdstudent phdstudent) {
        this.phdstudent = phdstudent;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Person[ id=" + id + " ]";
    }
    
}
