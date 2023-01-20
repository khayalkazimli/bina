package az.itcity.bina.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private List<String> emails;

    public UserRepositoryImpl() {
        this.emails = new ArrayList<>();
        this.emails.add("khayalkazimli@gmail.com");
        this.emails.add("mammad99@gmail.com");
        this.emails.add("huseyneliyev@gmail.com");
    }

    @Override
    public boolean isRegistered(String email) {
        return emails.contains(email);
    }
}
