package org.chobit.common.tools;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author robin
 */
public class ShortCodeTest {


    @Test
    public void gen() {
        int size = 10240;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            String code = ShortCode.gen();
            System.out.println(code);
            set.add(code);
        }
        Assert.assertEquals(size, set.size());
    }

}
