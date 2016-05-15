package com.example.aoiumi.medecide;

import com.orm.SugarRecord;

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
}
