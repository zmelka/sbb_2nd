package com.mysite.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;


	@Test
	void testJpa(){
		List<Question> all = this.questionRepository.findAll();
		assertEquals(2,all.size());

		Question q = all.get(0);
		assertEquals("sbb가 무엇가요?", q.getSubject());
	}

	@Test
	void testCreateQuestions() {
		Question q1 = new Question();
		q1.setSubject("sbb가 무엇가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다.?");
		q1.setCreateDate(LocalDateTime.now());
		questionRepository.save(q1);

		Question q2 = new Question();
		q2.setSubject("스프링부터 모델 질문입니다.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		questionRepository.save(q2);
	}





	@Test
	void contextLoads() {
	}

}
