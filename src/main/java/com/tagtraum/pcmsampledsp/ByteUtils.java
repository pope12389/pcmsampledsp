package org.pope.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteUtils {

    public static byte[] float2ByteArray(float val) {
        return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(val).array();
    }


    /** 
     * 将长度为4 的byte[]转成float
     * @param data
     * @return float
     */ 
    public static float byteArray2Float(byte[] data) {
        return ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getFloat();
    }
    
    /**
     * short 转换为byte[]数组
     * @param s
     * @return
     */
    public static byte[] short2ByteArray(short s) {
//        int temp = number;
//        byte[] b = new byte[2]; // 将最低位保存在最低位
//        b[0] = (byte)(temp & 0xff);
//        temp = temp >> 8; // 向右移8位
//        b[1] = (byte)(temp & 0xff);
//        return b;
       return ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putShort(s).array();
    }

    /**
     * byte[]转换为short
     * @param b
     * @return short
     */
    public static short byteArray2Short(byte[] b) {
//        short s = 0;
//        short s0 = (short) (b[0] & 0xff);// 最低位
//        short s1 = (short) (b[1] & 0xff);
//        s1 <<= 8;
//        s = (short) (s0 | s1);
//        return s;
        return ByteBuffer.wrap(b).order(ByteOrder.LITTLE_ENDIAN).getShort();
    }
    
    /**
     * float转换为short
     * @param f
     * @return
     */
    public static short float2Short(float f) {
        short s = 0;
        float max = Math.max(-1, Math.min(1, f));
        if(max < 0){
            s = (short) (max * 32768);
        }else{
            s = (short) (max * 32767);
        }
        
//        if(f >1.0f  ){
//            f = 1.0f;
//        }
//        if(f < -1.0f){
//            f = -1.0f;
//        }
//        s = (short) (f * Short.MAX_VALUE);
        return s;
    }
    /**
     * short 转换为 float
     * @param s
     * @return
     */
    public static float short2Float(short s){
        float f = 0f;
        if(s < 0){
            f =  s / 32768f;
        }else{
            f =  s / 32767f;
        }
//        f = s / 32768f;
        return f;
    }
/**
 * 将3个字节，24位转换为整数
 * @param in
 * @return
 */
    public static int byte24b2Int(byte [] in){
        byte [] temp = new byte[4];
        if(in.length < 4){
            System.arraycopy(in, 0, temp, 0, in.length);
        }else{
            temp = in;
        }
        return ByteBuffer.wrap(temp).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }
    
    /**
     * 将整数转换为24位，3个字节数组
     * @param i
     * @return
     */
    public static byte[] int2Byte24b(int i){
        byte[] array = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i).array();
        byte [] r = new byte[3];
        System.arraycopy(array, 0, r, 0, r.length);
       return r;
    }
    
    /**
     * 将24位整数转换为float
     * @param in
     * @return
     */
    public static float int24b2Float(int in)
    {
        float f = 0f;
        if(in > 8388607){
            f =  (16777216 - in) / -8388608f;
        }else{
            f =  in / 8388607f;
        }
//        f = in /16777216f;
        
        return f;
    }
    /**
     * 将float转换为24位整数
     * @param f
     * @return
     */
    public static int float2Int24b(float f)
    {
        int i = 0;
        float max = Math.max(-1, Math.min(1, f));
        if(max < 0){
            i = (int) (16777216 + max * 8388608);
        }else{
            i = (int) (max * 8388607);
        }
//        i = (int) (max * 16777216);
        return i;
    }
    
    
    public static byte[] intToBytea(int val){
        byte[] b = new byte[4];
        b[0] = (byte)(val & 0xff);
        b[1] = (byte)((val >> 8) & 0xff);
        b[2] = (byte)((val >> 16) & 0xff);
        b[3] = (byte)((val >> 24) & 0xff);
        return b;
        }
    
    public static void main(String[] args) {
        float f = -0.5356f;
//        System.out.println(Float.MAX_VALUE * f);
//        byte[] float2ByteArray = Float2ByteArray(f);
//        for (byte b : float2ByteArray) {
//            System.out.print(b+",");
//        }
//        float f1 = ByteArray2Float(float2ByteArray);
//        System.out.println(""+f1);
//        short s = 3;
//        byte[] shortToByte = shortToByte(s);
//        for (byte b : shortToByte) {
//            System.out.print(b+",");
//        }
//        System.out.println();
//       short byteToShort = byteToShort(shortToByte);
//       System.out.println(byteToShort);
       
       
//       short floatToShort = floatToShort(f);
//       System.out.println(floatToShort);
//       
//       float shortToFloat = shortToFloat(floatToShort);
//       System.out.println(shortToFloat);
//       
       int it = 16777216;//13816063
       int i24Max = 8388607;//0x7fffff;//
       int i24Min = -8388608;//-0x800000
//       System.out.println(Integer.toHexString(i24n));
//       byte[] intToByte = intToByte(it);
//       for (byte b : intToByte) {
//        System.out.println(b+",");
//    }
//       int byteToInt = byteToInt(intToByte);
//       System.out.println(byteToInt);
//        int convertFloatTo24Bit = ConvertFloatTo24Bit(f);
//        float convert24BitToFloat = Convert24BitToFloat(convertFloatTo24Bit);
//        System.out.println(convert24BitToFloat);
//        byte[] float2ByteArray = Float2ByteArray(convert24BitToFloat);
//        byte[] intToByte = intToByte(i24Min);
//        int byteToInt = byteToInt(intToByte);
//        System.out.println(byteToInt);
//        
//        byte[] intToBytea = intToBytea(i24Min);
//        for (byte b : intToBytea) {
//            System.out.print(b+",");
//        }
//        for (byte b : float2ByteArray) {
//            System.out.print(b+",");
//        }
        
        byte [] b24 = {46, 1, 8, 1, 56, 1, -74, 1, 91, 2, -28, 1, -95, 1, -114};
        byte [] h = {
                82, 73, 70, 70,  //riff 
                -60, 31, 4, 0, 
                87, 65, 86, 69,
                102, 109, 116, 32,
                16, 0, 0, 0, 
                1, 0, 
                1, 0,
                -128, 62, 0, 0, 
                -128, -69, 0, 0,
                3, 0, 
                24, 0, 
                100, 97, 116, 97,
                -96, 31, 4, 0, 
                };
        //82, 73, 70, 70, 72, 0, 0, 0, 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, 1, 0, -128, 62, 0, 0, -128, -69, 0, 0, 3, 0, 24, 0, 100, 97, 116, 97, 36, 0, 0, 0, 1, 57, 47, -3, 74, 38, 4, -43, 42, -3, 92, 50, 1, -67, 26, 1, 63, 19, -2, -18, 20, 2, -15, 21, -1, -18, 40, -1, 98, 56,
        
//        byte [] b36 = {1, 57, 47, -3, 74, 38, 4, -43, 42, -3, 92, 50, 1, -67, 26, 1, 63, 19, -2, -18, 20, 2, -15, 21, -1, -18, 40, -1, 98, 56, 2, -83, 55, -2, -73, 55};
        byte [] b36 = {-2, 58, 54, 1, -128, -5, -1, -48, -46, 1, -59, -41, 0, 88, 12, -1, -26, 86, 2, 75, 125, -2, 96, 122, 0, -24, 68, 1, 19, -27, -1, -30, -104, 2, 1, -128, -2, -3, -121, 1, 28, -79, -1, -100, -26, 1, 67, 0, 0, 71, -8, -1, 49, -39, 2, -96, -67, -2, -41, -66, 1, -12, -27};
//        System.err.println(h.length);
        byte [] t = new byte[3];
//        int pos = 0;
        for(int i = 0;i<b36.length/3;i++){
            t[0] = b36[i*3];
            t[1] = b36[i*3+1];
            t[2] = b36[i*3+2];
            int byteToInt2 = byte24b2Int(t);
//            short byteToShort = byteToShort(t);
//            float shortToFloat = shortToFloat(byteToShort);
//            System.out.println(shortToFloat);
            System.out.println("=="+byteToInt2);
            float convert24BitToFloat = int24b2Float(byteToInt2);
            System.out.println(convert24BitToFloat);
            int convertFloatTo24Bit = float2Int24b(convert24BitToFloat);
            
            System.out.println(convertFloatTo24Bit);
            
            byte[] intToByte = int2Byte24b(convertFloatTo24Bit);
            for (byte b : intToByte) {
                System.out.print(b+",");
            }
            System.out.println();
        }
        System.out.println((16777216-16482305)/8388607f);
//        byte []sr   = {-60, 31, 4, 0};
//       int byteToInt = byteToInt(sr);
//       System.out.println(byteToInt);
    }
}
