package cn.itlaobing.setudentTest;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import cn.itlaobing.entity.Student;
import cn.itlaobing.service.StudentService;
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentTest {
	@Autowired
	private StudentService studentService;
 	@Test
	public void findAll() {
 		List<Student> list=studentService.selectAll();
 		Assert.assertNotNull(list);
	}
 	@Test
 	public void saveTest() {
 		Student student=new Student();
 		student.setName("lili");
 		student.setGender("女");
 		student.setBirthday(new Date());
 		Student stu=studentService.save(student);
 		Assert.assertNotNull(stu);
 		Assert.assertNotNull(stu.getId());
 	}	
 				
 }
