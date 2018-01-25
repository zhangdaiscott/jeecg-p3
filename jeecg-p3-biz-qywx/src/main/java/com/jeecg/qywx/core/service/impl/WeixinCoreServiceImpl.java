package com.jeecg.qywx.core.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.jeecgframework.p3.core.logger.Logger;
import org.jeecgframework.p3.core.logger.LoggerFactory;
import org.jeecgframework.p3.core.util.plugin.ContextHolderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeecg.qywx.account.dao.QywxAccountDao;
import com.jeecg.qywx.account.dao.QywxMenuDao;
import com.jeecg.qywx.account.entity.QywxAccount;
import com.jeecg.qywx.account.entity.QywxMenu;
import com.jeecg.qywx.base.entity.QywxReceivetext;
import com.jeecg.qywx.core.service.AutoResponseDefaultServiceI;
import com.jeecg.qywx.core.service.KeyWordDealInterfaceService;
import com.jeecg.qywx.core.service.TextDealInterfaceService;
import com.jeecg.qywx.core.service.WeixinCoreService;
import com.jeecg.qywx.core.util.MessageUtil;
import com.jeecg.qywx.core.util.WeixinUtil;
import com.jeecg.qywx.sucai.dao.QywxNewsitemDao;
import com.jeecg.qywx.sucai.dao.QywxNewstemplateDao;
import com.jeecg.qywx.sucai.dao.QywxTexttemplateDao;
import com.jeecg.qywx.sucai.entity.QywxNewsitem;
import com.jeecg.qywx.sucai.entity.QywxNewstemplate;
import com.jeecg.qywx.sucai.entity.QywxTexttemplate;


@Service("weixinCoreService")
public class WeixinCoreServiceImpl implements WeixinCoreService {
	
	private static final Logger logger = LoggerFactory.getLogger(WeixinCoreServiceImpl.class);
	
