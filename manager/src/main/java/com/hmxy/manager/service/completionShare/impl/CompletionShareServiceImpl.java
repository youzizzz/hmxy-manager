package com.hmxy.manager.service.completionShare.impl;

import com.hmxy.dto.CompletionShareDTO;
import com.hmxy.http.HttpStatusEnum;
import com.hmxy.http.Response;
import com.hmxy.manager.dao.completionShare.CompletionShareDao;
import com.hmxy.manager.service.completionShare.CompletionShareService;
import com.hmxy.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tangyouzhi
 * @date 2018年11月12日15:14:11
 */
@Service
public class CompletionShareServiceImpl implements CompletionShareService {

    @Autowired
    private CompletionShareDao completionShareDao;

    /**
     * 根据ID获取一个用户分享
     *
     * @param csId
     * @return
     */
    @Override
    public Response<CompletionShareDTO> findOneCompletionShare(String csId) {
        return new Response<CompletionShareDTO>().setData(completionShareDao.findOneCompletionShare(csId))
                .setStatusCode(HttpStatusEnum.success.getCode()).setMessage("查询成功!");
    }

    /**
     * 新增一个用户分享
     *
     * @param completionShareDTO
     * @return
     */
    @Override
    public Response<String> saveCompletionShare(CompletionShareDTO completionShareDTO) {
        completionShareDTO.setCsId(UUIDUtil.generateUUID());
        int result = completionShareDao.saveCompletionShare(completionShareDTO);
        return new Response<String>().setStatusCode(HttpStatusEnum.success.getCode())
                .setMessage(result > 0 ? "用户补全信息新增成功" : "用户补全新增失败")
                .setData(result > 0 ? "success" : "error");
    }
}
