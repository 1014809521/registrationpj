package com.gpj.service.Implements;

import com.gpj.dao.SeekDao;
import com.gpj.entity.Doctor;
import com.gpj.entity.Seek;
import com.gpj.result.ResponseResult;
import com.gpj.service.SeekService;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;
@Service
public class SeekServiceImpl implements SeekService {
    @Autowired
    private SeekDao seekDao;

    @Override
    public ResponseResult save(Map map) {
        Seek seek = new Seek();
        seek.setPatientId((Integer.valueOf(String.valueOf(map.get("patientId")))));
        seek.setDays(String.valueOf(map.get("days")));
        seek.setDescribes(String.valueOf(map.get("describes")));
        seek.setIllness(String.valueOf(map.get("illness")));
        seek.setDrug(String.valueOf(map.get("drug")));
        seekDao.insert(seek);
        ResponseResult result = new ResponseResult();
        result.setCode("100");
        result.setMsg("成功");
        return result;
    }

    @Override
    public PageQuery<Seek> findSeekList(long pageNum, long pageSize, Integer patientId) {
        PageQuery<Seek> query = new PageQuery<>();
        query.setPara("patientId", patientId);
        seekDao.selectList(query);
        return query;
    }

    @Override
    public PageQuery<Seek> findSeekList1(long pageNum, long pageSize, Integer registrationId) {
        PageQuery<Seek> query = new PageQuery<>();
        query.setPara("registrationId", registrationId);
        seekDao.selectList(query);
        return query;
    }

}
