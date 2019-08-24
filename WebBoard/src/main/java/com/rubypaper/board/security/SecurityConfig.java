package com.rubypaper.board.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{//WebSecurityConfigurerAdapter Ŭ������ ����� ��ü�� ������ ��ϵǱ⸸�ص� �α��ΰ��� X
	
	@Autowired
	private SecurityUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {//�� ��ť��Ƽ�� ���õ� �پ��� ������ �߰�
		security.userDetailsService(userDetailsService);
		
		security.authorizeRequests().antMatchers("/", "/system/**").permitAll(); //����㰡
		security.authorizeRequests().antMatchers("/board/**").authenticated(); //������ ����� �㰡
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN"); //Role�� ADMIN�� ����� �㰡
		
		security.csrf().disable();
		security.formLogin().loginPage("/system/login").defaultSuccessUrl("/board/getBoardList", true); //�α���ȭ�� ����
		security.exceptionHandling().accessDeniedPage("/system/accessDenied"); //���� ȭ���� �ٸ�������(system/accessDenied) �����ֱ�
		security.logout().logoutUrl("/System/logout").invalidateHttpSession(true).logoutSuccessUrl("/"); //��������
		
	}
}
