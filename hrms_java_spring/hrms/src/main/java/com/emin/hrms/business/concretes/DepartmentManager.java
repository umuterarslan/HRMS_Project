package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.DepartmentService;
import com.emin.hrms.core.utilities.IsFull;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.DepartmentDao;
import com.emin.hrms.entities.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentManager implements DepartmentService {

    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentManager(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public DataResult<List<Department>> getDepartments() {
        if (IsFull.listController(this.departmentDao.findAll())){
            return new SuccessDataResult<>(this.departmentDao.findAll(),"Bölüm listeleme başarılı.");
        } else {
            return new ErrorDataResult<>(null,"Listelenecek bölüm bulunamadı!");
        }
    }

    @Override
    public Result addDepartment(Department department) {
        this.departmentDao.save(department);
        return new SuccessResult("Bölüm ekleme başarılı.");
    }
}
