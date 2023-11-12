package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Department;
import generator.service.DepartmentService;
import generator.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【department(科室)】的数据库操作Service实现
* @createDate 2023-11-12 14:15:31
*/
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department>
    implements DepartmentService{

}




