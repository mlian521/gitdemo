package com.example.service.impl;

import com.example.common.Comm;
import com.example.common.Res;
import com.example.common.ResEnum;
import com.example.controller.vo.DeptEmpVO;
import com.example.dao.factory.DaoFactory;
import com.example.dao.idao.IReportDao;
import com.example.service.dto.DeptEmpDTO;
import com.example.service.iservice.IReportService;

import java.util.List;

public class DeptEmpServiceImpl implements IReportService {
    IReportDao reportDao;

    public DeptEmpServiceImpl() {
        reportDao= (IReportDao) DaoFactory.getInstance(Comm.DEPT_EMP_REPORT);
    }

    @Override
    public Res<List<DeptEmpDTO>> makeReportForDeptEmp(DeptEmpVO deptEmpVO) {
        List<DeptEmpDTO> result=null;
        try {
            result=reportDao.makeReportForDeptEmp(deptEmpVO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (result!=null&& result.size()>0)?Res.success(ResEnum.SUCCESS,result):Res.error();
    }
}
