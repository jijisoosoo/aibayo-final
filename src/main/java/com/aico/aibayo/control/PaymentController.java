package com.aico.aibayo.control;

import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/payment")
public class PaymentController {

    @GetMapping("/admin/paymentBillingMain")
    public String adminPaymentBillingMain(){ return "/payment/admin/paymentBillingMain"; }

    @GetMapping("/admin/paymentBillingWrite")
    public String adminPaymentBillingWrite(){ return "/payment/admin/paymentBillingWrite"; }

    @GetMapping("/admin/paymentBillingConfirm")
    public String adminPaymentBillingConfirm(){ return "/payment/admin/paymentBillingConfirm"; }

    @GetMapping("/admin/paymentBillingDone")
    public String adminPaymentBillingDone(){ return "/payment/admin/paymentBillingDone"; }

    @GetMapping("/user/paymentMain")
    public String userPaymentWrite(){ return "/payment/user/paymentMain"; }

    @GetMapping("/user/paymentPay")
    public String userPaymentPay(){ return "/payment/user/paymentPay"; }

    @GetMapping("/user/paymentDone")
    public String userPaymentDone(){ return "/payment/user/paymentDone"; }
}
