package com.aico.aibayo.control;

import com.aico.aibayo.dto.kid.KidDto;
import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.teacher.TeacherDto;
import com.aico.aibayo.service.teacher.teacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class ApiTeacherController {
    private final teacherService teacherService;

    @DeleteMapping("/deleteOk")
    public ResponseEntity<MemberDto> deleteOk(@RequestBody Map<String, Object> requestBody) {
        System.out.println("requestBody : " + requestBody);

        MemberDto deleted = teacherService.deleteTeacher(requestBody);
        log.info("deleted: {}", deleted);

        return deleted == null ? ResponseEntity.badRequest().build() :
                ResponseEntity.ok(deleted);
    }
}
