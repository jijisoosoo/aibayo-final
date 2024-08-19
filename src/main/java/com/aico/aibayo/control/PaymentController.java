package com.aico.aibayo.control;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    @GetMapping("/admin/paymentBillingMain")
    public String adminPaymentBillingMain(){ return "/admin/payment/paymentBillingMain"; }

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
