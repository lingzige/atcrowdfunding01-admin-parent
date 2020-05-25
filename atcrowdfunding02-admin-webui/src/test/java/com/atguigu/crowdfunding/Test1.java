package com.atguigu.crowdfunding;


import com.zzk.atcrowdfunding.entity.Admin;
import com.zzk.atcrowdfunding.mapper.AdminMapper;
import com.zzk.atcrowdfunding.service.api.AdminService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml", "classpath:spring-persist-tx.xml"})
public class Test1 {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    @Test
    public void testAdmin(){
        String logAcct = "小明";
        Admin adminByLoginAcct = adminMapper.getAdminByLoginAcct(logAcct);
        System.out.println(adminByLoginAcct);
    }

    @Test
    public void testTx(){
        Admin admin = new Admin(null,"小章","12345","xiaozhang","xiaozhang@qq.com",null);
        adminService.saveAdmin(admin);
    }

    @Test
    public void testDataSource() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }


    @Test
    public void testInsert(){
        Admin admin = new Admin(null,"小明","12345","xiaoming","xiaoming@qq.com",null);
        int insert = adminMapper.insert(admin);
        System.out.println(insert);
    }

}
