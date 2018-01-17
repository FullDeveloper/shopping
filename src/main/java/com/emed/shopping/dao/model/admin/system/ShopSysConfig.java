package com.emed.shopping.dao.model.admin.system;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ShopSysConfig implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 标题
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 关键字
     *
     * @mbg.generated
     */
    private String keywords;

    /**
     * 描述
     *
     * @mbg.generated
     */
    private String description;

    /**
     * 地址
     *
     * @mbg.generated
     */
    private String address;

    /**
     * 版权
     *
     * @mbg.generated
     */
    private String copyRight;

    /**
     * 下载路径
     *
     * @mbg.generated
     */
    private String uploadFilePath;

    /**
     * 系统语言
     *
     * @mbg.generated
     */
    private String sysLanguage;

    /**
     * 积分比率
     *
     * @mbg.generated
     */
    private Integer integralRate;

    /**
     * 开启短信
     *
     * @mbg.generated
     */
    private String smsEnable;

    /**
     * 短信地址
     *
     * @mbg.generated
     */
    private String smsUrl;

    /**
     * 短信用户名
     *
     * @mbg.generated
     */
    private String smsUsername;

    /**
     * 短信密码
     *
     * @mbg.generated
     */
    private String smsPassword;

    /**
     * 短信测试
     *
     * @mbg.generated
     */
    private String smsTest;

    /**
     * 开启邮件
     *
     * @mbg.generated
     */
    private String emailEnable;

    /**
     * 邮件主人
     *
     * @mbg.generated
     */
    private String emailHost;

    /**
     * 邮件端口
     *
     * @mbg.generated
     */
    private String emailPort;

    /**
     * 邮件使用者
     *
     * @mbg.generated
     */
    private String emailUser;

    /**
     * 邮件使用者用户名
     *
     * @mbg.generated
     */
    private String emailUsername;

    /**
     * 邮件使用者密码
     *
     * @mbg.generated
     */
    private String emailPassword;

    /**
     * 邮件测试
     *
     * @mbg.generated
     */
    private String emailTest;

    /**
     * 网站名称
     *
     * @mbg.generated
     */
    private String websiteName;

    /**
     * 热搜
     *
     * @mbg.generated
     */
    private String hotSreach;

    /**
     * 网站样式
     *
     * @mbg.generated
     */
    private String websiteCss;

    /**
     * 网站logo
     *
     * @mbg.generated
     */
    private Long accessoryId;

    /**
     * 网站状态
     *
     * @mbg.generated
     */
    private String websiteStatus;

    /**
     * 游客是否可以咨询
     *
     * @mbg.generated
     */
    private String visitorConsult;

    /**
     * 安全码类型
     *
     * @mbg.generated
     */
    private String securityCodeType;

    /**
     * 是否注册安全码
     *
     * @mbg.generated
     */
    private String securityCodeRegiter;

    /**
     * 是否可以使用安全码进行登录
     *
     * @mbg.generated
     */
    private String securityCodeLogin;

    /**
     * 安全码咨询
     *
     * @mbg.generated
     */
    private String securityCodeConsult;

    /**
     * 图片后缀名
     *
     * @mbg.generated
     */
    private String imageSuffix;

    /**
     * 图片web服务
     *
     * @mbg.generated
     */
    private String imageWebServer;

    /**
     * 图片文件大小
     *
     * @mbg.generated
     */
    private Integer imageFileSize;

    /**
     * 小图片宽度
     *
     * @mbg.generated
     */
    private Integer smallWidth;

    /**
     * 小图片高度
     *
     * @mbg.generated
     */
    private Integer smallHeight;

    /**
     * 中等宽度
     *
     * @mbg.generated
     */
    private Integer middleWidth;

    /**
     * 中等高度
     *
     * @mbg.generated
     */
    private Integer middleHeight;

    /**
     * 大宽度
     *
     * @mbg.generated
     */
    private Integer bigWidth;

    /**
     * 大高度
     *
     * @mbg.generated
     */
    private Integer bigHeight;

    /**
     * 开启积分
     *
     * @mbg.generated
     */
    private String integral;

    /**
     * 积分商店
     *
     * @mbg.generated
     */
    private String integralStore;

    /**
     * 是否有证件
     *
     * @mbg.generated
     */
    private String voucher;

    /**
     * 是否有保证金
     *
     * @mbg.generated
     */
    private String deposit;

    /**
     * 是否团购
     *
     * @mbg.generated
     */
    private String groupBuy;

    /**
     * 是否支持金币
     *
     * @mbg.generated
     */
    private String gold;

    /**
     * 金币值
     *
     * @mbg.generated
     */
    private Integer goldMarketValue;

    /**
     * 成员注册
     *
     * @mbg.generated
     */
    private Integer memeberRegister;

    /**
     * 成员登录
     *
     * @mbg.generated
     */
    private Integer memberDayLogin;

    /**
     * 评论缩进
     *
     * @mbg.generated
     */
    private Integer indentComment;

    /**
     * 合理消费
     *
     * @mbg.generated
     */
    private Integer consumptionRatio;

    /**
     * everyIndentLimit
     *
     * @mbg.generated
     */
    private Integer everyIndentLimit;

    /**
     * 图片保存类型
     *
     * @mbg.generated
     */
    private String imageSaveType;

    /**
     * 投诉时间
     *
     * @mbg.generated
     */
    private Integer complaintTime;

    /**
     * 店铺图片
     *
     * @mbg.generated
     */
    private Long storeImageId;

    /**
     * 商品图片
     *
     * @mbg.generated
     */
    private Long goodsImageId;

    /**
     * 会员图标
     *
     * @mbg.generated
     */
    private Long memberIcon;

    /**
     * 允许商店
     *
     * @mbg.generated
     */
    private String storeAllow;

    /**
     * ztc状态
     *
     * @mbg.generated
     */
    private String ztcStatus;

    /**
     * ztc商品浏览
     *
     * @mbg.generated
     */
    private Integer ztcGoodsView;

    /**
     * ztc价格
     *
     * @mbg.generated
     */
    private Integer ztcPrice;

    /**
     * second_domain_open
     *
     * @mbg.generated
     */
    private String secondDomainOpen;

    /**
     * 允许数量
     *
     * @mbg.generated
     */
    private Integer domainAllowCount;

    /**
     * QQ登录
     *
     * @mbg.generated
     */
    private String qqLogin;

    /**
     * qq_login_id
     *
     * @mbg.generated
     */
    private String qqLoginId;

    /**
     * qq_login_key
     *
     * @mbg.generated
     */
    private String qqLoginKey;

    /**
     * 新浪登录
     *
     * @mbg.generated
     */
    private String sinaLogin;

    /**
     * 新浪ID
     *
     * @mbg.generated
     */
    private String sinaLoginId;

    /**
     * sina_login_key
     *
     * @mbg.generated
     */
    private String sinaLoginKey;

    /**
     * lucene_update
     *
     * @mbg.generated
     */
    private Date luceneUpdate;

    /**
     * alipay_fenrun
     *
     * @mbg.generated
     */
    private Integer alipayFenrun;

    /**
     * balance_fenrun
     *
     * @mbg.generated
     */
    private Integer balanceFenrun;

    /**
     * bargain_title
     *
     * @mbg.generated
     */
    private String bargainTitle;

    /**
     * 交易状态
     *
     * @mbg.generated
     */
    private Integer bargainStatus;

    /**
     * 合法交易
     *
     * @mbg.generated
     */
    private Integer bargainValidity;

    /**
     * 交易折扣
     *
     * @mbg.generated
     */
    private BigDecimal bargainRebate;

    /**
     * 交易最大值
     *
     * @mbg.generated
     */
    private Integer bargainMaximum;

    /**
     * 运送标题
     *
     * @mbg.generated
     */
    private String deliveryTitle;

    /**
     * 运送状态
     *
     * @mbg.generated
     */
    private Integer deliveryStatus;

    /**
     * 运送数量
     *
     * @mbg.generated
     */
    private Integer deliveryAmount;

    /**
     * 结合量
     *
     * @mbg.generated
     */
    private Integer combinAmount;

    /**
     * 结合数量
     *
     * @mbg.generated
     */
    private Integer combinCount;

    /**
     * uc_bbs
     *
     * @mbg.generated
     */
    private String ucBbs;

    /**
     * uc数据
     *
     * @mbg.generated
     */
    private String ucDatabase;

    /**
     * uc表前缀
     *
     * @mbg.generated
     */
    private String ucTablePrefix;

    /**
     * uc数据地址
     *
     * @mbg.generated
     */
    private String ucDatabaseUrl;

    /**
     * uc数据端口
     *
     * @mbg.generated
     */
    private String ucDatabasePort;

    /**
     * uc数据用户名
     *
     * @mbg.generated
     */
    private String ucDatabaseUsername;

    /**
     * uc数据密码
     *
     * @mbg.generated
     */
    private String ucDatabasePws;

    /**
     * uc文档
     *
     * @mbg.generated
     */
    private String ucApi;

    /**
     * ucIP地址
     *
     * @mbg.generated
     */
    private String ucIp;

    /**
     * uc密钥
     *
     * @mbg.generated
     */
    private String ucKey;

    /**
     * uc应用ID
     *
     * @mbg.generated
     */
    private String ucAppid;

    /**
     * auto_order_notice
     *
     * @mbg.generated
     */
    private Integer autoOrderNotice;

    /**
     * 自动确认订单
     *
     * @mbg.generated
     */
    private Integer autoOrderConfirm;

    /**
     * 自动返回订单
     *
     * @mbg.generated
     */
    private Integer autoOrderReturn;

    /**
     * 自动评价订单
     *
     * @mbg.generated
     */
    private Integer autoOrderEvaluate;

    /**
     * 货币码
     *
     * @mbg.generated
     */
    private String currencyCode;

    /**
     * 微信店铺
     *
     * @mbg.generated
     */
    private String wechatStore;

    /**
     * 微信量
     *
     * @mbg.generated
     */
    private Integer wechatAmount;

    /**
     * 支付类型配置
     *
     * @mbg.generated
     */
    private Integer configPaymentType;

    /**
     * 微信图片附件
     *
     * @mbg.generated
     */
    private Long wechatQrImgId;

    /**
     * 微信账目
     *
     * @mbg.generated
     */
    private String wechatAccount;

    /**
     * 微信令牌
     *
     * @mbg.generated
     */
    private String wechatToken;

    /**
     * 微信应用地址
     *
     * @mbg.generated
     */
    private String wechatAppId;

    /**
     * 微信app密钥
     *
     * @mbg.generated
     */
    private String weixinAppSecret;

    /**
     * 微信欢迎内容
     *
     * @mbg.generated
     */
    private String wechatWelcomeContent;

    /**
     * 微信店铺logo
     *
     * @mbg.generated
     */
    private Long storeWechatLogoId;

    /**
     * site_url
     *
     * @mbg.generated
     */
    private String siteUrl;

    /**
     * 关闭原因
     *
     * @mbg.generated
     */
    private String closeReason;

    /**
     * 信用规则
     *
     * @mbg.generated
     */
    private String creditRules;

    /**
     * 用户信用规则
     *
     * @mbg.generated
     */
    private String userCreditRules;

    /**
     * 模板
     *
     * @mbg.generated
     */
    private String templates;

    /**
     * 店铺支付
     *
     * @mbg.generated
     */
    private String storePayment;

    /**
     * 分享码
     *
     * @mbg.generated
     */
    private String shareCode;

    /**
     * sys_domain
     *
     * @mbg.generated
     */
    private String sysDomain;

    /**
     * qq_domain_code
     *
     * @mbg.generated
     */
    private String qqDomainCode;

    /**
     * sina_domain_code
     *
     * @mbg.generated
     */
    private String sinaDomainCode;

    /**
     * bargain_state
     *
     * @mbg.generated
     */
    private String bargainState;

    /**
     * 服务电话列表
     *
     * @mbg.generated
     */
    private String serviceTelephoneList;

    /**
     * 服务QQ列表
     *
     * @mbg.generated
     */
    private String serviceQqList;

    /**
     * 快递编号
     *
     * @mbg.generated
     */
    private String expressId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCopyRight() {
        return copyRight;
    }

    public void setCopyRight(String copyRight) {
        this.copyRight = copyRight;
    }

    public String getUploadFilePath() {
        return uploadFilePath;
    }

    public void setUploadFilePath(String uploadFilePath) {
        this.uploadFilePath = uploadFilePath;
    }

    public String getSysLanguage() {
        return sysLanguage;
    }

    public void setSysLanguage(String sysLanguage) {
        this.sysLanguage = sysLanguage;
    }

    public Integer getIntegralRate() {
        return integralRate;
    }

    public void setIntegralRate(Integer integralRate) {
        this.integralRate = integralRate;
    }

    public String getSmsEnable() {
        return smsEnable;
    }

    public void setSmsEnable(String smsEnable) {
        this.smsEnable = smsEnable;
    }

    public String getSmsUrl() {
        return smsUrl;
    }

    public void setSmsUrl(String smsUrl) {
        this.smsUrl = smsUrl;
    }

    public String getSmsUsername() {
        return smsUsername;
    }

    public void setSmsUsername(String smsUsername) {
        this.smsUsername = smsUsername;
    }

    public String getSmsPassword() {
        return smsPassword;
    }

    public void setSmsPassword(String smsPassword) {
        this.smsPassword = smsPassword;
    }

    public String getSmsTest() {
        return smsTest;
    }

    public void setSmsTest(String smsTest) {
        this.smsTest = smsTest;
    }

    public String getEmailEnable() {
        return emailEnable;
    }

    public void setEmailEnable(String emailEnable) {
        this.emailEnable = emailEnable;
    }

    public String getEmailHost() {
        return emailHost;
    }

    public void setEmailHost(String emailHost) {
        this.emailHost = emailHost;
    }

    public String getEmailPort() {
        return emailPort;
    }

    public void setEmailPort(String emailPort) {
        this.emailPort = emailPort;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getEmailUsername() {
        return emailUsername;
    }

    public void setEmailUsername(String emailUsername) {
        this.emailUsername = emailUsername;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }

    public String getEmailTest() {
        return emailTest;
    }

    public void setEmailTest(String emailTest) {
        this.emailTest = emailTest;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getHotSreach() {
        return hotSreach;
    }

    public void setHotSreach(String hotSreach) {
        this.hotSreach = hotSreach;
    }

    public String getWebsiteCss() {
        return websiteCss;
    }

    public void setWebsiteCss(String websiteCss) {
        this.websiteCss = websiteCss;
    }

    public Long getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(Long accessoryId) {
        this.accessoryId = accessoryId;
    }

    public String getWebsiteStatus() {
        return websiteStatus;
    }

    public void setWebsiteStatus(String websiteStatus) {
        this.websiteStatus = websiteStatus;
    }

    public String getVisitorConsult() {
        return visitorConsult;
    }

    public void setVisitorConsult(String visitorConsult) {
        this.visitorConsult = visitorConsult;
    }

    public String getSecurityCodeType() {
        return securityCodeType;
    }

    public void setSecurityCodeType(String securityCodeType) {
        this.securityCodeType = securityCodeType;
    }

    public String getSecurityCodeRegiter() {
        return securityCodeRegiter;
    }

    public void setSecurityCodeRegiter(String securityCodeRegiter) {
        this.securityCodeRegiter = securityCodeRegiter;
    }

    public String getSecurityCodeLogin() {
        return securityCodeLogin;
    }

    public void setSecurityCodeLogin(String securityCodeLogin) {
        this.securityCodeLogin = securityCodeLogin;
    }

    public String getSecurityCodeConsult() {
        return securityCodeConsult;
    }

    public void setSecurityCodeConsult(String securityCodeConsult) {
        this.securityCodeConsult = securityCodeConsult;
    }

    public String getImageSuffix() {
        return imageSuffix;
    }

    public void setImageSuffix(String imageSuffix) {
        this.imageSuffix = imageSuffix;
    }

    public String getImageWebServer() {
        return imageWebServer;
    }

    public void setImageWebServer(String imageWebServer) {
        this.imageWebServer = imageWebServer;
    }

    public Integer getImageFileSize() {
        return imageFileSize;
    }

    public void setImageFileSize(Integer imageFileSize) {
        this.imageFileSize = imageFileSize;
    }

    public Integer getSmallWidth() {
        return smallWidth;
    }

    public void setSmallWidth(Integer smallWidth) {
        this.smallWidth = smallWidth;
    }

    public Integer getSmallHeight() {
        return smallHeight;
    }

    public void setSmallHeight(Integer smallHeight) {
        this.smallHeight = smallHeight;
    }

    public Integer getMiddleWidth() {
        return middleWidth;
    }

    public void setMiddleWidth(Integer middleWidth) {
        this.middleWidth = middleWidth;
    }

    public Integer getMiddleHeight() {
        return middleHeight;
    }

    public void setMiddleHeight(Integer middleHeight) {
        this.middleHeight = middleHeight;
    }

    public Integer getBigWidth() {
        return bigWidth;
    }

    public void setBigWidth(Integer bigWidth) {
        this.bigWidth = bigWidth;
    }

    public Integer getBigHeight() {
        return bigHeight;
    }

    public void setBigHeight(Integer bigHeight) {
        this.bigHeight = bigHeight;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getIntegralStore() {
        return integralStore;
    }

    public void setIntegralStore(String integralStore) {
        this.integralStore = integralStore;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getGroupBuy() {
        return groupBuy;
    }

    public void setGroupBuy(String groupBuy) {
        this.groupBuy = groupBuy;
    }

    public String getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    public Integer getGoldMarketValue() {
        return goldMarketValue;
    }

    public void setGoldMarketValue(Integer goldMarketValue) {
        this.goldMarketValue = goldMarketValue;
    }

    public Integer getMemeberRegister() {
        return memeberRegister;
    }

    public void setMemeberRegister(Integer memeberRegister) {
        this.memeberRegister = memeberRegister;
    }

    public Integer getMemberDayLogin() {
        return memberDayLogin;
    }

    public void setMemberDayLogin(Integer memberDayLogin) {
        this.memberDayLogin = memberDayLogin;
    }

    public Integer getIndentComment() {
        return indentComment;
    }

    public void setIndentComment(Integer indentComment) {
        this.indentComment = indentComment;
    }

    public Integer getConsumptionRatio() {
        return consumptionRatio;
    }

    public void setConsumptionRatio(Integer consumptionRatio) {
        this.consumptionRatio = consumptionRatio;
    }

    public Integer getEveryIndentLimit() {
        return everyIndentLimit;
    }

    public void setEveryIndentLimit(Integer everyIndentLimit) {
        this.everyIndentLimit = everyIndentLimit;
    }

    public String getImageSaveType() {
        return imageSaveType;
    }

    public void setImageSaveType(String imageSaveType) {
        this.imageSaveType = imageSaveType;
    }

    public Integer getComplaintTime() {
        return complaintTime;
    }

    public void setComplaintTime(Integer complaintTime) {
        this.complaintTime = complaintTime;
    }

    public Long getStoreImageId() {
        return storeImageId;
    }

    public void setStoreImageId(Long storeImageId) {
        this.storeImageId = storeImageId;
    }

    public Long getGoodsImageId() {
        return goodsImageId;
    }

    public void setGoodsImageId(Long goodsImageId) {
        this.goodsImageId = goodsImageId;
    }

    public Long getMemberIcon() {
        return memberIcon;
    }

    public void setMemberIcon(Long memberIcon) {
        this.memberIcon = memberIcon;
    }

    public String getStoreAllow() {
        return storeAllow;
    }

    public void setStoreAllow(String storeAllow) {
        this.storeAllow = storeAllow;
    }

    public String getZtcStatus() {
        return ztcStatus;
    }

    public void setZtcStatus(String ztcStatus) {
        this.ztcStatus = ztcStatus;
    }

    public Integer getZtcGoodsView() {
        return ztcGoodsView;
    }

    public void setZtcGoodsView(Integer ztcGoodsView) {
        this.ztcGoodsView = ztcGoodsView;
    }

    public Integer getZtcPrice() {
        return ztcPrice;
    }

    public void setZtcPrice(Integer ztcPrice) {
        this.ztcPrice = ztcPrice;
    }

    public String getSecondDomainOpen() {
        return secondDomainOpen;
    }

    public void setSecondDomainOpen(String secondDomainOpen) {
        this.secondDomainOpen = secondDomainOpen;
    }

    public Integer getDomainAllowCount() {
        return domainAllowCount;
    }

    public void setDomainAllowCount(Integer domainAllowCount) {
        this.domainAllowCount = domainAllowCount;
    }

    public String getQqLogin() {
        return qqLogin;
    }

    public void setQqLogin(String qqLogin) {
        this.qqLogin = qqLogin;
    }

    public String getQqLoginId() {
        return qqLoginId;
    }

    public void setQqLoginId(String qqLoginId) {
        this.qqLoginId = qqLoginId;
    }

    public String getQqLoginKey() {
        return qqLoginKey;
    }

    public void setQqLoginKey(String qqLoginKey) {
        this.qqLoginKey = qqLoginKey;
    }

    public String getSinaLogin() {
        return sinaLogin;
    }

    public void setSinaLogin(String sinaLogin) {
        this.sinaLogin = sinaLogin;
    }

    public String getSinaLoginId() {
        return sinaLoginId;
    }

    public void setSinaLoginId(String sinaLoginId) {
        this.sinaLoginId = sinaLoginId;
    }

    public String getSinaLoginKey() {
        return sinaLoginKey;
    }

    public void setSinaLoginKey(String sinaLoginKey) {
        this.sinaLoginKey = sinaLoginKey;
    }

    public Date getLuceneUpdate() {
        return luceneUpdate;
    }

    public void setLuceneUpdate(Date luceneUpdate) {
        this.luceneUpdate = luceneUpdate;
    }

    public Integer getAlipayFenrun() {
        return alipayFenrun;
    }

    public void setAlipayFenrun(Integer alipayFenrun) {
        this.alipayFenrun = alipayFenrun;
    }

    public Integer getBalanceFenrun() {
        return balanceFenrun;
    }

    public void setBalanceFenrun(Integer balanceFenrun) {
        this.balanceFenrun = balanceFenrun;
    }

    public String getBargainTitle() {
        return bargainTitle;
    }

    public void setBargainTitle(String bargainTitle) {
        this.bargainTitle = bargainTitle;
    }

    public Integer getBargainStatus() {
        return bargainStatus;
    }

    public void setBargainStatus(Integer bargainStatus) {
        this.bargainStatus = bargainStatus;
    }

    public Integer getBargainValidity() {
        return bargainValidity;
    }

    public void setBargainValidity(Integer bargainValidity) {
        this.bargainValidity = bargainValidity;
    }

    public BigDecimal getBargainRebate() {
        return bargainRebate;
    }

    public void setBargainRebate(BigDecimal bargainRebate) {
        this.bargainRebate = bargainRebate;
    }

    public Integer getBargainMaximum() {
        return bargainMaximum;
    }

    public void setBargainMaximum(Integer bargainMaximum) {
        this.bargainMaximum = bargainMaximum;
    }

    public String getDeliveryTitle() {
        return deliveryTitle;
    }

    public void setDeliveryTitle(String deliveryTitle) {
        this.deliveryTitle = deliveryTitle;
    }

    public Integer getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(Integer deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Integer getDeliveryAmount() {
        return deliveryAmount;
    }

    public void setDeliveryAmount(Integer deliveryAmount) {
        this.deliveryAmount = deliveryAmount;
    }

    public Integer getCombinAmount() {
        return combinAmount;
    }

    public void setCombinAmount(Integer combinAmount) {
        this.combinAmount = combinAmount;
    }

    public Integer getCombinCount() {
        return combinCount;
    }

    public void setCombinCount(Integer combinCount) {
        this.combinCount = combinCount;
    }

    public String getUcBbs() {
        return ucBbs;
    }

    public void setUcBbs(String ucBbs) {
        this.ucBbs = ucBbs;
    }

    public String getUcDatabase() {
        return ucDatabase;
    }

    public void setUcDatabase(String ucDatabase) {
        this.ucDatabase = ucDatabase;
    }

    public String getUcTablePrefix() {
        return ucTablePrefix;
    }

    public void setUcTablePrefix(String ucTablePrefix) {
        this.ucTablePrefix = ucTablePrefix;
    }

    public String getUcDatabaseUrl() {
        return ucDatabaseUrl;
    }

    public void setUcDatabaseUrl(String ucDatabaseUrl) {
        this.ucDatabaseUrl = ucDatabaseUrl;
    }

    public String getUcDatabasePort() {
        return ucDatabasePort;
    }

    public void setUcDatabasePort(String ucDatabasePort) {
        this.ucDatabasePort = ucDatabasePort;
    }

    public String getUcDatabaseUsername() {
        return ucDatabaseUsername;
    }

    public void setUcDatabaseUsername(String ucDatabaseUsername) {
        this.ucDatabaseUsername = ucDatabaseUsername;
    }

    public String getUcDatabasePws() {
        return ucDatabasePws;
    }

    public void setUcDatabasePws(String ucDatabasePws) {
        this.ucDatabasePws = ucDatabasePws;
    }

    public String getUcApi() {
        return ucApi;
    }

    public void setUcApi(String ucApi) {
        this.ucApi = ucApi;
    }

    public String getUcIp() {
        return ucIp;
    }

    public void setUcIp(String ucIp) {
        this.ucIp = ucIp;
    }

    public String getUcKey() {
        return ucKey;
    }

    public void setUcKey(String ucKey) {
        this.ucKey = ucKey;
    }

    public String getUcAppid() {
        return ucAppid;
    }

    public void setUcAppid(String ucAppid) {
        this.ucAppid = ucAppid;
    }

    public Integer getAutoOrderNotice() {
        return autoOrderNotice;
    }

    public void setAutoOrderNotice(Integer autoOrderNotice) {
        this.autoOrderNotice = autoOrderNotice;
    }

    public Integer getAutoOrderConfirm() {
        return autoOrderConfirm;
    }

    public void setAutoOrderConfirm(Integer autoOrderConfirm) {
        this.autoOrderConfirm = autoOrderConfirm;
    }

    public Integer getAutoOrderReturn() {
        return autoOrderReturn;
    }

    public void setAutoOrderReturn(Integer autoOrderReturn) {
        this.autoOrderReturn = autoOrderReturn;
    }

    public Integer getAutoOrderEvaluate() {
        return autoOrderEvaluate;
    }

    public void setAutoOrderEvaluate(Integer autoOrderEvaluate) {
        this.autoOrderEvaluate = autoOrderEvaluate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getWechatStore() {
        return wechatStore;
    }

    public void setWechatStore(String wechatStore) {
        this.wechatStore = wechatStore;
    }

    public Integer getWechatAmount() {
        return wechatAmount;
    }

    public void setWechatAmount(Integer wechatAmount) {
        this.wechatAmount = wechatAmount;
    }

    public Integer getConfigPaymentType() {
        return configPaymentType;
    }

    public void setConfigPaymentType(Integer configPaymentType) {
        this.configPaymentType = configPaymentType;
    }

    public Long getWechatQrImgId() {
        return wechatQrImgId;
    }

    public void setWechatQrImgId(Long wechatQrImgId) {
        this.wechatQrImgId = wechatQrImgId;
    }

    public String getWechatAccount() {
        return wechatAccount;
    }

    public void setWechatAccount(String wechatAccount) {
        this.wechatAccount = wechatAccount;
    }

    public String getWechatToken() {
        return wechatToken;
    }

    public void setWechatToken(String wechatToken) {
        this.wechatToken = wechatToken;
    }

    public String getWechatAppId() {
        return wechatAppId;
    }

    public void setWechatAppId(String wechatAppId) {
        this.wechatAppId = wechatAppId;
    }

    public String getWeixinAppSecret() {
        return weixinAppSecret;
    }

    public void setWeixinAppSecret(String weixinAppSecret) {
        this.weixinAppSecret = weixinAppSecret;
    }

    public String getWechatWelcomeContent() {
        return wechatWelcomeContent;
    }

    public void setWechatWelcomeContent(String wechatWelcomeContent) {
        this.wechatWelcomeContent = wechatWelcomeContent;
    }

    public Long getStoreWechatLogoId() {
        return storeWechatLogoId;
    }

    public void setStoreWechatLogoId(Long storeWechatLogoId) {
        this.storeWechatLogoId = storeWechatLogoId;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public String getCreditRules() {
        return creditRules;
    }

    public void setCreditRules(String creditRules) {
        this.creditRules = creditRules;
    }

    public String getUserCreditRules() {
        return userCreditRules;
    }

    public void setUserCreditRules(String userCreditRules) {
        this.userCreditRules = userCreditRules;
    }

    public String getTemplates() {
        return templates;
    }

    public void setTemplates(String templates) {
        this.templates = templates;
    }

    public String getStorePayment() {
        return storePayment;
    }

    public void setStorePayment(String storePayment) {
        this.storePayment = storePayment;
    }

    public String getShareCode() {
        return shareCode;
    }

    public void setShareCode(String shareCode) {
        this.shareCode = shareCode;
    }

    public String getSysDomain() {
        return sysDomain;
    }

    public void setSysDomain(String sysDomain) {
        this.sysDomain = sysDomain;
    }

    public String getQqDomainCode() {
        return qqDomainCode;
    }

    public void setQqDomainCode(String qqDomainCode) {
        this.qqDomainCode = qqDomainCode;
    }

    public String getSinaDomainCode() {
        return sinaDomainCode;
    }

    public void setSinaDomainCode(String sinaDomainCode) {
        this.sinaDomainCode = sinaDomainCode;
    }

    public String getBargainState() {
        return bargainState;
    }

    public void setBargainState(String bargainState) {
        this.bargainState = bargainState;
    }

    public String getServiceTelephoneList() {
        return serviceTelephoneList;
    }

    public void setServiceTelephoneList(String serviceTelephoneList) {
        this.serviceTelephoneList = serviceTelephoneList;
    }

    public String getServiceQqList() {
        return serviceQqList;
    }

    public void setServiceQqList(String serviceQqList) {
        this.serviceQqList = serviceQqList;
    }

    public String getExpressId() {
        return expressId;
    }

    public void setExpressId(String expressId) {
        this.expressId = expressId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", keywords=").append(keywords);
        sb.append(", description=").append(description);
        sb.append(", address=").append(address);
        sb.append(", copyRight=").append(copyRight);
        sb.append(", uploadFilePath=").append(uploadFilePath);
        sb.append(", sysLanguage=").append(sysLanguage);
        sb.append(", integralRate=").append(integralRate);
        sb.append(", smsEnable=").append(smsEnable);
        sb.append(", smsUrl=").append(smsUrl);
        sb.append(", smsUsername=").append(smsUsername);
        sb.append(", smsPassword=").append(smsPassword);
        sb.append(", smsTest=").append(smsTest);
        sb.append(", emailEnable=").append(emailEnable);
        sb.append(", emailHost=").append(emailHost);
        sb.append(", emailPort=").append(emailPort);
        sb.append(", emailUser=").append(emailUser);
        sb.append(", emailUsername=").append(emailUsername);
        sb.append(", emailPassword=").append(emailPassword);
        sb.append(", emailTest=").append(emailTest);
        sb.append(", websiteName=").append(websiteName);
        sb.append(", hotSreach=").append(hotSreach);
        sb.append(", websiteCss=").append(websiteCss);
        sb.append(", accessoryId=").append(accessoryId);
        sb.append(", websiteStatus=").append(websiteStatus);
        sb.append(", visitorConsult=").append(visitorConsult);
        sb.append(", securityCodeType=").append(securityCodeType);
        sb.append(", securityCodeRegiter=").append(securityCodeRegiter);
        sb.append(", securityCodeLogin=").append(securityCodeLogin);
        sb.append(", securityCodeConsult=").append(securityCodeConsult);
        sb.append(", imageSuffix=").append(imageSuffix);
        sb.append(", imageWebServer=").append(imageWebServer);
        sb.append(", imageFileSize=").append(imageFileSize);
        sb.append(", smallWidth=").append(smallWidth);
        sb.append(", smallHeight=").append(smallHeight);
        sb.append(", middleWidth=").append(middleWidth);
        sb.append(", middleHeight=").append(middleHeight);
        sb.append(", bigWidth=").append(bigWidth);
        sb.append(", bigHeight=").append(bigHeight);
        sb.append(", integral=").append(integral);
        sb.append(", integralStore=").append(integralStore);
        sb.append(", voucher=").append(voucher);
        sb.append(", deposit=").append(deposit);
        sb.append(", groupBuy=").append(groupBuy);
        sb.append(", gold=").append(gold);
        sb.append(", goldMarketValue=").append(goldMarketValue);
        sb.append(", memeberRegister=").append(memeberRegister);
        sb.append(", memberDayLogin=").append(memberDayLogin);
        sb.append(", indentComment=").append(indentComment);
        sb.append(", consumptionRatio=").append(consumptionRatio);
        sb.append(", everyIndentLimit=").append(everyIndentLimit);
        sb.append(", imageSaveType=").append(imageSaveType);
        sb.append(", complaintTime=").append(complaintTime);
        sb.append(", storeImageId=").append(storeImageId);
        sb.append(", goodsImageId=").append(goodsImageId);
        sb.append(", memberIcon=").append(memberIcon);
        sb.append(", storeAllow=").append(storeAllow);
        sb.append(", ztcStatus=").append(ztcStatus);
        sb.append(", ztcGoodsView=").append(ztcGoodsView);
        sb.append(", ztcPrice=").append(ztcPrice);
        sb.append(", secondDomainOpen=").append(secondDomainOpen);
        sb.append(", domainAllowCount=").append(domainAllowCount);
        sb.append(", qqLogin=").append(qqLogin);
        sb.append(", qqLoginId=").append(qqLoginId);
        sb.append(", qqLoginKey=").append(qqLoginKey);
        sb.append(", sinaLogin=").append(sinaLogin);
        sb.append(", sinaLoginId=").append(sinaLoginId);
        sb.append(", sinaLoginKey=").append(sinaLoginKey);
        sb.append(", luceneUpdate=").append(luceneUpdate);
        sb.append(", alipayFenrun=").append(alipayFenrun);
        sb.append(", balanceFenrun=").append(balanceFenrun);
        sb.append(", bargainTitle=").append(bargainTitle);
        sb.append(", bargainStatus=").append(bargainStatus);
        sb.append(", bargainValidity=").append(bargainValidity);
        sb.append(", bargainRebate=").append(bargainRebate);
        sb.append(", bargainMaximum=").append(bargainMaximum);
        sb.append(", deliveryTitle=").append(deliveryTitle);
        sb.append(", deliveryStatus=").append(deliveryStatus);
        sb.append(", deliveryAmount=").append(deliveryAmount);
        sb.append(", combinAmount=").append(combinAmount);
        sb.append(", combinCount=").append(combinCount);
        sb.append(", ucBbs=").append(ucBbs);
        sb.append(", ucDatabase=").append(ucDatabase);
        sb.append(", ucTablePrefix=").append(ucTablePrefix);
        sb.append(", ucDatabaseUrl=").append(ucDatabaseUrl);
        sb.append(", ucDatabasePort=").append(ucDatabasePort);
        sb.append(", ucDatabaseUsername=").append(ucDatabaseUsername);
        sb.append(", ucDatabasePws=").append(ucDatabasePws);
        sb.append(", ucApi=").append(ucApi);
        sb.append(", ucIp=").append(ucIp);
        sb.append(", ucKey=").append(ucKey);
        sb.append(", ucAppid=").append(ucAppid);
        sb.append(", autoOrderNotice=").append(autoOrderNotice);
        sb.append(", autoOrderConfirm=").append(autoOrderConfirm);
        sb.append(", autoOrderReturn=").append(autoOrderReturn);
        sb.append(", autoOrderEvaluate=").append(autoOrderEvaluate);
        sb.append(", currencyCode=").append(currencyCode);
        sb.append(", wechatStore=").append(wechatStore);
        sb.append(", wechatAmount=").append(wechatAmount);
        sb.append(", configPaymentType=").append(configPaymentType);
        sb.append(", wechatQrImgId=").append(wechatQrImgId);
        sb.append(", wechatAccount=").append(wechatAccount);
        sb.append(", wechatToken=").append(wechatToken);
        sb.append(", wechatAppId=").append(wechatAppId);
        sb.append(", weixinAppSecret=").append(weixinAppSecret);
        sb.append(", wechatWelcomeContent=").append(wechatWelcomeContent);
        sb.append(", storeWechatLogoId=").append(storeWechatLogoId);
        sb.append(", siteUrl=").append(siteUrl);
        sb.append(", closeReason=").append(closeReason);
        sb.append(", creditRules=").append(creditRules);
        sb.append(", userCreditRules=").append(userCreditRules);
        sb.append(", templates=").append(templates);
        sb.append(", storePayment=").append(storePayment);
        sb.append(", shareCode=").append(shareCode);
        sb.append(", sysDomain=").append(sysDomain);
        sb.append(", qqDomainCode=").append(qqDomainCode);
        sb.append(", sinaDomainCode=").append(sinaDomainCode);
        sb.append(", bargainState=").append(bargainState);
        sb.append(", serviceTelephoneList=").append(serviceTelephoneList);
        sb.append(", serviceQqList=").append(serviceQqList);
        sb.append(", expressId=").append(expressId);
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
        ShopSysConfig other = (ShopSysConfig) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getKeywords() == null ? other.getKeywords() == null : this.getKeywords().equals(other.getKeywords()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getCopyRight() == null ? other.getCopyRight() == null : this.getCopyRight().equals(other.getCopyRight()))
            && (this.getUploadFilePath() == null ? other.getUploadFilePath() == null : this.getUploadFilePath().equals(other.getUploadFilePath()))
            && (this.getSysLanguage() == null ? other.getSysLanguage() == null : this.getSysLanguage().equals(other.getSysLanguage()))
            && (this.getIntegralRate() == null ? other.getIntegralRate() == null : this.getIntegralRate().equals(other.getIntegralRate()))
            && (this.getSmsEnable() == null ? other.getSmsEnable() == null : this.getSmsEnable().equals(other.getSmsEnable()))
            && (this.getSmsUrl() == null ? other.getSmsUrl() == null : this.getSmsUrl().equals(other.getSmsUrl()))
            && (this.getSmsUsername() == null ? other.getSmsUsername() == null : this.getSmsUsername().equals(other.getSmsUsername()))
            && (this.getSmsPassword() == null ? other.getSmsPassword() == null : this.getSmsPassword().equals(other.getSmsPassword()))
            && (this.getSmsTest() == null ? other.getSmsTest() == null : this.getSmsTest().equals(other.getSmsTest()))
            && (this.getEmailEnable() == null ? other.getEmailEnable() == null : this.getEmailEnable().equals(other.getEmailEnable()))
            && (this.getEmailHost() == null ? other.getEmailHost() == null : this.getEmailHost().equals(other.getEmailHost()))
            && (this.getEmailPort() == null ? other.getEmailPort() == null : this.getEmailPort().equals(other.getEmailPort()))
            && (this.getEmailUser() == null ? other.getEmailUser() == null : this.getEmailUser().equals(other.getEmailUser()))
            && (this.getEmailUsername() == null ? other.getEmailUsername() == null : this.getEmailUsername().equals(other.getEmailUsername()))
            && (this.getEmailPassword() == null ? other.getEmailPassword() == null : this.getEmailPassword().equals(other.getEmailPassword()))
            && (this.getEmailTest() == null ? other.getEmailTest() == null : this.getEmailTest().equals(other.getEmailTest()))
            && (this.getWebsiteName() == null ? other.getWebsiteName() == null : this.getWebsiteName().equals(other.getWebsiteName()))
            && (this.getHotSreach() == null ? other.getHotSreach() == null : this.getHotSreach().equals(other.getHotSreach()))
            && (this.getWebsiteCss() == null ? other.getWebsiteCss() == null : this.getWebsiteCss().equals(other.getWebsiteCss()))
            && (this.getAccessoryId() == null ? other.getAccessoryId() == null : this.getAccessoryId().equals(other.getAccessoryId()))
            && (this.getWebsiteStatus() == null ? other.getWebsiteStatus() == null : this.getWebsiteStatus().equals(other.getWebsiteStatus()))
            && (this.getVisitorConsult() == null ? other.getVisitorConsult() == null : this.getVisitorConsult().equals(other.getVisitorConsult()))
            && (this.getSecurityCodeType() == null ? other.getSecurityCodeType() == null : this.getSecurityCodeType().equals(other.getSecurityCodeType()))
            && (this.getSecurityCodeRegiter() == null ? other.getSecurityCodeRegiter() == null : this.getSecurityCodeRegiter().equals(other.getSecurityCodeRegiter()))
            && (this.getSecurityCodeLogin() == null ? other.getSecurityCodeLogin() == null : this.getSecurityCodeLogin().equals(other.getSecurityCodeLogin()))
            && (this.getSecurityCodeConsult() == null ? other.getSecurityCodeConsult() == null : this.getSecurityCodeConsult().equals(other.getSecurityCodeConsult()))
            && (this.getImageSuffix() == null ? other.getImageSuffix() == null : this.getImageSuffix().equals(other.getImageSuffix()))
            && (this.getImageWebServer() == null ? other.getImageWebServer() == null : this.getImageWebServer().equals(other.getImageWebServer()))
            && (this.getImageFileSize() == null ? other.getImageFileSize() == null : this.getImageFileSize().equals(other.getImageFileSize()))
            && (this.getSmallWidth() == null ? other.getSmallWidth() == null : this.getSmallWidth().equals(other.getSmallWidth()))
            && (this.getSmallHeight() == null ? other.getSmallHeight() == null : this.getSmallHeight().equals(other.getSmallHeight()))
            && (this.getMiddleWidth() == null ? other.getMiddleWidth() == null : this.getMiddleWidth().equals(other.getMiddleWidth()))
            && (this.getMiddleHeight() == null ? other.getMiddleHeight() == null : this.getMiddleHeight().equals(other.getMiddleHeight()))
            && (this.getBigWidth() == null ? other.getBigWidth() == null : this.getBigWidth().equals(other.getBigWidth()))
            && (this.getBigHeight() == null ? other.getBigHeight() == null : this.getBigHeight().equals(other.getBigHeight()))
            && (this.getIntegral() == null ? other.getIntegral() == null : this.getIntegral().equals(other.getIntegral()))
            && (this.getIntegralStore() == null ? other.getIntegralStore() == null : this.getIntegralStore().equals(other.getIntegralStore()))
            && (this.getVoucher() == null ? other.getVoucher() == null : this.getVoucher().equals(other.getVoucher()))
            && (this.getDeposit() == null ? other.getDeposit() == null : this.getDeposit().equals(other.getDeposit()))
            && (this.getGroupBuy() == null ? other.getGroupBuy() == null : this.getGroupBuy().equals(other.getGroupBuy()))
            && (this.getGold() == null ? other.getGold() == null : this.getGold().equals(other.getGold()))
            && (this.getGoldMarketValue() == null ? other.getGoldMarketValue() == null : this.getGoldMarketValue().equals(other.getGoldMarketValue()))
            && (this.getMemeberRegister() == null ? other.getMemeberRegister() == null : this.getMemeberRegister().equals(other.getMemeberRegister()))
            && (this.getMemberDayLogin() == null ? other.getMemberDayLogin() == null : this.getMemberDayLogin().equals(other.getMemberDayLogin()))
            && (this.getIndentComment() == null ? other.getIndentComment() == null : this.getIndentComment().equals(other.getIndentComment()))
            && (this.getConsumptionRatio() == null ? other.getConsumptionRatio() == null : this.getConsumptionRatio().equals(other.getConsumptionRatio()))
            && (this.getEveryIndentLimit() == null ? other.getEveryIndentLimit() == null : this.getEveryIndentLimit().equals(other.getEveryIndentLimit()))
            && (this.getImageSaveType() == null ? other.getImageSaveType() == null : this.getImageSaveType().equals(other.getImageSaveType()))
            && (this.getComplaintTime() == null ? other.getComplaintTime() == null : this.getComplaintTime().equals(other.getComplaintTime()))
            && (this.getStoreImageId() == null ? other.getStoreImageId() == null : this.getStoreImageId().equals(other.getStoreImageId()))
            && (this.getGoodsImageId() == null ? other.getGoodsImageId() == null : this.getGoodsImageId().equals(other.getGoodsImageId()))
            && (this.getMemberIcon() == null ? other.getMemberIcon() == null : this.getMemberIcon().equals(other.getMemberIcon()))
            && (this.getStoreAllow() == null ? other.getStoreAllow() == null : this.getStoreAllow().equals(other.getStoreAllow()))
            && (this.getZtcStatus() == null ? other.getZtcStatus() == null : this.getZtcStatus().equals(other.getZtcStatus()))
            && (this.getZtcGoodsView() == null ? other.getZtcGoodsView() == null : this.getZtcGoodsView().equals(other.getZtcGoodsView()))
            && (this.getZtcPrice() == null ? other.getZtcPrice() == null : this.getZtcPrice().equals(other.getZtcPrice()))
            && (this.getSecondDomainOpen() == null ? other.getSecondDomainOpen() == null : this.getSecondDomainOpen().equals(other.getSecondDomainOpen()))
            && (this.getDomainAllowCount() == null ? other.getDomainAllowCount() == null : this.getDomainAllowCount().equals(other.getDomainAllowCount()))
            && (this.getQqLogin() == null ? other.getQqLogin() == null : this.getQqLogin().equals(other.getQqLogin()))
            && (this.getQqLoginId() == null ? other.getQqLoginId() == null : this.getQqLoginId().equals(other.getQqLoginId()))
            && (this.getQqLoginKey() == null ? other.getQqLoginKey() == null : this.getQqLoginKey().equals(other.getQqLoginKey()))
            && (this.getSinaLogin() == null ? other.getSinaLogin() == null : this.getSinaLogin().equals(other.getSinaLogin()))
            && (this.getSinaLoginId() == null ? other.getSinaLoginId() == null : this.getSinaLoginId().equals(other.getSinaLoginId()))
            && (this.getSinaLoginKey() == null ? other.getSinaLoginKey() == null : this.getSinaLoginKey().equals(other.getSinaLoginKey()))
            && (this.getLuceneUpdate() == null ? other.getLuceneUpdate() == null : this.getLuceneUpdate().equals(other.getLuceneUpdate()))
            && (this.getAlipayFenrun() == null ? other.getAlipayFenrun() == null : this.getAlipayFenrun().equals(other.getAlipayFenrun()))
            && (this.getBalanceFenrun() == null ? other.getBalanceFenrun() == null : this.getBalanceFenrun().equals(other.getBalanceFenrun()))
            && (this.getBargainTitle() == null ? other.getBargainTitle() == null : this.getBargainTitle().equals(other.getBargainTitle()))
            && (this.getBargainStatus() == null ? other.getBargainStatus() == null : this.getBargainStatus().equals(other.getBargainStatus()))
            && (this.getBargainValidity() == null ? other.getBargainValidity() == null : this.getBargainValidity().equals(other.getBargainValidity()))
            && (this.getBargainRebate() == null ? other.getBargainRebate() == null : this.getBargainRebate().equals(other.getBargainRebate()))
            && (this.getBargainMaximum() == null ? other.getBargainMaximum() == null : this.getBargainMaximum().equals(other.getBargainMaximum()))
            && (this.getDeliveryTitle() == null ? other.getDeliveryTitle() == null : this.getDeliveryTitle().equals(other.getDeliveryTitle()))
            && (this.getDeliveryStatus() == null ? other.getDeliveryStatus() == null : this.getDeliveryStatus().equals(other.getDeliveryStatus()))
            && (this.getDeliveryAmount() == null ? other.getDeliveryAmount() == null : this.getDeliveryAmount().equals(other.getDeliveryAmount()))
            && (this.getCombinAmount() == null ? other.getCombinAmount() == null : this.getCombinAmount().equals(other.getCombinAmount()))
            && (this.getCombinCount() == null ? other.getCombinCount() == null : this.getCombinCount().equals(other.getCombinCount()))
            && (this.getUcBbs() == null ? other.getUcBbs() == null : this.getUcBbs().equals(other.getUcBbs()))
            && (this.getUcDatabase() == null ? other.getUcDatabase() == null : this.getUcDatabase().equals(other.getUcDatabase()))
            && (this.getUcTablePrefix() == null ? other.getUcTablePrefix() == null : this.getUcTablePrefix().equals(other.getUcTablePrefix()))
            && (this.getUcDatabaseUrl() == null ? other.getUcDatabaseUrl() == null : this.getUcDatabaseUrl().equals(other.getUcDatabaseUrl()))
            && (this.getUcDatabasePort() == null ? other.getUcDatabasePort() == null : this.getUcDatabasePort().equals(other.getUcDatabasePort()))
            && (this.getUcDatabaseUsername() == null ? other.getUcDatabaseUsername() == null : this.getUcDatabaseUsername().equals(other.getUcDatabaseUsername()))
            && (this.getUcDatabasePws() == null ? other.getUcDatabasePws() == null : this.getUcDatabasePws().equals(other.getUcDatabasePws()))
            && (this.getUcApi() == null ? other.getUcApi() == null : this.getUcApi().equals(other.getUcApi()))
            && (this.getUcIp() == null ? other.getUcIp() == null : this.getUcIp().equals(other.getUcIp()))
            && (this.getUcKey() == null ? other.getUcKey() == null : this.getUcKey().equals(other.getUcKey()))
            && (this.getUcAppid() == null ? other.getUcAppid() == null : this.getUcAppid().equals(other.getUcAppid()))
            && (this.getAutoOrderNotice() == null ? other.getAutoOrderNotice() == null : this.getAutoOrderNotice().equals(other.getAutoOrderNotice()))
            && (this.getAutoOrderConfirm() == null ? other.getAutoOrderConfirm() == null : this.getAutoOrderConfirm().equals(other.getAutoOrderConfirm()))
            && (this.getAutoOrderReturn() == null ? other.getAutoOrderReturn() == null : this.getAutoOrderReturn().equals(other.getAutoOrderReturn()))
            && (this.getAutoOrderEvaluate() == null ? other.getAutoOrderEvaluate() == null : this.getAutoOrderEvaluate().equals(other.getAutoOrderEvaluate()))
            && (this.getCurrencyCode() == null ? other.getCurrencyCode() == null : this.getCurrencyCode().equals(other.getCurrencyCode()))
            && (this.getWechatStore() == null ? other.getWechatStore() == null : this.getWechatStore().equals(other.getWechatStore()))
            && (this.getWechatAmount() == null ? other.getWechatAmount() == null : this.getWechatAmount().equals(other.getWechatAmount()))
            && (this.getConfigPaymentType() == null ? other.getConfigPaymentType() == null : this.getConfigPaymentType().equals(other.getConfigPaymentType()))
            && (this.getWechatQrImgId() == null ? other.getWechatQrImgId() == null : this.getWechatQrImgId().equals(other.getWechatQrImgId()))
            && (this.getWechatAccount() == null ? other.getWechatAccount() == null : this.getWechatAccount().equals(other.getWechatAccount()))
            && (this.getWechatToken() == null ? other.getWechatToken() == null : this.getWechatToken().equals(other.getWechatToken()))
            && (this.getWechatAppId() == null ? other.getWechatAppId() == null : this.getWechatAppId().equals(other.getWechatAppId()))
            && (this.getWeixinAppSecret() == null ? other.getWeixinAppSecret() == null : this.getWeixinAppSecret().equals(other.getWeixinAppSecret()))
            && (this.getWechatWelcomeContent() == null ? other.getWechatWelcomeContent() == null : this.getWechatWelcomeContent().equals(other.getWechatWelcomeContent()))
            && (this.getStoreWechatLogoId() == null ? other.getStoreWechatLogoId() == null : this.getStoreWechatLogoId().equals(other.getStoreWechatLogoId()))
            && (this.getSiteUrl() == null ? other.getSiteUrl() == null : this.getSiteUrl().equals(other.getSiteUrl()))
            && (this.getCloseReason() == null ? other.getCloseReason() == null : this.getCloseReason().equals(other.getCloseReason()))
            && (this.getCreditRules() == null ? other.getCreditRules() == null : this.getCreditRules().equals(other.getCreditRules()))
            && (this.getUserCreditRules() == null ? other.getUserCreditRules() == null : this.getUserCreditRules().equals(other.getUserCreditRules()))
            && (this.getTemplates() == null ? other.getTemplates() == null : this.getTemplates().equals(other.getTemplates()))
            && (this.getStorePayment() == null ? other.getStorePayment() == null : this.getStorePayment().equals(other.getStorePayment()))
            && (this.getShareCode() == null ? other.getShareCode() == null : this.getShareCode().equals(other.getShareCode()))
            && (this.getSysDomain() == null ? other.getSysDomain() == null : this.getSysDomain().equals(other.getSysDomain()))
            && (this.getQqDomainCode() == null ? other.getQqDomainCode() == null : this.getQqDomainCode().equals(other.getQqDomainCode()))
            && (this.getSinaDomainCode() == null ? other.getSinaDomainCode() == null : this.getSinaDomainCode().equals(other.getSinaDomainCode()))
            && (this.getBargainState() == null ? other.getBargainState() == null : this.getBargainState().equals(other.getBargainState()))
            && (this.getServiceTelephoneList() == null ? other.getServiceTelephoneList() == null : this.getServiceTelephoneList().equals(other.getServiceTelephoneList()))
            && (this.getServiceQqList() == null ? other.getServiceQqList() == null : this.getServiceQqList().equals(other.getServiceQqList()))
            && (this.getExpressId() == null ? other.getExpressId() == null : this.getExpressId().equals(other.getExpressId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getKeywords() == null) ? 0 : getKeywords().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getCopyRight() == null) ? 0 : getCopyRight().hashCode());
        result = prime * result + ((getUploadFilePath() == null) ? 0 : getUploadFilePath().hashCode());
        result = prime * result + ((getSysLanguage() == null) ? 0 : getSysLanguage().hashCode());
        result = prime * result + ((getIntegralRate() == null) ? 0 : getIntegralRate().hashCode());
        result = prime * result + ((getSmsEnable() == null) ? 0 : getSmsEnable().hashCode());
        result = prime * result + ((getSmsUrl() == null) ? 0 : getSmsUrl().hashCode());
        result = prime * result + ((getSmsUsername() == null) ? 0 : getSmsUsername().hashCode());
        result = prime * result + ((getSmsPassword() == null) ? 0 : getSmsPassword().hashCode());
        result = prime * result + ((getSmsTest() == null) ? 0 : getSmsTest().hashCode());
        result = prime * result + ((getEmailEnable() == null) ? 0 : getEmailEnable().hashCode());
        result = prime * result + ((getEmailHost() == null) ? 0 : getEmailHost().hashCode());
        result = prime * result + ((getEmailPort() == null) ? 0 : getEmailPort().hashCode());
        result = prime * result + ((getEmailUser() == null) ? 0 : getEmailUser().hashCode());
        result = prime * result + ((getEmailUsername() == null) ? 0 : getEmailUsername().hashCode());
        result = prime * result + ((getEmailPassword() == null) ? 0 : getEmailPassword().hashCode());
        result = prime * result + ((getEmailTest() == null) ? 0 : getEmailTest().hashCode());
        result = prime * result + ((getWebsiteName() == null) ? 0 : getWebsiteName().hashCode());
        result = prime * result + ((getHotSreach() == null) ? 0 : getHotSreach().hashCode());
        result = prime * result + ((getWebsiteCss() == null) ? 0 : getWebsiteCss().hashCode());
        result = prime * result + ((getAccessoryId() == null) ? 0 : getAccessoryId().hashCode());
        result = prime * result + ((getWebsiteStatus() == null) ? 0 : getWebsiteStatus().hashCode());
        result = prime * result + ((getVisitorConsult() == null) ? 0 : getVisitorConsult().hashCode());
        result = prime * result + ((getSecurityCodeType() == null) ? 0 : getSecurityCodeType().hashCode());
        result = prime * result + ((getSecurityCodeRegiter() == null) ? 0 : getSecurityCodeRegiter().hashCode());
        result = prime * result + ((getSecurityCodeLogin() == null) ? 0 : getSecurityCodeLogin().hashCode());
        result = prime * result + ((getSecurityCodeConsult() == null) ? 0 : getSecurityCodeConsult().hashCode());
        result = prime * result + ((getImageSuffix() == null) ? 0 : getImageSuffix().hashCode());
        result = prime * result + ((getImageWebServer() == null) ? 0 : getImageWebServer().hashCode());
        result = prime * result + ((getImageFileSize() == null) ? 0 : getImageFileSize().hashCode());
        result = prime * result + ((getSmallWidth() == null) ? 0 : getSmallWidth().hashCode());
        result = prime * result + ((getSmallHeight() == null) ? 0 : getSmallHeight().hashCode());
        result = prime * result + ((getMiddleWidth() == null) ? 0 : getMiddleWidth().hashCode());
        result = prime * result + ((getMiddleHeight() == null) ? 0 : getMiddleHeight().hashCode());
        result = prime * result + ((getBigWidth() == null) ? 0 : getBigWidth().hashCode());
        result = prime * result + ((getBigHeight() == null) ? 0 : getBigHeight().hashCode());
        result = prime * result + ((getIntegral() == null) ? 0 : getIntegral().hashCode());
        result = prime * result + ((getIntegralStore() == null) ? 0 : getIntegralStore().hashCode());
        result = prime * result + ((getVoucher() == null) ? 0 : getVoucher().hashCode());
        result = prime * result + ((getDeposit() == null) ? 0 : getDeposit().hashCode());
        result = prime * result + ((getGroupBuy() == null) ? 0 : getGroupBuy().hashCode());
        result = prime * result + ((getGold() == null) ? 0 : getGold().hashCode());
        result = prime * result + ((getGoldMarketValue() == null) ? 0 : getGoldMarketValue().hashCode());
        result = prime * result + ((getMemeberRegister() == null) ? 0 : getMemeberRegister().hashCode());
        result = prime * result + ((getMemberDayLogin() == null) ? 0 : getMemberDayLogin().hashCode());
        result = prime * result + ((getIndentComment() == null) ? 0 : getIndentComment().hashCode());
        result = prime * result + ((getConsumptionRatio() == null) ? 0 : getConsumptionRatio().hashCode());
        result = prime * result + ((getEveryIndentLimit() == null) ? 0 : getEveryIndentLimit().hashCode());
        result = prime * result + ((getImageSaveType() == null) ? 0 : getImageSaveType().hashCode());
        result = prime * result + ((getComplaintTime() == null) ? 0 : getComplaintTime().hashCode());
        result = prime * result + ((getStoreImageId() == null) ? 0 : getStoreImageId().hashCode());
        result = prime * result + ((getGoodsImageId() == null) ? 0 : getGoodsImageId().hashCode());
        result = prime * result + ((getMemberIcon() == null) ? 0 : getMemberIcon().hashCode());
        result = prime * result + ((getStoreAllow() == null) ? 0 : getStoreAllow().hashCode());
        result = prime * result + ((getZtcStatus() == null) ? 0 : getZtcStatus().hashCode());
        result = prime * result + ((getZtcGoodsView() == null) ? 0 : getZtcGoodsView().hashCode());
        result = prime * result + ((getZtcPrice() == null) ? 0 : getZtcPrice().hashCode());
        result = prime * result + ((getSecondDomainOpen() == null) ? 0 : getSecondDomainOpen().hashCode());
        result = prime * result + ((getDomainAllowCount() == null) ? 0 : getDomainAllowCount().hashCode());
        result = prime * result + ((getQqLogin() == null) ? 0 : getQqLogin().hashCode());
        result = prime * result + ((getQqLoginId() == null) ? 0 : getQqLoginId().hashCode());
        result = prime * result + ((getQqLoginKey() == null) ? 0 : getQqLoginKey().hashCode());
        result = prime * result + ((getSinaLogin() == null) ? 0 : getSinaLogin().hashCode());
        result = prime * result + ((getSinaLoginId() == null) ? 0 : getSinaLoginId().hashCode());
        result = prime * result + ((getSinaLoginKey() == null) ? 0 : getSinaLoginKey().hashCode());
        result = prime * result + ((getLuceneUpdate() == null) ? 0 : getLuceneUpdate().hashCode());
        result = prime * result + ((getAlipayFenrun() == null) ? 0 : getAlipayFenrun().hashCode());
        result = prime * result + ((getBalanceFenrun() == null) ? 0 : getBalanceFenrun().hashCode());
        result = prime * result + ((getBargainTitle() == null) ? 0 : getBargainTitle().hashCode());
        result = prime * result + ((getBargainStatus() == null) ? 0 : getBargainStatus().hashCode());
        result = prime * result + ((getBargainValidity() == null) ? 0 : getBargainValidity().hashCode());
        result = prime * result + ((getBargainRebate() == null) ? 0 : getBargainRebate().hashCode());
        result = prime * result + ((getBargainMaximum() == null) ? 0 : getBargainMaximum().hashCode());
        result = prime * result + ((getDeliveryTitle() == null) ? 0 : getDeliveryTitle().hashCode());
        result = prime * result + ((getDeliveryStatus() == null) ? 0 : getDeliveryStatus().hashCode());
        result = prime * result + ((getDeliveryAmount() == null) ? 0 : getDeliveryAmount().hashCode());
        result = prime * result + ((getCombinAmount() == null) ? 0 : getCombinAmount().hashCode());
        result = prime * result + ((getCombinCount() == null) ? 0 : getCombinCount().hashCode());
        result = prime * result + ((getUcBbs() == null) ? 0 : getUcBbs().hashCode());
        result = prime * result + ((getUcDatabase() == null) ? 0 : getUcDatabase().hashCode());
        result = prime * result + ((getUcTablePrefix() == null) ? 0 : getUcTablePrefix().hashCode());
        result = prime * result + ((getUcDatabaseUrl() == null) ? 0 : getUcDatabaseUrl().hashCode());
        result = prime * result + ((getUcDatabasePort() == null) ? 0 : getUcDatabasePort().hashCode());
        result = prime * result + ((getUcDatabaseUsername() == null) ? 0 : getUcDatabaseUsername().hashCode());
        result = prime * result + ((getUcDatabasePws() == null) ? 0 : getUcDatabasePws().hashCode());
        result = prime * result + ((getUcApi() == null) ? 0 : getUcApi().hashCode());
        result = prime * result + ((getUcIp() == null) ? 0 : getUcIp().hashCode());
        result = prime * result + ((getUcKey() == null) ? 0 : getUcKey().hashCode());
        result = prime * result + ((getUcAppid() == null) ? 0 : getUcAppid().hashCode());
        result = prime * result + ((getAutoOrderNotice() == null) ? 0 : getAutoOrderNotice().hashCode());
        result = prime * result + ((getAutoOrderConfirm() == null) ? 0 : getAutoOrderConfirm().hashCode());
        result = prime * result + ((getAutoOrderReturn() == null) ? 0 : getAutoOrderReturn().hashCode());
        result = prime * result + ((getAutoOrderEvaluate() == null) ? 0 : getAutoOrderEvaluate().hashCode());
        result = prime * result + ((getCurrencyCode() == null) ? 0 : getCurrencyCode().hashCode());
        result = prime * result + ((getWechatStore() == null) ? 0 : getWechatStore().hashCode());
        result = prime * result + ((getWechatAmount() == null) ? 0 : getWechatAmount().hashCode());
        result = prime * result + ((getConfigPaymentType() == null) ? 0 : getConfigPaymentType().hashCode());
        result = prime * result + ((getWechatQrImgId() == null) ? 0 : getWechatQrImgId().hashCode());
        result = prime * result + ((getWechatAccount() == null) ? 0 : getWechatAccount().hashCode());
        result = prime * result + ((getWechatToken() == null) ? 0 : getWechatToken().hashCode());
        result = prime * result + ((getWechatAppId() == null) ? 0 : getWechatAppId().hashCode());
        result = prime * result + ((getWeixinAppSecret() == null) ? 0 : getWeixinAppSecret().hashCode());
        result = prime * result + ((getWechatWelcomeContent() == null) ? 0 : getWechatWelcomeContent().hashCode());
        result = prime * result + ((getStoreWechatLogoId() == null) ? 0 : getStoreWechatLogoId().hashCode());
        result = prime * result + ((getSiteUrl() == null) ? 0 : getSiteUrl().hashCode());
        result = prime * result + ((getCloseReason() == null) ? 0 : getCloseReason().hashCode());
        result = prime * result + ((getCreditRules() == null) ? 0 : getCreditRules().hashCode());
        result = prime * result + ((getUserCreditRules() == null) ? 0 : getUserCreditRules().hashCode());
        result = prime * result + ((getTemplates() == null) ? 0 : getTemplates().hashCode());
        result = prime * result + ((getStorePayment() == null) ? 0 : getStorePayment().hashCode());
        result = prime * result + ((getShareCode() == null) ? 0 : getShareCode().hashCode());
        result = prime * result + ((getSysDomain() == null) ? 0 : getSysDomain().hashCode());
        result = prime * result + ((getQqDomainCode() == null) ? 0 : getQqDomainCode().hashCode());
        result = prime * result + ((getSinaDomainCode() == null) ? 0 : getSinaDomainCode().hashCode());
        result = prime * result + ((getBargainState() == null) ? 0 : getBargainState().hashCode());
        result = prime * result + ((getServiceTelephoneList() == null) ? 0 : getServiceTelephoneList().hashCode());
        result = prime * result + ((getServiceQqList() == null) ? 0 : getServiceQqList().hashCode());
        result = prime * result + ((getExpressId() == null) ? 0 : getExpressId().hashCode());
        return result;
    }
}