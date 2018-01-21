package llapps.com.viewpagecarddemo.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by SongUp on 2018/1/21.
 */

public class Constance {
    public static void showToast(Context context, String text){
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
