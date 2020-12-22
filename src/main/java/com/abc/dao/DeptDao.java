package com.abc.dao;

import com.abc.dao.entity.Dept;
import java.util.List;

public interface DeptDao {
    List<Dept> findAll();
    List<Dept> one2many();
}
