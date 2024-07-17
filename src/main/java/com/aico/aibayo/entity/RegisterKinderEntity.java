package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "register_kinder")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RegisterKinderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="kinder_no")
    private Long kinderNo; //유치원 번호
    @Column(name="ldgr_id")
    private String ldgrId; //원장 아이디
    @Column(name="kinder_kid_drop")
    private LocalDateTime kinderKidDrop; // 유치원 등원시간
    @Column(name="kinder_kid_pickup")
    private LocalDateTime kinderKidPickup; //유치원 하원시간
    @Column(name="kinderCode")
    private String kinderCode; //유치원 코드
    @Column(name="kinder_reg_date")
    private LocalDateTime kinderRegDate; //유치원 등록일자
    @Column(name="kinder_modify_date")
    private LocalDateTime kinderModifyDate; //유치원 수정일자
    @Column(name="kinder_delete_date")
    private LocalDateTime kinderDeleteDate; //유치원 삭제일자
    @Column(name="announce_status")
    private int announceStatus; //공지사항 상태
    @Column(name="notepad_status")
    private int notepadStatus; //알림장 상태
    @Column(name="meal_status")
    private int mealStatus; //식단표 상태
    @Column(name="medication_status")
    private int medicationStatus; //투약 의뢰서 상태
    @Column(name="return_home_status")
    private int returnHomeStatus; //귀가 동의서 상태
    @Column(name="attendance_status")
    private int attendanceStatus; //출석부 상태
    @Column(name="schedule_status")
    private int scheduleStatus; //일정표 상태
    @Column(name="pick_drop_status")
    private int pickDropStatus; //안심 승하차 상태
    @Column(name="life_record_status")
    private int lifeRecordStatus; //생활 기록 상태
    @Column(name="chat_status")
    private int chatStatus; //열린소통 상태
}
