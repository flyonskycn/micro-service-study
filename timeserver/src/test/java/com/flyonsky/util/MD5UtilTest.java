package com.flyonsky.util;

import org.junit.Test;
import static org.mockito.BDDMockito.*;

public class MD5UtilTest {

    @Test
    public void testMd5(){
        String md5 = MD5Util.md5("abc");
        System.out.println(md5);
    }
}
