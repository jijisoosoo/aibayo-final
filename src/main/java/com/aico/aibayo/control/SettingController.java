package com.aico.aibayo.control;

import com.aico.aibayo.dto.kinder.KinderDto;
import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.entity.RegisterKinderEntity;
import com.aico.aibayo.service.settingKinder.SettingKinderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/setting")
@RequiredArgsConstructor
public class SettingController {

    private final SettingKinderService settingKinderService;

    @GetMapping("/menu")
    public String menu(){
        return "/admin/setting/menu";
    }

    @GetMapping("/add")
    public String add(){
        return "/admin/setting/add";
    }

    @GetMapping("/modify/{kinderNo}")
    public String modify(
            @PathVariable Long kinderNo,
            @ModelAttribute("loginInfo") MemberDto loginInfo,
            Model model
    ){
        kinderNo = loginInfo.getKinderNo();

        return "/admin/setting/modify";
    }


    @GetMapping("/info/{kinderNo}")
    public String info(
            @PathVariable Long kinderNo,
            @ModelAttribute("loginInfo") MemberDto loginInfo,
            Model model
    ){
        kinderNo = loginInfo.getKinderNo();
        Optional<RegisterKinderEntity> kinderDto =
                settingKinderService.getKinderById(kinderNo);

        model.addAttribute("kinderDto", kinderDto.get());
        log.info("kinderDto : {}",kinderDto);
        return "/admin/setting/info";
    }

    @GetMapping("/test")
    public String test(){
        return "/admin/setting/copy";
    }



}
