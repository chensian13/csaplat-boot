package csa.stu.util.myutils.utils;

import java.net.URI;

public abstract class ImageUtil {
    public static final String patternString = "[http|https]+[://]+[0-9A-Za-z:/[-]_#[?][=][.][&]]*";


    /**
     * 图片路径验证
     * @param imgPath
     * @return
     */
    public static boolean isImgPath(String imgPath){
        if(imgPath.endsWith(".jpg")
                || imgPath.endsWith(".JPG")
                || imgPath.endsWith(".png")
                || imgPath.endsWith(".PNG")
                || imgPath.endsWith(".gif")
                || imgPath.endsWith(".GIF")
                || imgPath.endsWith(".jpeg")
                || imgPath.endsWith(".JPEG")){
            return true;
        }
        return false;
    }

    public static boolean isImgURL(String imgPath){
        if(isImgPath(imgPath)){
            try{
                URI uri=URI.create(imgPath);
                return true;
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }

}
