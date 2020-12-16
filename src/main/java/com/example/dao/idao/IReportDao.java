package com.example.dao.idao;

import com.example.controller.vo.DeptEmpVO;
import com.example.service.dto.DeptEmpDTO;

import java.util.List;

public interface IReportDao {
    List<DeptEmpDTO> makeReportForDeptEmp(DeptEmpVO deptEmpVO)throws Exception;

}
