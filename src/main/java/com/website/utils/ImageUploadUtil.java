package com.website.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.thoughtworks.xstream.core.util.Base64Encoder;

public class ImageUploadUtil {
     // 图片类型
    private static List<String> fileTypes = new ArrayList<String>();

    static {
        fileTypes.add(".jpg");
        fileTypes.add(".jpeg");
        fileTypes.add(".bmp");
        fileTypes.add(".gif");
        fileTypes.add(".png");
    }
    
    /**
     * 图片上传
     * 
     * @Title upload
     * @param request
     * @param DirectoryName
     *            文件上传目录：比如upload(无需带前面的/) upload/news ..
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public static String upload(HttpServletRequest request,HttpServletResponse response, String DirectoryName) throws IllegalStateException,
            IOException {
        PrintWriter out = null;
        response.setContentType("text/html");     
        response.setCharacterEncoding("UTF-8");  
        response.setContentType("multipart/form-data");
        
        // 创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession()
                .getServletContext());
        // 图片名称
        String fileName = null;
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                // 记录上传过程起始时的时间，用来计算上传时间
                // int pre = (int) System.currentTimeMillis();
                // 取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    try {
                        Base64Encoder encoder = new Base64Encoder();
                        String img = encoder.encode(file.getBytes());
                        Map responMap = new HashMap();
                        Map rsMap = qiniuUtil.upload(Base64.decode(img));
                        responMap.put("image_url", rsMap.get("image_url"));
                        fileName = (String) rsMap.get("image_url");
                        /*String json = JacksonUtil.convertData(responMap,"2");
                        fileName = json;*/
                        /*String json = JacksonUtil.convertData(responMap,"2");
                        response.setContentType("text/html;charset=UTF-8");
                        System.out.println(rsMap.get("image_url"));
                        out = response.getWriter();
                        out.println(json);
                        out.flush();
                        out.close();*/
                        
                        
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    
                    
                    
                    // 取得当前上传文件的文件名称
                   /* String myFileName = file.getOriginalFilename();
                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                        // 获得图片的原始名称
                        String originalFilename = file.getOriginalFilename();
                        // 获得图片后缀名称,如果后缀不为图片格式，则不上传
                        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
                        if (!fileTypes.contains(suffix)) {
                            continue;
                        }
                        // 获得上传路径的绝对路径地址(/upload)-->
                        String realPath = request.getSession().getServletContext().getRealPath("/" + DirectoryName);
                        System.out.println(realPath);
                        // 如果路径不存在，则创建该路径
                        File realPathDirectory = new File(realPath);
                        if (realPathDirectory == null || !realPathDirectory.exists()) {
                            realPathDirectory.mkdirs();
                        }
                        // 重命名上传后的文件名 111112323.jpg
                        fileName = DateUtil.format(new Date(), "yyyy-MM-dd") + suffix;
                        // 定义上传路径 .../upload/111112323.jpg
                        File uploadFile = new File(realPathDirectory + "\\" + fileName);
                        System.out.println(uploadFile);
                        file.transferTo(uploadFile);
                    }*/
                }
                // 记录上传该文件后的时间
                // int finaltime = (int) System.currentTimeMillis();
                // System.out.println(finaltime - pre);
            }
        }
        return fileName;
    }
    /**
     * ckeditor文件上传功能，回调，传回图片路径，实现预览效果。
     * 
     * @Title ckeditor
     * @param request
     * @param response
     * @param DirectoryName
     *            文件上传目录：比如upload(无需带前面的/) upload/..
     * @throws IOException
     */
    public static void ckeditor(HttpServletRequest request, HttpServletResponse response, String DirectoryName)
            throws IOException {
        String fileNamePath = upload(request,response, DirectoryName);
        String[] split = fileNamePath.split("/");
        String fileName = split[3];
        
        // 结合ckeditor功能
        // imageContextPath为图片在服务器地址，如upload/123.jpg,非绝对路径
        //String imageContextPath = request.getContextPath() + "/" + DirectoryName + "/" + fileName;
        
        response.setContentType("text/html;charset=UTF-8");
        String callback = request.getParameter("CKEditorFuncNum");
        PrintWriter out = response.getWriter();
        
        
        String json = "{ \"state\": \"SUCCESS\",\"url\": \""+fileName+"\"}";
        
        out.println(json);
        /*out.println("<script type=\"text/javascript\">");
        out.println("window.parent.CKEDITOR.tools.callFunction(" + 0 + ",'" + fileNamePath + "',''" + ")");
//        out.println("<img src='"+fileNamePath+"' />");
        out.println("</script>");*/
        out.flush();
        out.close();
    }

}
 