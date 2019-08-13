package mirotic.demospringboot.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void saveAccount() {
        Account account = new Account();
        account.setUsername("jupark");
        account.setPassword("secret");

        Account saveAccount = accountRepository.save(account);
        assertThat(saveAccount).isNotNull();
    }

    @Test
    public void findAccount() {
        Optional<Account> findAccount = accountRepository.findByUsername("sample");
        assertThat(findAccount).isNotEmpty();
    }

}