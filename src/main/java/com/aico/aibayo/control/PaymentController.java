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
    public String adminPaymentBillingMain(){ return "paymentBillingMain"; }

    @GetMapping("/admin/paymentBillingWrite")
    public String adminPaymentBillingWrite(){ return "paymentBillingWrite"; }

    @GetMapping("/admin/paymentBillingConfirm")
    public String adminPaymentBillingConfirm(){ return "paymentBillingConfirm"; }

    @GetMapping("/admin/paymentBillingDone")
    public String adminPaymentBillingDone(){ return "paymentBillingDone"; }

    @GetMapping("/user/paymentMain")
    public String userPaymentWrite(){ return "paymentMain"; }

    @GetMapping("/user/paymentPay")
    public String userPaymentPay(){ return "paymentPay"; }

    @GetMapping("/user/paymentDone")
    public String userPaymentDone(){ return "paymentDone"; }
}
