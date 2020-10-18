package com.kotsoft.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Created by Matt on 24.05.2019 at 19:13.
 * Software class represents "system" entity in database.
 * Class name changed from System to Software in order to avoid clashes with java.lang.System
 */

@Getter
@Setter
@Entity
@Table(name="system")
public class Software {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="technology")
    private String technology;

    @Column(name="owner")
    private String owner;

    public Software() {}

    public Software(String name, String description, String technology, String owner) {
        this.name = name;
        this.description = description;
        this.technology = technology;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Software{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", technology='" + technology + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
