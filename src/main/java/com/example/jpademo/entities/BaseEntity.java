package com.example.jpademo.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator", sequenceName = "id_sequence", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    /**
     * The version of the object
     * The initial version is 1 and is incremented every time the entity is updated
     */
    @Version
    @Column(name = "DATABASE_VERSION", nullable = false)
    private Long databaseVersion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", updatable = false, nullable = false)
    private LocalDateTime createDate = LocalDateTime.now();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_DATE", nullable = false)
    private LocalDateTime updateDate;

    /**
     * Set the update date, before saving the entity in the database
     */
    @PrePersist
    private void setUpdateDate() {
        updateDate = LocalDateTime.now();
    }
}
