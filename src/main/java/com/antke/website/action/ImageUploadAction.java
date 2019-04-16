package com.antke.website.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.antke.website.utils.ImageUploadUtil;
@Controller
@RequestMapping("/imageUpload")
public class ImageUploadAction {

     @RequestMapping("/upload.do")
     public void imageUpload(HttpServletRequest request, HttpServletResponse response){
         String DirectoryName = "upload/";
            try {
                ImageUploadUtil.ckeditor(request, response, DirectoryName);
            } catch (Exception e) {
                e.printStackTrace();
            }
     }
}