package com.aico.aibayo.dto.teacher;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class teacherDto {
    private Long id;
    private String username;
    private String name;
    private String phone;
    private String profilePicture;

    private LocalDateTime acceptRegDate;
    private Long kinderAcceptNo;
    private Long classNo;
    private Long classAcceptNo;
    private List<Long> oldClassIds;
    private List<Long> newClassIds;

    public teacherDto(Long id, String username, String name, String phone, String profilePicture,
                      LocalDateTime acceptRegDate, Long kinderAcceptNo, Long classNo, Long classAcceptNo) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.phone = phone;
        this.profilePicture = profilePicture;
        this.acceptRegDate = acceptRegDate;
        this.kinderAcceptNo = kinderAcceptNo;
        this.classNo = classNo;
        this.classAcceptNo = classAcceptNo;
    }

    public teacherDto(Long id, String username, String name, String phone,
                      String profilePicture, LocalDateTime acceptRegDate, Long KinderAcceptNo) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.phone = phone;
        this.profilePicture = profilePicture;
        this.acceptRegDate = acceptRegDate;
        this.kinderAcceptNo = KinderAcceptNo;
    }
}
