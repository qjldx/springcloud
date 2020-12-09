package com.atguigu.springcloud.contgroller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;


@RestController
@Slf4j
public class PaymentController {
   @Resource
    private PaymentService paymentService;

    @PostMapping(value="/payment/create")
    public CommonResult create(@RequestBody Payment payment)
    {
      int result =paymentService.create(payment);

       log.info("插入的结果******"+result);
        if (result>0){
            return new CommonResult(200,"插入数据成功",result);
        } else {
            return new CommonResult(400,"插入数据库失败");
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Integer id )
    {
        Payment payment = paymentService.getPaymentById(id);



        log.info("插入的结果******"+payment+"\t"+"哈哈成功");
        if (payment!=null){
            return new CommonResult(200,"查询成功",payment);
        } else {
            return new CommonResult(400,"没有对应记录,ID"+id);
        }
    }
}
