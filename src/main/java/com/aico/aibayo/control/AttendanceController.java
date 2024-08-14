package com.aico.aibayo.control;

import com.aico.aibayo.dto.attendance.AttendanceDto;
import com.aico.aibayo.dto.classKid.ClassKidDto;
import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.entity.AttendanceEntity;
import com.aico.aibayo.entity.ClassEntity;
import com.aico.aibayo.jwt.JWTUtil;
import com.aico.aibayo.repository.attendance.AttendanceRepository;
import com.aico.aibayo.service.attendance.AttendanceService;
import com.aico.aibayo.service.classManage.ClassService;
import com.aico.aibayo.service.member.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/attendance")
public class AttendanceController {
    private final JWTUtil jwtUtil;
    private final MemberService memberService;
    private final ClassService classService;
    private final AttendanceService attendanceService;


    @ModelAttribute
    public void addAttributes(HttpServletRequest request, Model model) {
        String token = getTokenFromCookies(request.getCookies());
        if (token == null || token.isEmpty()) {
            log.error("JWT token is missing");
            // 여기서 예외를 던지거나, 적절히 처리합니다.
            return;
        }

        String username = jwtUtil.getUsername(token);
        log.info("loginUser: {}", username);
        MemberDto memberDto = memberService.findByUsername(username);

        model.addAttribute("loginInfo", memberDto);
    }

    private String getTokenFromCookies(Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("jwt".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    @GetMapping("/admin/main")
    public String adminMain() {
        return "admin/attendance/main";
    }

    @GetMapping("/admin/detailToday")
    public String detailToday(@ModelAttribute("loginInfo") MemberDto memberDto, Model model) {
        List<ClassEntity> classList = classService.getClassList(memberDto.getKinderNo());

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));

        model.addAttribute("date", date);
        model.addAttribute("classList", classList);
        log.info("day : detailToday");
        return "admin/attendance/detailToday";
    }

    @GetMapping("/admin/detailBefore")
    public String detailBefore(Model model) {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
        model.addAttribute("date", date);
        log.info("day : detailBefore");
        return "admin/attendance/detailBefore";
    }

    @GetMapping("/admin/detailAfter")
    public String detailAfter(Model model) {
        // 현재 날짜와 시간 가져오기 -> 날짜 출력 포맷 -> 포매팅
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
        model.addAttribute("date", date);

        log.info("day : detailAfter");
        return "admin/attendance/detailAfter";
    }

    @GetMapping("/admin/write")
    public String detailWrite(Model model) {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
        model.addAttribute("date", date);

        return "admin/attendance/detailWrite";
    }

    @GetMapping("/admin/write/{classNo}")
    public String writePage(@PathVariable Long classNo, Model model, @ModelAttribute("loginInfo") MemberDto memberDto) {
        System.out.println("write classNo : " + classNo);
        model.addAttribute("classNo", classNo);
        model.addAttribute("kinderNo", memberDto.getKinderNo());


        List<ClassKidDto> classKid = classService.getClassKid(classNo);
        model.addAttribute("classKid", classKid);


        return "admin/attendance/detailWrite"; // 이 경로는 작성 페이지의 템플릿 경로로 수정해 주세요.
    }

//    @PostMapping("/admin/write")
//    public String writePage(@RequestBody List<AttendanceDto> attendanceList) {
//        System.out.println("write page post ok");
//        // AttendanceDto 리스트 처리 로직
//        for (AttendanceDto dto : attendanceList) {
//            System.out.println("Received DTO: " + dto);
//            attendanceService.createAttendance(dto);
//        }
//        return "admin/attendance/detailToday";
//    }

    @PostMapping("/admin/write")
    public ResponseEntity<?> writePage(@RequestBody List<Map<String, Object>> attendanceList) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        for (Map<String, Object> attendance : attendanceList) {
            AttendanceDto attendanceDto = new AttendanceDto();

            // String으로 받은 후 Long으로 변환
            attendanceDto.setKinderNo(Long.valueOf(attendance.get("kinderNo").toString()));
            attendanceDto.setClassNo(Long.valueOf(attendance.get("classNo").toString()));
            attendanceDto.setKidNo(Long.valueOf(attendance.get("kidNo").toString()));

            attendanceDto.setKidName((String) attendance.get("kidName"));

            // kidDrop 처리
            String kidDropStr = (String) attendance.get("kidDrop");
            if (kidDropStr != null && !kidDropStr.trim().isEmpty()) {
                attendanceDto.setKidDrop(LocalDateTime.parse(kidDropStr, formatter));
            }

            // kidPickup 처리
            String kidPickupStr = (String) attendance.get("kidPickup");
            if (kidPickupStr != null && !kidPickupStr.trim().isEmpty()) {
                attendanceDto.setKidPickup(LocalDateTime.parse(kidPickupStr, formatter));
            }

            attendanceDto.setNote((String) attendance.get("note"));
            attendanceDto.setAttendanceStatus((String) attendance.get("attendanceStatus"));

            // AttendanceService에 전달
            attendanceService.createAttendance(attendanceDto);
        }
        return ResponseEntity.ok("Success");
    }


    @PostMapping("/getKidAttendance")
    @ResponseBody
    public List<AttendanceDto> getKidAttendance(@ModelAttribute("loginInfo") MemberDto memberDto, @RequestParam("classNo") Long classNo, Model model) {
        Long kinderNo = memberDto.getKinderNo();

        System.out.println("getKidAttendance method");

        List<AttendanceDto> attendanceList = attendanceService.getKids(kinderNo, classNo);

        return attendanceList;
    }
}
