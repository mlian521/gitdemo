package com.example.service.iservice;

import com.example.common.Res;
import com.example.controller.vo.DelVO;
import com.example.dao.entity.Emp;

import java.util.List;

public interface IEmpService {
    List<Emp> findByPage(int page, int size);
    List<Emp> findByName(String ename);
    Emp findById(Integer empno);

    String delete(Emp emp);
    String save(Emp emp);
    String update(Emp emp);

    Res<List<Emp>> findByDept(int deptno);

    Res delBatch(List<DelVO> delVOList);
}
