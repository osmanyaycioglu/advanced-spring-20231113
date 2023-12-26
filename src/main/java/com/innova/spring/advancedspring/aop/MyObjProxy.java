package com.innova.spring.advancedspring.aop;

import lombok.experimental.Delegate;

public class MyObjProxy extends MyObj {
    private MyObj myObj;

    public MyObjProxy(final MyObj myObjParam) {
        myObj = myObjParam;
    }

    @Override
    public String method1() {
        // trans
        String stringLoc = myObj.method1();
        // commit
        return stringLoc;
    }

    @Override
    public String method2() {
        return myObj.method2();
    }
}
