package com.nwpu.melonbookkeeping.service;

import com.nwpu.melonbookkeeping.controller.admin.vo.AdminIndexVO;

/**
 * @author noorall
 * @date 2021/1/83:21 下午
 * @Description: 管理员操作接口
 */
public interface AdminService {
    boolean login(String userName, String password);

    boolean modifyAdminPassword(String password);

    AdminIndexVO getIndexVO();
}
