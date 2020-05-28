import com.test.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Test.class);
        logger.info("开始执行");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountService accountService = (AccountService) context.getBean("accountService");

        try {
            accountService.transfer(1, 2, 50.00);
        }catch (Exception e){
            logger.info("转账失败，失败原因：" +  e.getMessage());
        }

        logger.info("结束执行");
    }
}
