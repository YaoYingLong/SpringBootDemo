package com.nokia.example.JpaRepository;

import com.nokia.example.model.LocalUser;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Y31201308 on 2016/8/10.
 */
public interface LocalUserRepository extends BaseRepository<LocalUser, Long>{

    @Query(value = "select * from users where address = ?1" , nativeQuery = true)
    List<LocalUser>  findByAddress(String address);

    LocalUser findByUsername(String name);

}
