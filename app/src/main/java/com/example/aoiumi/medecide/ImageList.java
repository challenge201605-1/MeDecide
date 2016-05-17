package com.example.aoiumi.medecide;

import com.orm.SugarRecord;

import java.util.List;

/**
 * イメージリストクラス
 * Created by aoiumi on 16/05/15.
 */
public class ImageList extends SugarRecord {
    byte[] image_data;

    public ImageList(){

    }

    public ImageList(byte[] image_data){
        this.image_data = image_data;
    }

    /**
     * 画像一覧がからかどうかを調べるstaticメソッド
     * @return
     */
    public static boolean isEmptyImageList() {
        List<ImageList> imageLists = ImageList.listAll(ImageList.class);
        int num = imageLists.size();

        if (num > 0) {
            return false;
        } else {
            return true;
        }
    }
}
