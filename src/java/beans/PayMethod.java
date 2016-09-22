/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author maruf
 */
@ManagedBean
@RequestScoped
public class PayMethod {

    private int methodId;
    private String methodName;
    private String methodDetails;
    private String methodMobNum;
            
    public PayMethod() {
    }

    public int getMethodId() {
        return methodId;
    }

    public void setMethodId(int methodId) {
        this.methodId = methodId;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodDetails() {
        return methodDetails;
    }

    public void setMethodDetails(String methodDetails) {
        this.methodDetails = methodDetails;
    }

    public String getMethodMobNum() {
        return methodMobNum;
    }

    public void setMethodMobNum(String methodMobNum) {
        this.methodMobNum = methodMobNum;
    }
    
}
