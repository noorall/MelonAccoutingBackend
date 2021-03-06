package com.nwpu.melonbookkeeping.service;

import com.nwpu.melonbookkeeping.controller.admin.param.SystemConfigParam;

import java.util.Map;

/**
 * @author noorall
 * @date 2021/1/79:47 下午
 * @Description: 网站全局配置服务
 */
public interface ConfigService {
    Map<String, String> getWebConfig();

    boolean saveWebConfig(Map<String, String> configs);

    void updateApiCallsCount();
}
