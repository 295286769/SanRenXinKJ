package com.srx.huangweishui.common.utils;

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private StringUtils() {
        throw new AssertionError();
    }

    /**
     * is null or its length is 0 or it is made by space
     *
     * @param str
     * @return if string is null or its size is 0 or it is made by space, return
     * true, else return false.
     */
    public static boolean isBlank(String str) {
        return (str == null || str.trim().length() == 0);
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * is null or its length is 0
     *
     * @param str
     * @return if string is null or its size is 0, return true, else return
     * false.
     */
    public static boolean isEmpty(CharSequence str) {
        return (str == null || str.length() == 0);
    }


    /**
     * get length of CharSequence
     *
     * @param str
     * @return if str is null or empty, return 0, else return
     * {@link CharSequence#length()}.
     */
    public static int length(CharSequence str) {
        return str == null ? 0 : str.length();
    }

    /**
     * null Object to empty string
     *
     * @param obj
     * @return
     */
    public static String nullToEmpty(Object obj) {
        return nullToDefault(obj, "");
    }

    /**
     * @param obj
     * @param defaultStr
     * @return
     */
    public static String nullToDefault(Object obj, String defaultStr) {
        return (obj == null ? defaultStr : (obj instanceof String ? (String) obj : obj.toString()));
    }

    /**
     * capitalize first letter
     *
     * @param str
     * @return
     */
    public static String capitalizeFirstLetter(String str) {
        if (isEmpty(str)) {
            return str;
        }

        char c = str.charAt(0);
        return (!Character.isLetter(c) || Character.isUpperCase(c)) ? str
                : new StringBuilder(str.length()).append(Character.toUpperCase(c)).append(str.substring(1)).toString();
    }

    /**
     * encoded in utf-8
     *
     * @param str
     * @return
     * @throws UnsupportedEncodingException if an error occurs
     */
    public static String utf8Encode(String str) {
        if (!isEmpty(str) && str.getBytes().length != str.length()) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UnsupportedEncodingException occurred. ", e);
            }
        }
        return str;
    }

    /**
     * encoded in utf-8, if exception, return defultReturn
     *
     * @param str
     * @param defultReturn
     * @return
     */
    public static String utf8Encode(String str, String defultReturn) {
        if (!isEmpty(str) && str.getBytes().length != str.length()) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                return defultReturn;
            }
        }
        return str;
    }

    /**
     * get innerHtml from href
     *
     * @param href
     * @return
     */
    public static String getHrefInnerHtml(String href) {
        if (isEmpty(href)) {
            return "";
        }

        String hrefReg = ".*<[\\s]*a[\\s]*.*>(.+?)<[\\s]*/a[\\s]*>.*";
        Pattern hrefPattern = Pattern.compile(hrefReg, Pattern.CASE_INSENSITIVE);
        Matcher hrefMatcher = hrefPattern.matcher(href);
        if (hrefMatcher.matches()) {
            return hrefMatcher.group(1);
        }
        return href;
    }

    /**
     * process special char in html
     *
     * @param source
     * @return
     */
    public static String htmlEscapeCharsToString(String source) {
        return StringUtils.isEmpty(source) ? source
                : source.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replaceAll("&quot;",
                "\"");
    }

    /**
     * transform half width char to full width char
     *
     * @param s
     * @return
     */
    public static String fullWidthToHalfWidth(String s) {
        if (isEmpty(s)) {
            return s;
        }

        char[] source = s.toCharArray();
        for (int i = 0; i < source.length; i++) {
            if (source[i] == 12288) {
                source[i] = ' ';
                // } else if (source[i] == 12290) {
                // source[i] = '.';
            } else if (source[i] >= 65281 && source[i] <= 65374) {
                source[i] = (char) (source[i] - 65248);
            } else {
                source[i] = source[i];
            }
        }
        return new String(source);
    }

    /**
     * transform full width char to half width char
     *
     * @param s
     * @return
     */
    public static String halfWidthToFullWidth(String s) {
        if (isEmpty(s)) {
            return s;
        }

        char[] source = s.toCharArray();
        for (int i = 0; i < source.length; i++) {
            if (source[i] == ' ') {
                source[i] = (char) 12288;
                // } else if (source[i] == '.') {
                // source[i] = (char)12290;
            } else if (source[i] >= 33 && source[i] <= 126) {
                source[i] = (char) (source[i] + 65248);
            } else {
                source[i] = source[i];
            }
        }
        return new String(source);
    }

    /**
     * @param str
     * @return whether a string is json format
     */
    public static boolean isJsonString(String str) {
        try {
            new JSONObject(str);
        } catch (JSONException e) {
            return false;
        }
        return true;
    }

    /**
     * @param origStr
     * @param removeTarget
     * @return
     */
    public static String removeFirst(String origStr, char removeTarget) {
        String strRemoveTarget = String.valueOf(removeTarget);
        if (isEmpty(origStr) || isEmpty(strRemoveTarget)) {
            return origStr;
        }
        if (origStr.startsWith(strRemoveTarget)) {
            return origStr.substring(1, origStr.length());
        } else {
            return origStr;
        }
    }

    /**
     * @param arr
     * @return
     */
    public static String byteArrayToString(byte[] arr) {
        if (arr == null) {
            return null;
        }
        return new String(arr, Charset.forName("utf-8"));
    }

    /**
     * @param resId
     * @param args
     * @return
     */
    public static String format(int resId, Object... args) {
        String template = ResourceUtils.getString(resId);
        return String.format(template, args);
    }

    /**
     * @param str
     * @param args
     * @return
     */
    public static String format(String str, Object... args) {
        return String.format(str, args);
    }


    /**
     * 使用java正则表达式去掉多余的.与0
     * @param s
     * @return
     */
    public static String subZeroAndDot(String s){
        if(s==null || s.length()==0){
            return "";
        }
        if(s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }


    /**
     * 验证纳税人识别号//纳税人识别号,一律由15位-20位码（字符型）不能全部为0组成
     */
    public static boolean verificationTaxpayerNumber(String taxpayerNumber) {
        if (!TextUtils.isEmpty(taxpayerNumber)) {
//            String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{0,20}$";
            String regex = "^[0-9A-Za-z]{15,20}$";
            boolean b = taxpayerNumber.matches(regex);
            boolean isAllZero = true;
            for (int i = 0; i < taxpayerNumber.length(); i++) {
                String s = String.valueOf(taxpayerNumber.charAt(i));
                if (!s.equals("0")) {
                    isAllZero = false;
                    break;
                }
            }
            if (b && !isAllZero) {
                return true;
            }
        }


        return false;
    }

    /**
     * 判断字符串是否全部为0  true:是false:不是
     *
     * @param
     */
    public static boolean isAllZero(String stringText) {
        boolean isAllZero = true;
        for (int i = 0; i < stringText.length(); i++) {
            String s = String.valueOf(stringText.charAt(i));
            if (!s.equals("0")) {
                isAllZero = false;
                break;
            }
        }
        return isAllZero;
    }

    //邮箱验证
    public static boolean isEmail(String strEmail) {
        String strPattern = "^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
        if (TextUtils.isEmpty(strPattern)) {
            return false;
        } else {
            return strEmail.matches(strPattern);
        }
    }

    // 判断是否符合身份证号码的规范
    public static boolean isIDCard(String IDCard) {
        if (IDCard != null) {
            String IDCardRegex = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x|Y|y)$)";
            return IDCard.matches(IDCardRegex);
        }
        return false;
    }

    /**
     * 是否是6-18位密码
     * 含有数字或者字母
     * @param password
     * @return
     */
    public static boolean isOkPassword(String password) {
        String regex = "^[0-9a-zA-Z]{6,18}";
        boolean b = password.matches(regex);
        if (b) {
            return true;
        }
        return false;
    }

    /**
     * 非空
     * 全部中文 没有空格
     * 全部英文 中间至少含有一个空格
     * @param name
     * @return
     */
    public static boolean isName(String name) {
        name=name.trim();
      if(StringUtils.isBlank(name)){
          ToasterManager.showToast("请输入姓名");
          return false;
      }
        //判断字符串是否全为汉字
        String reg = "[\\u4e00-\\u9fa5]+"  ;
        boolean result1 = name.matches(reg);
        if(result1){
            //全部为汉字
            return true;
        }else{
            String name2=name.replace(" ","");
            boolean isWord=name2.matches("[a-zA-Z]+");
            if(isWord){
                //全部字母
                if(name.contains(" ") && !name.startsWith(" ")&& !name.endsWith(" ")){
                    // 中间含有空格
                    return true;
                }else{
                    ToasterManager.showToast("英文名时，请在姓和名之前输入一个空格");
                    return false;
                }
            }else{
                //不全部是汉字也不全部是字母
                ToasterManager.showToast("姓和名必须中英文统一");
                return false;
            }

        }
    }


    /**
     * 是否全部是数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    // 判断一个字符串是否含有数字
    public static boolean HasDigit(String content) {
        boolean flag = false;
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(content);
        if (m.matches()) {
            flag = true;
        }
        return flag;
    }
    /**
     * 是否含有字母
     * @return
     */
    public static boolean HasLetter(String password) {
        String regex = "^[a-zA-Z]";
        boolean b = password.matches(regex);
        if (b) {
            return true;
        }
        return false;
    }

    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobiles) {
//    /*
//    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
//    联通：130、131、132、152、155、156、185、186
//    电信：133、153、180、189、（1349卫通）
//    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
//    */
//        String telRegex = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        String telRegex = "[1][0-9]\\d{9}";
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }
    //判断字符串是否是整数
    public static boolean isInteger(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }




    //json格式化
    /**
     * @date  2017/8/24
     * @description 将字符串格式化成JSON的格式
     */
    public static String stringToJSON(String strJson) {
        // 计数tab的个数
        int tabNum = 0;
        StringBuffer jsonFormat = new StringBuffer();
        int length = strJson.length();

        char last = 0;
        for (int i = 0; i < length; i++) {
            char c = strJson.charAt(i);
            if (c == '{') {
                tabNum++;
                jsonFormat.append(c + "\n");
                jsonFormat.append(getSpaceOrTab(tabNum));
            }
            else if (c == '}') {
                tabNum--;
                jsonFormat.append("\n");
                jsonFormat.append(getSpaceOrTab(tabNum));
                jsonFormat.append(c);
            }
            else if (c == ',') {
                jsonFormat.append(c + "\n");
                jsonFormat.append(getSpaceOrTab(tabNum));
            }
            else if (c == ':') {
                jsonFormat.append(c + " ");
            }
            else if (c == '[') {
                tabNum++;
                char next = strJson.charAt(i + 1);
                if (next == ']') {
                    jsonFormat.append(c);
                }
                else {
                    jsonFormat.append(c + "\n");
                    jsonFormat.append(getSpaceOrTab(tabNum));
                }
            }
            else if (c == ']') {
                tabNum--;
                if (last == '[') {
                    jsonFormat.append(c);
                }
                else {
                    jsonFormat.append("\n" + getSpaceOrTab(tabNum) + c);
                }
            }
            else {
                jsonFormat.append(c);
            }
            last = c;
        }
        return jsonFormat.toString();
    }
    private static String getSpaceOrTab(int tabNum) {
        StringBuffer sbTab = new StringBuffer();
        for (int i = 0; i < tabNum; i++) {
            sbTab.append('\t');
        }
        return sbTab.toString();
    }
    public static String getMd5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
