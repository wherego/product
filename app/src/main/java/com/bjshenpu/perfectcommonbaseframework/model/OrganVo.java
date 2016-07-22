package com.bjshenpu.perfectcommonbaseframework.model;

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
 * 创建日期 ： 2016/1/3 18:38
 * <p/>
 * 描 述 ：
 * <p/>
 * ============================================================
 **/
public class OrganVo implements Serializable {

    /**
     * 职级
     */
    public String organGrade;
    /**
     * 机构
     */
    public String organName;

    public String getOrganGrade() {
        return organGrade;
    }

    public void setOrganGrade(String organGrade) {
        this.organGrade = organGrade;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }
}
