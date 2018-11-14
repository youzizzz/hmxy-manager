package com.hmxy.manager.service.shareMeet;

import com.hmxy.dto.SharerMeettingDTO;
import com.hmxy.http.PageInfo;
import com.hmxy.http.Response;

/**
 * @discripeion:
 * @author: liangj
 * @date: 2018/11/13 17:25
 */
public interface SharerMeettingService {


    Response<String> sharerMeettingAdd(SharerMeettingDTO sharerMeettingDTO);
}
