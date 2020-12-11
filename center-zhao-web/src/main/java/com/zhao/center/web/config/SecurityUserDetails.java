//package com.zhao.center.web.config;
//
//import com.zhao.center.dto.resp.SysMenuDTO;
//import com.zhao.center.dto.resp.SysUserDTO;
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @author ZCH
// * @Description 用户信息
// * @since 2020/12/9$ 10:20$
// */
//@Data
//public class SecurityUserDetails implements UserDetails {
//
//    private SysUserDTO sysUserDTO;
//
//    private List<SysMenuDTO> sysMenuDTOList;
//
//    public SecurityUserDetails(SysUserDTO sysUserDTO, List<SysMenuDTO> sysMenuDTOList) {
//        this.sysUserDTO = sysUserDTO;
//        this.sysMenuDTOList = sysMenuDTOList;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return sysMenuDTOList.stream()
//                .map(resource ->new SimpleGrantedAuthority(resource.getId()+":"+resource.getName()+":"+resource.getParentId()+":"+resource.getUrl()))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public String getPassword() {
//        return sysUserDTO.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return sysUserDTO.getName();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return sysUserDTO.getStatus().equals(1);
//    }
//}
