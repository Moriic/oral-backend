package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Sickbed;
import generator.service.SickbedService;
import generator.mapper.SickbedMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【sickbed(床位)】的数据库操作Service实现
* @createDate 2023-11-12 14:15:31
*/
@Service
public class SickbedServiceImpl extends ServiceImpl<SickbedMapper, Sickbed>
    implements SickbedService{

}




