package com.aico.aibayo.dto.teacher;

import com.aico.aibayo.dto.ClassDto;
import com.aico.aibayo.entity.AcceptLogEntity;
import com.aico.aibayo.entity.ClassEntity;
import com.aico.aibayo.entity.MemberEntity;
import com.aico.aibayo.entity.TeacherKinderEntity;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private Long KinderAcceptNo;
    private Long classNo;
    private Long ClassAcceptNo;

    public teacherDto(Long id, String username, String name, String phone,
                      String profilePicture, LocalDateTime acceptRegDate, Long KinderAcceptNo) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.phone = phone;
        this.profilePicture = profilePicture;
        this.acceptRegDate = acceptRegDate;
        this.KinderAcceptNo = KinderAcceptNo;
    }
}
