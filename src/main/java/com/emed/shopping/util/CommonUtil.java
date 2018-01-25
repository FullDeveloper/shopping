package com.emed.shopping.util;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: 周润斌
 * @Date: create in 上午 17:38 2018/1/16 0016
 * @Description:
 */
public class CommonUtil {

    public static String nullToString(Object s) {
        return s == null ? "" : s.toString().trim();
    }


    public static boolean collectionIsNotEmpty(List list){

        return list != null && list.size()>0;
    }

    public static Long nullToLong(Object s){
        if(isEmpty(s)){
            return null;
        }
        return Long.parseLong(s.toString());
    }

    public static float nullToFloat(Object s) {
        float v = 0.0F;
        if (s != null)
            try {
                v = Float.parseFloat(s.toString());
            } catch (Exception localException) {
                localException.printStackTrace();
            }
        return v;
    }

    public static Integer nullToInt(Object s) {
        Integer v = 0;
        if (s != null)
            try {
                v = Integer.parseInt(s.toString());
            } catch (Exception localException) {
                localException.printStackTrace();
            }
        return v;
    }

    public static boolean isEmpty(Object obj) {
        return obj == null || "".equals(obj);
    }

    public static Map saveFileToServer(HttpServletRequest request, String filePath, String saveFilePathName,
                                       String saveFileName, String[] extendes) throws IOException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile(filePath);
        Map map = new HashMap();
        if (file != null && !file.isEmpty()) {
            //获取文件后缀名
            String extend = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            //如果文件名为空
            if (isEmpty(saveFileName)) {
                saveFileName = UUID.randomUUID().toString() + "." + extend;
            }
            //如果文件没有后缀名
            if (saveFileName.lastIndexOf(".") < 0) {
                saveFileName = saveFileName + "." + extend;
            }
            float fileSize = Float.valueOf((float) file.getSize()).floatValue();
            List errors = new ArrayList();
            boolean flag = false;
            if (extendes != null) {
                for (String s : extendes) {
                    if (extend.toLowerCase().equals(s))
                        flag = true;
                }
            }
            if (!flag) {
                File path = new File(saveFilePathName);
                if (!path.exists()) {
                    path.mkdir();
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                DataOutputStream out = new DataOutputStream(
                        new FileOutputStream(saveFilePathName + File.separator + saveFileName));
                InputStream is = null;
                try {
                    is = file.getInputStream();
                    int size = (int) fileSize;
                    byte[] buffer = new byte[size];
                    while (is.read(buffer) > 0) {
                        out.write(buffer);
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                } finally {
                    if (is != null) {
                        is.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                }
                if (isImg(extend)) {
                    File img = new File(saveFilePathName + File.separator + saveFileName);
                    try {
                        BufferedImage bis = ImageIO.read(img);
                        int w = bis.getWidth();
                        int h = bis.getHeight();
                        map.put("width", Integer.valueOf(w));
                        map.put("height", Integer.valueOf(h));
                    } catch (Exception localException) {
                        localException.printStackTrace();
                    }
                }
                map.put("mime", extend);
                map.put("fileName", saveFileName);
                map.put("fileSize", Float.valueOf(fileSize));
                map.put("error", errors);
                map.put("oldName", file.getOriginalFilename());
            } else {
                errors.add("不允许的扩展名");
            }
        } else {
            map.put("width", Integer.valueOf(0));
            map.put("height", Integer.valueOf(0));
            map.put("mime", "");
            map.put("fileName", "");
            map.put("fileSize", Float.valueOf(0.0F));
            map.put("oldName", "");
        }
        return map;
    }

    public static boolean isImg(String extend) {
        boolean ret = false;
        List<String> list = new ArrayList<String>();
        list.add("jpg");
        list.add("jpeg");
        list.add("bmp");
        list.add("gif");
        list.add("png");
        list.add("tif");
        for (String s : list) {
            if (s.equals(extend))
                ret = true;
        }
        return ret;
    }

}
