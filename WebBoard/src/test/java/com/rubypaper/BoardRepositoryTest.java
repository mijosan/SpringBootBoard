package com.rubypaper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.board.domain.Board;
import com.rubypaper.board.domain.Member;
import com.rubypaper.board.domain.Role;
import com.rubypaper.board.persistence.BoardRepository;
import com.rubypaper.board.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	/*
	 * @Test public void testGetBoardList() { Member member =
	 * memberRepo.findById("member").get();
	 * 
	 * System.out.println("[ " + member.getName() + "�� ����� �Խñ� ]"); for (Board board
	 * : member.getBoardList()) { System.out.println("---> " + board.toString()); }
	 * }
	 */

	
	/*
	 * @Test public void testGetBoard() {
	 * 
	 * Board board = boardRepo.findById(1L).get();
	 * 
	 * System.out.println("[ " + board.getSeq() + "�� �Խ� �� �� ���� ]");
	 * System.out.println("����\t : " + board.getTitle());
	 * System.out.println("�ۼ���\t : " + board.getMember().getName());
	 * System.out.println("���� \t : " + board.getContent());
	 * System.out.println("�����\t : " + board.getCreateDate());
	 * System.out.println("��ȸ�� \t : " + board.getCnt()); }
	 */

	
	
	  @Test public void testInsert() {
		  
		  Member member1 = new Member();
		  member1.setId("member"); 
		  member1.setPassword(encoder.encode("member123"));
		  member1.setName("�Ѹ�"); 
		  member1.setRole(Role.ROLE_MEMBER);
		  member1.setEnabled(true); 
		  memberRepo.save(member1);
	  
		  Member member2 = new Member(); 
		  member2.setId("admin");
		  member2.setPassword(encoder.encode("admin123")); 
		  member2.setName("�����");
		  member2.setRole(Role.ROLE_ADMIN); 
		  member2.setEnabled(true);
		  memberRepo.save(member2);
	  
	  
		  for (int i = 1; i <= 13; i++) { 
			  Board board = new Board();
			  board.setMember(member1); 
			  board.setTitle(member1.getName() + "�� ����� �Խñ� " + i); 
			  board.setContent(member1.getName() + "�� ����� �Խñ� " + i);
			  boardRepo.save(board); 
		  }
	  
		  for (int i = 1; i <= 3; i++) { 
			  Board board = new Board();
			  board.setMember(member2); 
			  board.setTitle(member2.getName() + "�� ����� �Խñ� " + i); 
			  board.setContent(member2.getName() + "�� ����� �Խñ� " + i);
			  boardRepo.save(board); 
			  } 
		  }
	 
}
