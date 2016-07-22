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
 * 创建日期 ： 2015/12/17 17:54
 * <p/>
 * 描 述 ：
 * <p/>
 * ============================================================
 **/
public class LoginEntity extends BaseEntity implements Serializable {

    public AgentInfoEntity agentInfo;
    public OrganVo organVo;
    public AgentAttr agentAttr;
    public String sysDate;

    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }

    public AgentAttr getAgentAttr() {
        return agentAttr;
    }

    public void setAgentAttr(AgentAttr agentAttr) {
        this.agentAttr = agentAttr;
    }

    public AgentInfoEntity getAgentInfo() {
        return agentInfo;
    }

    public OrganVo getOrganVo() {
        return organVo;
    }

    public void setOrganVo(OrganVo organVo) {
        this.organVo = organVo;
    }

    public void setAgentInfo(AgentInfoEntity agentInfo) {
        this.agentInfo = agentInfo;
    }
}
