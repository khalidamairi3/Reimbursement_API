package com.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

/**
 * the reimbursement entity and its attributes as they are expected to be stored in the database
 */

@Entity
@Table(name="reimbursement")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Reimbursement {
    @Id
    @Column(name="id", columnDefinition = "AUTO_INCREMENT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private double amount;
    private String status;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="manager_id", referencedColumnName = "id")
    @JsonIgnore
    Manager manager;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="employee_id", referencedColumnName = "id")
    Employee employee;
}
