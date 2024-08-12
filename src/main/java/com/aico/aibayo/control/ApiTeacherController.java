package com.aico.aibayo.control;

import com.aico.aibayo.dto.kid.KidDto;
import com.aico.aibayo.dto.teacher.TeacherDto;
import com.aico.aibayo.service.teacher.teacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class ApiTeacherController {
    private final teacherService teacherService;

//    @DeleteMapping("/deleteOk")
//    public ResponseEntity<KidDto> deleteOk(@RequestBody TeacherDto teacherDto) {
//        log.info("delete: {}", teacherDto);
//        KidDto deleted = teacherService.deleteTeacher(teacherDto);
//        log.info("deleted: {}", deleted);
//
//        return deleted == null ? ResponseEntity.badRequest().build() :
//                ResponseEntity.ok(deleted);
//    }
}
