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

}
