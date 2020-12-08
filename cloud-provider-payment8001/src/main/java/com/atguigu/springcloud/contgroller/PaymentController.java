package com.atguigu.springcloud.contgroller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import javax.annotation.Resource;


@Controller
public class PaymentController {
   @Resource
    private PaymentService paymentService;

    @PostMapping(value="/payment/create")
    public CommonResult create(Payment payment)
    {
      int result =paymentService.create(payment);
        System.out.println("插入的结果******"+result);
        if (result>0){
            return new CommonResult(200,"插入数据成功",result);
        } else {
            return new CommonResult(400,"插入数据库失败");
        }
    }
    @GetMapping(value="/payment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id )
    {
        Payment payment = paymentService.getPaymentById(id);


        System.out.println("插入的结果******"+payment);
        if (payment!=null){
            return new CommonResult(200,"插入数据成功",payment);
        } else {
            return new CommonResult(400,"插入数据库失败");
        }
    }
}
