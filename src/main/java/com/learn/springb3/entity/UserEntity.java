package com.learn.springb3.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "user_app")
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6659355453167373930L;
	
	@Id
	@GeneratedValue(generator = "USER_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(
        name = "USER_SEQ",
        allocationSize = 1
    )
    @Column(name = "id", unique = true, nullable = false)
	private Integer id;
    @Column(name = "name", nullable = false)
	private String name;
    @Column(name = "email", nullable = false)
	private String email;
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;
    @Column(name = "tags", length = 200,  nullable = false)
    private String tags;
    @Column(name = "created_at", nullable = false, length = 35)
    private Date createdAt;
    @PrePersist
    public void onPrePersist() {
        this.setCreatedAt(new Date());
    }
}

