package com.github.ucchyocean.lc.japanize;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;

public class BaiduIME {

    protected BaiduIME() {
    }

    /**
     * BaiduIMEの変換候補を抽出します
     *
     * @param json 変換元のJson形式の文字列
     * @return 変換後の文字列
     * @since 2.8.10
     */
    public static String parseJson(String json) {
        try {
            JsonElement response = new Gson().fromJson(json, JsonArray.class);
            JsonArray array = response.getAsJsonArray().get(0).getAsJsonArray().get(0).getAsJsonArray().get(1)
                .getAsJsonArray();
            if ( array.size() > 0 ) {
                return array.get(0).getAsString();
            }
        } catch (JsonSyntaxException e) {
        }
        return null;
    }
}
