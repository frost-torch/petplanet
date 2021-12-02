package com.petplanet.backend.dao;

import com.petplanet.backend.pojo.Help;

public interface HelpDao {

    Integer addHelp(Help help);

    /**
     * 删除一条指定的求助信息，并返回删除的状态
     * @param hId 求助信息的序列号，用于指定一条求助信息
     * @return 删除的状态（成功为 true，不成功为 false）
     */
    boolean delHelp(Integer hId);

}
