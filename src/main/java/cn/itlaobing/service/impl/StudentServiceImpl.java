package cn.itlaobing.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.itlaobing.entity.Student;
import cn.itlaobing.mapper.StudentMapper;
import cn.itlaobing.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentMapper studentMapper;
	//全查
	@Transactional(readOnly=true)
	@Override
	public List<Student> selectAll() {
		return studentMapper.findAll();
	}
	
//-------------------------------------------------------------------------------------------
	//添加
	@Transactional
	@Override
	public Student save(Student student) {
		studentMapper.insert(student);
		return student;
	}
	
//-------------------------------------------------------------------------------------------
	//删除
	@Transactional
	@Override
	public void delete(Integer id) {
		studentMapper.deleteByPrimaryKey(id);
	}
	
//-------------------------------------------------------------------------------------------
	//根据id查找学生信息
	@Override
	public Student findById(Integer id) {
		return studentMapper.selectByPrimaryKey(id);
	}
	
//-------------------------------------------------------------------------------------------
	//修改
	@Transactional
	@Override
	public Student update(Student student) {
		studentMapper.updateByPrimaryKey(student);
		return student;
	}

}
