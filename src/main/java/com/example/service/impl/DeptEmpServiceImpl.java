package com.example.service.impl;

import com.example.common.Comm;
import com.example.common.Res;
import com.example.common.ResEnum;
import com.example.controller.vo.DeptEmpVO;
import com.example.dao.idao.IReportDao;
import com.example.service.dto.DeptEmpDTO;
import com.example.service.iservice.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("deptEmpService")
public class DeptEmpServiceImpl implements IReportService {
    @Autowired
    IReportDao reportDao;

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
