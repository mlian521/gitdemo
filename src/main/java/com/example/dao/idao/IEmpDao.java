package com.example.dao.idao;

import com.example.controller.vo.DelVO;
import com.example.dao.entity.Emp;

import java.util.List;

public interface IEmpDao {
    List<Emp> findByPage(int start, int size)throws Exception;
    List<Emp> findByName(String ename)throws Exception;
    Emp findById(Integer empno)throws Exception;

    void delete(Emp emp)throws Exception;
    void save(Emp emp)throws Exception;
    void update(Emp emp)throws Exception;

    List<Emp> findByDept(int deptno)throws Exception;

    void delBatch(List<DelVO> delVOList)throws Exception;
}
