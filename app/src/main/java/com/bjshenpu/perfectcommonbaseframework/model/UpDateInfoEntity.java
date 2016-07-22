package com.bjshenpu.perfectcommonbaseframework.model;


import com.bjshenpu.perfectcommonbaseframework.base.BaseEntity;

import java.io.Serializable;


/**
 * ============================================================
 * <p/>
 * 版 权 ：
 * <p/>
 * 作 者 : Quentin
 * <p/>
 * 版 本 ： 1.0
 * <p/>
 * 创建日期 ： 2015/12/12 12:08
 * <p/>
 * 描 述 ：更新apk
 * <p/>
 * ============================================================
 **/
public class UpDateInfoEntity extends BaseEntity implements Serializable {

    /**
     * Apk路径
     */
    public String path;
    /**
     * 版本
     */
    String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
