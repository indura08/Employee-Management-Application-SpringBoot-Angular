package BackendEmployeeMng.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false , updatable = false) //meke theruma awilla update krnna bha eka paarak data athulathkrt passe column ka  hadenneanna ehmai
    private int id;
    private String name;
    private String email;

    private String address;
    private String jobTitle;
    private String phone;
    private String imgUrl;
    @Column(nullable = false , updatable = false)
    private String employeeCode;

    public Employee(){}

    public Employee(String name, String email, String address, String jobTitle, String phone, String imgUrl, String employeeCode) {
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imgUrl = imgUrl;
        this.employeeCode = employeeCode;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public String getEmployeeCode() {
        return employeeCode;
    }
    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phone='" + phone + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
