package org.chobit.common.tools;

import org.chobit.common.codec.MD5;

/**
 * 设备ID常用编码方式
 *
 * @author robin
 */
public enum DeviceIdEncryptor {

    /**
     * 未加密
     */
    NOT_ENCRYPTED {
        @Override
        public String encrypt(String deviceId) {
            return deviceId;
        }
    },

    /**
     * 只做MD5加密
     */
    ENCRYPTION1 {
        @Override
        public String encrypt(String deviceId) {
            return MD5.encode(deviceId);
        }
    },

    /**
     * 先大写，后作MD5加密
     */
    ENCRYPTION2 {
        @Override
        public String encrypt(String deviceId) {
            return MD5.encode(deviceId.toUpperCase());
        }
    },

    /**
     * 先小写后作MD5加密
     */
    ENCRYPTION3 {
        @Override
        public String encrypt(String deviceId) {
            return MD5.encode(deviceId.toLowerCase());
        }
    },

    /**
     * 先大写，转MD5，后转大写
     */
    ENCRYPTION4 {
        @Override
        public String encrypt(String deviceId) {
            return MD5.encode(deviceId.toUpperCase()).toUpperCase();
        }
    },


    /**
     * 先小写，转MD5，后转大写
     */
    ENCRYPTION5 {
        @Override
        public String encrypt(String deviceId) {
            return MD5.encode(deviceId.toLowerCase()).toUpperCase();
        }
    };

    public abstract String encrypt(String deviceId);

}
