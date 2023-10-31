package com.oral.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PythonScriptRunner {

    public static String runPythonScript(String scriptPath, String... args) {
        try {
            // 构建Python脚本的执行命令
            ProcessBuilder processBuilder = new ProcessBuilder("python", scriptPath);
            processBuilder.command().addAll(Arrays.asList(args));

            // 启动进程并等待完成
            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            // 读取Python脚本的输出
            StringBuilder output = new StringBuilder();
            try (InputStream inputStream = process.getInputStream();
                 InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                 BufferedReader reader = new BufferedReader(inputStreamReader)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line);
                }
            }

            if (exitCode == 0) {
                return output.toString();
            }

            // python运行时间较长会报错
//            else {
//                System.out.println(exitCode);
//                throw new RuntimeException("Python脚本执行失败，错误输出：" + output.toString());
//            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("执行Python脚本时发生错误", e);
        }
        return "";
    }
}
