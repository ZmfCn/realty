package com.zmf.realty.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author zmf
 * @description
 * @timestamp 2018-06-18 01:29
 */
public class IoUtil {
    /**
     * @param response response
     * @param data data
     */
    public static void writeToOutput(HttpServletResponse response, byte[] data) {
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            os.write(data);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
