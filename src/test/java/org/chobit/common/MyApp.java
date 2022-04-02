package org.chobit.common;

import org.chobit.common.model.ParamMap;

/**
 * @author robin
 */
public class MyApp {


    public static void main(String[] args) {
        ParamMap<Object> map = new ParamMap<>(2);
        System.out.println(map.getDouble("rate", 2.0));
    }


}
