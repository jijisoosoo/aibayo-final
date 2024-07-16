package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_info_no")
    private int memberInfoNo;
    @Column
    private String id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;
}
