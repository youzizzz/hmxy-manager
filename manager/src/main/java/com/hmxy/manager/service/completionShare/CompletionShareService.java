package com.hmxy.manager.service.completionShare;

import com.hmxy.dto.CompletionShareDTO;
import com.hmxy.http.Response;
import org.apache.ibatis.annotations.Mapper;

/**
 * @discripeion:
 * @author: tangyozhi
 * @date: 2018年11月7日15:50:07
 */
public interface CompletionShareService {

    /**
     * 根据ID获取一个用户分享
     * @param csId
     * @return
     */
    Response<CompletionShareDTO> findOneCompletionShare(String csId);

    /**
     * 新增一个用户分享
     * @param completionShareDTO
     * @return
     */
    Response<String> saveCompletionShare(CompletionShareDTO completionShareDTO);

}
