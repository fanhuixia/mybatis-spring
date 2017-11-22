package cn.itlaobing.service;

import java.util.List;

import cn.itlaobing.entity.Student;

public interface StudentService {
	//全查
	public List<Student> selectAll();
	//添加数据
	public Student save(Student student);
	//根据id删除数据
	public void delete(Integer id);
	//根据id查找学生的信息
	public Student findById(Integer id);
	//根据id修改数据
	public Student update(Student student);
}
