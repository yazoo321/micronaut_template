package server.account.repository;

import com.org.mmo_server.repository.model.tables.daos.UsersDao;
import com.org.mmo_server.repository.model.tables.pojos.Users;

import javax.inject.Singleton;
import org.jooq.Configuration;

@Singleton
public class AccountRepository {
    // Use DSL context for higher performance results
    // @Inject
    // DSLContext dslContext;

    UsersDao usersDao;

    AccountRepository(Configuration configuration) {
        this.usersDao = new UsersDao(configuration);
    }

    public Users fetchByUsername(String username) {
        return usersDao.fetchOneByUsername(username);
    }
}
