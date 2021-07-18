package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.SystemPersonel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface SystemPersonelDao extends JpaRepository<SystemPersonel, Integer> {

    SystemPersonel getSystemPersonelById(int id);

    @Transactional
    void deleteSystemPersonelById(int id);

    @Transactional
    @Modifying
    @Query("Update SystemPersonel sp set sp.email = :email, sp.username = :username where sp.id = :id")
    void updateSystemPersonel(int id, String email, String username);

}
