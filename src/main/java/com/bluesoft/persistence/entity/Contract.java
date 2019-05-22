package com.***REMOVED***.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Matt on 22.05.2019 at 19:34.
 */

@Getter
@Setter
@Entity
@Table(name="umowy")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="numer_umowy")
    private String contractNumber;

    @Column(name="system")
    private String system;

    @Column(name="data_od")
    private LocalDate startDate;

    @Column(name="data_do")
    private LocalDate endDate;

    @Column(name="wplywy")
    private long income;

    @Column(name="skala")
    private String range;

    @Column(name="aktywna")
    private boolean enabled;

    private Contract() {}

    public Contract(String contractNumber, String system, LocalDate startDate, LocalDate endDate, long income, String range, boolean enabled) {
        this.contractNumber = contractNumber;
        this.system = system;
        this.startDate = startDate;
        this.endDate = endDate;
        this.income = income;
        this.range = range;
        this.enabled = enabled;
    }
}
