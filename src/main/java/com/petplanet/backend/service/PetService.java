package com.petplanet.backend.service;

import com.petplanet.backend.dao.PetDao;
import com.petplanet.backend.pojo.Pet;
import com.petplanet.backend.util.WebStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PetService {

    @SuppressWarnings("all")
    @Autowired
    private PetDao petDao;

    public Map<String, Object> addPet(Pet pet) {
        return petDao.addPet(pet);
    }

    public List<Pet> queryPet(Integer uId, Integer pId) {

        if (null == pId) {
            return petDao.queryPet(uId);
        }
        return petDao.queryPet(uId, pId);
    }

    public Map<String, Object> updatePet(Pet pet) {
        if (petDao.updatePet(pet)) {
            return WebStatusUtil.httpOk("响应成功");
        } else {
            return WebStatusUtil.httpError("参数缺少或非法参数");
        }
    }

    public Map<String, Object> delPet(Integer pId) {
        try {
            petDao.delPet(pId);
        }catch (Exception e) {
            e.printStackTrace();
            return WebStatusUtil.httpError("无相关记录");
        } finally {
            return WebStatusUtil.httpOk("操作成功！");
        }
    }
}
