import com.atguigu.springcloud.PaymentMain8001;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.service.impl.PaymentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaymentMain8001.class)
public class Test1 {
       @Autowired
       PaymentService paymentService=new PaymentServiceImpl();
    @Test
    public void test1(){
        Payment paymentById = paymentService.getPaymentById(1);
        System.out.println(paymentById);

    }
    @Test
    public void test2(){
        Payment payment=new Payment();
        payment.setSerial("bbbbb");
        int i = paymentService.create(payment);
        System.out.println("payment is create"+i);
    }
}
