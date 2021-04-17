package com.gpj.service.Implements;

import com.gpj.dao.AuthorityDao;
import com.gpj.dao.PatientDao;
import com.gpj.entity.Authority;
import com.gpj.entity.Doctor;
import com.gpj.entity.Patient;
import com.gpj.result.ActiveResult;
import com.gpj.result.ResponseResult;
import com.gpj.service.AuthorityService;
import com.gpj.service.DoctorService;
import org.beetl.sql.core.query.LambdaQuery;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityDao authorityDao;
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private DoctorService doctorService;
    @Override
    public ResponseResult check(Authority authority, HttpSession session) {
        //从数据库查询用户
        ResponseResult result = new ResponseResult();
        Authority authority1 = authorityDao.findUserByName(authority.getUsername());//查询用户是否存在
        if (authority1 == null){
            result.setCode("101");//不存在的错误码
            result.setMsg("用户名或密码错误");
        }else {
            if(authority1.getPassword().equals(authority.getPassword())){
                result.setCode("100");//登录成功
                result.setMsg(String.valueOf(authority1.getRole()));//登录角色
                //绑定session
                session.setAttribute("authority",authority1);
            }
            else{
                result.setCode("103");//密码错误

            }
        }
        return result;
    }

    @Override
    public ResponseResult register(ActiveResult activeResult) {

        //查询病人

        Patient patient = new Patient();
        ResponseResult result = new ResponseResult();
        Authority authority1 = authorityDao.findUserByName(activeResult.getUsername());
        if(authority1!=null){
            result.setCode("201");
            result.setMsg("用户存在");
        }
//        else if (doctorService.findByUserId(authority1.getId()).getId()!=null){
//            authority1 = new Authority();
//            authority1.setRole(2);
//            authority1.setUsername(activeResult.getUsername());
//            authority1.setPassword(activeResult.getPassword());
//            authorityDao.insert(authority1);
//            result.setCode("200");
//            result.setMsg("注册成功");
//        }
            else {
            patient = new Patient();
            authority1 = new Authority();
            authority1.setRole(3);
            authority1.setUsername(activeResult.getUsername());
            authority1.setPassword(activeResult.getPassword());
            authorityDao.insert(authority1);
            patient.setUserId(authorityDao.findUserByName(activeResult.getUsername()).getId());
            patient.setAge(activeResult.getAge());
            System.out.println(activeResult.getSex());
            patient.setSex(activeResult.getSex().equals("男")?1:2);
            patient.setName(activeResult.getName());
            patientDao.insert(patient);
            result.setCode("200");
            result.setMsg("注册成功");
        }
        return result;
    }

    @Override
    public Authority findByUserId(Integer userId) {
        Query<Authority> query = authorityDao.createQuery();
        query.andEq("id",userId);
        return query.single();
    }
}
