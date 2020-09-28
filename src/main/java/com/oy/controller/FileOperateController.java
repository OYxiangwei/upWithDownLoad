package com.oy.controller;

import com.oy.entity.FileInfo;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("file")
public class FileOperateController {
    @GetMapping("uploadForm")
    public String uploadForm(){
        return "upload";
    }
    @PostMapping(value = "/upload")
    public String upload(HttpServletRequest request , @ModelAttribute FileInfo fileInfo ,Model model) throws IOException {
        // 上传路径
        String path = request.getServletContext().getRealPath("/resources/");
        System.out.println("request.getServletContext():--"+request.getServletContext());
        File filePath=new File(path,fileInfo.getFile().getOriginalFilename());
        if(!filePath.getParentFile().exists()){
            filePath.getParentFile().mkdirs();
        }
        // 上传文件会自动绑定到 MultipartFile 中
        // 如果文件为空，跳转至失败页面
        if (fileInfo.getFile().isEmpty()){
            return "failure";
        }else {
            List<MultipartFile> files = new ArrayList<>();
            files.add(fileInfo.getFile());
            for (MultipartFile fileUp:files){
                // 上传文件名
                String fileName = fileUp.getOriginalFilename();
                // 打印文件上传后的完整路径
                System.out.println("完整路径："+path+File.separator+fileName);
                // 将文件保存到一个目标文件中
                fileUp.transferTo(new File(path+File.separator+fileName));
            }
            model.addAttribute("fileinfo",fileInfo);
            return "download";
        }

    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,@RequestParam("filename") String filename ) throws IOException {
        String path = request.getServletContext().getRealPath("/resources/");
        File file = new File(path+File.separator+filename);
        HttpHeaders httpHeaders = new HttpHeaders();
        String downloadFile = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        httpHeaders.setContentDispositionFormData("attachment",downloadFile);
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),httpHeaders, HttpStatus.CREATED);
    }
}
