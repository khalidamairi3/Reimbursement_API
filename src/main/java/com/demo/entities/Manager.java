package com.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * the manager entity and its attributes as they are expected to be stored in the database
 */
@Entity
@Table(name="manager")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Manager {

    @Id
    @Column(name="id", columnDefinition = "AUTO_INCREMENT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String firstName;
    String lastName;
    String email;

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "manager")
////    @JoinColumn(name = "manager_id",unique = false,insertable = false)
//    private List<Reimbursement> reimbursements;
}
