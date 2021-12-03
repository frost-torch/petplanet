package com.petplanet.backend.service;

import com.petplanet.backend.dao.OnlinePetDao;
import com.petplanet.backend.pojo.OnlinePet;
import com.petplanet.backend.util.WebStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OnlinePetService {

    @SuppressWarnings("all")
    @Autowired
    private OnlinePetDao onlinePetDao;

    public Map<String, Object> addOnlinePet(OnlinePet onlinePet) {

        Integer flag = onlinePetDao.addOnlinePet(onlinePet);

        if (0 != flag) return WebStatusUtil.httpError("参数错误或缺少参数");

        return WebStatusUtil.httpOk("响应成功！");
    }

    public List<OnlinePet> queryAllOnlinePets(Integer uId) {

        List<OnlinePet> onlinePets;

        try {
            onlinePets = onlinePetDao.queryOnlinePets(uId);
        } catch (Exception e) {
            e.printStackTrace();
            onlinePets = new ArrayList<>();
        }

        return onlinePets;
    }

    public Map<String, Object> delOnlinePet(Integer uId, Integer pId) {
        return onlinePetDao.delOnlinePet(uId, pId) ? WebStatusUtil.httpOk("响应成功") : WebStatusUtil.httpError("参数问题");
    }

}
