package com.appleframework.web;

import java.util.HashMap;
import java.util.Map;

import com.appleframework.web.message.Errors;
import com.appleframework.web.verify.DefaultMd5Verifier;
import com.appleframework.web.verify.Verifier;

/**
 * 签名验证实现
 * @author tanghc
 *
 */
public class ApiSigner implements Signer {
    
    private Map<String, Verifier> checker = new HashMap<>();
    
    public ApiSigner() {
        checker.put("md5", new DefaultMd5Verifier());
    }
    
    /**
     * 添加签名检查器
     * @param algorithmName
     * @param checker
     */
    public void addChecker(String algorithmName,Verifier checker) {
        this.checker.put(algorithmName, checker);
    }

    @Override
    public boolean isRightSign(ApiParam apiParam, String secret,String signMethod) {
        Verifier verifier = checker.get(signMethod.toLowerCase());
        if(verifier == null) {
            throw Errors.ERROR_ALGORITHM.getException(signMethod);
        }
        return verifier.verify(apiParam, secret);
    }

}
