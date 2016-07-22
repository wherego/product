package com.bjshenpu.perfectcommonbaseframework.base;

/**
 * ============================================================
 * <p/>
 * 版 权 ：
 * <p/>
 * 作 者 : Quentin
 * <p/>
 * 版 本 ： 1.0
 * <p/>
 * 创建日期 ： 2016/4/6 10:09
 * <p/>
 * 描 述 ：
 * <p/>
 * ============================================================
 **/
public class BaseEntity {




    String errorCode;

    String[] errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String[] getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String[] errorMessage) {
        this.errorMessage = errorMessage;
    }



//    public boolean isOk() {
////        if (code == HttpConfig.ResponseCode.OK) {
////            return true;
////        } else {
////            return false;
////        }
//    }

//	public boolean isCode(String code) {
//		if (respCode != null && respCode.equals(code)) {
//			return true;
//		} else {
//			return false;
//		}
//	}

//    public boolean isAuthTokenInvalid() {
//        if (code == 100) {
//            return true;
//        } else {
//            return false;
//        }
//    }



}
