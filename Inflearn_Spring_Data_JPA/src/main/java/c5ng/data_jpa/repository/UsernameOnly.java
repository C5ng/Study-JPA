package c5ng.data_jpa.repository;

import org.springframework.beans.factory.annotation.Value;

public interface UsernameOnly {
    @Value("#{target.username + ' ' + target.age}")
    String getUsername();
}
