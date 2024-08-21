package com.aico.aibayo.control;

import com.aico.aibayo.common.AcceptStatusEnum;
import com.aico.aibayo.common.PaymentStatusEnum;
import com.aico.aibayo.dto.ClassDto;
import com.aico.aibayo.dto.kid.KidDto;
import com.aico.aibayo.dto.kid.KidSearchCondition;
import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.payment.PaymentDto;
import com.aico.aibayo.dto.payment.PaymentSearchCondition;
import com.aico.aibayo.dto.schedule.ScheduleSearchCondition;
import com.aico.aibayo.service.kid.KidService;
import com.aico.aibayo.service.payment.PaymentLogService;
import com.aico.aibayo.service.payment.PaymentService;
import com.aico.aibayo.service.classManage.ClassService;
import com.aico.aibayo.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final MemberService memberService;
    private final PaymentService paymentService;
    private final PaymentLogService paymentLogService;
    private final ClassService classService;
    private final KidService kidService;

    @GetMapping("/admin/paymentBillingMain")
    public String adminPaymentMain(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model){
        PaymentSearchCondition condition = new PaymentSearchCondition();
        condition.setKinderNo(loginInfo.getKinderNo());
        List<PaymentDto> paymentDtoList = paymentService.getAllByKinderNo(condition);
        model.addAttribute("paymentDtoList", paymentDtoList);

        List<ClassDto> classList = classService.getByKinderNo(loginInfo.getKinderNo());
        model.addAttribute("classList", classList);

        return "/admin/payment/paymentBillingMain";
    }

    @PostMapping("/admin/paymentBillingMainSearch")
    public String adminPaymentMainSearch(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model,
                                         @RequestBody PaymentSearchCondition condition){
        condition.setKinderNo(loginInfo.getKinderNo());

        List<PaymentDto> paymentDtoList = paymentService.getAllBySearchCondition(condition);
        model.addAttribute("paymentDtoList", paymentDtoList);

        return "/admin/payment/paymentBillingMain";
    }

    @GetMapping("/admin/paymentBillingWrite")
    public String adminPaymentBillingWrite(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model){

        PaymentSearchCondition condition = new PaymentSearchCondition();
        condition.setKinderNo(loginInfo.getKinderNo());

        List<ClassDto> classList = classService.getByKinderNo(loginInfo.getKinderNo());
        model.addAttribute("classList", classList);

        return "/admin/payment/paymentBillingWrite";
    }

    @PostMapping("/admin/paymentBillingWriteGetKid")
    public String adminPaymentWriteGetKid(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model,
                                         @RequestBody KidSearchCondition condition){
        condition.setKinderNo(loginInfo.getKinderNo());
        condition.setAcceptStatus(AcceptStatusEnum.ACCEPT.getStatus());

        List<KidDto> kidDtoList = kidService.getAllWithParentByClassNoAndAcceptStatus(condition);
        model.addAttribute("kidDtoList", kidDtoList);

        return "/admin/payment/paymentBillingWrite";
    }

    @PostMapping("/admin/ShowSelectedKid")
    public String adminPaymentWriteShowSelectedKid(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model,
                                         @RequestBody Map<String, Object> selectedClassAndKid){

        String classNo = (String) selectedClassAndKid.get("classNo");
        String className = (String) selectedClassAndKid.get("className");
        List<Map<String, Object>> selectedKidList = (List<Map<String, Object>>) selectedClassAndKid.get("selectedKidList");

        model.addAttribute("selectedClassNo", classNo);
        model.addAttribute("selectedClassName", className);
        model.addAttribute("selectedKidList", selectedKidList);

        return "/admin/payment/paymentBillingWrite";
    }

    @PostMapping("/admin/showDiscountedKid")
    public String adminPaymentWriteShowDiscountedKid(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model,
                                         @RequestBody Map<String, Object> discountMap){

        List<PaymentDto> discountList = (List<PaymentDto>)discountMap.get("discountList");
        log.info("discountList {}", discountList);
        model.addAttribute("discountList", discountList);

        return "admin/payment/paymentBillingWrite";
    }

    @PostMapping("/admin/showMemo")
    public String adminPaymentWriteShowMemo(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model,
                                         @RequestBody Map<String, Object> memoMap){

        List<PaymentDto> memoList = (List<PaymentDto>)memoMap.get("memoList");
        log.info("memoList {}", memoList);
        model.addAttribute("memoList", memoList);

        return "admin/payment/paymentBillingWrite";
    }

    @PostMapping("/admin/sendBill")
    @ResponseBody
    public void writeOk(@ModelAttribute("loginInfo") MemberDto loginInfo,
                        @RequestBody Map<String, Object> requestBody) {

        requestBody.put("kinderNo", loginInfo.getKinderNo());
        paymentService.insertSchedule(requestBody);

    }

    @GetMapping("/admin/paymentBillingConfirm")
    public String adminPaymentBillingConfirm(){ return "/admin/payment/paymentBillingConfirm"; }

    @GetMapping("/admin/paymentBillingDone")
    public String adminPaymentBillingDone(){ return "/admin/payment/paymentBillingDone"; }

    @GetMapping("/user/paymentMain")
    public String userPaymentWrite(){ return "/user/payment/paymentMain"; }

    @GetMapping("/user/paymentPay")
    public String userPaymentPay(){ return "/user/payment/paymentPay"; }

    @GetMapping("/user/paymentDone")
    public String userPaymentDone(){ return "/user/payment/paymentDone"; }
}
