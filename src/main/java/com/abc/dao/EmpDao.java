package com.abc.dao;

import com.abc.controller.vo.DelVO;
import com.abc.dao.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpDao {
    List<Emp> findByPage(@Param("start") int start,@Param("size") int size);
    List<Emp> findByName(@Param("ename") String ename);
    Emp findById(@Param("empno") Integer empno);

    int delete(Emp emp);
    int save(Emp emp);
    int update(Emp emp);

    List<Emp> findByDept(@Param("deptno") int deptno);

    int[] delBatch(List<DelVO> delVOList);
}
