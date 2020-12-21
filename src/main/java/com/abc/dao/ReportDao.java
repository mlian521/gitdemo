package com.abc.dao;

import com.abc.controller.vo.DeptEmpVO;
import com.abc.service.dto.DeptEmpDTO;

import java.util.List;

public interface ReportDao {
    List<DeptEmpDTO> makeReportForDeptEmp(DeptEmpVO deptEmpVO);

}
