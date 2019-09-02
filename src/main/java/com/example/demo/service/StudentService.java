package com.example.demo.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.repository.StudentRepository;
import com.example.demo.vo.Student;

@Service
public class StudentService implements StudentRepository{

	
	private static final String TABLE_NAME ="Student";
	
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;//오브젝트 serialization과 connection management를 수행
	
	/* REDIS 서버에 데이터를 CURD위해 5가지 데이터 유형에 대한 오퍼레이션 인터페이스 제공 
	 * ValueOperations - String (512MB를 넘지 못함)
	 * ListOperations - list
	 * SetOperations - set
	 * ZSetOperaions - sorted set
	 * HashOperaions - hash
	 * */
	private HashOperations<String,Long,Student> hashOperations;

	@PostConstruct
	private void intializeHashOperations() {
		hashOperations = redisTemplate.opsForHash();// hash operations를 사용하겠다.
	}

	@Override
	public void save(Student student) {
		hashOperations.put(TABLE_NAME,student.getId(),student);
	}

	@Override
	public Student find(Long id) {
		return hashOperations.get(TABLE_NAME, id);
	}
	

}
