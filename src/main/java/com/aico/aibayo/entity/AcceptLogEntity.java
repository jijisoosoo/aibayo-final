package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "accept_log")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AcceptLogEntity {
    @Id
    @Column(name = "accept_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long acceptNo;
    @Column(name = "code_verify")
    private int codeVerify;
    @Column(name = "accept_type")
    private int acceptType;
    @Column(name = "accept_date")
    private LocalDateTime acceptDate;
    @Column(name = "accept_status")
    private int acceptStatus;
    @Column(name = "accept_reg_date")
    private LocalDateTime  acceptRegDate;
    @Column(name = "accept_modify_date")
    private LocalDateTime acceptModifyDate; ;
    @Column(name = "accept_delete_date")
    private LocalDateTime acceptDeleteDate;
}
