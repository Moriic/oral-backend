package com.oral.controller.doctor;

import cn.hutool.core.io.FileUtil;
import com.oral.common.BaseResponse;
import com.oral.common.ResultUtils;
import com.oral.constant.FileConstant;
import com.oral.model.vo.NiiVO;
import com.oral.utils.PythonScriptRunner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/upload")
public class UploadController {


    // TODO 完善一下捏
    @PostMapping("/nii")
    public BaseResponse<NiiVO> uploadNii(MultipartFile file) throws IOException {
        NiiVO niiVO = new NiiVO();
        String id = UUID.randomUUID().toString();
        niiVO.setId(id);
        log.info("上传文件：{}", file.getOriginalFilename());

        String niiFile = FileConstant.INPUT_FILE + id + "/" + file.getOriginalFilename();
        String outputFile = FileConstant.OUTPUT_FILE + id;
        FileUtil.mkParentDirs(niiFile);
        file.transferTo(FileUtil.file(niiFile));

        // 获取python脚本路径
        String scriptPath = FileConstant.PYTHON_FILE;

        // 获取切片数
        String result = PythonScriptRunner.runPythonScript(scriptPath, "get_nii_data", niiFile);
        String[] slices = result.split(",");
        niiVO.setX(Integer.valueOf(slices[0]));
        niiVO.setY(Integer.valueOf(slices[1]));
        niiVO.setZ(Integer.valueOf(slices[2]));

        // 生成切片
        new Thread(() -> {
            PythonScriptRunner.runPythonScript(scriptPath, "get_x_slice", niiFile, outputFile);
        }).start();
        new Thread(() -> {
            PythonScriptRunner.runPythonScript(scriptPath, "get_y_slice", niiFile, outputFile);
        }).start();
        new Thread(() -> {
            PythonScriptRunner.runPythonScript(scriptPath, "get_z_slice", niiFile, outputFile);
        }).start();

        return ResultUtils.success(niiVO);
    }

    /**
     * 图片上传
     *
     * @param image
     * @return
     * @throws IOException
     */
    @PostMapping("/image")
    public BaseResponse<String> uploadImage(MultipartFile image) throws IOException {
        log.info("文件上传：{}", image);

        //获取原始文件名
        String originalFilename = image.getOriginalFilename();

        //构建新的文件名
        String extname = originalFilename.substring(originalFilename.lastIndexOf("."));//文件扩展名
        String newFileName = UUID.randomUUID() + extname;//随机名+文件扩展名

        //将文件存储在服务器的磁盘目录
        image.transferTo(new File(FileConstant.IMAGE_FILE + newFileName));

        return ResultUtils.success(FileConstant.IMAGE_FILE + newFileName);
    }
}
