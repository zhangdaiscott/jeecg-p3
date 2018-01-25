package com.jeecg.auth.util;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.jeecg.auth.entity.JwSystemAuth;
import com.jeecg.auth.entity.TreeNode;

/**
 * Description: 系统工具
 * @author junfeng.zhou
 * @version V1.0
 */
public class SystemUtil {
    /**
     * 拼树：
     * @param allList 所有可用的权限
     * @return
     */
    public static String listTreeToAuth(List<JwSystemAuth> allList) {
        if(allList!=null && allList.size()>0) {
            List<TreeNode> treeList = new ArrayList<TreeNode>();
            for(JwSystemAuth auth :allList) {
                TreeNode tn = new TreeNode();
                tn.setId(auth.getAuthId());
                String pId = "0";
                if(auth.getParentAuthId()!=null && !auth.getParentAuthId().equals("")){
                    pId = auth.getParentAuthId();
                }
                tn.setpId(pId);
                tn.setName(auth.getAuthName());
                if("1".equals(auth.getAuthType())||"Y".equals(auth.getLeafInd())){
                	tn.setOpen(false); //设置所有打开或所有闭关
                }else{
                	tn.setOpen(true); //设置所有打开或所有闭关
                }
                tn.setChecked(false);
                tn.setDoCheck(false);
                tn.setHalfCheck(false);
                tn.setParent(false);
                tn.setChkDisabled(false);
                tn.setNocheck(false);
                treeList.add(tn);
            }
            JSONArray jsonArray = JSONArray.fromObject(treeList);
            return jsonArray.toString();
        }
        return "";
    }
}
