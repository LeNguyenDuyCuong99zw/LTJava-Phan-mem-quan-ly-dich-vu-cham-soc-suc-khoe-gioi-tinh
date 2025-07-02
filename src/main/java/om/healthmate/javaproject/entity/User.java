package om.healthmate.javaproject.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    // Danh sách chuyên khoa chuẩn dùng cho filter, form, và quản lý bác sĩ
    public static final String[] SPECIALIZATIONS = {
        "Phụ khoa",
        "Nam Học",
        "Sản",
        "Nội nhi"
        // Thêm chuyên khoa khác nếu cần
    };
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "NVARCHAR(255)", nullable = false)
    private String name;

    @Column(columnDefinition = "NVARCHAR(255)", nullable = false, unique = true)
    private String email;

    @Column(columnDefinition = "NVARCHAR(255)", nullable = false)
    private String password;

    @Column(columnDefinition = "NVARCHAR(50)", nullable = false)
    private String role; // USER, DOCTOR, ADMIN


    @Column(columnDefinition = "NVARCHAR(100)")
    private String specialization; // Chuyên khoa cho bác sĩ

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Cycle> cycles;

    // Getters và setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public List<Cycle> getCycles() { return cycles; }
    public void setCycles(List<Cycle> cycles) { this.cycles = cycles; }
}