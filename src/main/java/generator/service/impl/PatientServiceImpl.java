package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Patient;
import generator.service.PatientService;
import generator.mapper.PatientMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【patient(患者)】的数据库操作Service实现
* @createDate 2023-11-12 14:15:31
*/
@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient>
    implements PatientService{

}




