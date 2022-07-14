package com.vitamin.serviceimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitamin.dto.OoviResponse;
import com.vitamin.entity.Answer;
import com.vitamin.entity.NextQuestion;
import com.vitamin.entity.Question;
import com.vitamin.repository.AnswerRepository;
import com.vitamin.repository.NextQuestionRepository;
import com.vitamin.repository.QuestionRepository;
import com.vitamin.service.QuestionService;
import com.vitamin.util.Constant;
import com.vitamin.util.Message;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepository repository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private NextQuestionRepository nextQuestionRepository;

	@Override
	public OoviResponse addQuestions(Collection<Question> questions) {
		OoviResponse response = new OoviResponse();
		try {
			for(Question question : questions){
				Question savedQuestion = repository.save(question);
				Collection<Answer> answers = savedQuestion.getAnswers();
				for(Answer answer : answers){
					answer.setQuestion(savedQuestion);
				}
				answerRepository.save(answers);
				
				Collection<NextQuestion> nextQuestions = savedQuestion.getNextQuestion();
				
				for(NextQuestion nextQuestion : nextQuestions){
					nextQuestion.setQuestion(savedQuestion);
				}
				nextQuestionRepository.save(nextQuestions);
				savedQuestion.setNextQuestion(nextQuestions);
				repository.save(savedQuestion);
			}
			
			response.setStatusCode(Constant.SUCCESS_STATUS_CODE);
			response.setMessage(Message.QUESTION_ADDED);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatusCode(Constant.ERROR_STATUS_CODE);
			response.setMessage(Message.SOMETHING_WENT_WONG);
		}
		return response;
	}
	
	@Override
	public Collection<Question> fetchAllQuestions() {
		return repository.findAllByOrderByIdAsc();
	}

}
