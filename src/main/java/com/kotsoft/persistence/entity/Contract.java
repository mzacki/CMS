package com.kotsoft.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Created by Matt on 22.05.2019 at 19:34.
 * Contract class represents entity "contract" in database.
 */

@Getter
@Setter
@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "contract_number")
    private String contractNumber;

    @Column(name = "start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(name = "end_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Column(name = "income")
    private long income;

    @Column(name = "range")
    private String range;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "system_id")
    private Software software;

    public Contract() {
    }

    public Contract(String contractNumber, LocalDate startDate, LocalDate endDate, long income, String range, boolean enabled) {
        this.contractNumber = contractNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.income = income;
        this.range = range;
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", contractNumber='" + contractNumber + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", income=" + income +
                ", range='" + range + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
