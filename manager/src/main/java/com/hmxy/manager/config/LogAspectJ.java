package com.hmxy.manager.config;

import com.hmxy.dto.UserInfoDTO;
import com.hmxy.dto.UserLogDTO;
import com.hmxy.http.HttpStatusEnum;
import com.hmxy.manager.dao.userLog.UserLogDao;
import com.hmxy.util.UUIDUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 日志切面
 *
 * @author tangyouzhi
 */
@Aspect
@Component
public class LogAspectJ {

    @Autowired
    private UserLogDao userLogDao;


    private Environment env;

    /**
     * 登录信息在session中的Key
     */
    private String storageName;

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
        storageName = env.getProperty("session.storage.name");
    }

    @Pointcut("execution(public * com.hmxy.manager.controller..*.*(..))&&(" +
            "@annotation(org.springframework.web.bind.annotation.GetMapping)||" +
            "@annotation(org.springframework.web.bind.annotation.PostMapping)||" +
            "@annotation(org.springframework.web.bind.annotation.RequestMapping))")
    public void pointCut() {
    }


    @Around(value = "pointCut()")
    public Object Interceptor(ProceedingJoinPoint pjp) throws NoSuchMethodException, SecurityException {
        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = pjp.getTarget();
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String path = request.getRequestURI();
        UserLogDTO userLog = null;
        Object obj = null;
        Date startTime = null;
        Date endTime = null;
        try {
            if (path.equals("/hmxy-manager/client/login") || path.equals("/hmxy-manager/client/userLogin")) {
                return pjp.proceed();
            }
            userLog = new UserLogDTO();
            startTime = new Date();
            UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute(storageName);
            userLog.setUserId(userInfoDTO.getUserId());
            obj = pjp.proceed();
            endTime = new Date();
            userLog.setId(UUIDUtil.generateUUID());
            userLog.setStartTime(startTime);
            userLog.setPath(path);
            userLog.setEndTime(endTime);
            userLog.setExecuteTime(endTime.getTime() - startTime.getTime());
            userLog.setExecuteResult(HttpStatusEnum.success.getCode());
            userLogDao.addLog(userLog);
            return obj;
        } catch (Throwable e) {
            endTime = new Date();
            userLog.setId(UUIDUtil.generateUUID());
            userLog.setStartTime(startTime);
            userLog.setEndTime(endTime);
            userLog.setPath(path);
            userLog.setExecuteTime(endTime.getTime() - startTime.getTime());
            userLog.setExecuteResult(HttpStatusEnum.error.getCode());
            userLogDao.addLog(userLog);
            e.printStackTrace();
        }
        return null;
    }

}
