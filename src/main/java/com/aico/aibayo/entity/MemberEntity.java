package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column
    private String pw;
    @Column(name = "reg_type")
    private int regType;
    @Column(name = "role_no")
    private int roleNo;
    @Column
    private int status;
    @Column(name = "reg_date")
    private LocalDateTime regDate;
    @Column(name = "modify_date")
    private LocalDateTime modifyDate;
    @Column(name = "inactivate_date")
    private LocalDateTime inactivateDate;
    @Column(name = "latest_log_date")
    private LocalDateTime latestLogDate;
    @Column(name = "latest_ip")
    private String latestIp;
}
