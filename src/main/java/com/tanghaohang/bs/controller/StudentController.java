package com.tanghaohang.bs.controller;


import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tanghaohang.bs.entity.Student;
import com.tanghaohang.bs.mapper.StudentMapper;
import com.tanghaohang.bs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


//相当于@Controller+@ResponseBody两个注解的结合，返回json数据不需要在方法前面加@ResponseBody注解了，
// 但使用@RestController这个注解，就不能返回jsp,html页面，视图解析器无法解析jsp,html页面
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentService studentService;

    //查询所有
    @GetMapping("/")
    public List<Student> findAll(){

        return studentService.list();
        //List<Student> all = studentMapper.findAll();
        //return all;
    }

    @PostMapping
    public boolean save(@RequestBody Student student) {
        // 新增或者更新
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id){

        return studentService.removeById(id);
        //return studentMapper.deleteById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<String> ids) { // [1,2,3]
        return studentService.removeByIds(ids);
    }

    @GetMapping("/trans")
    public void transaction() throws Exception {
         studentService.trans();
    }

    // 分页查询
    //  接口路径：/user/page?pageNum=1&pageSize=10
    // @RequestParam接受
    // limit第一个参数 = (pageNum - 1) * pageSize
    // pageSize
/*    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam String name) {
        pageNum = (pageNum - 1) * pageSize;
        name = "%" + name + "%";
        List<Student> data = studentMapper.selectPage(pageNum, pageSize, name);
        Integer total = studentMapper.selectTotal(name);
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }*/
    //mybatis方式分页查询
    @GetMapping("/page")
    public IPage<Student> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize,
                                   @RequestParam(defaultValue = "") String id,
                                   @RequestParam(defaultValue = "") String sex,
                                   @RequestParam(defaultValue = "") String major) {
        IPage<Student> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        if (!"".equals(id)) {
            queryWrapper.like("id", id);
        }
        if (!"".equals(sex)) {
            queryWrapper.like("sex", sex);
        }
        if (!"".equals(major)) {
            queryWrapper.like("major", major);
        }
        return studentService.page(page, queryWrapper);
    }


    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Student> list = studentService.list();
        // 通过工具类创建writer 写出到磁盘路径
       ExcelWriter writer = ExcelUtil.getWriter("e:/用户信息.xlsx");
        // 在内存操作，写出到浏览器
//        writer = ExcelUtil.getWriter(true);
        //自定义标题别名
        writer.addHeaderAlias("id", "学号");
        writer.addHeaderAlias("name", "姓名");
        writer.addHeaderAlias("sex", "性别");
        writer.addHeaderAlias("year", "年龄");
        writer.addHeaderAlias("major", "专业");
        writer.addHeaderAlias("cls", "班级");
        writer.addHeaderAlias("tel", "电话");

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        //String fileName = URLEncoder.encode("用户信息", "UTF-8");
        //response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }

    @GetMapping("/duobiao")
    public List<Student> duobiao(@RequestParam String id){
        return  studentService.duobiao(id);
    }

}
