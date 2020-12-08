package com.atguigu.springcloud.contgroller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;


import javax.annotation.Resource;


@Controller
public class PaymentController {
   @Resource
    private PaymentService paymentService;

    @PostMapping(Value="/payment/create")
    public CommonResult create(Payment payment)
    {
      int result =paymentService.create(payment);
        Log.info("插入的结果******"+result);
        if (result>0){
            return new CommonResult(200,"插入数据成功",result);
        } else {
            return new CommonResult(400,"插入数据库失败");
        }
    }
    @GetMapping(Value="/payment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id )
    {
        Payment payment = paymentService.getPaymentById(id);



        Log.info("插入的结果******"+payment);
        if (payment!=null){
            return new CommonResult(200,"插入数据成功",payment);
        } else {
            return new CommonResult(400,"插入数据库失败");
        }
    }
}
