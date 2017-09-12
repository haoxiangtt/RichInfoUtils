package cn.richinfo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * @description 存储封装类
 */
public class SharePersistent {
    private static SharePersistent instance;
    /**
     * 用于存储token,openid等数据的文件名称
     */
    private final static String FILE_NAME = "UMC_SDK_SHARE_PREFERENCE"; // 数据记录文件名称

    public final static String KEY_CONFIG_SIM_SLOT_ID = "KEY_CONFIG_SIM_SLOT_ID";//默认登录sim卡的slot_id

    public final static String KEY_SMS_CONTENT = "KEY_SMS_CONTENT_";

    public final static String KEY_SMS_EXPIRE_TIME = "KEY_SMS_EXPIRE_TIME_;";

    public final static String KEY_MOBILEKEY = "KEY_MOBILEKEY";//用于存入mobilekey
    public final static String KEY_BUFFER_CURRENT_TIME = "KEY_BUFFER_CURRENT_TIME";//用于存入缓冲页面的当前时间
    public final static String KEY_SECURITYPHONE = "KEY_SECURITYPHONE";
    public final static String KEY_IMSI_MOBILEKEY = "KEY_IMSI_MOBILEKEY";
    public final static String KEY_AUTH_TYPE = "KEY_AUTH_TYPE";


    public final static String KEY_ISUNUSEAUTH = "KEY_ISUNUSEAUTH"; //用于控制是否特别权限(显示登录页面)
    public final static String KEY_RELAY_STATE = "KEY_RELAY_STATE";
    public final static String KEY_CAPAIDS = "KEY_CAPAIDS";

    private SharePersistent() {
    }

    /**
     * 获取SharePersistent对象
     *
     * @return 可用的SharePersistent对象
     */
    public static SharePersistent getInstance() {
        if (instance == null) {
            instance = new SharePersistent();
        }
        return instance;
    }

    /**
     * 设置String数据
     *
     * @param context 上下文
     * @param key     存储键
     * @param value   和键对应的值（String类型）
     */
    public boolean put(Context context, String key, String value) {
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE); // 读取文件,如果没有则会创建
        Editor editor = settings.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    /**
     * 设置boolean数据
     *
     * @param context 上下文
     * @param key     存储键
     * @param value   和键对应的值（boolean类型）
     */
    public boolean put(Context context, String key, boolean value) {
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE); // 读取文件,如果没有则会创建
        Editor editor = settings.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }


    /**
     * 设置long型数据
     *
     * @param context 上下文
     * @param key     存储键
     * @param value   和键对应的值（long类型）
     */
    public boolean put(Context context, String key, long value) {
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE); // 读取文件,如果没有则会创建
        Editor editor = settings.edit();
        editor.putLong(key, value);
        return editor.commit();
    }

    /**
     * 设置int型数据
     *
     * @param context 上下文
     * @param key     存储键
     * @param value   和键对应的值（int类型）
     */
    public boolean put(Context context, String key, int value) {
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE); // 读取文件,如果没有则会创建
        Editor editor = settings.edit();
        editor.putInt(key, value);
        return editor.commit();
    }


    /**
     * 获取int型数据
     *
     * @param context      上下文
     * @param key          存储数据时所对应的键
     * @param defaultValue 默认值
     * @return 和键对应的值（int类型）
     */
    public int get(Context context, String key, int defaultValue) {
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return settings.getInt(key, defaultValue);
    }


    /**
     * 获取数据（accesstoken,clientip,openid等）
     *
     * @param context 上下文
     * @param key     存储数据时所对应的键
     * @return 和键对应的值（String类型）
     */
    public String get(Context context, String key,String defaultStr) {
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return settings.getString(key, defaultStr);
    }


    /**
     * 获取数据（accesstoken,clientip,openid等）
     *
     * @param context 上下文
     * @param key     存储数据时所对应的键
     * @return 和键对应的值（long类型）
     */
    public long get(Context context, String key,long defaultKey) {
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return settings.getLong(key, 0L);
    }

    /**
     * 取出Boolean
     */
    public boolean get(Context context, String key, boolean defValue) {
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return settings.getBoolean(key, defValue);
    }


    /**
     * 清空key对应的数据
     *
     * @param context 上下文
     * @param key     情况特定数据对应的键
     * @return 成功清除返回true 否则 返回false
     */
    public boolean clear(Context context, String key) {
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return settings.edit().remove(key).commit();
    }

    /**
     * 清楚所有的SharedPreferences数据
     *
     * @param context
     * @return
     */
    public boolean clear(Context context) {
        SharedPreferences settings = context.getApplicationContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return settings.edit().clear().commit();
    }

}
