package com.hmxy.manager.dao.completionShare;

import com.hmxy.dto.AreaDTO;
import com.hmxy.dto.CompletionShareDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @discripeion: 用户补全
 * @author: tangyozhi
 * @date: 2018年11月7日15:50:07
 */
@Mapper
public interface CompletionShareDao {

    /**
     * 根据ID获取一个用户分享
     * @param csId
     * @return
     */
    CompletionShareDTO findOneCompletionShare(String csId);

    /**
     * 新增一个用户分享
     * @param completionShareDTO
     * @return
     */
    Integer saveCompletionShare(CompletionShareDTO completionShareDTO);

}
