package com.emed.shopping.dao.model.admin.user;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ShopUser implements Serializable {
    /**
     * id
     *
     * @mbg.generated
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 录入时间
     *
     * @mbg.generated
     */
    private Date addTime;

    private String deleteStatus;

    private String msn;

    private String qq;

    private String ww;

    /**
     * 地址
     *
     * @mbg.generated
     */
    private String address;

    private BigDecimal availableBalance;

    /**
     * 生日
     *
     * @mbg.generated
     */
    private Date birthday;

    /**
     * 邮箱
     *
     * @mbg.generated
     */
    private String email;

    private BigDecimal freezeBlance;

    private Integer gold;

    private Integer integral;

    /**
     * 上次登陆日期
     *
     * @mbg.generated
     */
    private Date lastLoginDate;

    /**
     * 上次登录ip
     *
     * @mbg.generated
     */
    private String lastLoginIp;

    /**
     * 登录次数
     *
     * @mbg.generated
     */
    private Integer loginCount;

    /**
     * 登陆日期
     *
     * @mbg.generated
     */
    private Date loginDate;

    /**
     * 登录IP
     *
     * @mbg.generated
     */
    private String loginIp;

    /**
     * 手机号
     *
     * @mbg.generated
     */
    private String mobile;

    /**
     * 密码
     *
     * @mbg.generated
     */
    private String password;

    private Integer report;

    /**
     * 性别
     *
     * @mbg.generated
     */
    private Integer sex;

    /**
     * 状态
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * 用户电话
     *
     * @mbg.generated
     */
    private String telephone;

    /**
     * 用户真实姓名
     *
     * @mbg.generated
     */
    private String trueName;

    /**
     * 用户登录名
     *
     * @mbg.generated
     */
    private String userName;

    /**
     * 用户校色
     *
     * @mbg.generated
     */
    private String userRole;

    /**
     * 用户信用
     *
     * @mbg.generated
     */
    private Integer userCredit;

    /**
     * 相片id
     *
     * @mbg.generated
     */
    private Long photoId;

    /**
     * 商店id
     *
     * @mbg.generated
     */
    private Long storeId;

    /**
     * qq的openid
     *
     * @mbg.generated
     */
    private String qqOpenid;

    /**
     * sina的openid
     *
     * @mbg.generated
     */
    private String sinaOpenid;

    private Long parentId;

    /**
     * 年份
     *
     * @mbg.generated
     */
    private Integer years;

    /**
     * 区域id
     *
     * @mbg.generated
     */
    private Long areaId;

    /**
     * 商店快速菜单
     *
     * @mbg.generated
     */
    private String storeQuickMenu;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWw() {
        return ww;
    }

    public void setWw(String ww) {
        this.ww = ww;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getFreezeBlance() {
        return freezeBlance;
    }

    public void setFreezeBlance(BigDecimal freezeBlance) {
        this.freezeBlance = freezeBlance;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getReport() {
        return report;
    }

    public void setReport(Integer report) {
        this.report = report;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Integer getUserCredit() {
        return userCredit;
    }

    public void setUserCredit(Integer userCredit) {
        this.userCredit = userCredit;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getQqOpenid() {
        return qqOpenid;
    }

    public void setQqOpenid(String qqOpenid) {
        this.qqOpenid = qqOpenid;
    }

    public String getSinaOpenid() {
        return sinaOpenid;
    }

    public void setSinaOpenid(String sinaOpenid) {
        this.sinaOpenid = sinaOpenid;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getStoreQuickMenu() {
        return storeQuickMenu;
    }

    public void setStoreQuickMenu(String storeQuickMenu) {
        this.storeQuickMenu = storeQuickMenu;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", addTime=").append(addTime);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", msn=").append(msn);
        sb.append(", qq=").append(qq);
        sb.append(", ww=").append(ww);
        sb.append(", address=").append(address);
        sb.append(", availableBalance=").append(availableBalance);
        sb.append(", birthday=").append(birthday);
        sb.append(", email=").append(email);
        sb.append(", freezeBlance=").append(freezeBlance);
        sb.append(", gold=").append(gold);
        sb.append(", integral=").append(integral);
        sb.append(", lastLoginDate=").append(lastLoginDate);
        sb.append(", lastLoginIp=").append(lastLoginIp);
        sb.append(", loginCount=").append(loginCount);
        sb.append(", loginDate=").append(loginDate);
        sb.append(", loginIp=").append(loginIp);
        sb.append(", mobile=").append(mobile);
        sb.append(", password=").append(password);
        sb.append(", report=").append(report);
        sb.append(", sex=").append(sex);
        sb.append(", status=").append(status);
        sb.append(", telephone=").append(telephone);
        sb.append(", trueName=").append(trueName);
        sb.append(", userName=").append(userName);
        sb.append(", userRole=").append(userRole);
        sb.append(", userCredit=").append(userCredit);
        sb.append(", photoId=").append(photoId);
        sb.append(", storeId=").append(storeId);
        sb.append(", qqOpenid=").append(qqOpenid);
        sb.append(", sinaOpenid=").append(sinaOpenid);
        sb.append(", parentId=").append(parentId);
        sb.append(", years=").append(years);
        sb.append(", areaId=").append(areaId);
        sb.append(", storeQuickMenu=").append(storeQuickMenu);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ShopUser other = (ShopUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getDeleteStatus() == null ? other.getDeleteStatus() == null : this.getDeleteStatus().equals(other.getDeleteStatus()))
            && (this.getMsn() == null ? other.getMsn() == null : this.getMsn().equals(other.getMsn()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
            && (this.getWw() == null ? other.getWw() == null : this.getWw().equals(other.getWw()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getAvailableBalance() == null ? other.getAvailableBalance() == null : this.getAvailableBalance().equals(other.getAvailableBalance()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getFreezeBlance() == null ? other.getFreezeBlance() == null : this.getFreezeBlance().equals(other.getFreezeBlance()))
            && (this.getGold() == null ? other.getGold() == null : this.getGold().equals(other.getGold()))
            && (this.getIntegral() == null ? other.getIntegral() == null : this.getIntegral().equals(other.getIntegral()))
            && (this.getLastLoginDate() == null ? other.getLastLoginDate() == null : this.getLastLoginDate().equals(other.getLastLoginDate()))
            && (this.getLastLoginIp() == null ? other.getLastLoginIp() == null : this.getLastLoginIp().equals(other.getLastLoginIp()))
            && (this.getLoginCount() == null ? other.getLoginCount() == null : this.getLoginCount().equals(other.getLoginCount()))
            && (this.getLoginDate() == null ? other.getLoginDate() == null : this.getLoginDate().equals(other.getLoginDate()))
            && (this.getLoginIp() == null ? other.getLoginIp() == null : this.getLoginIp().equals(other.getLoginIp()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getReport() == null ? other.getReport() == null : this.getReport().equals(other.getReport()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getTrueName() == null ? other.getTrueName() == null : this.getTrueName().equals(other.getTrueName()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getUserRole() == null ? other.getUserRole() == null : this.getUserRole().equals(other.getUserRole()))
            && (this.getUserCredit() == null ? other.getUserCredit() == null : this.getUserCredit().equals(other.getUserCredit()))
            && (this.getPhotoId() == null ? other.getPhotoId() == null : this.getPhotoId().equals(other.getPhotoId()))
            && (this.getStoreId() == null ? other.getStoreId() == null : this.getStoreId().equals(other.getStoreId()))
            && (this.getQqOpenid() == null ? other.getQqOpenid() == null : this.getQqOpenid().equals(other.getQqOpenid()))
            && (this.getSinaOpenid() == null ? other.getSinaOpenid() == null : this.getSinaOpenid().equals(other.getSinaOpenid()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getYears() == null ? other.getYears() == null : this.getYears().equals(other.getYears()))
            && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getStoreQuickMenu() == null ? other.getStoreQuickMenu() == null : this.getStoreQuickMenu().equals(other.getStoreQuickMenu()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getDeleteStatus() == null) ? 0 : getDeleteStatus().hashCode());
        result = prime * result + ((getMsn() == null) ? 0 : getMsn().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getWw() == null) ? 0 : getWw().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getAvailableBalance() == null) ? 0 : getAvailableBalance().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getFreezeBlance() == null) ? 0 : getFreezeBlance().hashCode());
        result = prime * result + ((getGold() == null) ? 0 : getGold().hashCode());
        result = prime * result + ((getIntegral() == null) ? 0 : getIntegral().hashCode());
        result = prime * result + ((getLastLoginDate() == null) ? 0 : getLastLoginDate().hashCode());
        result = prime * result + ((getLastLoginIp() == null) ? 0 : getLastLoginIp().hashCode());
        result = prime * result + ((getLoginCount() == null) ? 0 : getLoginCount().hashCode());
        result = prime * result + ((getLoginDate() == null) ? 0 : getLoginDate().hashCode());
        result = prime * result + ((getLoginIp() == null) ? 0 : getLoginIp().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getReport() == null) ? 0 : getReport().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getTrueName() == null) ? 0 : getTrueName().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getUserRole() == null) ? 0 : getUserRole().hashCode());
        result = prime * result + ((getUserCredit() == null) ? 0 : getUserCredit().hashCode());
        result = prime * result + ((getPhotoId() == null) ? 0 : getPhotoId().hashCode());
        result = prime * result + ((getStoreId() == null) ? 0 : getStoreId().hashCode());
        result = prime * result + ((getQqOpenid() == null) ? 0 : getQqOpenid().hashCode());
        result = prime * result + ((getSinaOpenid() == null) ? 0 : getSinaOpenid().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getYears() == null) ? 0 : getYears().hashCode());
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getStoreQuickMenu() == null) ? 0 : getStoreQuickMenu().hashCode());
        return result;
    }
}