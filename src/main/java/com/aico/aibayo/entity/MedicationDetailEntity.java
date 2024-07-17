package com.aico.aibayo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medication_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class MedicationDetailEntity {
    @Id
    @Column(name="medi_detail_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mediDetailNo; //투약 내용 번호
    @Column(name="medi_order_no")
    private int mediOrderNo;
    @Column(name="medi_type")
    private String mediType;
    @Column
    private String dosage;
    @Column(name="dose_count")
    private String doseCount;
    @Column(name="dose_time")
    private String doseTime;
    @Column(name="storage_type")
    private String storageType;
}
