package com.demo.entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="employee")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @Column(name="id", columnDefinition = "AUTO_INCREMENT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String firstName;
    String lastName;
    String email;

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "employee")
////    @JoinColumn(name = "employee_id",unique = false,insertable = false)
//    private List<Reimbursement> reimbursements;
}
