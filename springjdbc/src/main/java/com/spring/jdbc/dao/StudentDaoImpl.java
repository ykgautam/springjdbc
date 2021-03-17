package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate JdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return JdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		JdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student student) {
//		insert query
		String query = "insert into student(id,name,city) values(?,?,?)";
		int r = this.JdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return r;
	}

	@Override
	public int change(Student student) {
		String query = "update student set name=?, city=? where id=?";
		int res = this.JdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return res;
	}

	@Override
	public int delete(int studentId) {
		String query = "delete from student where id=?";
		int r = this.JdbcTemplate.update(query, studentId);
		return r;
	}

	@Override
	public Student getStudent(int studentId) {
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student queryForObject = this.JdbcTemplate.queryForObject(query, rowMapper, studentId);

		return queryForObject;
	}

	@Override
	public List<Student> getAllStudents() {
//		selecting multiple students
		String query = "select * from student";
		List<Student> students = JdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}

}
