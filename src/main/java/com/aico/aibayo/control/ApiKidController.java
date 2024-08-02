package com.aico.aibayo.control;

import com.aico.aibayo.dto.kid.KidDto;
import com.aico.aibayo.service.kid.KidService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/kid")
@RequiredArgsConstructor
public class ApiKidController {
    private final KidService kidService;

    @PutMapping("/modifyOk")
    public ResponseEntity<KidDto> modifyOk(@RequestBody KidDto kidDto) {
        log.info("modify: {}", kidDto);
        KidDto updated = kidService.updateKid(kidDto);

        return updated == null ? ResponseEntity.badRequest().build() :
                ResponseEntity.ok(updated);
    }

    @DeleteMapping("/deleteOk")
    public ResponseEntity<KidDto> deleteOk(@RequestBody KidDto kidDto) {
        log.info("delete: {}", kidDto);
        KidDto deleted = kidService.deleteKid(kidDto);
        log.info("deleted: {}", deleted);

        return deleted == null ? ResponseEntity.badRequest().build() :
                ResponseEntity.ok(deleted);
    }

}
