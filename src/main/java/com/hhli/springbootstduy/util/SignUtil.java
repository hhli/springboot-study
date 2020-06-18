package com.hhli.springbootstduy.util;

import com.hhli.springbootstduy.exception.CustomerException;
import com.hhli.springbootstduy.model.enums.CodeEnum;
import com.hhli.springbootstduy.model.enums.ParamEnum;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author 李辉辉
 * @date 2020-06-17 17:27
 * @description
 */
public class SignUtil {

    private SignUtil() {

    }


    /**
     * 根据请求参数，生成签名
     * @param data
     * @param secret
     * @return
     * @author zhangdeman001@ke.com
     */
    public static String genRequestInSign(Map<String, String> data, String secret) throws
            CustomerException {
        if (null == data || 0 == data.size()) {
            throw new CustomerException(CodeEnum.SIGN_ERROR, "请求参数为空，无法生成加密串");
        }


        Map<String, String> sortData = sortMapByKey(data);

        if (null == sortData || sortData.isEmpty()) {
            throw new CustomerException(CodeEnum.SIGN_ERROR, "请求参数为空，无法生成加密串");
        }

        StringBuilder signStr = new StringBuilder();

        for (String key : sortData.keySet()) {
            if (key.equals(ParamEnum.SIGN.getParamName())) {
                //签名字段不参与签名生成
                continue;
            }
            String urlEncodeStr;
            try {
                urlEncodeStr = URLEncoder.encode(sortData.get(key), "utf-8");
            } catch (Exception e) {
                throw new CustomerException(CodeEnum.SIGN_ERROR, key + "对应的只 urlencode 失败");
            }
            if (signStr.length() > 0) {
                signStr.append("&");
            }
            signStr.append(key).append("=").append(urlEncodeStr);
        }

        signStr.append(secret);
        return StringUtil.getMd5String(signStr.toString(), "");
    }

    /**
     * 使用 Map按key进行排序
     * @param map
     * @return
     */
    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return new HashMap<>(0);
        }

        Map<String, String> sortMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        sortMap.putAll(map);

        return sortMap;
    }

    /**
     * 获取大数据服务的签名
     * @param params
     * @param secretKey
     * @return
     * @author zhangdeman001@ke.com
     */
    public static String getBigDataSign(Map<String, String> params, String secretKey) throws
            UnsupportedEncodingException, NoSuchAlgorithmException {
        return getSign(getSign(getSignStr(params, "").toLowerCase()).toLowerCase() + secretKey).toLowerCase();
    }

    /**
     * 拼接组装准备加密的字符串
     * @param params 请求参数map
     * @param secretKey 分配的加密私钥
     * @return 生成的拼接好的准备加密字符串
     */
    public static String getSignStr(Map<String, String> params, String secretKey)
            throws UnsupportedEncodingException {
        if (params.isEmpty()) {
            return "";
        }
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            String value = String.valueOf(params.get(key));
            if (null != key && null != value) {
                sb.append(key).append("=").append(URLEncoder.encode(value, "UTF-8")).append("&");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        if (!StringUtils.isEmpty(secretKey)) {
            sb.append(secretKey);
        }
        return sb.toString();
    }

    /**
     * 获取签名
     * @param data 加密的字符串
     * @return 加密结果
     * @throws NoSuchAlgorithmException
     * @author zhangdeman001@ke.com
     */
    public static String getSign(String data)
            throws NoSuchAlgorithmException {
        if (StringUtils.isBlank(data)) {
            return "";
        }

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return byte2hex(md5.digest(data.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     *
     * @param bytes 字节数组
     * @return md5加密结果
     * @author zhangdeman001@ke.com
     */
    public static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }
}