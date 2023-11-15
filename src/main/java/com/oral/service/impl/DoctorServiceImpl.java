package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Doctor;
import generator.service.DoctorService;
import generator.mapper.DoctorMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【doctor(医生)】的数据库操作Service实现
* @createDate 2023-11-12 14:15:31
*/
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor>
    implements DoctorService{

}




