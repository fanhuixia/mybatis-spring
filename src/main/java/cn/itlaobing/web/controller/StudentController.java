package cn.itlaobing.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itlaobing.entity.Student;
import cn.itlaobing.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;
	//通用的方法
	@ModelAttribute
	public void paramed(@PathVariable(required=false) Integer id,Model model) {
		if(id==null) {
			model.addAttribute("student", new Student());
		}else {
			model.addAttribute("student", studentService.findById(id));
		}
	}
//-------------------------------------------------------------------------------------------
	// 全查
	@GetMapping()
	public String index(Model model) {
		List<Student> list = studentService.selectAll();
		model.addAttribute("student", list);
		return "student/index";
	}

//-------------------------------------------------------------------------------------------
	// 获取表单页面
	 @GetMapping("/save")
	public String save(Model model) {
		model.addAttribute("student", new Student());
		return "student/save";
	}

	// 添加学生信息
	 @PostMapping("/save")
	public String save(@ModelAttribute("student") @Valid Student student,
            BindingResult bindingResult) {
		 if(bindingResult.hasErrors()) {
				return "student/save";
			}
		studentService.save(student);
		return "redirect:/students";
	}

//-------------------------------------------------------------------------------------------
	//删除数据
	 @GetMapping("/{id}/delete")
	 public String delete(@PathVariable Integer id) {
		 studentService.delete(id);
		 return "redirect:/students";
	 }
	 
//-------------------------------------------------------------------------------------------
	 //修改数据
	 //1先得到页面
	 @GetMapping("/{id}/update")
	 public String update() {
		 return "student/update";
	 }
	 //2修改开始
	 @PostMapping("/{id}/update")
	 public String update(@ModelAttribute("student") @Validated Student student,BindingResult bindingResult) {
		 studentService.update(student);
		 return "redirect:/students";
	 }
}
