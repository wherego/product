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
 * 创建日期 ： 2015/12/17 17:53
 * <p/>
 * 描 述 ：
 * <p/>
 * ============================================================
 **/
public class AgentInfoEntity implements Serializable{

    private static final long serialVersionUID = -5898610693095408071L;
    /**
     * 身份证号
     */
    public String idNo  ;
    /**
     * 电话号
     */
    public String phone  ;
    /**
     * 账户
     */
    public String agentCode  ;
    /**
     * 密码
     */
    public String password  ;
    public String state  ;
    public String idType  ;
    public String organId  ;
    public String icon  ;
    public String birthday  ;
    public String accountState  ;
    public String agentName  ;
    public String branchType  ;
    public String gender  ;
    public String group  ;
    public String permissionType  ;


    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountState() {
        return accountState;
    }

    public void setAccountState(String accountState) {
        this.accountState = accountState;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getBranchType() {
        return branchType;
    }

    public void setBranchType(String branchType) {
        this.branchType = branchType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }
}