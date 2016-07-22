package com.bjshenpu.perfectcommonbaseframework.model;


import java.io.Serializable;

/**
 * ============================================================
 * <p/>
 * 版 权 ：
 * <p/>
 * 作 者 :Quentin
 * <p/>
 * 版 本 ： 1.0
 * <p/>
 * 创建日期 ： 2016/1/4 20:26
 * <p/>
 * 描 述 ：
 * <p/>
 * ============================================================
 **/
public class AgentAttr implements Serializable {

    /**
     * 职业证号
     */
    public String agentPracNum;

    /**
     * 人生格言
     */
    public String agentLiftMotto;


    public String getAgentPracNum() {
        return agentPracNum;
    }

    public void setAgentPracNum(String agentPracNum) {
        this.agentPracNum = agentPracNum;
    }

    public String getAgentLiftMotto() {
        return agentLiftMotto;
    }

    public void setAgentLiftMotto(String agentLiftMotto) {
        this.agentLiftMotto = agentLiftMotto;
    }
}
