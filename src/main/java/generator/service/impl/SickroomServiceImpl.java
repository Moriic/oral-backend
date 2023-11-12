package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Sickroom;
import generator.service.SickroomService;
import generator.mapper.SickroomMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【sickroom(病房)】的数据库操作Service实现
* @createDate 2023-11-12 14:15:31
*/
@Service
public class SickroomServiceImpl extends ServiceImpl<SickroomMapper, Sickroom>
    implements SickroomService{

}




