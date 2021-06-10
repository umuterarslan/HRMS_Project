package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.SystemPersonel;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface SystemPersonelDao extends JpaRepository<SystemPersonel, Integer> {

    SystemPersonel getSystemPersonelById(int id);

    @Transactional
    void deleteSystemPersonelById(int id);

}
