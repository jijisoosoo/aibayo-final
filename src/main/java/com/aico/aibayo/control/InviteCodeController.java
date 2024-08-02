package com.aico.aibayo.control;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inviteCode")
public class InviteCodeController {

    @PostMapping("/mail")
    public ResponseEntity mail(@RequestParam String parentName,
                               @RequestParam String parentEmail) {

        return ResponseEntity.ok().build();
    }
}
