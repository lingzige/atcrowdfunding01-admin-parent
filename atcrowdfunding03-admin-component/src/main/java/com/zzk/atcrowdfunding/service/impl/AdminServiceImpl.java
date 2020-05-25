package com.zzk.atcrowdfunding.service.impl;

import com.zzk.atcrowdfunding.constant.CrowdConstant;
import com.zzk.atcrowdfunding.entity.Admin;
import com.zzk.atcrowdfunding.entity.AdminExample;
import com.zzk.atcrowdfunding.exception.LoginFailedException;
import com.zzk.atcrowdfunding.mapper.AdminMapper;
import com.zzk.atcrowdfunding.service.api.AdminService;
import com.zzk.atcrowdfunding.util.CrowdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public void saveAdmin(Admin admin) {
        adminMapper.insert(admin);

    }

    public List<Admin> getAll() {
        List<Admin> admins = adminMapper.selectByExample(new AdminExample());
        return admins;
    }

    public Admin getAdminByLoginAcct(String loginAcct, String userPswd) {

        // 1。根据登录账号查询admin对象
        Admin admin = adminMapper.getAdminByLoginAcct(loginAcct);

        // 2。判断admin是否为null
        if(admin == null){
            // 3。如果为null，则抛出异常
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }

        // 4。如果不为null，则将数据库密码从admin对象中取出
        String userPswdInDataBase = admin.getUserPswd();

        // 5。判断form表单的明文加密后的密码和数据库中的密码是否一样
        String encodedUserPswd = CrowdUtil.md5(userPswd);

        //if(!userPswdInDataBase.equals(encodedUserPswd)){ 这种方式因为比较的都是变量，可能会出现空指针异常
        if(!Objects.equals(encodedUserPswd, userPswdInDataBase)){
            // 6。如果不一样，则抛出异常
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
        // 7。如果一样，则返回admin对象

        return admin;
    }
}
