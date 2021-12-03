package com.petplanet.backend.service;

import com.petplanet.backend.dao.HelpDao;
import com.petplanet.backend.pojo.Help;
import com.petplanet.backend.util.WebStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HelpService {

    @SuppressWarnings("all")
    @Autowired
    private HelpDao helpDao;

    public Map<String, Object> addHelp(Help help) {

        Integer hId = helpDao.addHelp(help);

        if (null == hId) {
            return WebStatusUtil.httpError("非法信息或缺少信息（有可能是当前用户发表过相同主题的求助信息所导致）");
        } else {

            Map<String, Object> ok = WebStatusUtil.httpOk("响应成功");
            ok.put("hId", hId);
            return ok;
        }
    }

    public Map<String, Object> delHelp(Integer hId) {

        if (null == hId) {
            return WebStatusUtil.httpError("请填写需要删除的求助消息的序列号！");
        }

        if (helpDao.delHelp(hId)) {
            return WebStatusUtil.httpOk("删除成功！");
        } else {
            return WebStatusUtil.httpError("删除失败");
        }
    }

    public Map<String, Object> updateHelp(Help help) {

        try {
            helpDao.updateHelp(help);
        } catch (Exception e) {
            e.printStackTrace();
            return WebStatusUtil.httpError("参数缺失或非法参数");
        }

        return WebStatusUtil.httpOk("修改成功！");
    }

}