	@Autowired
	private TextDealInterfaceService textDealInterfaceService;//文本消息接口实现类
	@Autowired
	private KeyWordDealInterfaceService keyWordDealInterfaceServcie;//关键字接口实现类
//	@Autowired
//	private ImageDealInterfaceService imageDealInterfaceService;//图片消息处理接口实现类
//	@Autowired
//	private LocationDealInterfaceService locationDealInterfaceService;//地理位置消息实现接口
//	@Autowired
//	private GzDealInterfaceService gzDealIntefaceService;//关注事件处理接口
//	@Autowired
//	private QxDealInterfaceService qxDealInterfaceService;//取消事件处理接口
//	@Autowired
//	private MenuClickDealInterfaceService menuClickDealInterfaceService;//微信菜单点击事件接口
	@Autowired
	private AutoResponseDefaultServiceI autoResponseDefaultService;//默认回复接口
//	@Autowired
//	private SystemService systemService;
	@Autowired
	private QywxAccountDao qywxAccountDao;
	@Autowired
	private QywxMenuDao qywxMenuDao;
	@Autowired
	private QywxTexttemplateDao qywxTexttemplateDao;
	@Autowired
	private QywxNewstemplateDao qywxNewstemplateDao;
	@Autowired
	private QywxNewsitemDao qywxNewsitemDao;
	
	
    /** 
     * ToUserName	企业号CorpID
     * FromUserName	成员UserID
     * CreateTime	消息创建时间（整型）
     * MsgType	消息类型，此时固定为：text
     * Content	文本消息内容
     * MsgId	消息id，64位整型
     * AgentID	企业应用的id，整型。可在应用的设置页面查看
     */
    public  String processRequest(String resultXml) {
    	String respMessage="";
        try {
            // xml请求解析
            Map<String, String> requestMap = MessageUtil.parseXml(resultXml);
            // 企业号CorpID
            String toUserName = requestMap.get("ToUserName");
            // 发送方帐号（UserID）
            String fromUserName = requestMap.get("FromUserName");
            //消息创建时间 注：微信消息接口中的CreateTime表示距离1970年的秒数而System.currentTimeMillis()表示距离1970年的毫秒数
            Long CreateTimeLong = Long.valueOf(requestMap.get("CreateTime"))*1000L;
            String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(CreateTimeLong));
            // 消息类型
            String msgType = requestMap.get("MsgType");
            //消息ID
        	String msgId = requestMap.get("MsgId");
        	//应用Id
        	String agentId = requestMap.get("AgentID");
        	logger.info("[WECHAT]","发送方账号:{},接收方账号:{},消息类型:{}", new Object[]{fromUserName,toUserName,msgType});
            //企业号ID
            String accountId = null;
            //添加关注人记录,并把账号信息保存到session中，后面保存用户信息使用
        	HttpSession session = ContextHolderUtils.getSession();
        	QywxAccount condition = new QywxAccount();
    		condition.setCorpid(toUserName);
    		List<QywxAccount> accountList = qywxAccountDao.getListByProperty(condition);
    		
        	if(accountList!=null && accountList.size()>0){
        		accountId = accountList.get(0).getId();
        	}else{
        		//TODO
        		return null;
        	}
    		
        	logger.info("----accountId-----"+accountId);
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
            	String content = requestMap.get("Content");
            	respMessage = this.dealTextMsg(toUserName, fromUserName, createTime, msgId, agentId, accountId, content);
            }else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)){
//            	String picUrl = requestMap.get("PicUrl");
//            	String mediaId = requestMap.get("MediaId");
//            	respMessage = this.dealImageMsg(toUserName, fromUserName, createTime, msgId, agentId, accountId, picUrl, mediaId);
        		
            }else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)){
//            	System.out.println("....位置信息....");
//            	//位置消息接口实现类未进行任何操作，为后来提供扩展提供方便
//            	this.locationDealInterfaceService.dealLocationMessage(null, toUserName);
//            	//判断是否转接多客服系统
//            	//AccountInfoEntity accountInfo = this.systemService.findUniqueByProperty(AccountInfoEntity.class, "wxbs", toUserName);
//            	respMessage = this.autoResponseDefaultService.getWorkDefaultResponse(fromUserName, toUserName, accountInfo.getId(),agentId);
        		
            }else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)){
//            	//接收语音消息
//            	//判断是否转接多客服系统
//            	//AccountInfoEntity accountInfo = this.systemService.findUniqueByProperty(AccountInfoEntity.class, "wxbs", toUserName);
//            	respMessage = this.autoResponseDefaultService.getWorkDefaultResponse(fromUserName, toUserName, accountInfo.getId(),agentId);
            }else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)){
            	//接收连接消息
            	//判断是否转接多客服系统
//            	//AccountInfoEntity accountInfo = this.systemService.findUniqueByProperty(AccountInfoEntity.class, "wxbs", toUserName);
//            	respMessage = this.autoResponseDefaultService.getWorkDefaultResponse(fromUserName, toUserName, accountInfo.getId(),agentId);
            }else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)){
//            	//接收视频消息
//            	//判断是否转接多客服系统
//            	//AccountInfoEntity accountInfo = this.systemService.findUniqueByProperty(AccountInfoEntity.class, "wxbs", toUserName);
//            	respMessage = this.autoResponseDefaultService.getWorkDefaultResponse(fromUserName, toUserName, accountInfo.getId(),agentId);
            }else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                    // 事件类型
                    String eventType = requestMap.get("Event");
                    System.out.println("......eventType...."+eventType);
                    // 订阅
                    if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    	//respMessage = this.gzDealIntefaceService.dealGzUserInfo(fromUserName, toUserName,accountInfo.getId(),agentId);
                    }
                    // 取消订阅
                    else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    	//this.qxDealInterfaceService.dealQxUserInfo(fromUserName, accountInfo.getId());
                    }
                    //接收地理位置信息
    				else if(eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)){
                     	
//                     	LocationEntity location = this.systemService.findUniqueByProperty(LocationEntity.class, "openid", fromUserName);
//                     	String latitude = requestMap.get("Latitude");
//                     	String longitude = requestMap.get("Longitude");
//                     	Date nowTime = new Date(); 
//                     	if(location ==null){
//                     		location = new LocationEntity();
//                         	String precision =  requestMap.get("Precision");
//                         	location.setAccountid(accountInfo.getId());
//                         	location.setOpenid(fromUserName);
//                         	location.setLatitude(latitude);
//                         	location.setLongitude(longitude);
//                         	location.setPrecision(precision);
//                         	location.setAddtime(nowTime);
//                         	this.systemService.save(location);
//                     	}else{
//                     		location.setLongitude(longitude);
//                     		location.setLatitude(latitude);
//                     		location.setAddtime(nowTime);
//                     		this.systemService.updateEntitie(location);
//                     	}
//                 
//                     	respMessage = "";
                     }
                    // 自定义菜单点击事件
                    else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    	
                    	String menuKey = requestMap.get("EventKey");
                    	System.out.println("....menuKey...."+menuKey);
                       //自定义菜单CLICK类型
                    	QywxMenu qywxMenu = qywxMenuDao.getMenuByMenuKey(menuKey);
                    	respMessage = dealMenuMessage(qywxMenu, toUserName, fromUserName, accountId, agentId);
                   }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("....respMessage....."+respMessage);
        return respMessage;
    }
    /**
     * 处理text消息
     * @param toUserName
     * @param fromUserName
     * @param createTime
     * @param msgId
     * @param agentId
     * @param accountId
     * @param content
     */
    private String dealTextMsg(String toUserName,String fromUserName,String createTime,String msgId,String agentId,String accountId,String content){
    	String respMessage = "";
    	//保存接收到的信息
    	QywxReceivetext receiveText = new QywxReceivetext();
    	receiveText.setContent(content);
    	Timestamp temp = Timestamp.valueOf(createTime);
    	String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    	receiveText.setId(randomSeed);
    	receiveText.setAccountid(accountId);
    	receiveText.setCreatetime(temp);
    	receiveText.setCreateDate(new Date());
    	receiveText.setFromusername(fromUserName);
    	receiveText.setTousername(toUserName);
    	receiveText.setMsgid(msgId);
    	receiveText.setMsgtype(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
    	receiveText.setResponse("0");
    	receiveText.setNickname("");
    	receiveText.setAgentId(agentId);
    	//保存消息
    	this.textDealInterfaceService.dealTextMessage(receiveText);
    	
    	//处理关键字
    	respMessage = this.keyWordDealInterfaceServcie.dealKeyMessage(content, toUserName, fromUserName,accountId,agentId);
    	
    	if(respMessage==""){
    		//判断是否转接多客服系统
    		respMessage = this.autoResponseDefaultService.getWorkDefaultResponse(fromUserName, toUserName, accountId,agentId);
    	}
    	return respMessage;
    }
    
    /**
     * 处理image消息
     * @param toUserName
     * @param fromUserName
     * @param createTime
     * @param msgId
     * @param agentId
     * @param accountId
     * @param picUrl
     * @param mediaId
     */
    private String dealImageMsg(String toUserName,String fromUserName,String createTime,String msgId,String agentId,String accountId,String picUrl,String mediaId){
    	String respMessage = "";
    	System.out.println(".....图片信息....");
    	//图片信息接口实现类未进行任何操作，为后来提供扩展提供方便
//    	this.imageDealInterfaceService.dealImageMessage(null, toUserName);
//    	//判断是否转接多客服系统
//    	//AccountInfoEntity accountInfo = this.systemService.findUniqueByProperty(AccountInfoEntity.class, "wxbs", toUserName);
//    	respMessage = this.autoResponseDefaultService.getWorkDefaultResponse(fromUserName, toUserName, accountInfo.getId(),agentId);
    	return respMessage;
    }
    
    /**
     * 处理voice消息
     * @param toUserName
     * @param fromUserName
     * @param createTime
     * @param msgId
     * @param agentId
     * @param accountId
     * @param format
     * @param mediaId
     */
    private String dealVoiceMsg(String toUserName,String fromUserName,String createTime,String msgId,String agentId,String accountId,String format,String mediaId){
    	String respMessage = "";
    	return respMessage;
    }
    
    private String dealVideoMsg(String toUserName,String fromUserName,String createTime,String msgId,String agentId,String accountId,String format,String mediaId){
    	String respMessage = "";
    	return respMessage;
    }
    
    /**
     * 处理菜单消息
     * @return
     */
    public String dealMenuMessage(QywxMenu qywxMenu, String toUserName,String fromUser,String accountid,String agentid) {
    	String responseMessage = "";
    	String lx = qywxMenu.getMsgType();
		String tempalteId = qywxMenu.getTemplateId();
		System.out.println(" dealMenuMessage [1] --lx-- "+lx + " -- tempalteId -- " + tempalteId);
		if("text".equals(lx)){
			QywxTexttemplate textTemplate = qywxTexttemplateDao.get(tempalteId);
			if(textTemplate!=null){
				System.out.println(" dealMenuMessage [2] --responseMessage--" + responseMessage);
				responseMessage = WeixinUtil.wrapperTextMessage(textTemplate, fromUser, toUserName);
			}
		}else if("news".equals(lx)){
			QywxNewstemplate newsTemplate = qywxNewstemplateDao.get(tempalteId);
			if(newsTemplate!=null){
				List<QywxNewsitem> newsList = qywxNewsitemDao.getQywxNewsitemByTemplateId(newsTemplate.getId());
				if(newsList!=null&&newsList.size()>0){
					responseMessage = WeixinUtil.wrapperNewsMessage(newsList, fromUser, toUserName,accountid,agentid);
					System.out.println("dealMenuMessage [3] --responseMessage--" + responseMessage);
				}
			}
		}
    	return responseMessage;
	}
}
