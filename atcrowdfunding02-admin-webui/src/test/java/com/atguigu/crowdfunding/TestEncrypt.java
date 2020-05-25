package com.atguigu.crowdfunding;

import com.zzk.atcrowdfunding.util.CrowdUtil;
import org.junit.Test;

public class TestEncrypt {

    @Test
    public void testMd5(){
        String source = "123123";
        String encoded = CrowdUtil.md5(source);
        System.out.println(encoded);
    }
}
