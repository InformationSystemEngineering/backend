package com.example.IIS.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StudentExtraActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "extra_activity_id", referencedColumnName = "id")
    private ExtraActivity extraActivity;


    // Getteri i setteri
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public ExtraActivity getExtraActivity() {
        return extraActivity;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setExtraActivity(ExtraActivity extraActivity) {
        this.extraActivity = extraActivity;
    }
}


