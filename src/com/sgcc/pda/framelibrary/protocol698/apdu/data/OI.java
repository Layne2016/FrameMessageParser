package com.sgcc.pda.framelibrary.protocol698.apdu.data;

import android.support.annotation.IntRange;
import com.sgcc.pda.framelibrary.utils.NumberConvert;

/**
 * Created by Tsinling on 2019/1/21 14:52
 * Description:
 */
public class OI extends Data {
    @Override
    public int dataType() {
        return 80;
    }

    private int OIA1;
    private int OIA2;
    private int OIB1;
    private int OIB2;

    private String OIStr;

    public OI(@IntRange(from = 0, to = 15) int OIA1, @IntRange(from = 0, to = 15) int OIA2,
              @IntRange(from = 0, to = 15) int OIB1, @IntRange(from = 0, to = 15) int OIB2) {
        this.OIA1 = OIA1;
        this.OIA2 = OIA2;
        this.OIB1 = OIB1;
        this.OIB2 = OIB2;
        OIStr = NumberConvert.toHexStr(OIA1, 1)
                + NumberConvert.toHexStr(OIA2, 1)
                + NumberConvert.toHexStr(OIB1, 1)
                + NumberConvert.toHexStr(OIB2, 1);
    }

    /**
     * 对象标识符  2 字节 16进制字符串
     *
     * @param oiHexStr
     */
    public OI(String oiHexStr) {
        this.OIStr = oiHexStr;
        if (oiHexStr.length() != 4 || !NumberConvert.isHexStr(oiHexStr)) {
            throw new IllegalArgumentException("参数异常,需要2字节 16进制字符串");
        }
       byte[] ois = NumberConvert.hexStringToBytes(oiHexStr);
        this.OIA1 = (ois[0] & 0xF0) >> 4;
        this.OIA2 = ois[0] & 0x0f;
        this.OIB1 = (ois[1] & 0xF0) >> 4;
        this.OIB2 = ois[1] & 0x0f;
    }

    @Override
    public String toHexString() {
        return OIStr;
    }

    @Override
    public String format() {
        return "";
    }

    public int getOIA1() {
        return OIA1;
    }

    public int getOIA2() {
        return OIA2;
    }

    public int getOIB1() {
        return OIB1;
    }

    public int getOIB2() {
        return OIB2;
    }

}
