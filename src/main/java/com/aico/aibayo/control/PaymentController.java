package com.aico.aibayo.control;

import com.aico.aibayo.common.PaymentStatusEnum;
import com.aico.aibayo.dto.member.MemberDto;
import com.aico.aibayo.dto.payment.PaymentDto;
import com.aico.aibayo.dto.payment.PaymentSearchCondition;
import com.aico.aibayo.service.payment.PaymentLogService;
import com.aico.aibayo.service.payment.PaymentService;
import com.aico.aibayo.service.classManage.ClassService;
import com.aico.aibayo.service.member.MemberService;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final MemberService memberService;
    private final PaymentService paymentService;
    private final PaymentLogService paymentLogService;
    private final ClassService classService;

    @GetMapping("/admin/paymentBillingMain")
    public String adminPaymentBillingMain(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model){
        PaymentSearchCondition condition = new PaymentSearchCondition();
        condition.setKinderNo(loginInfo.getKinderNo());
        List<PaymentDto> paymentDtoList = paymentService.getAllByKinderNo(condition);
        model.addAttribute("paymentDtoList", paymentDtoList);

        return "/admin/payment/paymentBillingMain";
    }

    @GetMapping("/admin/paymentBillingWrite")
    public String adminPaymentBillingWrite(){ return "/admin/payment/paymentBillingWrite"; }

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
