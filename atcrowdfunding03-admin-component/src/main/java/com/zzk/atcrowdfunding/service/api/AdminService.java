package com.zzk.atcrowdfunding.service.api;

import com.github.pagehelper.PageInfo;
import com.zzk.atcrowdfunding.entity.Admin;

import java.util.List;

public interface AdminService {

    void saveAdmin(Admin admin);

    List<Admin> getAll();

    Admin getAdminByLoginAcct(String loginAcct, String userPswd);

    PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize);
}
