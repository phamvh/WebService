package org.soap.test;

import javax.jws.WebService;

/**
 * Created by van on 6/18/15.
 */
@WebService
public class Sum {

    public int add(int a, int b){
        return a+b;
    }
}
