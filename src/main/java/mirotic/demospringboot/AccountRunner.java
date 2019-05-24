package mirotic.demospringboot;

import com.mirotic.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountRunner implements ApplicationRunner {

    @Autowired
    Account account;

    @Override
    public void run(ApplicationArguments args) {
        System.out.println(account);
    }

//    override by AutoConfiguration
//    @Bean
//    public Account account() {
//        Account account = new Account();
//        account.setName("test");
//        account.setAge(33);
//        account.setMarry(true);
//        return account;
//    }

}
