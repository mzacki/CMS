package com.***REMOVED***.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Matt on 24.05.2019 at 19:13.
 */

@Getter
@Setter
@Entity
@Table(name="systemy")
public class System {

    // redundant name="id" for the sake of clarity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="nazwa")
    private String name;

    @Column(name="opis")
    private String description;

    @Column(name="technologie")
    private String technology;

    @Column(name="posiadacz")
    private String owner;

    public System() {}

    public System(String name, String description, String technology, String owner) {
        this.name = name;
        this.description = description;
        this.technology = technology;
        this.owner = owner;
    }

    // add toString() for debugging purposes
    @Override
    public String toString() {
        return "System{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", technology='" + technology + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
