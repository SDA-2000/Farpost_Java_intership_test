package fefu.farpost.farpost_java_intership_test.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import fefu.farpost.farpost_java_intership_test.Models.Account;

public interface AccountRepository extends JpaRepository<Account, Long>
{

}
