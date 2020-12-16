package com.example.service.iservice;

import com.example.common.Res;
import com.example.controller.vo.DeptEmpVO;
import com.example.service.dto.DeptEmpDTO;

import java.util.List;

public interface IReportService {
    Res<List<DeptEmpDTO>> makeReportForDeptEmp(DeptEmpVO deptEmpVO);
}
