package com.xcz.printer.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class GetFileType {

    private static Map<String, String> mFileTypes = new HashMap<>();

    /** 无参构造函数 **/
    private GetFileType(){}

    //各种类型文件的文件头的16进制字符串
    static {
        mFileTypes.put("FFD8FF",".jpg"); //JPEG
        mFileTypes.put("FFD8FFE0", ".jpg");
        mFileTypes.put("FFD8FFE1", ".jpg");
        mFileTypes.put("89504E47", ".png");
        mFileTypes.put("47494638", ".gif");
        mFileTypes.put("49492A00", ".tif");
        mFileTypes.put("3C3F786D6C",".xml");
    }

    public static String getFileRealType(File file) throws Exception{
        InputStream is = new FileInputStream(file);
        return getFileType(is);
    }

    //获取文件字节流中的文件头
    public static String getFileType(InputStream is){
        byte [] b = new byte[4];
        if (is!=null){
            try{
                int len=is.read(b,0,b.length);
                if (len>0){
                    return mFileTypes.get(bytesToHexString(b));
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return mFileTypes.get(bytesToHexString(b));
    }

    /**
     * 将文件的byte数组转换成string类型表示
     * 将字节数组的前四位转换成16进制字符串，并且转换的时候，要先和0xFF做一次与运算。
     * 在整个文件流的字节数组中，有很多是负数，进行了与运算后，可以将前面的符号位都去掉，
     * 这样转换成的16进制字符串最多保留两位，如果是正数又小于10，那么转换后只有一位，
     * 需要在前面补0，这样做的目的是方便比较，取完前四位这个循环就可以终止了
     *
     * @param bytes 要读取文件头信息的文件的byte数组
     * @return 文件头信息
     */
    private static String bytesToHexString(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        String hv;
        for (int i = 0; i < bytes.length; i++) {
            // 以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式，并转换为大写
            hv = Integer.toHexString(bytes[i] & 0xFF).toUpperCase();
            if (hv.length() < 2) {
                builder.append(0);
            }
            builder.append(hv);
        }
        return builder.toString();
    }

//    public static void main(String[] args) throws Exception{
//        //该文件的真实类型是.png，改成.jpg来验证是否能获取到真正的文件类型
//        File file = new File("D:/11.jpg");
//        System.out.println(getFileRealType(file));
//    }
}
