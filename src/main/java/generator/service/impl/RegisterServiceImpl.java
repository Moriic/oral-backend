package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Register;
import generator.service.RegisterService;
import generator.mapper.RegisterMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【register(挂号)】的数据库操作Service实现
* @createDate 2023-11-12 14:15:31
*/
@Service
public class RegisterServiceImpl extends ServiceImpl<RegisterMapper, Register>
    implements RegisterService{

}




