package com.example.service.iservice;

import com.example.common.Res;
import com.example.dao.entity.Dept;

import java.util.List;

public interface IDeptService {
    Res<List<Dept>> findAll();
}
