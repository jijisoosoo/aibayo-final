package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ClassKidEntity {
    @Id
    @GeneratedValue
    @Column(name = "class_no")
    private int classNo;
    @Id
    @GeneratedValue
    @Column(name = "kid_no")
    private int kidNo;
    @Column(name = "accept_no")
    private int acceptNo;
}
