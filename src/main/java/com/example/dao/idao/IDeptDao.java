package com.example.dao.idao;

import com.example.dao.entity.Dept;
import java.util.List;

public interface IDeptDao {
    List<Dept> findAll()throws Exception;
}
