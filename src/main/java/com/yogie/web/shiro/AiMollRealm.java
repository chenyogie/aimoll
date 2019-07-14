package com.yogie.web.shiro;

import com.yogie.domain.Employee;
import com.yogie.service.IEmployeeService;
import com.yogie.service.IPermissionService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @program: aimoll
 * @Date: 2019/7/10 18:24
 * @Author: Chenyogie
 * @Description: 自定义的realm
 */
public class AiMollRealm extends AuthorizingRealm {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    IPermissionService permissionService;

    @Override
    public String getName() {
        return "aiMollRealm";
    }

    /**
     * 权限认证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //拿到username
        Employee loginUser = (Employee) principalCollection.getPrimaryPrincipal();
        //根据username拿到角色
        //Set<String> roles = getRolesByUsername(loginUser.getUsername());
        //根据当前登录用户拿到对应的权限
        Set<String> permissions = permissionService.findPermissionsByUserId(loginUser.getId());
        //创建授权对象
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //将角色和权限设置到权限对象中
        //authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    /**
     * 身份认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //将AuthenticationToken强制转换成UsernamePasswordToken
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //从token中拿到用户名
        String username = token.getUsername();
        //根据用户名查询对应用户
        Employee loginUser = employeeService.findByUsername(username);
        if(loginUser==null){
            return null;
        }
        //将盐值封装到ByteSource对象中
        ByteSource salt = ByteSource.Util.bytes("chenyogie");
        //将用户名、密码、盐值、realm的名称封装到认证对象中
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(loginUser,loginUser.getPassword(),salt,getName());
        return authenticationInfo;
    }
}
